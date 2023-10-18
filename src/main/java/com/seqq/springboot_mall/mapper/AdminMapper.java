package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> adminLogin(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);

}
