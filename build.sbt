import sbt.Keys.mainClass

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
  .aggregate(helloWorld, firstPhaseExercise, listOfNumbers)

lazy val helloWorld = project.in(file("phase-1/hello-world"))
  .settings(common: _*)
  .settings(
    name := "hello-world",
    artifactName := {
      (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
        artifact.name + "." + artifact.extension
    },

    mainClass in(Compile, run) := Some("scala.courses.HelloWorld")
  )

lazy val firstPhaseExercise = project.in(file("phase-1/person"))
  .settings(common: _*)
  .settings(
    name := "phase-1-person",
    artifactName := {
      (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
        artifact.name + "." + artifact.extension
    },

    mainClass in(Compile, run) := Some("scala.course.Person")
  )

lazy val listOfNumbers = project.in(file("phase-1/list-of-numbers"))
  .settings(common: _*)
  .settings(
    name := "phase-1-list-of-numbers",
    artifactName := {
      (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
        artifact.name + "." + artifact.extension
    },

    mainClass in(Compile, run) := Some("scala.course.PrimeNumbers")
  )
