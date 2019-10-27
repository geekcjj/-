package com.maike.beauty.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月16日 上午11:03:22
 * @description:
 *
 */
public class TestJson {
	static int i = 0;
	public static void main(String[] args) {
		JSONObject result2=JSONArray.parseObject("{\"颜色\":[\"白色\",\"橙色\",\"棕色\",\"粉红色\",\"黑色\",\"蓝色\",\"绿色\"],\"尺寸\":[\"S\",\"M\",\"L\",\"XL\",\"XXL\",\"XXS\",\"XS\"]}");
		//JSONArray jarray2 = new JSONArray();
		System.out.println(JSON.toJSONString(result2));
		JSONObject result3=JSONArray.parseObject("{\"颜色\":\"橙色\",\"尺寸\":\"M\"}");
		JSONObject result4=JSONArray.parseObject("{\"颜色\":\"黄色\",\"尺寸\":\"L\"}");
		JSONObject result5=JSONArray.parseObject("{\"颜色\":\"蓝色\",\"尺寸\":\"XL\"}");
		//商家添加商品是选择不同规格的组合产生一条sku数据，然后把这条sku的规格json对象聚合到在添加的商品信息数据中
		Map<String,Object> map=new HashMap<String,Object>();
		String[] strs=new String[3];
		String[] strs1=new String[3];
		//JSONArray jsonArray = new JSONArray();
		//for(int i=0;i<3;i++) {
			strs[0]=(String) result3.get("颜色");
			strs[1]=(String)(result4.get("颜色"));
			strs[2]=(String)(result5.get("颜色"));
			strs1[0]=(String)(result3.get("尺寸"));
			strs1[1]=(String)(result4.get("尺寸"));
			strs1[2]=(String)(result5.get("尺寸"));
			map.put("颜色", strs);
			map.put("尺寸", strs1);
			//JSONObject json = new JSONObject(map);
			System.out.println("拼接成的字符串数组："+JSON.toJSONString(map));
		//}
		System.out.println("显示所有颜色的数组："+result2.get("颜色"));
		System.out.println("显示所有尺寸的数组："+result2.get("尺寸"));
		//把商品信息中的skujson数组对象与单一的skujson对象中的数据遍历比较，相同则显示单价和库存量
		JSONArray array = JSONArray.parseArray(result2.get("颜色").toString());
		for(int i=0;i<array.size();i++) {
			if(array.get(i).equals(result3.get("颜色"))) {
				System.out.println("成功");
				System.out.println("显示比对成功的数据："+array.get(i));
			}
		}
		//显示比对的数据
		//System.out.println("显示颜色数组的第一位数据："+array.get(0));
		//System.out.println(i++);
	}
}
