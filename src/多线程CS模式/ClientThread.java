package ���߳�CSģʽ;

import java.io.*;
import java.net.*;

class ClientThread extends Thread {
	Socket socket=null;	
	DataInputStream in=null;
		   
	public ClientThread(Socket t) {
	     socket=t;	     
	}
	
	public void run() {//������շ������˷��͵����ݣ����������Ļ��
		String s=null;
		while(true) {
			try{ 				
				in =new DataInputStream(socket.getInputStream());				
	        	s=in.readUTF();				//read���������͵����
	        	System.out.println(s);
	        }catch(IOException e) { 
	        	System.out.println("��������ѶϿ�");
	        	socket=new Socket();
	        	break;
	        }   
		}
	}
}

