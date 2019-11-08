package 多线程CS模式;

import java.io.*;
import java.net.*;

class ClientThread extends Thread {
	Socket socket=null;	
	DataInputStream in=null;
		   
	public ClientThread(Socket t) {
	     socket=t;	     
	}
	
	public void run() {//负责接收服务器端发送的数据，并输出到屏幕。
		String s=null;
		while(true) {
			try{ 				
				in =new DataInputStream(socket.getInputStream());				
	        	s=in.readUTF();				//read服务器发送的面积
	        	System.out.println(s);
	        }catch(IOException e) { 
	        	System.out.println("与服务器已断开");
	        	socket=new Socket();
	        	break;
	        }   
		}
	}
}

