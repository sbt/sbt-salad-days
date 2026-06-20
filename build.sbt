version := "0.1.0-SNAPSHOT"
organization := "com.eed3si9n"
description := "sbt plugin to reduce Scaladoc JAR file size"

lazy val plugin = (projectMatrix in file("plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-salad-days",
    scalacOptions := {
      if scalaBinaryVersion.value == "3" then
        Seq("-deprecation", "-unchecked")
      else
        Seq("-deprecation", "-unchecked", "-release:8")
    },
  )
  .jvmPlatform(scalaVersions = Seq("3.8.4", "2.12.20"))
