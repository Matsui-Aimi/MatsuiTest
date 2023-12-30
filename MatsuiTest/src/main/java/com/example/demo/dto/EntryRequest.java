package com.example.demo.dto;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EntryRequest {
	/**
	 * ユーザー情報 リクエストデータ
	 */
	/**
	  * ユーザーID
	  */
	private Integer user_id;

	/**
	 * ユーザー名
	 */
	@NotEmpty(message = "氏名を入力してください")
	private String user_name;
	/**
	 * メールアドレス
	 */
	@NotEmpty(message = "メールアドレスを入力してください")
	private String e_mail;

	// 生年月日
	@NotEmpty(message = "生年月日を入力してください")
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String birthday;

	/**
	 *備考
	 */
	@Size(max = 100)
	private String comments;

}
