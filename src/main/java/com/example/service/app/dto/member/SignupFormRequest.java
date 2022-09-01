package com.example.service.app.dto.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupFormRequest {

    @ApiModelProperty(value = "帳號", required = true)
    @JsonProperty("ACCOUNT_NAME")
    private String accountName;

    @ApiModelProperty(value = "密碼", required = true)
    @JsonProperty("PASSWORD")
    private String password;

    @ApiModelProperty(value = "確認密碼", required = true)
    @JsonProperty("CONFIRM_PASSWORD")
    private String confirmPassword;
}
