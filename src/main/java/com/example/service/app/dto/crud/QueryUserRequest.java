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
public class QueryUserRequest {

    @ApiModelProperty(value = "ID", required = false)
    @JsonProperty("ID")
    private Long id;

    @ApiModelProperty(value = "USERNAME", required = false)
    @JsonProperty("USERNAME")
    private String username;

    @ApiModelProperty(value = "PHONE", required = false)
    @JsonProperty("PHONE")
    private String phone;
}
