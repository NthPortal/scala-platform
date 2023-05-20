val scala212 = "2.12.17"
val scala213 = "2.13.10"
val scala3   = "3.2.2"

ThisBuild / scalaVersion       := scala213
ThisBuild / crossScalaVersions := Seq(scala212, scala213, scala3)

// publishing info
inThisBuild(
  Seq(
    organization  := "lgbt.princess",
    versionScheme := Some("semver-spec"),
    homepage      := Some(url("https://github.com/NthPortal/scala-platform")),
    licenses      := Seq(License.Apache2),
    developers := List(
      Developer(
        "NthPortal",
        "April Hyacinth",
        "dev@princess.lgbt",
        url("https://github.com/NthPortal"),
      ),
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/NthPortal/scala-platform"),
        "scm:git:git@github.com:NthPortal/scala-platform.git",
        "scm:git:git@github.com:NthPortal/scala-platform.git",
      ),
    ),
  ),
)

// CI config
inThisBuild(
  Seq(
    githubWorkflowTargetTags ++= Seq("v*"),
    githubWorkflowPublishTargetBranches ++= Seq(
      RefPredicate.StartsWith(Ref.Tag("v")),
    ),
    githubWorkflowJavaVersions := Seq(
      JavaSpec.temurin("8"),
      JavaSpec.temurin("11"),
      JavaSpec.temurin("17"),
    ),
    githubWorkflowBuildPostamble ++= Seq(
      WorkflowStep.Sbt(
        name = Some("scalafmt"),
        commands = List("scalafmtCheckAll", "scalafmtSbtCheck"),
      ),
    ),
    githubWorkflowBuildMatrixFailFast := Some(false),
    githubWorkflowPublishPreamble += WorkflowStep.Use(UseRef.Public("olafurpg", "setup-gpg", "v3")),
    githubWorkflowPublish := Seq(
      WorkflowStep.Sbt(
        List("ci-release"),
        env = Map(
          "PGP_PASSPHRASE"    -> "${{ secrets.PGP_PASSPHRASE }}",
          "PGP_SECRET"        -> "${{ secrets.PGP_SECRET }}",
          "SONATYPE_PASSWORD" -> "${{ secrets.SONATYPE_PASSWORD }}",
          "SONATYPE_USERNAME" -> "${{ secrets.SONATYPE_USERNAME }}",
        ),
      ),
    ),
  ),
)

lazy val platform =
  crossProject(JVMPlatform, JSPlatform, NativePlatform)
    .in(file("platform"))
    .settings(
      name := "platform",
      scalacOptions ++= Seq(
        "-feature",
        "-Werror",
      ),
      scalacOptions ++= {
        CrossVersion.partialVersion(scalaVersion.value) match {
          case Some((2, _)) => Seq("-Xlint:_")
          case _            => Nil
        }
      },
      libraryDependencies ++= Seq(
        "org.scalameta" %%% "munit" % "1.0.0-M7" % Test,
      ),
    )
