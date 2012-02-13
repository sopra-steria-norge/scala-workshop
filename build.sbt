name := "scala-koans"

version := "1.0"

scalaVersion := "2.9.1"

organization := "org.scalakoans"

libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "1.6.1" % "test",
	"org.scalatra" %% "scalatra" % "2.0.3",
    "org.scalatra" %% "scalatra-scalatest" % "2.0.3",
    "org.scalatra" %% "scalatra-test" % "2.0.3")
