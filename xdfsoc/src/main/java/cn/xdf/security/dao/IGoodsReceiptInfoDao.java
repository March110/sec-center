package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.GoodsReceiptInfo;

public interface IGoodsReceiptInfoDao extends JpaRepository<GoodsReceiptInfo, Long> {

}