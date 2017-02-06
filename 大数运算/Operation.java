package ��������;

import java.util.Scanner;

public class Operation {
	public int[] big_add(char[] first,char[] second){
		//����������������� ���ҳ��󳤶Ⱥ�С���ȵ�
		char[] oFirst = new char[first.length];
		char[] oSecond = new char[second.length];
		int big = oFirst.length>oSecond.length?oFirst.length:oSecond.length;
		int small = oFirst.length>oSecond.length?oSecond.length:oFirst.length;
		int[] result = new int[big+1];
		for(int i=0;i<oFirst.length;i++){
			oFirst[oFirst.length-1-i] = first[i];
		}
		for(int i=0;i<oSecond.length;i++){
			oSecond[oSecond.length-1-i] = second[i];
		}
		//����С���ȶ�λ�ӷ� temp ���������ж��Ƿ���Ҫ��λ
		int temp = 0;
		for(int i=0;i<small;i++){
			temp = temp+(int)oFirst[i] - 48+(int)oSecond[i] -48;
			if(temp>9){
				result[i] = temp%10;
				temp = 1;
			}else{
				result[i] = temp;
				temp = 0;
			}
		}
		//�Դ󳤶�ʣ��ļ�λ�������λtemp���мӷ�
		char[] tt = oFirst.length>oSecond.length?oFirst:oSecond;
		for(int i=small;i<big;i++){
			temp = (int)tt[i]-48+temp;
			if(temp>9){
				result[i] = temp%10;
				temp = 1;
			}else{
				result[i] = temp;
				temp = 0;
			}
		}
		//���մ浽���ؽ������result
		result[result.length-1] = temp;
		return result;
	}
	
	public int[] big_multiply(char[] a,char b[]){
		//�洢�������Ԫ�ص����ý��
		char[] aa = new char[a.length];
		char[] bb = new char[b.length];
		//������� ��Ϊ�������ĳ˻����Ȳ��ᳬ��������֮�ͼ�3
		int[] result = new int[a.length+b.length+3];
		//����
		for(int i=0;i<aa.length;i++){
			aa[i] = a[a.length-i-1];
		}
		for(int j=0;j<bb.length;j++){
			bb[j] = b[b.length-1-j];
		}
		
		//��λ���
		for(int i =0;i<aa.length;i++){
			for(int j=0;j<bb.length;j++){
				//���ϳ˻��Ĵ�λ��˵�ԭ�� ������ͨ��ȡUnicodeֵ֮���ȥ48λ����1
				result[i+j] += ((int)aa[i]-48)*((int)bb[j]-48);
			}
		}
		//��λ
		int temp = 0;//��λ�ı�ʾ�� 81 162 81 
		for(int i=0;i<result.length;i++){
			int flag = result[i]+temp;
			if(flag>9){
				result[i] = flag%10;
				temp = flag/10;
			}else{
				result[i] = result[i]+temp;
				temp = 0;
			}
		}
		
		return result;
	}
	
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Operation o = new Operation();
		//�ӷ�
		System.out.println("�����ӷ�");
		String s1 = sc.next();
		String s2 = sc.next();
		char[] ss1 = s1.toCharArray();
		char[] ss2 = s2.toCharArray();
		int[] result = o.big_add(ss1, ss2);
		int length = 0;
		//�жϼӷ�������λ��0����1
		if(result[result.length-1]==0){
			length = result.length-2;
		}else{
			length = result.length-1;
		}
		for(int i=length;i>=0;i--){
			System.out.print(result[i]);
		}
		System.out.println();
		System.out.println("�����˷�");
		String s3 = sc.next();
		String s4 = sc.next();
		char[] ss3 = s3.toCharArray();
		char[] ss4 = s4.toCharArray();
		int[] result02 = o.big_multiply(ss3, ss4);
		//�ҵ����λ
		int maxLength = 0;
		for(int i=result02.length-1;i>=0;i--){
			if(result02[i]!=0){
				maxLength = i;
				break;
			}
		}
		for(int i=maxLength;i>=0;i--){
			System.out.print(result02[i]);
		}
	}
}
