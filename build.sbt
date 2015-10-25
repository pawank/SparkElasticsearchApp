name := "SparkElasticsearchExample"

version := "1.0"

scalaVersion := "2.11.5"

//libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "1.5.1", "org.elasticsearch" %% "elasticsearch-spark" % "2.1.1")

libraryDependencies ++= Dependencies.sparkAkkaHadoop

initialCommands in console :=
  """
    |import org.apache.spark._
    |import org.apache.spark.streaming._
    |import org.apache.spark.streaming.StreamingContext._
    |import org.apache.spark.streaming.dstream._
    |import akka.actor.{ActorSystem, Props}
    |import com.typesafe.config.ConfigFactory
    |import org.elasticsearch.spark._
  """.stripMargin


    