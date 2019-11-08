package 多线程CS模式;

import java.net.*;
import java.util.Scanner;
import java.io.*; 

public class Client {
	Socket socket;
	DataOutputStream out;
	
	public Client() {
		socket = new Socket();
	}
   
	//请求与服务器连接	 
	public void connect() {				
		try {	//请求和服务器建立套接字连接：		
			InetAddress address = InetAddress.getByName("127.0.0.1");
			InetSocketAddress socketAddress=new InetSocketAddress(address,4331);			
			socket.connect(socketAddress);	
			
			//创建并启动线程，负责接收服务器端发送的结果。
			ClientThread thread=new ClientThread(socket);
			thread.start();
		}catch(UnknownHostException e1) {
			e1.printStackTrace();
		}catch(IOException e) {			
			e.printStackTrace();
		} 
	}
	
	//从键盘读入半径，并发送到服务器端。输入"#"则中断连接，并终止客户端程序。
	@SuppressWarnings("resource")
	public void send() {	
		Scanner sc = new Scanner(System.in);
		String s;
		while(true) {
			s=sc.nextLine();	//从键盘读入半径
			if(!s.equals("#")){
				double r=Double.parseDouble(s);	         
				try {	
					//创建socket对象连接的输出流
					out = new DataOutputStream(socket.getOutputStream());
					out.writeDouble(r);				     
				}catch(IOException e1){	 
					e1.printStackTrace();			
				}
			}else{//输入"#"则中断连接，并终止客户端程序	         
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

