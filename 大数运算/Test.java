package ��������;

import java.math.BigInteger;

public class Test {
	public static void main(String[] args){
		BigInteger a = new BigInteger("123456789");
		BigInteger b = new BigInteger("987654321");
		System.out.println("���Ϊ");
		System.out.println("�ӷ�:"+a.add(b));
		System.out.println("����"+a.subtract(b));
		System.out.println("�˷�"+a.multiply(b));
		System.out.print("����");
		BigInteger[] result = a.divideAndRemainder(b);
		System.out.print(result[0]+".");
		System.out.print(result[1]);
		System.out.println();
		System.out.println("--------------------");
		char aa = '1';
		char bb = '2';
		System.out.println(((int)aa-48)*((int)bb-48));
 	}
}
