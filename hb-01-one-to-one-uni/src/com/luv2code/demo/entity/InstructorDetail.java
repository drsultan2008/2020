package com.luv2code.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	InstructorDetail(){
		
	}

	public InstructorDetail(String youtubeChanel, String hobby) {
		super();
		this.youtubeChannel = youtubeChanel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChanel() {
		return youtubeChannel;
	}

	public void setYoutubeChanel(String youtubeChanel) {
		this.youtubeChannel = youtubeChanel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChanel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
}
