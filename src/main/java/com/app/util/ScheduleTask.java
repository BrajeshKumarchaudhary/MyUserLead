package com.app.util;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;

public class ScheduleTask {
	Logger logger=LoggerFactory.getLogger(ScheduleTask.class);
	@Autowired
	ThreadExecutionService threadService;
	@Autowired 
	SendSMSWithTwilio smswithtwilio;
	@Autowired
	TaskScheduler taskscheduler;
	@Autowired
	SendMailer sendmailer;
	public void sendLeadAgentsSms(String toMobileNo)
	{
		Runnable exe1 = () -> {
			try {
				this.smswithtwilio.sendSMS(toMobileNo);
			} catch (Exception ex) {
				logger.info(ex.getMessage());
			}
		};
		this.taskscheduler.schedule(exe1,addSecondsToDate(new Date(), 3));
	}
	public void sendLeadMailer(String email)
	{
		Runnable exe1 = () -> {
			try {
				this.sendmailer.sendmailer(email);
			} catch (Exception ex) {
				logger.info(ex.getMessage());
			}
		};
		this.threadService.executeScheduleTask(exe1, 2);
	}
	
	
	
	
	public static Date addSecondsToDate(Date settledDate, Integer seconds) {
	      Calendar cal = Calendar.getInstance();
	      cal.setTime(settledDate);
	      cal.add(Calendar.SECOND, seconds);
	      return cal.getTime();
	  }
	

}
