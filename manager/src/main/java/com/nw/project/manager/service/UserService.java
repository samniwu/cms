package com.nw.project.manager.service;

import com.nw.project.common.dto.AdminUserDTO;
import com.nw.project.common.dto.ResponseDTO;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    /**
     * 登录命令
     * @param adminUserRequestDTO
     * @return
     */
    ResponseDTO login(HttpServletRequest request,AdminUserDTO adminUserRequestDTO);
}
