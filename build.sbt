import sbt.Keys.scalaVersion

name := "CRUDEndpoint"

val commonSettings = Seq(
	organization := "org.arkmaxim",
	version := "1.0",
	scalaVersion := "2.12.1",
	scalacOptions ++= Seq(
		"-feature",
		"-deprecation",
		"-encoding", "UTF-8",
		"-unchecked",
		"-Xlint",
		"-Yno-adapted-args",
		"-Ywarn-dead-code",
		"-Ywarn-numeric-widen",
		"-Ywarn-value-discard",
		"-Xfuture",
		"-Xexperimental"
	),
	libraryDependencies ++= Seq(
		"org.mindrot" % "jbcrypt" % "0.4",
		"com.typesafe.slick" % "slick_2.11" % "3.1.0",
		"mysql" % "mysql-connector-java" % "5.1.34",
		"io.monix" %% "monix" % "2.2.4",
		"org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
		"com.zaxxer" % "HikariCP" % "2.4.5"
	),
	resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases/"
)


lazy val endpoint = project.in(file("endpoint"))
	.settings(commonSettings: _*)
	.settings(
		name := "endpoints",
		libraryDependencies ++= Seq(
			"io.circe" %% "circe-core" % "0.7.0",
			"io.circe" %% "circe-generic-extras" % "0.7.0",
			"io.circe"  %%  "circe-generic"  %  "0.7.0",
			"io.circe"  %%  "circe-parser"  %  "0.7.0",
			// core API
			"org.julienrf" %% "endpoints-algebra" % "0.2.0",
			// (optional) JSON serialization using circe.io
			"org.julienrf" %% "endpoints-algebra-circe" % "0.2.0"
		)
	)

lazy val client = project.in(file("client"))
  .settings(commonSettings: _*)
  .settings(
		name := "client",
		libraryDependencies ++= Seq(
			// client based on JavaScript’s XMLHttpRequest
			"org.julienrf" % "endpoints-xhr-client_sjs0.6_2.11" % "0.2.0",
			// (optional) JSON serialization using circe.io
			"org.julienrf" % "endpoints-xhr-client-circe_sjs0.6_2.11" % "0.2.0",
			// (optional) uses faithful’s `Future`
			"org.julienrf" % "endpoints-xhr-client-faithful_sjs0.6_2.11" % "0.2.0"
		)
	)

lazy val server = project.in(file("server"))
	.settings(commonSettings:_*)
  .settings(
		name := "server",
		libraryDependencies ++= Seq(
			// server based on akka-http
			"org.julienrf" %% "endpoints-akka-http-server" % "0.2.0",
			// (optional) JSON serialization using circe.io
			"org.julienrf" %% "endpoints-akka-http-server-circe" % "0.2.0"
		)
	).dependsOn(endpoint)


//val main = (project in file(".")).aggregate(endpoint, server.dependsOn(endpoint), client.dependsOn(endpoint))

