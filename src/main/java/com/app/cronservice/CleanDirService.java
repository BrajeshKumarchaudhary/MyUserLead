package com.app.cronservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.app.util.ThreadExecutionService;

@Service
public class CleanDirService {
  
	Logger logger=LoggerFactory.getLogger(CleanDirService.class);
	@Autowired
	ThreadExecutionService threadservice;
	@Value("${file.upload-dir}")
    private String filepath;
	
//	@Scheduled(fixedDelay = 10000)
	public void deleteDir() throws IOException {
		logger.info("Directory Clean Scheduler is running----------");	
		File file=new File(filepath);
//		delete(file);
	}
	void delete(File f) throws IOException {
		  if (f.isDirectory()) {
		    for (File c : f.listFiles())
		      delete(c);
		  }
		  if (!f.delete())
		    throw new FileNotFoundException("Failed to delete file: " + f);
		}
	
	
	
	
}
