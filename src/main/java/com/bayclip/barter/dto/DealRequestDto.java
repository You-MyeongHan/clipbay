package com.bayclip.barter.dto;

import lombok.Data;

@Data
public class DealRequestDto {
	private long fromItemId;
	private long toItemId;
	private String content;
	private Integer toUserId;
}