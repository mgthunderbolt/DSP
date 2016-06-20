package com.mycompany.app.spark

/**
  * Created by lzz on 6/19/16.
  */
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


object App {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)
    val line = sc.textFile( "hdfs://192.168.1.222:9000/word_list.txt" )
    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)
    sc.stop()
  }
}

