package ���߳�CSģʽ;

import java.io.*;
import java.net.*;

public class Server {	
   public static void main(String args[]) {
      ServerSocket server=null;
      Socket you=null;
      ServerThread thread;  
      
      try{    //��������    	
      	server=new ServerSocket(4331);	
      } catch(IOException e1) { 
    	  e1.printStackTrace();
    	  System.out.println("���ڼ���"); //ServerSocket�������ظ�����
      }   
      
      while(true) {	//ѭ������         
        try{  
        	System.out.println("�ȴ��ͻ�����");
        	if(server!=null){
        		you=server.accept();	//���տͻ��˵����Ӻ��У�ÿ���ͻ��˵����Ӷ������һ��Scoket����
        		System.out.println("�ͻ��ĵ�ַ:"+you.getInetAddress());
        	}
        }catch(IOException e) {
        	System.out.println("���ڵȴ��ͻ�");        	
        	try {
				server.close();
				you.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}  
        }
        
        if(you!=null) { 
        	thread = new ServerThread(you);	//ʹ���뵱ǰ�ͻ������ӵ�Scoket���󴴽��̣߳���������
        	thread.start(); 				//Ϊÿ���ͻ�����һ��ר�ŵ��߳�  
        }        
      }      
   }
}
