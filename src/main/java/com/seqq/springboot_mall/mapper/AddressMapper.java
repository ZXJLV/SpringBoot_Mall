package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper {

    // 查询出所有省份
    List<Address> selectAddress();

    // 根据城市查城市
    List<Address> selectAddressByAddressRegionId(@Param("addressRegionId") int addressRegionId);

    //
    List<Address> selectAddressAll();

    Address selectAddressByAddressAreaId(@Param("addressAreaId") String addressAreaId);

}
