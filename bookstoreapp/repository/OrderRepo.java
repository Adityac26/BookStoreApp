package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderData,Long> {
}
