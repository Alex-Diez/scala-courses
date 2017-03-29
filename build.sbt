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
  .aggregate(phase_one, phase_two)

lazy val phase_one = project.in(file("phase_one"))
  .settings(common: _*)
  .settings(name := "phase-1")

lazy val phase_two = project.in(file("phase_two"))
  .settings(common: _*)
  .settings(name := "phase-2")
