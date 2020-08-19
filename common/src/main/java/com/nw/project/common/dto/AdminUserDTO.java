package com.nw.project.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息DTO
 * @author niwu
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminUserDTO {

    private String username;

    private String password;

    private String phone;

    private String email;

    private Date lastLoginDate;

    private String lastLoginIp;

    private String currentLoginIp;

    private Date currentLoginDate;
}
