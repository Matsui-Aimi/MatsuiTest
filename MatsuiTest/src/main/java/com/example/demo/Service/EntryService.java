package com.example.demo.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.EntryEntity;
import com.example.demo.Repository.EntryRepository;
import com.example.demo.dto.EntryRequest;

@Service
@Transactional(rollbackFor = Exception.class)
public class EntryService {
	@Autowired
	private EntryRepository entryRepository;

	public List<EntryEntity> searchAll() {
		return entryRepository.findAll();
	}

	//新規登録
	public void create(EntryRequest entryRequest) {
		EntryEntity entry = new EntryEntity();
		entry.setUser_id(entryRequest.getUser_id());
		entry.setUser_name(entryRequest.getUser_name());
		entry.setE_mail(entryRequest.getE_mail());
		// 変換する文字列
		String string1 = entryRequest.getBirthday();
		// Stringからjava.time.LocalDateに変換する
		LocalDate localDate = LocalDate.parse(string1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		entry.setBirthday(localDate);

		entry.setComments(entryRequest.getComments());

		entryRepository.save(entry);
	}
}
