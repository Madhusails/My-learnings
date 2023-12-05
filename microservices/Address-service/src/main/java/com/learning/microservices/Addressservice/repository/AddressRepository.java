package com.learning.microservices.Addressservice.repository;

import com.learning.microservices.Addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(nativeQuery = true,value="SELECT a.id,a.district,a.lane,a.street  FROM studentaddressdatabase.address a join studentaddressdatabase.students s on a.student_id=s.id where a.student_id=1")
    Address findAddressByStudentId(@Param("studentId") int studentId);
}
