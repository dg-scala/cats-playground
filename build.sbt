name := "catsPlayground"

version := "1.0.0-SNAPSHOT"

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.5.0-RC1",
  "org.typelevel" %% "cats-kernel" % "1.5.0-RC1",
  "org.typelevel" %% "cats-macros" % "1.5.0-RC1",
  "org.typelevel" %% "cats-laws" % "1.5.0-RC1" % Test,
  "org.typelevel" %% "cats-testkit" % "1.5.0-RC1" % Test
)

lazy val typeClass = project in file("type-class")