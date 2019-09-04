package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.UserGroup;

public interface IGroupDao extends JpaRepository<UserGroup, Long> {
	
	public UserGroup findByGroupName(String groupName);
	
	public UserGroup findById(int id);
	
}
