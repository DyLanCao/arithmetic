package ����С�㷨;

import java.util.Scanner;


//�����ƽ���ֵ�ѧ��ѧ�ż��ɼ�
public class Test02 {
	public static void main(String[] args){
		int[] sno = new int[100];
		int[] gra = new int[100];
		int index = 0;
		Scanner sc = new Scanner(System.in);
		while(true){
			int number = sc.nextInt();
			if(number!=-1){
				sno[index] = number;
				gra[index] = sc.nextInt();
				index++;
			}else{
				break;
			}
		}
		System.out.println("index===="+index);
		int sum = 0;
		for(int i=0;i<index;i++){
			sum += gra[i];
		}
		for(int i=0;i<index;i++){
			if(gra[i]>(sum/index)){
				System.out.println("ѧ��: "+sno[i]);
				System.out.println("�ɼ�: "+gra[i]);
			}
		}
		System.out.println("ƽ���ɼ�Ϊ: "+sum/index);
	}
}
