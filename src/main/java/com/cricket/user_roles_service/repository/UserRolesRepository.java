package com.cricket.user_roles_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cricket.user_roles_service.entity.UserRolesEntity;
@Repository

public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Integer> {

	List<UserRolesEntity> findByUserId(Integer userId);

	
}
