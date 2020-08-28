package com.app.services;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.freelance.bean.CountryBean;
import com.app.freelance.bean.StateListBean;
import com.app.freelance.bean.WorkListBean;
import com.app.repo.CountryRepo;
import com.app.repo.StateRepo;
import com.app.repo.WorkRepo;
import com.app.util.QueryService;
@Service
public class GenricService {
    @Autowired
    CountryRepo countryrepo;
    @Autowired    
    WorkRepo workrepo;
    @Autowired
    QueryService queryservice;
    @Autowired
    StateRepo staterepo;
	public List<CountryBean> getCountryList() {
		return countryrepo.findAll();
	}
	public List<WorkListBean> getWorkList() {
		return workrepo.findAll();
	}
	public List<StateListBean> getStateList(String code) {
		List<StateListBean> statelist=new LinkedList<>();
		queryservice.executeQuery(getQuery(code)).forEach(value->{
			JSONObject object=(JSONObject)value;
			StateListBean temp=new StateListBean();
			temp.setCountryCode(object.getString("country_code"));
			temp.setId(object.getInt("id"));
			temp.setStateCode(object.getString("state_code"));
			temp.setStateName(object.getString("state_name"));
			statelist.add(temp);
		});
		return statelist;
	}
  private static String getQuery(String code) {
	  return "SELECT * FROM state s WHERE s.country_code='mycode'".replace("mycode", code);
  }
}
