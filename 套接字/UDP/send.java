package �׽���.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class send {
	public static void main(String[] args) throws IOException{
		//ͨ�������׽��� ��һ���˿�
		DatagramSocket ds = new DatagramSocket(8888);
		System.out.println("������Ҫ���͵���Ϣ");
		Scanner sc = new Scanner(System.in);
		String message = sc.next();
		//���û�������Ϣ��Ϊ�ֽ������д���
		byte[] b = new byte[1024];
		b = message.getBytes();
		//�������׽��ֵ��ַ������ȷ�װ�����ݰ������а�װ
		DatagramPacket dp = new DatagramPacket(b,b.length,InetAddress.getByName("127.0.0.1"),9999);
		//�����ݰ����ͳ�ȥ
		ds.send(dp);
	}
}
