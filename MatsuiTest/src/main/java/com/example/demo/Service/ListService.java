package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.ListEntity;
import com.example.demo.Repository.ListRepository;

@Service
public class ListService {
	@Autowired
	private ListRepository listRepository;

	public List<ListEntity> searchAll() {
		return listRepository.findAll();
	  }

}
