package UDPͨѶ��;

public class ShanghaiHost {

	public static void main(String[] args) {
		UDPHost shanghai = new UDPHost("�Ϻ�", 2019, 2016);
		System.out.println(shanghai.toString());
		
		while(true) {			
			shanghai.sendPacket();			
		}
	
	}
}
