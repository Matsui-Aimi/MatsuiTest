package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.ListEntity;
import com.example.demo.Service.ListService;

@Controller
public class ListController {
	
	@Autowired
	private ListService listService;


	@GetMapping(value ="/list")
		public String displayList(Model model) {
	    List<ListEntity> list = listService.searchAll();
		    model.addAttribute("list", list);
		    return "list";
	  }

}
