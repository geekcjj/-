package com.maike.beauty.controller;


import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.maike.beauty.entity.DeliveryRiders;
import com.maike.beauty.enums.ResultEnum;
import com.maike.beauty.service.IDeliveryRidersService;
import com.maike.beauty.service.impl.DeliveryRidersServiceImpl;
import com.maike.beauty.utils.BaiduOCRUtils;
import com.maike.beauty.utils.Base64ImageUtils;
import com.maike.beauty.utils.FileNameUtils;
import com.maike.beauty.utils.MD5Util;
import com.maike.beauty.utils.MyException;
import com.maike.beauty.utils.Result;
import com.maike.beauty.utils.SMSUtil;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-08-15
 */
@RestController
@RequestMapping(value="/delivery-riders")
public class DeliveryRidersController extends BaseController{
	@RequestMapping(value="/print")
	public Result print(){
		//int i=0;
		return Result.success("我是陈加加");
	}
	@RequestMapping(value="/pageRiders")
	public Result selectPageDelInfo(@RequestParam int pageNum,@RequestParam int pageSize ){
		//QueryWrapper<DeliveryRiders> queryWrapper =  new QueryWrapper<>();
        //queryWrapper.orderByDesc("create_time");
		//PageHelper.startPage(0, 1);
	    //List<DeliveryRiders> deliveryRiders = deliveryRidersService.list(queryWrapper);
//	    List<UserDto> userDtos = new ArrayList<>();
//	    users.forEach(user -> {
//	        userDtos.add(dozerBeanMapper.map(user, UserDto.class));
//	    });
	    // 用PageInfo对结果进行包装
	    PageInfo<DeliveryRiders> pageInfo = deliveryRidersService.selectPageDeliveryRider(pageNum,pageSize);
	    System.out.println("数据是"+pageInfo);
		return Result.success(pageInfo);
	}
	@RequestMapping(value="/riderLogin")
	public Result loginByPhoneAndPwd(@RequestParam String phone,@RequestParam String password){
		if(phone!=null||password!=null) {
			QueryWrapper<DeliveryRiders> queryWrapper=new QueryWrapper<DeliveryRiders>();
			queryWrapper.eq("phone", phone);
			if(deliveryRidersService.getOne(queryWrapper)==null) {
				return Result.error(ResultEnum.USER_NOT_EXIST.getCode(), ResultEnum.USER_NOT_EXIST.getMsg());
			}else if(deliveryRidersService.loginByPhoneAndPwd(phone,password)>0) {
				return Result.success(deliveryRidersService.getOne(queryWrapper));
			}
		}else{
			return Result.error("手机号和密码不能为空！");
		}
		return Result.error("登录失败！");
	}
	/**
	 * @RequestBosy只能用post方法传参数
	 * @param deliveryRiders
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/addPerfectRider",method= {RequestMethod.POST},headers="content-type=multipart/form-data")
	public Result addPerfectRider(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request,@RequestParam String email,@RequestParam String nickname,
			@RequestParam String realname,@RequestParam String identityId,@RequestParam String id) throws IllegalStateException, IOException {
		DeliveryRiders riders=new DeliveryRiders();
		//String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		//String path = ResourceUtils.getURL("classpath:").getPath();
		String filePath = "http://127.0.0.1:8899/uploadFile/userpic/";//request.getServletContext().getRealPath("/")/ridersFile/userpic/
		String localpath="/Volumes/MacFile/WorkSpace/SpringBootTestFile/imageFile/userpic/";//System.getProperty("user.dir")+"/src/main/resources/static/uploadFile";
		// 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
		// 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
		//String localpath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
		//String filename=System.currentTimeMillis()+"";
		//TODO 判断文件格式是不是图片
        String contentType = multipartFile.getContentType();
        int index=contentType.indexOf('/');
        String fileType=contentType.substring(index+1);
        System.out.println("获取上传的文件名："+multipartFile.getOriginalFilename()+"文件的类型："+fileType);
        //byte[] imagebyte=Base64ImageUtils.base64ToByte(base64str, filePath, filename);
        System.out.println("pngjpgjpegJPGPNGJPEG".contains(fileType));
        if("pngjpgjpegJPGPNGJPEG".contains(fileType)) {
        	String originalFileName="riderusrpic"+FileNameUtils.getFileName(multipartFile.getOriginalFilename());
			File tmpFile = new File(localpath);
			//判断是否存在该文件夹，若不存在则创建文件夹
			if(!tmpFile.exists()){
				tmpFile.mkdir();
			}
			File file = new File(localpath, originalFileName);
	        //String fileName = file.toString();
	      //for(MultipartFile file:files){
	        multipartFile.transferTo(file);
	        //if(Base64ImageUtils.imgsaveToFile(imagebyte, fileName)) {
			//for(MultipartFile file:files){
			//files.transferTo(new File(filePath+files.getOriginalFilename()));
	        System.out.println(originalFileName);
	        System.out.println(file.getAbsolutePath());
			riders.setUserPic(filePath+originalFileName);
			riders.setId(id);
			riders.setNickname(nickname);
			riders.setRealname(realname);
			riders.setEmail(email);
			riders.setIdentityId(identityId);
			//}
			if(deliveryRidersService.addPerfectRder(riders)>0) {
				return Result.success(true);
			}
	        }else {
	        	return Result.error("文件格式不是图片！");
	        }
//			if(deliveryRidersService.getOne(new QueryWrapper<DeliveryRiders>().eq("phone", riders.getPhone())) != null) {
//				return Result.error(ResultEnum.USER_IS_EXISTS.getCode(),ResultEnum.USER_IS_EXISTS.getMsg());
//			}else if(deliveryRidersService.addPerfectRder(riders)>0){
//				//int flag=deliveryRidersService.riderRegister(deliveryRiders);
//				return Result.success(true);
//			}
        //}else {
        	//MyException exception=new MyException("文件类型错误！");
    		//return Result.error("文件类型错误！");
        //}
        MyException exception=new MyException("没有完成！发生异常！");
		return Result.error(exception);
	}
	/**
	 * 骑手通过手机号快速注册
	 * @param phone
	 * @param password
	 * @return
	 */
	@PostMapping(value="/riderRegister")
	public Result riderRegister(HttpSession session,@RequestParam String phone,@RequestParam String password,@RequestParam String code) {
		if(deliveryRidersService.getOne(new QueryWrapper<DeliveryRiders>().eq("phone", phone))!=null) {
			return Result.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
		}else //if(session.getAttribute("user"+phone)==code||session.getAttribute("user"+phone).equals(code)) {
			if(deliveryRidersService.riderRegister(phone, password)>0) {
				return Result.success();
			//}
		}else{
			//System.out.println(session.getAttribute("user"+phone)+"=="+code);
			return Result.error("注册失败！请重新注册！");
		}
		//return Result.error("注册失败！请重新注册！");
	}
	/**
	 * 通过手机获取验证码
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/getverifycode")
	@ResponseBody
	public Result getVerifyCode(HttpSession session,@RequestParam String phone) {
		try {
			//生成验证码
			int verifycode= (int)((Math.random()*9+1)*100000);//随机生成的6位数（验证码）//EMailUtil.getNumberLetter();
			//session.setAttribute("user"+phone, verifycode);
			//session.setMaxInactiveInterval(60);
			//System.out.println(session.getAttribute("user"+phone));
//			if(SMSUtil.exportaa(String.valueOf(verifycode),phone).equals("100")) {
//				System.out.println(SMSUtil.exportaa(String.valueOf(verifycode),phone));
//				String md5str=MD5Util.MD5Encode(String.valueOf(verifycode),"utf-8");
//				System.out.println("md5字符串："+md5str);
//				return Result.success(MD5Util.MD5Encode(String.valueOf(verifycode),"utf-8"));
//			}
			return Result.success(String.valueOf(verifycode));//MD5Util.MD5Encode( ,"utf-8")
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return Result.error(e.getMessage());
		}
		//return Result.error(new MyException("验证码发送失败！"));
	}
	/**
	 * 暂时没用
	 * @param files
	 * @param request
	 * @param deliveryRiders
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addRiderPic",method= {RequestMethod.POST})
	@ResponseBody
	public Result uploadFile(@RequestParam("picfile") MultipartFile files, HttpServletRequest request,DeliveryRiders deliveryRiders)throws Exception{
		String filePath = request.getServletContext().getRealPath("/")+"ridersfile/userpic";
		//TODO 判断文件格式是不是图片
        String contentType = files.getContentType();
		File tmpFile = new File(filePath);
		//判断是否存在该文件夹，若不存在则创建文件夹
		if(!tmpFile.exists()){
			tmpFile.mkdir();
		}
	
		//for(MultipartFile file:files){
		files.transferTo(new File(filePath+files.getOriginalFilename()));
		deliveryRiders.setUserPic(filePath+files.getOriginalFilename());
		//}
		if(deliveryRidersService.addPerfectRder(deliveryRiders)>0) {
			return Result.success(true);
		}
		//if()
		return Result.error("上传失败！");
	}
	/**
	 * 通过身份证获取身份证号
	 * @return
	 * @throws IOException 
	 */
	@PostMapping(value="/getIdardId")
	public Result getIdCardId(@RequestParam("file") MultipartFile files,HttpServletRequest request) throws IOException {
		String idcard=BaiduOCRUtils.getIdCardId(files.getBytes());
		if(idcard.equals("error")) {
			return Result.error("错误");
		}else if(idcard.equals("valid")){
			return Result.error("为空");
		}
		return Result.success(idcard);
	}
	/**
	 * 骑手通过手机号找到ID
	 * @param phone
	 * @param password
	 * @return
	 */
	@PostMapping(value="/riderFindId")
	public Result getRiderID(HttpSession session,@RequestParam String phone) {
		if(deliveryRidersService.getOne(new QueryWrapper<DeliveryRiders>().eq("phone", phone))!=null) {
			return Result.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
		}else //if(session.getAttribute("user"+phone)==code||session.getAttribute("user"+phone).equals(code)) {
		{
			return Result.success(deliveryRidersService.getOne(new QueryWrapper<DeliveryRiders>().eq("phone", phone)).getId());
			//}
		}
		//return Result.error("注册失败！请重新注册！");
	}
	/**
	 * 修改骑手密码
	 * @param oldPwd
	 * @param pwd
	 * @return
	 */
	@PostMapping(value="/modifyRiderPwd")
	public Result modifyRiderPassword(@RequestParam String oldPwd,@RequestParam String phone,@RequestParam String pwd) {
		if(deliveryRidersService.updatePwd(oldPwd,phone,pwd)>0) {
			return Result.success();
		}else {
			return Result.error("修改密码失败");
		}
	}
}
