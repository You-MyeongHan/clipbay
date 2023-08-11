package com.bayclip.auth.dto;

import com.bayclip.user.dto.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
	private String uid;
	private String pwd;
	private String nick;
	private String email;
	private Boolean emailReceive;
	private Role role;
}
