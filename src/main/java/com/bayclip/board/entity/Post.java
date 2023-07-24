package com.bayclip.board.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.bayclip.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name="post")
@NamedEntityGraph(name = "Post.userWithNick", attributeNodes = @NamedAttributeNode(value = "user", subgraph = "userNick"))
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String category;
	private String content;
	@CreationTimestamp
	private LocalDateTime  wr_date;
	private LocalDateTime  re_date;
	private LocalDateTime  del_date;
	@ColumnDefault("0")
	@Column(name="view_cnt")
	private Integer viewCnt;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	@JsonIgnore
    private User user;
	private String nick;
	private String thumbnail;
//	@Version
//    private int version;
	
	@ElementCollection
	@CollectionTable(
		name="post_recommendations",
		joinColumns=@JoinColumn(name="post_id")
	)
	@Column(name="user_id")
	private Set<Integer> recommendations=new HashSet<>();
	
	@ElementCollection
	@CollectionTable(
		name="post_decommendations",
		joinColumns=@JoinColumn(name="post_id")
	)
	@Column(name="user_id")
	private Set<Integer> decommendations=new HashSet<>();
	
	@Transactional
	public void updateViewCnt(Integer visit) {
		this.viewCnt=visit;
	}
}