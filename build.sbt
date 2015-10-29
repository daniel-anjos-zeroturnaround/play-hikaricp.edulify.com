name := "play-hikaricp"

version := "2.0.7"

scalaVersion := "2.10.4"

crossScalaVersions := Seq("2.10.5", "2.11.6")

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  jdbc,
  "com.zaxxer" % "HikariCP-java6" % "2.3.9",
  "com.googlecode.usc" % "jdbcdslog" % "1.0.6.2",
  "com.h2database" % "h2" % "1.4.187" % "test"
)

resolvers ++= Seq(
  Resolver.typesafeRepo("releases"),
  "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"
)

organization := "com.edulify"

organizationName := "Edulify.com"

organizationHomepage := Some(new URL("https://edulify.com"))

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

publishTo := {
  val nexus = "https://repos.zeroturnaround.com/nexus/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/st-snapshots")
  else
    Some("releases"  at nexus + "content/repositories/thirdparty")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

startYear := Some(2012)

description := "HikariCP Plugin for Play Framework 2.2.x"

licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://edulify.github.io/play-hikaricp.edulify.com/"))

pomExtra :=
  <scm>
    <url>https://github.com/edulify/play-hikaricp.edulify.com</url>
    <connection>scm:git:git@github.com:edulify/play-hikaricp.edulify.com.git</connection>
    <developerConnection>scm:git:https://github.com/edulify/play-hikaricp.edulify.com.git</developerConnection>
  </scm>
  <developers>
    <developer>
      <id>megazord</id>
      <name>Megazord</name>
      <email>contact [at] edulify.com</email>
      <url>https://github.com/megazord</url>
    </developer>
  </developers>

scalacOptions := Seq("-feature", "-deprecation")

