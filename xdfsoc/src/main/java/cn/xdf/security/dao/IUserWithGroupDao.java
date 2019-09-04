package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.UserWithGroup;

public interface IUserWithGroupDao extends JpaRepository<UserWithGroup, Long> {

	public UserWithGroup findByUserId(String userId);
	
}
