package �������;

public class Test {
	public static void InsertSort(int[] array) {
		// ������ĵڶ���Ԫ�ؿ�ʼѭ���������е�Ԫ�ز���
		for (int i = 1; i < array.length; i++) {

			// ���������еĵ�2��Ԫ��Ϊ��һ��ѭ��Ҫ���������
			int insertNote = array[i];
			int j = i - 1;
			while (j >= 0 && insertNote < array[j]) {
				// ���Ҫ������Ԫ��С�ڵ�j��Ԫ��,�ͽ���j��Ԫ������ƶ�
				array[j + 1] = array[j];
				j--;
			}
			// ֱ��Ҫ�����Ԫ�ز�С�ڵ�j��Ԫ��,��insertNote���뵽������
			array[j + 1] = insertNote;

		}
	}

	public static void main(String[] args) {
		int[] array = { 8, 9, 7 };
		Test.InsertSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
