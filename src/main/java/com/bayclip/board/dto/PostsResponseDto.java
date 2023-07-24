package com.bayclip.board.dto;

import java.time.LocalDateTime;

import com.bayclip.board.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PostsResponseDto {
	private final String title;
	private final Long id;
	private final String nick;
	private final String category;
	private final LocalDateTime wr_date;
	private final Integer view_cnt;

	
	public static PostsResponseDto from(Post post) {
		return new PostsResponseDto(post);
	}
	
	private PostsResponseDto(Post post) {
		this.title=post.getTitle();
		this.nick=post.getNick();
		this.id=post.getId();
		this.category=post.getCategory();
		this.wr_date=post.getWr_date();
		this.view_cnt=post.getViewCnt();
	}
}