ThisBuild / version := "0.1.0-SNAPSHOT"
name := "assembly-test"
ThisBuild / organization := "com.kelvin.assembly"
version := "0.1"

scalaVersion := "2.13.6"

lazy val globalApp = (project in file("."))
  .aggregate(app)
  .settings(
  )


lazy val app = (project in file("app"))
  .settings(
  )

ThisBuild / assembly / mainClass := Some("com.kelvin.assembly.Main")