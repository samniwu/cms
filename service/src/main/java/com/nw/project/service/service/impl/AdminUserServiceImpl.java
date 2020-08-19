package com.nw.project.service.service.impl;

import com.nw.project.common.dto.AdminUserDTO;
import com.nw.project.common.dto.ResponseDTO;
import com.nw.project.common.enums.ErrorCode;
import com.nw.project.common.exception.ApiException;
import com.nw.project.service.dao.AdminUserDAO;
import com.nw.project.service.entity.AdminUser;
import com.nw.project.service.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * adminuser 实现类
 * @author niwu
 */
@Slf4j
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDAO adminUserDAO;

    @Override
    public ResponseDTO<AdminUserDTO> login(String userName, String password,String loginIp) throws ApiException {
        AdminUser adminUser = adminUserDAO.findByUserNameAndPassword(userName,password);
        if (null == adminUser) {
            throw new ApiException(ErrorCode.LOGIN_ERROR.getCode(),ErrorCode.LOGIN_ERROR.getMessage());
        }
        adminUser.setLastLoginIp(adminUser.getCurrentLoginIp());
        adminUser.setLastLoginTime(adminUser.getCurrentLoginTime());
        adminUser.setCurrentLoginIp(loginIp);
        adminUser.setCurrentLoginTime(new Date());
        adminUser.setUpdateTime(new Date());
        AdminUserDTO adminUserDTO = new AdminUserDTO();
        adminUserDTO.setUsername(adminUser.getUserName());
        adminUserDTO.setCurrentLoginDate(adminUser.getCurrentLoginTime());
        adminUserDTO.setCurrentLoginIp(adminUser.getCurrentLoginIp());
        adminUserDTO.setLastLoginIp(adminUser.getLastLoginIp());
        adminUserDTO.setLastLoginDate(adminUser.getLastLoginTime());
        adminUserDAO.saveAndFlush(adminUser);
        return ResponseDTO.success(adminUserDTO);
    }
}
