package com.nw.project.manager.controller;

import com.nw.project.common.consts.ApiConsts;
import com.nw.project.common.dto.AdminUserDTO;
import com.nw.project.common.dto.ResponseDTO;
import com.nw.project.manager.service.impl.AdminUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  user controller
 * @author niwu
 */
@RestController
@RequestMapping(ApiConsts.API_PREFIX_USER)
@Slf4j
public class UserController {

    @Autowired
    private AdminUserServiceImpl adminUserService;

    @PostMapping(ApiConsts.API_LOGIN)
    public ResponseDTO<AdminUserDTO> adminLogin(HttpServletRequest request,AdminUserDTO adminUserRequestDTO) {
        return adminUserService.login(request,adminUserRequestDTO);
    }
}
