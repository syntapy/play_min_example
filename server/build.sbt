lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """civiform-server""",
    version := "0.0.1",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      "com.j2html" % "j2html" % "1.5.0"
    ),
  )
