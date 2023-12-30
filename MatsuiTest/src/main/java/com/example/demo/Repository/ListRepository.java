package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.ListEntity;


public interface ListRepository extends JpaRepository<ListEntity, Integer> {
	
}
