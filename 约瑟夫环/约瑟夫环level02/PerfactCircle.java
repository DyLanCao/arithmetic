package Լɪ��.Լɪ��level02;

public class PerfactCircle {
	public static class Node{
		private int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
		public Node(){
			
		}
	}
	public static void main(String[] args){
		int person = 41;//���������ܺ�
		int l = 3;//ÿ������ٳ�ȥһ��
		Node header = new Node(1);//ͷ���
		Node operator = header;//ʵ�ʽ��в����Ľڵ�
		//����һ����ѭ������
		for(int i=2;i<=person;i++){
			//�����ڵ����һ�����δ���
			operator.next = new Node(i);
			//�õ�ǰ�����ڵ�һֱ�����һ��
			operator = operator.next;
		}
		//ѭ���������һ���ڵ����ͷ���
		operator.next = header;
		//��������Ҵ�һ�˵��ж�
		// 16 31
		while(operator != operator.next){
			//ÿ��L��������Ƴ�
			for(int i=1;i<l;i++){
				operator = operator.next;
				//System.out.println("temp = "+temp.value+" operator = "+operator.value);
			}
			System.out.println("λ��"+operator.next.value+"�Ƴ���");
			operator.next = operator.next.next;
		}
		System.out.println("����Ҵ��λ����"+operator.value);
	}
}
