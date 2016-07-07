package �鲢����;

public class Test{
    public static void main(String[] args) {
   //��Ҫ�������������
    int[] array=new int[]{8,3,2,1,7,4,6,5};
     //���ԭ���������
    printResult(array);
    //�鲢�������
    sort(array,0,array.length-1);
    //�����������ؽ��
    printResult(array);
    }
     
     
    /**
     * �鲢����
     * @param array
     */
    private static void sort(int[] array,int i,int j) {
        if(i<j)
        {
            int middle=(i+j)/2;
            //�ݹ鴦����صĺϲ�����
            sort(array,i,middle);
            sort(array,middle+1,j);
            merge(array,i,middle,j);           
        }
    }
 
 
    /**
     * �ϲ���ص���������
     * ͬʱʹ�ϲ����������Ȼ����
     * @param array
     * @param i
     * @param middle
     * @param j
     *  4 5 6     9 10 11
     *
     */
    private static void merge(int[] array, int i, int middle, int j) {
        //����һ����ʱ���������洢�ϲ��������
        int[] temp=new int[array.length];
        int m=i;
        int n=middle+1;
        int k=i;
        while(m<=middle&&n<=j)
        {
            if(array[m]<array[n])
                temp[k++]=array[m++];
            else
                temp[k++]=array[n++];
        }
        //����ʣ��δ�ϲ��Ĳ���
        while(m<=middle)
        {
            temp[k++]=array[m++];
        }
        while(n<=j)
        {
            temp[k++]=array[n++];
        }
        //����ʱ�����е����ݴ洢��ԭ������
        while(i<=j)
        {
            array[i]=temp[i++];
        }
    }
 
 
    /**
     *                                       
     * �����Ӧ����Ľ��
     * @param array
     */
    private static void printResult(int[] array) {
       for(int value:array)    
           System.out.print(" "+value+" ");
      System.out.println();
    }
}
