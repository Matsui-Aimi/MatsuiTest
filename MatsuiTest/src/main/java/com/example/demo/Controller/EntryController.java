package com.example.demo.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.EntryService;
import com.example.demo.dto.EntryRequest;
/**
 * ユーザー情報 Controller
 */
@Controller
public class EntryController {
	/**
	   * ユーザー情報 Service
	   */
	@Autowired
	private EntryService entryService;

		
		 @GetMapping(value = "/entry")
		  public String displayAdd(Model model) {
		    model.addAttribute("entryRequest", new EntryRequest());
		    return "entry";
		  }
			
		//登録
	@PostMapping("/entry/add")
	public String create(@Validated @ModelAttribute EntryRequest entryRequest, BindingResult result,
			Model model) {
		//入力判定
		if (result.hasErrors()) {
			// 入力チェックエラー
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			//エラー判定後の画面遷移
			model.addAttribute("validationError", errorList);
			return "entry";
		}
		// 出勤情報の登録
		entryService.create(entryRequest);
		return "redirect:/list";
	}	

}
