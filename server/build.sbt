lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """civiform-server""",
    version := "0.0.1",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      guice,
      "com.j2html" % "j2html" % "1.5.0",
      "com.google.inject.extensions" % "guice-assistedinject" % "5.1.0"
    ),
  )
