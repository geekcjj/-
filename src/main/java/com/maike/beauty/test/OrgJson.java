package com.maike.beauty.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月16日 下午4:37:41
 * @description:
 *
 */
public class OrgJson {
	public static void main(String[] args) throws IOException {
		String jsonStr ="{\"颜色\":[\"白色\",\"橙色\",\"棕色\",\"粉红色\",\"黑色\",\"蓝色\",\"绿色\"],\"尺寸\":[\"S\",\"M\",\"L\",\"XL\",\"XXL\",\"XXS\",\"XS\"]}";
		//将整个json字符串转换成JSONObject对象
		JSONObject jo = new JSONObject(jsonStr);
		System.out.println("jsonStr:"+jo.toString());
		System.out.println("颜色:"+jo.getString("颜色")+" 尺寸:"+jo.getString("尺寸"));
		//读取json中的对象
		JSONObject jo1 = jo.getJSONObject("颜色");
		System.out.println("颜色:"+jo1.toString());
		//System.out.println("sex:"+jo1.getString("sex")+" hobby:"+jo1.getString("hobby"));
		//读取json中的数组
//		JSONArray ja = jo.getJSONArray("parents");
//		System.out.println(ja.toString());
//		JSONObject jo1_father = ja.getJSONObject(0);
//		System.out.println("father:"+jo1_father.getString("father")+" job:"+jo1_father.getString("job"));
//		JSONObject jo1_mother = ja.getJSONObject(1);
//		System.out.println("mother:"+jo1_mother.getString("mother")+" job:"+jo1_mother.getString("job"));
		
		//读取json文件
		//方法一：按照上面操作json字符串的原理，我们可以先将json文件转换成字符串在进行操作（注意填写正确的文件路径）
//		FileReader fr = new FileReader(new File("file/test.json"));
//		BufferedReader br = new BufferedReader(fr);
//		String fileStr ="";
//		String tempStr = br.readLine();
//		while(tempStr!=null) {
//			fileStr += tempStr;
//			tempStr = br.readLine();
//		}
//		//生成JSONObject对象，后续操作上面相同
//		JSONObject jo2 = new JSONObject(fileStr);
//		System.out.println("jsonFile:"+jo2.toString());
//		
//		//方法二:使用JSONTokener读取json文件，之后转换为JSONObject对象，后续操作与上面相同（注意填写正确的文件路径）
//		JSONTokener jt = new JSONTokener(new FileReader(new File("file/test.json")));
//		JSONObject jo3 = (JSONObject)jt.nextValue();
//		System.out.println("jsonFile:"+jo3.toString());
	}
}
