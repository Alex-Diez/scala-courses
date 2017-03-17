name := "scala-courses"
version := "1.0"
scalaVersion := "2.12.1"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

lazy val common = Seq(
  version := "1.0",

  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test",

  scalacOptions ++= Seq("-deprecation", "-feature")
)

lazy val root = Project("scala-courses", file("."))
  .aggregate(phase_one)

lazy val phase_one = project.in(file("phase_one"))
  .settings(common: _*)
  .settings(name := "phase-1")
