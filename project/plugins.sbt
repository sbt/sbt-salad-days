addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.3.1")

lazy val metaroot = rootProject
  .dependsOn(metaSbtSaladDays)

lazy val metaSbtSaladDays = (project in file("plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    Compile / unmanagedSourceDirectories :=
      mirrorScalaSource((ThisBuild / baseDirectory).value.getParentFile / "plugin")
  )

def mirrorScalaSource(baseDirectory: File): Seq[File] =
  val scalaSourceDir = baseDirectory / "src" / "main" / "scala"
  if scalaSourceDir.exists then scalaSourceDir :: Nil
  else sys.error(s"Missing source directory: $scalaSourceDir")
