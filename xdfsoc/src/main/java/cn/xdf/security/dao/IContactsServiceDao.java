package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.ContactsService;

public interface IContactsServiceDao  extends JpaRepository<ContactsService, Long> {

	public ContactsService findByGoodsBillCode(String goodsBillCode);

}
