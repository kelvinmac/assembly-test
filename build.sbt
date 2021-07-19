import sbt.ThisBuild




lazy val commonSettings = Seq(
  organization := "com.kelvin.assembly",
  name := "assembly-test",
    ThisBuild / organization := "com.kelvin.assembly",
version := "0.1",
  scalaVersion := "2.13.6"
)
lazy val globalApp = (project in file("."))
  .enablePlugins(DockerPlugin)
  .dependsOn(app)
  .settings(commonSettings)
  .settings(
    assembly / mainClass := Some("com.kelvin.assembly.Main")
  )


lazy val app = (project in file("app"))
  .settings(commonSettings)
  .settings(
    libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.13.0"
  )

docker / dockerfile := {
  // The assembly task generates a fat JAR file
  val artifact: File     = assembly.value
  val artifactTargetPath = s"/app/${artifact.name}"

  new Dockerfile {
    from("adoptopenjdk/openjdk11")
    add(artifact, artifactTargetPath)
    entryPoint("java", "-jar", artifactTargetPath)
  }
}

docker / imageNames := Seq(
  ImageName("com.kelvin.assembly-test:stable")
)