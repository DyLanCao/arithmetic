package ˳�����;

public class Test02 {
	
	public static int search(int[] number,int key){
		int[] temp = new int[number.length+1];
		//����ĩβΪ������
		for(int i=0;i<number.length;i++){
			temp[i] = number[i];
		}
		temp[number.length] = key;
		int result = 0;
		//���в���ƥ��
		for(int i=0;;i++){
			if(temp[i] == key){
				result = i;
				break;
			}
		}
		if(result < number.length){
			return result;
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args){
		int[] number = {12,24,53241,52,35,5263,7};
		int key= 52;
		System.out.println(Test02.search(number, key));
	}
}
