package Լɪ��;

import Լɪ��.MyLinkedList.Place;

public class KillGame {
	//����ѭ������
	public MyLinkedList mll = new MyLinkedList();
	//����������ʼ������
	public void initList(int number){
		for(int i=0;i<number;i++){
			mll.add("λ��"+(i+1));
		}
	}
	
	public static void main(String[] args){
		KillGame kg = new KillGame();
		//��ʼ����41����
		kg.initList(41);
		//�����ı�־
		int index = 1;
		//����λ�� ��ʼ��ʱ��ָ��ͷ
		Place p = kg.mll.header;
		//��ʼɱ����Ϸ
		while(kg.mll.size()>2){
			//���統ǰ����λ��ָ����header�ڵ������Զ��Ƶ���һλ
			if(p == kg.mll.header){
				p = p.getAfter();
			}
			//���統ǰ����Ϊ�����ĵ������˾�ɱ����
			if(index%3==0){
				System.out.println(p.getPlace()+"������");
				kg.mll.remove(p);
				p = p.getAfter();
				//����������½��б���
			}else{
				p = p.getAfter();
			}
			//������+1
			index++;
		}
		//��ǰ�ڵ�Ϊ3��ʱ������ѭ�����������Ҵ��ߺ�һ��header�ڵ�
		System.out.println();
		System.out.println("�Ҵ�������λ��"+kg.mll.get(1).getPlace());
		System.out.println("�Ҵ�������λ��"+kg.mll.get(2).getPlace());
		
	}
}
