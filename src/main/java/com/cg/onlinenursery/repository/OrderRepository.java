package com.cg.onlinenursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlinenursery.entity.Order;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
