package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.LandingPageService;
import com.app.util.SendMailer;
@RestController
public class HomeController {
	@Autowired
	LandingPageService landingpageService;
	@RequestMapping("/home")
    public String welcome() {
        return "my";
    }
	
	
	@GetMapping("/sendMail")
    public String sendMail() {
		SendMailer mailservice=new SendMailer();
		mailservice.sendSimpleMessage("bk04031997@gmail.com", "Hi how are you");
        return "Emaail send succesfully";
    }
}
