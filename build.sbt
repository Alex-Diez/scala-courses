name := "scala-courses"
version := "1.0"
scalaVersion := "2.12.1"

lazy val common = Seq(
  version := "1.0",
  scalaVersion := "2.12.1",

  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test",

  scalacOptions ++= Seq("-deprecation", "-feature")
)

lazy val root = Project("scala-courses", file("."))
  .aggregate(phase_1, phase_2, phase_3)

lazy val phase_1 = project.in(file("phase_1"))
  .settings(common: _*)
  .settings(name := "phase-1")

lazy val phase_2 = project.in(file("phase_2"))
  .settings(common: _*)
  .settings(name := "phase-2")

lazy val phase_3 = project.in(file("phase_3"))
  .settings(common: _*)
  .settings(name := "phase-3")
