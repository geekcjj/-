package com.maike.beauty.test;

import java.util.concurrent.atomic.AtomicInteger;

import com.maike.beauty.utils.GenerateNumUtil;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月27日 下午6:04:10
 * @description:
 *
 */
public class TestNumberID {
	private AtomicInteger id;

	public TestNumberID() {
	    id = new AtomicInteger();
	}

	public TestNumberID(int initialId) {
	    id = new AtomicInteger(initialId);
	}

	public Integer next() {
	      return id.incrementAndGet();
	}
	public static void main(String[] args) {
		//GenerateNumUtil generateNumUtil=new GenerateNumUtil();
		TestNumberID testNumberID=new TestNumberID();
    	System.out.println(GenerateNumUtil.GenerateOrder());
    	System.out.println(GenerateNumUtil.GenerateOrder());
    	System.out.println(testNumberID.next());
    	System.out.println(System.currentTimeMillis());
	}
}
