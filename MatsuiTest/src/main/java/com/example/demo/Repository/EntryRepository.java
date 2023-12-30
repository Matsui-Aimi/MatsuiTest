package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.EntryEntity;

public interface EntryRepository extends JpaRepository<EntryEntity, Integer> {}
