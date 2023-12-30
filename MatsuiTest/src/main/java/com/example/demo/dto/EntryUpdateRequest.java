package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)

public class EntryUpdateRequest extends EntryRequest implements Serializable {

	  /**
	   * ユーザーID
	   */
	  @NotNull
	  private Integer id;
	}

