package com.app.freelance.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "state")
public class StateListBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private int id;
  @Column(name = "state_name", nullable = true)
  private String stateName;
  @Column(name = "state_code", nullable = true)
  private String stateCode;
  @Column(name = "country_code", nullable = true)
  private String countryCode;
}

