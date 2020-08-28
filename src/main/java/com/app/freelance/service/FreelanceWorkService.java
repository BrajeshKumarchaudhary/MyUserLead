package com.app.freelance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.freelance.bean.FreeLance;
import com.app.freelance.repo.FreelanceRepo;

@Service
public class FreelanceWorkService {
	@Autowired
	FreelanceRepo repo;
	public long createNewLead(FreeLance lead)
	{
		FreeLance leadsave=repo.save(lead);
		return leadsave.getId();
	}

}
