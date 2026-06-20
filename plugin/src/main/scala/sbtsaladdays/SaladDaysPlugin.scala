package sbtsaladdays

import sbt.*
import Keys.*

object SaladDaysPlugin extends AutoPlugin {
  override lazy val requires = sbt.plugins.JvmPlugin
  override lazy val trigger = allRequirements
  override lazy val projectSettings = Seq(
    Compile / packageDoc / mappings := {
      if (scalaVersion.value.startsWith("3.")) {
        val orig = (Compile / packageDoc / mappings).value
        orig.filter { case (_, v) =>
          !v.startsWith("fonts") &&
          !v.startsWith("webfonts") &&
          !v.startsWith("scripts/inkuire")
        }
      } else {
        (Compile / packageDoc / mappings).value
      }
    }
  )
}
