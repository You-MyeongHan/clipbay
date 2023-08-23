package com.bayclip.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {
	private String accessToken;
	private String refreshToken;
	private Integer id;
	private String nick;
	private String email;
	private Integer point;
}
