scmInfo := Some(
  ScmInfo(
    url("https://github.com/sbt/sbt-salad-days"),
    "scm:git@github.com:sbt/sbt-salad-days.git"
  )
)
developers := List(
  Developer(
    id = "eed3si9n",
    name = "Eugene Yokota",
    email = "@eed3si9n",
    url = url("https://eed3si9n.com/")
  )
)
pomIncludeRepository := { _ =>
  false
}
publishTo := {
  val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
  if (version.value.endsWith("-SNAPSHOT")) Some("central-snapshots" at centralSnapshots)
  else localStaging.value
}
homepage := Some(url("https://github.com/sbt/sbt-salad-days"))
licenses := Seq(License.Apache2)
publishMavenStyle := true
