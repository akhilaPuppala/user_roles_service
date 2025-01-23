package com.cricket.user_roles_service.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRolesPojo {
	
	private int userId;
    private List<String> roles;

}
