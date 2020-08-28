package com.app.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendSMS {
	private static final Logger logger = LoggerFactory.getLogger(SendSMS.class.getName());
	public static String sendSMSToUsers(String phnNo, String msg, String serviceProvider, String mobileCountryCode){
		String smsURL = null;
		String urlStr = null;
		 InputStream iStream = null;
		 try {
//			smsURL = "";
			 urlStr = "";
			URL url = new URL(smsURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(urlStr);
			wr.flush();
			if(conn.getResponseCode() == 200){
				iStream = conn.getInputStream();
			}else{
				iStream = conn.getErrorStream();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			logger.info("Sending SMS Response : " + sb);
			return  sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
