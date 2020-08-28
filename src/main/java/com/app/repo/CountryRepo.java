package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.freelance.bean.CountryBean;


@Repository
public interface CountryRepo  extends JpaRepository<CountryBean,Long> {

}
