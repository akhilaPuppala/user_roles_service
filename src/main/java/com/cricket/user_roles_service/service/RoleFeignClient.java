package com.cricket.user_roles_service.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cricket.user_roles_service.pojo.RolePojo;

@FeignClient(name = "role-service", url = "http://localhost:8082/api/roles")


public interface RoleFeignClient {
	
	@GetMapping("/")
    List<RolePojo> getAllRoles();
	
	

}
