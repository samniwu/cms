package com.nw.project.manager.service;

import com.nw.project.common.consts.ApiConsts;
import com.nw.project.common.dto.AdminUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 客户端
 * @author niwu
 */
@FeignClient(name = "${eureka.instanceName}")
public interface FeignClientService {

    @RequestMapping(value= ApiConsts.API_PREFIX_USER + ApiConsts.API_LOGIN, method = RequestMethod.POST)
    String login(@RequestBody AdminUserDTO adminUserDTO);
}
