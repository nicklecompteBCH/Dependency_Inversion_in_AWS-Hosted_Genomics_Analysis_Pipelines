name := "aws-lambda-scala"

scalaVersion := "2.11.8"

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"

libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "2.2.2"

libraryDependencies += "org.elasticsearch.client" % "elasticsearch-rest-client" % "7.4.2"

libraryDependencies += "com.amazonaws" % "aws-java-sdk-secretsmanager" % "1.11.442"