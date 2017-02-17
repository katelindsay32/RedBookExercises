val commonSettings = Seq(
  scalaVersion := "2.12.1"
)

val libDependencies: Seq[ModuleID] = {
  val http4sVersion = "0.15.0a"

  Seq(
    "org.scalatest" %% "scalatest" % "3.0.0" % "test,it",
    "org.mockito" % "mockito-all" % "1.9.5" % "test,it"
  )
}


lazy val exercises = (project in file("exercises"))
  .settings(commonSettings)
  .settings(
    name := "exercises"
  )
  .settings(
    Seq(libraryDependencies := libDependencies)
  )

lazy val answers = (project in file("answers"))
  .settings(commonSettings)
  .settings(
    name := "answers"
  )
  .settings(
    Seq(libraryDependencies := libDependencies)
  )

lazy val root = (project in file("."))
  .aggregate(exercises, answers)
  .settings(commonSettings)
  .settings(
    name := "fpinscala"
  )