package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.EntryEntity;

public  interface EditDeleteRepository extends JpaRepository<EntryEntity, Integer>{

}
