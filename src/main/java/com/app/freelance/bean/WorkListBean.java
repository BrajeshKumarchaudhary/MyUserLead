package com.app.freelance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "work_list")
public class WorkListBean {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private int id;
  @Column(name = "work_name", nullable = true)
  private String workName;
  @Column(name = "work_code", nullable = true)
  private String workCode;
}
