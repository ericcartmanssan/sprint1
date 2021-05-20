package com.cg.onlinenursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlinenursery.entity.Customer;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}

