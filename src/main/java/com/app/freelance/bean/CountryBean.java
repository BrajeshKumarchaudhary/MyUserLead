package com.app.freelance.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "country")
public class CountryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private int id;
  @Column(name = "country_name", nullable = true)
  private String countryName;
  @Column(name = "country_code", nullable = true)
  private String countryCode;
}
