name := "cats-playground"

ThisBuild / version := "1.0.0-SNAPSHOT"

ThisBuild / scalacOptions += "-Ypartial-unification"

lazy val commonLibraries = Seq(
  "org.typelevel" %% "cats-core" % "1.5.0-RC1",
  "org.typelevel" %% "cats-kernel" % "1.5.0-RC1",
  "org.typelevel" %% "cats-macros" % "1.5.0-RC1",
  "org.typelevel" %% "cats-laws" % "1.5.0-RC1" % Test,
  "org.typelevel" %% "cats-testkit" % "1.5.0-RC1" % Test
)

libraryDependencies ++= commonLibraries

lazy val typeClass = (project in file("type-class"))
  .settings(
    libraryDependencies ++= commonLibraries
  )

lazy val monoidAndSemigroup = (project in file("monoid-and-semigroup"))
  .settings(
    libraryDependencies ++= commonLibraries
  )

lazy val functor = (project in file("functor"))
  .settings(
    libraryDependencies ++= commonLibraries
  )
