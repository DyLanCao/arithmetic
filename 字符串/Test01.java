package �ַ���;

import java.util.ArrayList;

//���ַ������ҳ���һ��ֻ����һ�ε��ַ�����������"abaccdeff"�����'b'��
public class Test01 {
	
	public static char search(String data){
		char[] values = data.toCharArray();
		ArrayList<Character> l = new ArrayList<Character>();
		char[] temp = new char[values.length];
		int number = 0;
		for(int i=0;i<values.length;i++){
			if(l.contains(values[i])){
				temp[number++] = values[i];
			}else{
				l.add(values[i]);
			}
		}
		for(int i=0;i<temp.length;i++){
			if(temp[i]=='\0'){
				break;
			}else{
				l.remove(new Character(temp[i]));
			}
		}
		return l.get(0);
	}
	
	public static void main(String[] args){
		String s = "abaccdeff";
		char result = Test01.search(s);
		System.out.println(result);
	}
}
