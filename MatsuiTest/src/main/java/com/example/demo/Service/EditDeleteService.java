package com.example.demo.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.EntryEntity;
import com.example.demo.Repository.EditDeleteRepository;
import com.example.demo.dto.EditDeleteRequest;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)

public class EditDeleteService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private EditDeleteRepository editDeleteRepository;

	/**
	 * ユーザー情報 主キー検索
	 * @return 検索結果
	 */
	public EntryEntity findById(Integer user_id) {
		return editDeleteRepository.getOne(user_id);
	}

	/**
	 * ユーザー情報 更新
	 * @param user ユーザー情報
	 */
	public void update(EditDeleteRequest editDeleteRequest) {
		EntryEntity entryEntity = new EntryEntity();
		entryEntity = findById(editDeleteRequest.getUser_id());
		entryEntity.setUser_name(editDeleteRequest.getUser_name());
		entryEntity.setE_mail(editDeleteRequest.getE_mail());
//		entryEntity.setBirthday(editDeleteRequest.getBirthday());
		// 変換する文字列
		String string1 = editDeleteRequest.getBirthday();
		// Stringからjava.time.LocalDateに変換する
		LocalDate localDate = LocalDate.parse(string1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		entryEntity.setBirthday(localDate);
		entryEntity.setComments(editDeleteRequest.getComments());

		editDeleteRepository.save(entryEntity);
	}

	/**
	 * ユーザー情報 物理削除
	 * @param id ユーザーID
	 */
	public void delete(Integer user_id) {
		EntryEntity entryEntity = findById(user_id);
		editDeleteRepository.delete(entryEntity);
	}

}
