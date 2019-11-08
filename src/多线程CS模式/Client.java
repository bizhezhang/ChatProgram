package ���߳�CSģʽ;

import java.net.*;
import java.util.Scanner;
import java.io.*; 

public class Client {
	Socket socket;
	DataOutputStream out;
	
	public Client() {
		socket = new Socket();
	}
   
	//���������������	 
	public void connect() {				
		try {	//����ͷ����������׽������ӣ�		
			InetAddress address = InetAddress.getByName("127.0.0.1");
			InetSocketAddress socketAddress=new InetSocketAddress(address,4331);			
			socket.connect(socketAddress);	
			
			//�����������̣߳�������շ������˷��͵Ľ����
			ClientThread thread=new ClientThread(socket);
			thread.start();
		}catch(UnknownHostException e1) {
			e1.printStackTrace();
		}catch(IOException e) {			
			e.printStackTrace();
		} 
	}
	
	//�Ӽ��̶���뾶�������͵��������ˡ�����"#"���ж����ӣ�����ֹ�ͻ��˳���
	@SuppressWarnings("resource")
	public void send() {	
		Scanner sc = new Scanner(System.in);
		String s;
		while(true) {
			s=sc.nextLine();	//�Ӽ��̶���뾶
			if(!s.equals("#")){
				double r=Double.parseDouble(s);	         
				try {	
					//����socket�������ӵ������
					out = new DataOutputStream(socket.getOutputStream());
					out.writeDouble(r);				     
				}catch(IOException e1){	 
					e1.printStackTrace();			
				}
			}else{//����"#"���ж����ӣ�����ֹ�ͻ��˳���	         
				try {
					out.close();
					socket.close();
				} catch(IOException e1) {
					e1.printStackTrace();
				}	
				break;
			}		
		}		
	}
	
	public static void main(String args[]) {
	     Client client = new Client();
	     client.connect(); 
	     client.send();	       
	}	
}

