package com.seqq.springboot_mall.service;

import com.seqq.springboot_mall.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressService {

    // 查询出所有省份
    List<Address> selectAddress();

    // 根据城市查城市
    List<Address> selectAddressByAddressRegionId(int addressRegionId);

    List<Address> selectAddressAll();

    Address selectAddressByAddressAreaId(String addressAreaId);
}
