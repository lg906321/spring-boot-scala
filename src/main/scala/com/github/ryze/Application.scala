package com.github.ryze

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{ImportAutoConfiguration, SpringBootApplication}

@SpringBootApplication
//调用Java文件
@ImportAutoConfiguration(classes = Array(classOf[ServerConfiguration]))
class Application

object Application
{
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[Application], args: _*)
}
