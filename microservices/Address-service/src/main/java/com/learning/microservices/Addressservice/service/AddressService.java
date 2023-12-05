package com.learning.microservices.Addressservice.service;

import com.learning.microservices.Addressservice.dto.AddressDto;
import com.learning.microservices.Addressservice.entity.Address;
import com.learning.microservices.Addressservice.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<AddressDto> FindAllAddress()
    {
        List<Address> address=addressRepository.findAll();
        List<AddressDto> addressDtos=address.stream().map(a->modelMapper.map(a,AddressDto.class))
                .collect(Collectors.toList());
        return addressDtos;
    }
    public AddressDto getAddressByStudentId(int studentId)
    {
        Address address=addressRepository.findAddressByStudentId(studentId);
        AddressDto addressDto=modelMapper.map(address, AddressDto.class);
        return addressDto;
    }
}
