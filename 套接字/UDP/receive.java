package �׽���.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class receive {
	public static void main(String[] args) throws IOException{
		//���ݰ����Ŷ˿�
		DatagramSocket socket = new DatagramSocket(9999);
		byte[] b = new byte[1024];
		//ȷ�����ݰ����ܵĳ���
		DatagramPacket dp = new DatagramPacket(b,b.length);
		//����Ϣ���뵽���ݰ��д��뵽�ֽ�����B��
		socket.receive(dp);
		//���ֽ���Ϣת���ַ�������ʽ
		String message = new String(b,0,dp.getLength());
		System.out.println("���ͷ�˵:"+message);
	}
}
