package com.app.util;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

//@Service
public class SendSMSWithTwilio {
	public static final String ACCOUNT_SID = "XXXXXXXXXXXXXXXXXXXX";
	   public static final String AUTH_TOKEN = "XXXXXXXXXXXXXXXXXXXXX";
	   public static final String TWILIO_NUMBER = "+XXXXXXX";

	   public void sendSMS(String toNumber){
	      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	      Message message = Message.creator(
	            new PhoneNumber(toNumber),
	            new PhoneNumber(TWILIO_NUMBER),
	            "Sample message twilio using Spring")
	            .create();
	   }
}
