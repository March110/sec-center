package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.BillRelease;

public interface IBillReleaseDao extends JpaRepository<BillRelease, Long> {

}
