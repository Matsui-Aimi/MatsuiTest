package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class EditDeleteRequest implements Serializable{
	
	@NotEmpty(message="名前を入力してください")
	private String user_name;

	@NotEmpty(message="メールアドレスを入力してください")
	private String e_mail;

	@NotEmpty(message="生年月日を入力してください")
	private String birthday;
	
	@Size(max = 100)
	private String comments;


	private Integer user_id;

}
