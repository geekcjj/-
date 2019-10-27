package com.maike.beauty.entity;

import lombok.Data;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月16日 下午7:27:27
 * @description:
 *
 */
@Data
public class Message {
	private String username;
	private String to_username;
	private String content;
	private String date;
	public Message(String username, String content, String date) {
	  super();
	  this.username = username;
	  this.content = content;
	  this.date = date;
	}
}
