package Լɪ��.Լɪ��level02;

import Լɪ��.Լɪ��level02.KillLinkedList.Place;


public class KillGame {
	public static KillLinkedList kll = new KillLinkedList();
	
	//��ʼ��Լɪ��
	public static void init(int number){
		for(int i=1;i<=number;i++){
			kll.add("λ��"+i);
		}
	}
	
	public static void main(String[] args){
		int person = 41;
		//��ʼ�����е�����
		init(person);
		//ָ��ͷ�ڵ�
		Place temp = kll.getHeader();
		//��ǰ��λ������
		int index = 1;
		//��ǰ��������2��ʱ��ִ��ɱ����Ϸ
		while(kll.size()>2){
			//�����ǰ��ʾΪͷ�ڵ�Ļ��Զ�������һ��ȥ
			if(temp == kll.getHeader()){
				temp = temp.getAfter();
			}
			if(index %3 ==0){
				System.out.println(temp.getPlace()+"������");
				kll.remove(temp);
			}
			//��ǰ�ڵ�ָ����һ��
			temp = temp.getAfter();
			//��ǰ�����ż�һ
			index++;
		}
		System.out.println("�Ҵ�����"+kll.get(1).getPlace());
		System.out.println("�Ҵ�����"+kll.get(2).getPlace());
	}
}
