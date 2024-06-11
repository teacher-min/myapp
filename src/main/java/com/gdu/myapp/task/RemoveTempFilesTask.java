package com.gdu.myapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.gdu.myapp.service.UploadService;

public class RemoveTempFilesTask {

  @Autowired
  private UploadService uploadService;   
  
  @Scheduled(cron="0 0 3 * * ?")
  public void execute() {
    uploadService.removeTempFiles();
  }
  
}
