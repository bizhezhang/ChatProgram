package 多线程CS模式;

import java.io.*;
import java.net.*;

class ServerThread extends Thread {
	   Socket socket;
	   String s=null;	   
	   DataOutputStream out=null;
	   DataInputStream  in=null;
	   
	   public ServerThread(Socket t) {
	      socket=t;
	      try {  
	    	  out=new DataOutputStream(socket.getOutputStream());	             
	    	  in=new DataInputStream(socket.getInputStream());
	      }catch(IOException e){}
	   }  
	   
	   public void run() {        
	      while(true) {
	         try{  
	        	 double r=in.readDouble();			//堵塞状态，除非读取到信息
	        	 System.out.println("收到半径="+r);
	        	 double area=Math.PI*r*r;	        	 
	        	 out.writeUTF("半径是:"+r+"的圆的面积:"+area);	//发送面积到客户端
	         }catch (IOException e) {
	        	 System.out.println("客户离开\n");
	        	 try {
	        		 in.close();
		        	 out.close();
		        	 socket.close();
	        	 } catch (IOException e3) {
					e3.printStackTrace();
	        	 }
	        	 return;
	         }
	      }	      
	   } 
	}

