package com.example.spring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/** @author pablo.paparini */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {

  private String name;
  private String environment;
  private List<String> servers = new ArrayList<String>();
  private List<Attenders> attenders = new ArrayList<Attenders>();


  public List<Attenders> getAttenders() {
    return attenders;
  }

  public void setAttenders(List<Attenders> attenders) {
    this.attenders = attenders;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public List<String> getServers() {
    return servers;
  }

  public void setServers(List<String> servers) {
    this.servers = servers;
  }



}
