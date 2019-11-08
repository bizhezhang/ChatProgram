package UDP通讯器;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPHost implements Runnable {
	String hostName;
	int receivePort;
	int destPort; // 目标主机端口
	Scanner sc = new Scanner(System.in);

	public UDPHost(String hostName, int receivePort, int destPort) {
		super();
		this.hostName = hostName;
		this.receivePort = receivePort;
		this.destPort = destPort;

		new Thread(this).start(); // 线程负责接收数据包
	}

	// 发送数据包
	@SuppressWarnings("resource")
	public void sendPacket() {
		String outMessage = sc.nextLine();
		byte buffer[] = outMessage.getBytes();

		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			DatagramPacket data_pack = new DatagramPacket(buffer, buffer.length, address, destPort);
			DatagramSocket mail_data = new DatagramSocket();
			mail_data.send(data_pack);
		} catch (Exception e) {
		}
	}

	// 接收数据包
	public void run() {
		DatagramPacket pack = null;
		DatagramSocket mail_data = null;
		byte data[] = new byte[8192];

		try {
			pack = new DatagramPacket(data, data.length);
			mail_data = new DatagramSocket(receivePort);
		} catch (Exception e) {
		}

		while (true) {
			if (mail_data == null)
				break;
			else
				try {
					mail_data.receive(pack);
					String message = new String(pack.getData(), 0, pack.getLength());
					System.out.print("收到数据是：" + message + "\n");
				} catch (Exception e) {
				}
		}
	}

	public String toString() {
		return "我是" + hostName + ", receivePort=" + receivePort + ", destPort=" + destPort;
	}
}
