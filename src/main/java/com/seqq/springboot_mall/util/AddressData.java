package com.seqq.springboot_mall.util;

import com.seqq.springboot_mall.entity.Address;

import java.util.List;

public class AddressData {

    private List<Address> cityList;
    private List<Address> districtList;

    public AddressData(List<Address> cityList, List<Address> districtList) {
        this.cityList = cityList;
        this.districtList = districtList;
    }

    public List<Address> getCityList() {
        return cityList;
    }

    public void setCityList(List<Address> cityList) {
        this.cityList = cityList;
    }

    public List<Address> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<Address> districtList) {
        this.districtList = districtList;
    }
}
