package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.LeadUsers;
import com.app.repo.LeadUserRepo;

@Service
public class LeadUserService {
@Autowired
LeadUserRepo leaduserrepo;

public long createNewLead(LeadUsers lead)
{
	LeadUsers leadsave= leaduserrepo.save(lead);
	return leadsave.getId();
}

}
