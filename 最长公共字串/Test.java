package ������ִ�;

//��������������չ����ʱ�临�Ӷ�ΪO(n^2)���ռ临�Ӷ�ΪO(1)���Ժã�����������⣬�Ƽ�ʹ��
public class Test {	
	private static String longestPalindrome(String str){  
        int n=str.length();  //��ȡ��ǰ�ַ����ĳ���
        if(str==""){ 		//����Ϊ��ֱ�ӷ��ؿմ� 
            return "";  
        }  
        String longest=str.substring(0, 1);  //��ȡ��һ���ַ�
        for(int i=0;i<n-1;i++){  		
            String p1=expandAroundCenter(str,i,i);  //�ж�����ʱ�����
            if(p1.length()>longest.length()){  
                longest=p1;  
            }  
            String p2=expandAroundCenter(str,i,i+1);  //�ж�ż�������
            if(p2.length()>longest.length()){  
                longest=p2;  
            }  
        }  
        return longest;       
    }  
      
    private static String expandAroundCenter(String str,int l,int r){  
        int n=str.length();       
        while(l>=0&&r<=n-1&&str.charAt(l)==str.charAt(r)){  
            l--;  
            r++;  
        }         
        /** 
         * ����Ҫע��,c++�е�str.substr(beginIndex,length)�ĺ�һ�������Ǵ�beginIndex��ʼ�ĳ��ȣ�      
         * ��java�е�str.substring(beginIndex,endIndex)�ĺ�һ��������һ���±꣬Ӧ��С��beginIndex, 
         * �����ڻ�ȡ���ַ�����,���������±꣬ 
         */  
        return str.substring(l+1, r);         
    }  
    public static void main(String[] args){  
//        String str="djdslkAABCDEAfjdl1234321skjflkdsjfkldsababasdlkfjsdwieowowwpw";  
//        String s=longestPalindrome(str);  
//        System.out.println(s); 
    	String s = "abc";
    	System.out.println(s.substring(0,1));
    }

}
