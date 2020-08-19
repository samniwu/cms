package com.nw.project.service.controller;

import com.nw.project.common.consts.ApiConsts;
import com.nw.project.common.dto.AdminUserDTO;
import com.nw.project.common.dto.ResponseDTO;
import com.nw.project.common.exception.ApiException;
import com.nw.project.service.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping(ApiConsts.API_LOGIN)
    public ResponseDTO<AdminUserDTO> login(@RequestBody AdminUserDTO adminUserDTO) throws ApiException {
        return adminUserService.login(adminUserDTO.getUsername(),adminUserDTO.getPassword(),adminUserDTO.getCurrentLoginIp());
    }

}
