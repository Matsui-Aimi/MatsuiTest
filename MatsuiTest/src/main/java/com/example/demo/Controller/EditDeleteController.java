package com.example.demo.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.EntryEntity;
import com.example.demo.Service.EditDeleteService;
import com.example.demo.dto.EditDeleteRequest;



/**
 * ユーザー情報 Controller
 */
@Controller
public class EditDeleteController {
	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	private EditDeleteService editDeleteService;


	/**
	 * ユーザー編集画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping("/editDelete/{user_id}")
	public String displayEdit(@PathVariable Integer user_id, Model model) {
		EntryEntity entryEntity = new EntryEntity();
		 entryEntity = editDeleteService.findById(user_id);
		EditDeleteRequest editDeleteRequest = new EditDeleteRequest();
		editDeleteRequest.setUser_id(entryEntity.getUser_id());
		editDeleteRequest.setUser_name(entryEntity.getUser_name());
		editDeleteRequest.setE_mail(entryEntity.getE_mail());
//		editDeleteRequest.setBirthday(entryEntity.getBirthday());
		// 変換する文字列
		LocalDate localDate = entryEntity.getBirthday();
		// java.time.LocalDateからStringに変換する
		String string = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		editDeleteRequest.setBirthday(string);
		
		editDeleteRequest.setComments(entryEntity.getComments());

		model.addAttribute("editDeleteRequest", editDeleteRequest);
		return "editDelete";
	}

	/**
	 * ユーザー更新
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@PostMapping("/editDelete/update/{user_id}")
	public String update(@Validated @ModelAttribute EditDeleteRequest editDeleteRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();

			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "editDelete";
		}

		// ユーザー情報の更新
		editDeleteService.update(editDeleteRequest);
		return "redirect:/list";
	}

	/**
	 * ユーザー情報削除
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/Delete/{user_id}")
	public String delete(@PathVariable Integer user_id, Model model) {
		// ユーザー情報の削除
		editDeleteService.delete(user_id);
		return "redirect:/list";
	}

}
