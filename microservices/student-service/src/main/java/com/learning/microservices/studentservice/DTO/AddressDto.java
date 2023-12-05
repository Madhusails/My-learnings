package com.learning.microservices.studentservice.DTO;

public class AddressDto {
    private int id;
    private String lane;
    private String street;
    private String district;
    public AddressDto()
    {

    }

    public AddressDto(int id, String lane, String street, String district) {
        this.id = id;
        this.lane = lane;
        this.street = street;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
