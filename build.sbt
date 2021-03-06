name := """world-golf"""
organization := "com.world-golf"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % Test
libraryDependencies += "org.scalatest" %% "scalatest-wordspec" % "3.0.0" % Test
libraryDependencies += "org.scalatest" %% "scalatest-shouldmatchers" % "3.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.world-golf.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.world-golf.binders._"
