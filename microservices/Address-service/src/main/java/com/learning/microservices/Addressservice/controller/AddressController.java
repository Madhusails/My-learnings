package com.learning.microservices.Addressservice.controller;

import com.learning.microservices.Addressservice.dto.AddressDto;
import com.learning.microservices.Addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/address")
    public List<AddressDto> GetAll()
    {
        return addressService.FindAllAddress();
    }
    @GetMapping("/address/{studentId}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable("studentId") int studentId)
    {
        AddressDto addressDto=addressService.getAddressByStudentId(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(addressDto);
    }
}
