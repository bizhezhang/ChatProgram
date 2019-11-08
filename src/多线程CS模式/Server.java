package 多线程CS模式;

import java.io.*;
import java.net.*;

public class Server {	
   public static void main(String args[]) {
      ServerSocket server=null;
      Socket you=null;
      ServerThread thread;  
      
      try{    //监听请求    	
      	server=new ServerSocket(4331);	
      } catch(IOException e1) { 
    	  e1.printStackTrace();
    	  System.out.println("正在监听"); //ServerSocket对象不能重复创建
      }   
      
      while(true) {	//循环监听         
        try{  
        	System.out.println("等待客户呼叫");
        	if(server!=null){
        		you=server.accept();	//接收客户端的连接呼叫，每个客户端的连接都会产生一个Scoket对象
        		System.out.println("客户的地址:"+you.getInetAddress());
        	}
        }catch(IOException e) {
        	System.out.println("正在等待客户");        	
        	try {
				server.close();
				you.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}  
        }
        
        if(you!=null) { 
        	thread = new ServerThread(you);	//使用与当前客户端连接的Scoket对象创建线程，处理请求
        	thread.start(); 				//为每个客户启动一个专门的线程  
        }        
      }      
   }
}
