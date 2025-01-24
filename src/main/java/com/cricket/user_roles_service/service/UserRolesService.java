package com.cricket.user_roles_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.user_roles_service.entity.UserRolesEntity;
import com.cricket.user_roles_service.pojo.RolePojo;
import com.cricket.user_roles_service.pojo.UserRolesPojo;
import com.cricket.user_roles_service.repository.UserRolesRepository;
@Service
public class UserRolesService {
	
	@Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private RoleFeignClient roleFeignClient;

 
    public List<String> getRolesByUserId(Integer userId) {
    
        List<UserRolesEntity> userRoles = userRolesRepository.findByUserId(userId);
        List<Integer> allRoleIds = userRoles.stream()
                                         .map(UserRolesEntity::getRoleId)
                                         .collect(Collectors.toList());

        
        List<RolePojo> allRolePojo = roleFeignClient.getAllRoles();

        List<String> allRoles = new ArrayList<String>();
       for(RolePojo eachRole: allRolePojo) {
    	   for(int roleId: allRoleIds) {
    		   if(roleId == eachRole.getRoleId()) {
    			   allRoles.add(eachRole.getRoleName());
    			   break;
    		   }
    	   }
       }
        
        return allRoles;
    }


	public UserRolesEntity createUserRole(UserRolesEntity entity) {
		UserRolesEntity saved=userRolesRepository.saveAndFlush(entity);
		return saved;
	}

}
