package �׽���.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		//��ʼ���ͻ��˵��׽���ͨ��IP �Լ����ŵĶ˿ں���׼ȷ���ҵ���������ڲ��������ͨ��
		Socket socket = new Socket("127.0.0.1",9999);
		
		//ͨ���׽�������ȡ�����
		OutputStream os = socket.getOutputStream();
		
		//��ԭʼ�ֽ������ת��Ϊ�ַ������
		PrintWriter pw = new PrintWriter(os);
		
		System.out.println("��������Ϣ");
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		//���û�������Ϣ�����͵�������
		pw.println(message);
		//ˢ�»������Ϣ���͸�������
		pw.flush();
		
	}
}
