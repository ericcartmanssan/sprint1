package com.cg.onlinenursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlinenursery.entity.Address;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
