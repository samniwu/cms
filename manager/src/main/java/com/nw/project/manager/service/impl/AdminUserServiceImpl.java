package com.nw.project.manager.service.impl;

import com.alibaba.fastjson.JSON;
import com.netflix.discovery.EurekaClient;
import com.nw.project.common.dto.AdminUserDTO;
import com.nw.project.common.dto.ResponseDTO;
import com.nw.project.common.enums.ErrorCode;
import com.nw.project.common.utils.HttpUtil;
import com.nw.project.manager.service.FeignClientService;
import com.nw.project.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class AdminUserServiceImpl implements UserService {

    @Autowired
    private FeignClientService feignClientService;
    @Override
    public ResponseDTO login(HttpServletRequest request,AdminUserDTO adminUserDTO) {
        String loginIp = HttpUtil.getIpAddr(request);
        adminUserDTO.setCurrentLoginIp(loginIp);
        String result = feignClientService.login(adminUserDTO);
        if (StringUtils.isBlank(result)) {
            return ResponseDTO.error(ErrorCode.HTTP_REQUEST_ERROR);
        } else {
            return JSON.parseObject(result,ResponseDTO.class);
        }
    }
}
