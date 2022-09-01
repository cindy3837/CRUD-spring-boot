package com.example.service.app.dto.crud;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    @ApiModelProperty(value = "ID", required = true)
    @JsonProperty("ID")
    private Long id;

    @ApiModelProperty(value = "USERNAME", required = true)
    @JsonProperty("USERNAME")
    private String username;

    @ApiModelProperty(value = "PHONE", required = true)
    @JsonProperty("PHONE")
    private String phone;
}
