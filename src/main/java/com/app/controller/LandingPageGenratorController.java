package com.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.app.config.ReportTemplateEngine;
import com.app.model.LeadUsers;
import com.app.request.LeadRequestPayload;
import com.app.services.LandingPageService;
import com.app.services.LeadUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/landingpage")
public class LandingPageGenratorController {
	Logger logger = LoggerFactory.getLogger(LeadUserController.class);
	@Autowired
	LeadUserService leadService;
	@Autowired
	private SpringTemplateEngine templateEngine;
	@Autowired
	LandingPageService landingpageservice;

	@GetMapping("/createLandingPage")
	@ApiOperation(value = " Create New Lead ", produces = "application/zip", tags = { " Landing Page Genrator" })
	public byte[] createLandingPage(HttpServletResponse response) throws IOException {
		// setting headers
		response.setContentType("application/zip");
		response.setStatus(HttpServletResponse.SC_OK);
		response.addHeader("Content-Disposition", "attachment; filename=\"test.zip\"");
		final String htmlContent = this.templateEngine.process("my", getContext());
		byte[] fileName = landingpageservice.genrateLandingPage(htmlContent);
		return fileName;
	}
	@GetMapping("/createPage")
	@ApiOperation(value = " Create New Landing Page and get Path ",produces = MediaType.APPLICATION_JSON_VALUE,tags = { " Landing Page Genrator" })
	public ResponseEntity<Object>  createPage() throws IOException {
		JSONObject response = new JSONObject();		
		final String htmlContent = this.templateEngine.process("my", getContext());
		String fileName = landingpageservice.genratePage(htmlContent);
		response.put("message","success");
		response.put("filePath", fileName);
		return new ResponseEntity<>(response.toMap(), HttpStatus.OK);
	}

	public Context getContext() {
		final Context ctx = new Context();
//		ctx.setVariable("name", recipientName);
//		ctx.setVariable("subscriptionDate", new Date());
//		ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
//		ctx.setVariable("imageResourceName", imageResourceName); // so that we can reference it from HTML
		return ctx;
	}

}
