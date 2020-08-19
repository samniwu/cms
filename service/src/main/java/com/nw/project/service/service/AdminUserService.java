package com.nw.project.service.service;

import com.nw.project.common.dto.AdminUserDTO;
import com.nw.project.common.dto.ResponseDTO;
import com.nw.project.common.exception.ApiException;

public interface AdminUserService {

    ResponseDTO<AdminUserDTO> login(String userName,String password,String loginIp) throws ApiException;
}
