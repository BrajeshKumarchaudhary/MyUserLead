package com.app.freelance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.freelance.bean.FreeLance;


public interface FreelanceRepo extends JpaRepository<FreeLance,Long>  {

}
