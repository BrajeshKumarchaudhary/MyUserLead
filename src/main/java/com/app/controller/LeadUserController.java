package com.app.controller;

import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.LeadUsers;
import com.app.request.LeadRequestPayload;
import com.app.services.LeadUserService;

import io.swagger.annotations.ApiOperation;
import javassist.expr.Instanceof;

@RestController
@RequestMapping("api/v1/lead")
public class LeadUserController {
	Logger logger = LoggerFactory.getLogger(LeadUserController.class);
	@Autowired
	LeadUserService leadService;

	@PostMapping("/createLead")
	@ApiOperation(value = " Create New Lead ", produces = MediaType.APPLICATION_JSON_VALUE, tags = { " Lead APIs" })
	public ResponseEntity<Object> getLeadStatus(@Validated @RequestBody LeadRequestPayload payload) {
		JSONObject response = new JSONObject();
		try {
			LeadUsers lead = prepareRequest(payload);
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

	public LeadUsers prepareRequest(LeadRequestPayload leadPayload) {
		LeadUsers lead = new LeadUsers();
		try {
			lead = new LeadUsers();
			lead.setRole(leadPayload.getRole());
			lead.setOrgId(leadPayload.getOrgId());
			lead.setIsheadUser(leadPayload.getRole() == "ADMIN" ? 1 : 0);
			lead.setUserName(leadPayload.getUserName());
			lead.setName(leadPayload.getName());
			lead.setMiddleName(leadPayload.getMiddleName());
			lead.setLastName(leadPayload.getLastName());
			lead.setEmail(leadPayload.getEmail());
			lead.setDomainId(leadPayload.getDomainId());
			lead.setMobile(leadPayload.getMobile());
			lead.setAltMobile(leadPayload.getAltMobile());
			lead.setCountryId(leadPayload.getCountryId());
			lead.setStateId(leadPayload.getStateId());
			lead.setStatus("Active");
			lead.setIsValidaionRequired(0);
			lead.setDomainUrl(leadPayload.getDomainUrl());
			lead.setProjectName(leadPayload.getProjectName());
			lead.setProjectId(leadPayload.getProjectId());
			lead.setProjectInfo(leadPayload.getProjectInfo());
			lead.setProjectUlr(leadPayload.getProjectUrl());
			lead.setProjectLat((float)leadPayload.getProjectLat());
			lead.setProjectLong((float)leadPayload.getProjectLong());
			return lead;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info("Error--" + ex.getMessage());
		}
		return lead;
	}

}
