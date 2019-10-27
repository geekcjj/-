package com.maike.beauty.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.maike.beauty.entity.Message;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月16日 下午7:26:01
 * @description:
 *
 */
@ServerEndpoint("/ChatService/{userid}")
@Component
public class ChatWebService {
	//每进入一个用户，就新建一个ChatService对象
	  
	  private static int onlineCount = 0; //静态变量， 用来记录当前在线连接数
	  private static List<HashMap<String,ChatWebService>> webSocketList = new ArrayList<HashMap<String,ChatWebService>>();    //静态变量，用来存放在线用户
	  private static HashMap<String,ChatWebService> webSocketSet=new HashMap<String, ChatWebService>();//webSocketMap
	  private Session session;   //用于存储与该用户的会话，要通过它来给客户端发送数据
	  private String userid;

	  /**
	   * 连接建立成功调用的方法
	   * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	   */
	  @OnOpen
	  public void onOpen(@PathParam("userid") String userid, Session session){
		this.userid = userid;
	    this.session = session;
	    webSocketSet.put(userid,this);   //加入set中
	    webSocketList.add(webSocketSet);
	    addOnlineCount();      //在线数加1
	    System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
	  }
	  
	  /**
	   * 连接关闭调用的方法
	   */
	  @OnClose
	  public void onClose(){
	    webSocketSet.remove(userid); //从set中删除
	    //使用迭代删除
        //Iterator<HashMap<String, ChatWebService>> websocketIterator = webSocketList.iterator();
//        while (websocketIterator.hasNext()) { 
//            //删除特定元素
//            HashMap<String, ChatWebService> websock = websocketIterator.next();
//            if("".equals(websock.get(userid))){
//            	websocketIterator.remove();
//            } 
////            if("".equals(websock.get(userid))){
////            	websocketIterator.remove();
////            }
//                         
//        }
	    subOnlineCount();      //在线数减1
	    System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	  }

	  /**
	   * 收到客户端消息后调用的方法
	   * @param message 客户端发送过来的消息
	   * @param session 可选的参数
	 * @throws IOException 
	   */
	  @OnMessage
	  public void onMessage(String data, Session session) throws IOException {
	    Message mess = new Gson().fromJson(data, Message.class);
	    System.out.printf("来自%s的消息:%s\n", mess.getUsername(), mess.getContent());
	    //群发消息
//	    for(userid item: webSocketSet){
//	      try {
//	        item.sendMessage(mess);
//	      } catch (IOException e) {
//	        e.printStackTrace();
//	        continue;
//	      }
//	    }
	    // 发送数据给服务端
	   	sendMessageAll(mess);
	  }
	  
	  /**
	   * 发生错误时调用
	   * @param session
	   * @param error
	   */
	  @OnError
	  public void onError(Session session, Throwable error){
	    System.out.println("发生错误");
	    error.printStackTrace();
	  }

	  //以下为辅助函数
	  public void sendMessage(Message mess) throws IOException{

	    String datatime = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	    mess.setDate(datatime);
	    String jsonInfo = new Gson().toJson(mess);    //将消息对象转换成json字符串
	    this.session.getAsyncRemote().sendText(jsonInfo); //通过session异步地将信息发送到客户端上
	  }
	  public void sendMessageTo(Message mess, String To) throws IOException {
		 // session.getBasicRemote().sendText(message);
		 // session.getAsyncRemote().sendText(message);
		 String jsonInfo = new Gson().toJson(mess);    //将消息对象转换成json字符串
		 for (ChatWebService item : webSocketSet.values()) {
		    if (item.userid.equals(To)) {
		   	item.session.getAsyncRemote().sendText(jsonInfo);
		    }
		 }
	  }
	  public void sendMessageAll(Message mess) throws IOException {
		String jsonInfo = new Gson().toJson(mess);    //将消息对象转换成json字符串
		for (ChatWebService item : webSocketSet.values()) {
			//webSocketSet.get(userid)
			item.session.getAsyncRemote().sendText(jsonInfo);
		}
	  }
	  public static synchronized int getOnlineCount() {
	    return onlineCount;
	  }

	  public static synchronized void addOnlineCount() {
		 ChatWebService.onlineCount++;
	  }

	  public static synchronized void subOnlineCount() {
		 ChatWebService.onlineCount--;
	  }
}
