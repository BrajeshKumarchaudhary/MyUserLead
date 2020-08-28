package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.LeadUsers;

@Repository
public interface LeadUserRepo extends JpaRepository<LeadUsers,Long> {
}
