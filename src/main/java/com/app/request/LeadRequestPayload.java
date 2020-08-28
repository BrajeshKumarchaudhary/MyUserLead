package com.app.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LeadRequestPayload {
	@NotNull(message = "Please provide role!")
	@Min(value = 1, message = "Please provide role!")
	@ApiModelProperty(required = true, value = "Role", example = "USER", position = 1)
	private String role;
	@NotNull(message = "Please provide orgId!")
	@Min(value = 1, message = "Please provide orgId!")
	@ApiModelProperty(required = true, value = "OrganisationId", example = "101", position = 2)
	private long orgId;
	@NotNull(message = "Please provide username!")
	@Min(value = 1, message = "Please provide username!")
	@ApiModelProperty(required = true, value = "OrganisationId", example = "bk123", position = 3)
	private String userName;
	@NotNull(message = "Please provide name!")
	@Min(value = 1, message = "Please provide name!")
	@ApiModelProperty(required = true, value = "name", example = "bk", position = 4)

	private String name;
	@NotNull(message = "Please provide middlename!")
	@Min(value = 1, message = "Please provide middleName!")
	@ApiModelProperty(required = false, value = "MiddleName", example = "Kumar", position = 5)

	private String middleName;
	@NotNull(message = "Please provide lastname!")
	@Min(value = 1, message = "Please provide lastname!")
	@ApiModelProperty(required = false, value = "lastName", example = "bk", position = 6)

	private String lastName;
	@NotNull(message = "Please provide email!")
	@Min(value = 1, message = "Please provide email!")
	@ApiModelProperty(required = true, value = "OrganisationId", example = "bk04031997@gamil.com", position = 7)

	private String email;
	@NotNull(message = "Please provide domainId!")
	@Min(value = 1, message = "Please provide domainId!")
	@ApiModelProperty(required = true, value = "domainId", example = "1", position = 8)

	private Long domainId;
	@NotNull(message = "Please provide mobile!")
	@Min(value = 1, message = "Please provide mobile!")
	@ApiModelProperty(required = true, value = "mobile", example = "9956230789", position = 9)

	private String mobile;
	@ApiModelProperty(required = false, value = "alterNate Mobile", example = "9956230788", position = 10)

	private long altMobile;
	@NotNull(message = "Please provide countryId!")
	@Min(value = 1, message = "Please provide country Id!")
	@ApiModelProperty(required = true, value = "countryId", example = "1", position = 11)

	private int countryId;
	@NotNull(message = "Please provide alternate StateId!")
	@Min(value = 1, message = "Please provide stateId")
	@ApiModelProperty(required = true, value = "StateId", example = "9", position = 12)

	private int stateId;
	@NotNull(message = "Please provide domainUrl!")
	@Min(value = 1, message = "Please provide DomainUrl!")
	@ApiModelProperty(required = true, value = "domainUrl", example = "www.sun.com", position = 13)
	 private String domainUrl;
	
	@NotNull(message = "Please provide projectName!")
	@Min(value = 1, message = "Please provide ProjectName!")
	@ApiModelProperty(required = true, value = "projectName", example = "GlobalPark", position = 14)
	 private String projectName;
	
	@NotNull(message = "Please provide projectId!")
	@Min(value = 1, message = "Please provide ProjectId!")
	@ApiModelProperty(required = true, value = "projectId", example = "9090", position = 15)
	  private long projectId;
	
	@NotNull(message = "Please provide projectInfo!")
	@Min(value = 1, message = "Please provide ProjectInfo!")
	@ApiModelProperty(required = true, value = "projectInfo", example = "GlobalPark", position = 16)
	private String projectInfo;
	
	@NotNull(message = "Please provide projectUrl!")
	@Min(value = 1, message = "Please provide ProjectUrl!")
	@ApiModelProperty(required = true, value = "projectUrl", example = "/SonuCity/gloabalPark", position = 17)
	private String projectUrl;
   
	@NotNull(message = "Please provide projectLat!")
	@Min(value = 1, message = "Please provide ProjectLat!")
	@ApiModelProperty(required = true, value = "projectLat", example = "79.91", position = 17)
	private float projectLat;

	@NotNull(message = "Please provide projectLong!")
	@Min(value = 1, message = "Please provide ProjectLong!")
	@ApiModelProperty(required = true, value = "projectLong", example = "79.91", position = 17)
	private float projectLong;

}
