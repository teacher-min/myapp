package com.gdu.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.gdu.myapp.task.RemoveBlogImageTask;
import com.gdu.myapp.task.RemoveTempFilesTask;

@EnableScheduling
@Configuration
public class TaskConfig {

  @Bean
  RemoveBlogImageTask removeBlogImageTask() {
    return new RemoveBlogImageTask();
  }
  
  @Bean
  RemoveTempFilesTask removeTempFilesTask() {
    return new RemoveTempFilesTask();
  }
  
}
