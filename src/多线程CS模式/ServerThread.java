package ���߳�CSģʽ;

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
	        	 double r=in.readDouble();			//����״̬�����Ƕ�ȡ����Ϣ
	        	 System.out.println("�յ��뾶="+r);
	        	 double area=Math.PI*r*r;	        	 
	        	 out.writeUTF("�뾶��:"+r+"��Բ�����:"+area);	//����������ͻ���
	         }catch (IOException e) {
	        	 System.out.println("�ͻ��뿪\n");
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

