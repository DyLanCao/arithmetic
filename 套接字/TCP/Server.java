package �׽���.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException{
		//�������˿���һ���˿� ��ײ���ʵ��һ��bind���׽��ֵ��˿��ϵ�һ������
		ServerSocket ss = new ServerSocket(9999);
		
		//�ȴ��ͻ������������� ���ӻ����һ����Ӧ���׽��� ͨ���׽��������ж�д����
		Socket socket = ss.accept();
		//���ж�����
		InputStream is = socket.getInputStream();
		//ת��Ϊ�ַ���ȡ
		InputStreamReader ir = new InputStreamReader(is);
		//ת��Ϊ��ǿ��bufferReader���������ж�ȡ
		BufferedReader br = new BufferedReader(ir);
		String message = br.readLine();
		System.out.println("�ͻ���˵:"+message);
	}
}
