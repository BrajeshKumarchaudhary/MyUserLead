package com.app.controller;

import java.util.List;
import com.app.freelance.bean.WorkListBean;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.freelance.bean.CountryBean;
import com.app.freelance.bean.StateListBean;
import com.app.services.GenricService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/lead")
public class GenricController {
@Autowired
GenricService service;
@CrossOrigin
@GetMapping(value = "/getCountryList")
@ApiOperation(value = "get All Country ", produces = MediaType.APPLICATION_JSON_VALUE, tags = { " Genric APIs" })
public ResponseEntity<Object> getCountryList(){
	JSONObject response = new JSONObject();
	List<CountryBean> country=service.getCountryList();
	         if(country.size()>0) {
	        	 response.put("data", country);
	        	 response.put("message", "success");
	         }else {
	        	 response.put("data", country);
	        	 response.put("message", "No Data Found");
	         }
	return new ResponseEntity<>(response.toMap(), HttpStatus.OK);
}
@CrossOrigin
@GetMapping(value = "/getWorkList")
@ApiOperation(value = "get All Type work ", produces = MediaType.APPLICATION_JSON_VALUE, tags = { " Genric APIs" })
public ResponseEntity<Object> getWorkList(){
	JSONObject response = new JSONObject();
	List<WorkListBean> worklist=service.getWorkList();
	         if(worklist.size()>0) {
	        	 response.put("data", worklist);
	        	 response.put("message", "success");
	         }else {
	        	 response.put("data", worklist);
	        	 response.put("message", "No Data Found");
	         }
	return new ResponseEntity<>(response.toMap(), HttpStatus.OK);
}
@CrossOrigin
@GetMapping(value = "/getStateList")
@ApiOperation(value = "get All State List ", produces = MediaType.APPLICATION_JSON_VALUE, tags = { " Genric APIs" })
public ResponseEntity<Object> getStateList(@RequestParam(required = true,value = "countryCode") String countryCode){
	JSONObject response = new JSONObject();
	List<StateListBean> statelist=service.getStateList(countryCode);
	         if(statelist.size()>0) {
	        	 response.put("data", statelist);
	        	 response.put("message", "success");
	         }else {
	        	 response.put("data", statelist);
	        	 response.put("message", "No Data Found");
	         }
	return new ResponseEntity<>(response.toMap(), HttpStatus.OK);
}




	
	
	
}
