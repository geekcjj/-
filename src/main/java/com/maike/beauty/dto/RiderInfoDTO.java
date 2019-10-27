package com.maike.beauty.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月21日 下午4:35:09
 * @description:
 *
 */
@Data
public class RiderInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nikename;
	private String relaname;
	private String phoone;
	private String email;
	private String identityid;
	private String user_pic;
}
