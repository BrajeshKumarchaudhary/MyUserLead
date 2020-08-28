package com.app.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FreeLanceRequest {
	
	@NotNull(message = "Please provide organisationName!")
	@Min(value = 1, message = "Please provide organisationName!")
	@ApiModelProperty(required = true, value = "organisationName", example = "bk123", position = 1)
	private String organisationName;
	
	@NotNull(message = "Please provide username!")
	@Min(value = 1, message = "Please provide username!")
	@ApiModelProperty(required = true, value = "userName", example = "bk123", position = 2)
	private String userName;
	
	@NotNull(message = "Please provide name!")
	@Min(value = 1, message = "Please provide name!")
	@ApiModelProperty(required = true, value = "name", example = "bk", position = 3)
    private String name;
	
	@NotNull(message = "Please provide middlename!")
	@Min(value = 1, message = "Please provide middleName!")
	@ApiModelProperty(required = false, value = "MiddleName", example = "Kumar", position = 4)
    private String middleName;
	
	@NotNull(message = "Please provide lastname!")
	@Min(value = 1, message = "Please provide lastname!")
	@ApiModelProperty(required = false, value = "lastName", example = "bk", position = 5)
    private String lastName;
	
	@NotNull(message = "Please provide email!")
	@Min(value = 1, message = "Please provide email!")
	@ApiModelProperty(required = true, value = "OrganisationId", example = "bk04031997@gamil.com", position = 6)
    private String email;
	
	
	@NotNull(message = "Please provide work Type!")
	@Min(value = 1, message = "Please provide work Type!")
	@ApiModelProperty(required = true, value = "workType", example = "bk04031997@gamil.com", position = 7)
    private String workType;
		
	@NotNull(message = "Please provide mobile!")
	@Min(value = 1, message = "Please provide mobile!")
	@ApiModelProperty(required = true, value = "mobile", example = "9956230789", position = 8)

	private String mobile;
	@ApiModelProperty(required = false, value = "alterNate Mobile", example = "9956230788", position = 9)

	private long altMobile;
	@NotNull(message = "Please provide countryId!")
	@Min(value = 1, message = "Please provide country Id!")
	@ApiModelProperty(required = true, value = "countryId", example = "1", position = 10)

	private int countryId;
	@NotNull(message = "Please provide alternate StateId!")
	@Min(value = 1, message = "Please provide stateId")
	@ApiModelProperty(required = true, value = "StateId", example = "9", position = 11)

	private int stateId;
	@NotNull(message = "Please provide domainUrl!")
	@Min(value = 1, message = "Please provide DomainUrl!")
	@ApiModelProperty(required = true, value = "domainUrl", example = "www.sun.com", position = 12)
	 private String domainUrl;
	
	@NotNull(message = "Please provide projectName!")
	@Min(value = 1, message = "Please provide ProjectName!")
	@ApiModelProperty(required = true, value = "projectName", example = "GlobalPark", position = 13)
	 private String projectName;
	
	@NotNull(message = "Please provide projectId!")
	@Min(value = 1, message = "Please provide ProjectId!")
	@ApiModelProperty(required = true, value = "projectId", example = "9090", position = 14)
	  private long projectId;
	
	@NotNull(message = "Please provide projectInfo!")
	@Min(value = 1, message = "Please provide ProjectInfo!")
	@ApiModelProperty(required = true, value = "projectInfo", example = "GlobalPark", position = 15)
	private String projectInfo;
	
	@NotNull(message = "Please provide projectUrl!")
	@Min(value = 1, message = "Please provide ProjectUrl!")
	@ApiModelProperty(required = true, value = "projectUrl", example = "/SonuCity/gloabalPark", position = 16)
	private String projectUrl;
}
