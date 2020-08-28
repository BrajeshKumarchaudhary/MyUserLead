package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.freelance.bean.WorkListBean;
@Repository
public interface WorkRepo extends JpaRepository<WorkListBean,Long> {

}
