package com.example.service.app.dto.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {

    @ApiModelProperty(value = "帳號", required = true)
    @JsonProperty("ACCOUNT_NAME")
    private String accountName;

    @ApiModelProperty(value = "舊密碼", required = true)
    @JsonProperty("OLD_PASSWORD")
    private String oldPassword;

    @ApiModelProperty(value = "新密碼", required = true)
    @JsonProperty("NEW_PASSWORD")
    private String newPassword;

    @ApiModelProperty(value = "確認新密碼", required = true)
    @JsonProperty("CONFIRM_NEW_PASSWORD")
    private String confirmNewPassword;
}
