val scala212 = "2.12.17"
val scala213 = "2.13.10"
val scala3   = "3.2.2"

ThisBuild / scalaVersion       := scala213
ThisBuild / organization       := "lgbt.princess"
ThisBuild / crossScalaVersions := Seq(scala212, scala213, scala3)

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
