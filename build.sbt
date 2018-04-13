import Dependencies._
import scalariform.formatter.preferences._

scalariformPreferences := scalariformPreferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(DanglingCloseParenthesis, Preserve)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.mycaule",
      scalaVersion := "2.11.12",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Assessment",
    libraryDependencies += scalaTest % Test
  )
