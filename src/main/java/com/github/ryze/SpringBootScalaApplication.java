package com.github.ryze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(classes = ServerConfiguration.class)
public class SpringBootScalaApplication
{
  public static void main(String[] args)
  {
    SpringApplication.run(SpringBootScalaApplication.class, args);
  }
}
