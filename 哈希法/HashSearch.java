package ��ϣ��;

/*
 * --------------Super ��------------------
 */
public class HashSearch {
	
	private static Object[] hash = new Object[100];//��ϣ���ʼֵΪ10����λ
	
	public static void main(String[] args){
		//�������ݴ����ϣ����
		String a = "abc";
		String b = "def";
		String c = "ghi";
		String d = "jkl";
		String e = "mno";
		String f = "pqr";
		String g = "stu";
		String h = "vwx";
		String i = "yz";
		InsertHash(a);
		InsertHash(b);
		InsertHash(c);
		InsertHash(d);
		InsertHash(e);
		InsertHash(f);
		InsertHash(g);
		InsertHash(h);
		InsertHash(i);
		//��λʽ����ĳһ�ض�Ԫ��
		int result = hashSearch("mno");
		System.out.println("��������ַ���Ϊ:mno");
		System.out.println("��ǰ�ڹ�ϣ���е�����Ϊ:"+result);
		System.out.println("��ϣ��������Ϊ"+"'"+result+"'"+"�����ַ���Ϊ"+hash[result]);
	}
	
	//����hash��
	public static void InsertHash(String data){
		int index = hashFunction(data);
		//��ȡ�е�����ϣ��������
		if(hash[index] == null){
			hash[index] = data;
		}else{
			solveClash(index,data);
		}
	}
	//ƽ��ȡ�з�
	public static int hashFunction(String data){
		//���ַ���ת��Ϊ�ַ��������֮�����ƽ������
		char[] d = data.toCharArray();
		int temp = 0;
		for(int i=0;i<d.length;i++){
			temp += (int)d[i];
		}
		temp = temp*temp;
		//��ƽ������ֵ����ȡ��
		int index = 0;
		String s = String.valueOf(temp);
		//ȡ���������м���λ �������ַ�������ķ���
		index += Integer.parseInt(String.valueOf(s.charAt(s.length()/2-1)))*10;
		index += Integer.parseInt(String.valueOf(s.charAt(s.length()/2)));
		return index;
	}
	//��������ͻ�ķ���
	public static void solveClash(int index,String data){
		//�������Կ��ŵ�ַ�������ͻ
		for(int i=1;index+i<100;i++){
			if(hash[index+i] == null){
				hash[index+i] = data;
				break;
			}
		}
	}
	//ͨ��hash�㷨��λʽ����Ԫ��
	public static int hashSearch(String data){
		int index = hashFunction(data);
		return index;
	}
}
