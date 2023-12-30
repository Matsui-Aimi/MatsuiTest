package com.example.demo.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "entry" , schema = "public")
public class ListEntity {
	/**
	 * ユーザーID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	

//	   * ユーザー名
	  @Column(name = "user_name")
	  private String user_name;
	  
	  /**
	   * メールアドレス
	   */
	  @Column(name = "e_mail")
	  private String e_mail;
	  
	  /**
	   * 生年月日
	   */
	  @Column(name = "birthday")
	  private Date birthday;

	  /**
	   * 備考
	   */
	  @Column(name = "comments")
	  private String comments;


}
