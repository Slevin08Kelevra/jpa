/* Copyright © 2015 Oracle and/or its affiliates. All rights reserved. */
package com.example.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class App {

  @Autowired
  IncomingCallManager atManager;

  @Autowired
  private YAMLConfig myConfig;

  @Scheduled(fixedRate = 2000)
  public void scheduleFixedRateTask() {
    System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
    System.out.println(atManager.getLineCount());
    System.out.println("yaml " + myConfig.getName());
    System.out.println("at " + myConfig.getAttenders().get(0).getJob());
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class);

  }

}
