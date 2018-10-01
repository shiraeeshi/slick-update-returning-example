name := "SlickUpdateReturningExample"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val slickVersion           = "3.2.1"

  Seq(
    "com.typesafe.slick" %% "slick"           % slickVersion
    , "com.typesafe.slick" %% "slick-hikaricp"  % slickVersion
    , "org.postgresql" % "postgresql" % "42.0.0"
    //, "ch.qos.logback" % "logback-classic" % "1.1.7"
  )
}

packageDescription := "Demo"


