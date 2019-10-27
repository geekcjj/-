package com.maike.beauty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @projectname BeautyClothes
 * @author GEEKCJJ
 * @date 2019年8月13日 上午10:31:25
 * @description:
 *
 */
@SpringBootApplication
@MapperScan({"com.maike.beauty.mapper"})
public class BeautyApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeautyApplication.class, args);
	}
}
