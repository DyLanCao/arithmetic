package ��ϣ��;

public class Test02 {
	public static void main(String[] args){
		//��д��һ�����ͱ���b ���� 1 ��
		int[] a = new int[1024];
		for(int i=0;i<a.length;i++){
			a[i] = i;
		}
		//�û�˵��Ҫ�� 555 �����ֵ
		for(int i=0;i<a.length;i++){
			if(a[i] == 555){
				System.out.println("�ҵ��ˣ���������λ���� "+i);
				break;
			}
		}
	}
}
