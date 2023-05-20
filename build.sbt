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
    licenses      := Seq("The Apache License, Version 2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt")),
    developers := List(
      Developer(
        "NthPortal",
        "April Hyacinth",
        "dev@princess.lgbt",
        url("https://nthportal.com"),
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

lazy val platform =
  crossProject(JVMPlatform, JSPlatform, NativePlatform)
    .in(file("platform"))
    .settings(
      name := "platform",
      scalacOptions ++= Seq("-Xlint:_"),
      libraryDependencies ++= Seq(
        "org.scalameta" %%% "munit" % "1.0.0-M7" % Test,
      ),
    )
