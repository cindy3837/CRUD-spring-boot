package com.example.service.app.dto.crud;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddUserRequest {

    @ApiModelProperty(value = "ID", required = false)
    @JsonProperty("ID")
    private Long id;

    @ApiModelProperty(value = "USERNAME", required = true)
    @JsonProperty("USERNAME")
    private String username;

    @ApiModelProperty(value = "PHONE", required = true)
    @Size(min=10, message="Must 10")
    @JsonProperty("PHONE")
    private String phone;
}
