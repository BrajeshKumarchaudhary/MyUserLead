package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.freelance.bean.StateListBean;


@Repository
public interface StateRepo extends JpaRepository<StateListBean,Long>  {

	
	@Query(
			  value = "SELECT * FROM state s WHERE s.country_code =:code", 
			  nativeQuery = true)
	String findStateList(@Param("code") String code);

}
