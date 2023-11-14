package com.seqq.springboot_mall.service.impl;

import com.seqq.springboot_mall.entity.Address;
import com.seqq.springboot_mall.mapper.AddressMapper;
import com.seqq.springboot_mall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> selectAddress() {
        return addressMapper.selectAddress();
    }

    @Override
    public List<Address> selectAddressByAddressRegionId(int addressRegionId) {
        return addressMapper.selectAddressByAddressRegionId(addressRegionId);
    }

    @Override
    public List<Address> selectAddressAll() {
        return addressMapper.selectAddressAll();
    }

    @Override
    public Address selectAddressByAddressAreaId(String addressAreaId) {
        return addressMapper.selectAddressByAddressAreaId(addressAreaId);
    }
}
