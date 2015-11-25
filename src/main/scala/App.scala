//#!/bin/sh
//exec scala "$0" "$@"
//!#

/**
 * Created by pawan on 25/10/15.
  */
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.dstream._
import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import org.elasticsearch.spark._

object App {
  def main(args:Array[String]) = {
    val conf = new org.apache.spark.SparkConf()
      .setMaster("local[*]")
      .setAppName("SprakES")
      //.set("es.nodes", "192.168.7.7")
      .set("es.nodes", "localhost") //change the IP as per your running IP of elasticsearch
      //.set("es.nodes", "192.168.1.100") //change the IP as per your running IP of elasticsearch
      .set("es.port", "9200")
      .set("es.index.auto.create", "true")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark = new org.apache.spark.SparkContext(conf)
    //Random test
    //val data = spark.parallelize(1 to 1000000).collect().filter(_ < 1000)
    //data.foreach(println)

    //Create RDD from ES index
    val glRDD = spark.esRDD("graylog2_0/message")
    //Just count the no of messages logged so far by graylog2 in ES indexes
    println("No of messages:",glRDD.count())
    spark.stop()
  }
}

//App.main(args)
