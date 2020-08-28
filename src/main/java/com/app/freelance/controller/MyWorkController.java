package com.app.freelance.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.freelance.bean.FreeLance;
import com.app.freelance.service.FreelanceWorkService;
import com.app.model.LeadUsers;
import com.app.request.FreeLanceRequest;
import com.app.request.LeadRequestPayload;
import com.app.services.LeadUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/freelance_work")
public class MyWorkController {
	Logger logger = LoggerFactory.getLogger(MyWorkController.class);
	@Autowired
	FreelanceWorkService leadService;

	@PostMapping("/createLead")
	@ApiOperation(value = " Create New Lead ", produces = MediaType.APPLICATION_JSON_VALUE, tags = { " Work Lead APIs" })
	public ResponseEntity<Object> getLeadStatus(@Validated @RequestBody FreeLanceRequest payload) {
		JSONObject response = new JSONObject();
		try {
			FreeLance lead = prepareRequest(payload);
			if(leadService.createNewLead(lead)>0) {
			   response.put("Message", "Succuess");
			}else {
				response.put("Message", "Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return new ResponseEntity<>(response.toMap(), HttpStatus.OK);
	}

	public FreeLance prepareRequest(FreeLanceRequest leadPayload) {
		FreeLance lead = new FreeLance();
		try {
			lead = new FreeLance();
			lead.setOrgName(leadPayload.getOrganisationName());
			lead.setUserName(leadPayload.getUserName());
			lead.setName(leadPayload.getName());
			lead.setMiddleName(leadPayload.getMiddleName());
			lead.setLastName(leadPayload.getLastName());
			lead.setEmail(leadPayload.getEmail());
			lead.setMobile(leadPayload.getMobile());
			lead.setAltMobile(leadPayload.getAltMobile());
			lead.setCountryId(leadPayload.getCountryId());
			lead.setStateId(leadPayload.getStateId());
			lead.setStatus("Active");
			lead.setIsValidaionRequired(0);
			lead.setDomainUrl(leadPayload.getDomainUrl());
			lead.setProjectName(leadPayload.getProjectName());
			lead.setProjectInfo(leadPayload.getProjectInfo());
			lead.setProjectUlr(leadPayload.getProjectUrl());
			lead.setWorkType(leadPayload.getWorkType());
			return lead;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info("Error--" + ex.getMessage());
		}
		return lead;
	}
}