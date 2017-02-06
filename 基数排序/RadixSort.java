package ��������;

import java.util.LinkedList;

public class RadixSort {
	// �洢ԭ���������
	private LinkedList<Integer> mainRadix;
	// �洢ÿ��������Χ������
	private LinkedList<Integer>[] subQueue;

	@SuppressWarnings("unchecked")
	public RadixSort() {
		// ��ʼ��ԭʼ����
		mainRadix = new LinkedList<Integer>();
		// ��ʼ��ÿ������ֵ������
		subQueue = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			subQueue[i] = new LinkedList<Integer>();
		}
	}

	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		int[] array = { 24, 52, 63, 7674, 74, 25, 14, 256, 63263, 14, 4, 4242,
				52 };
		System.out.println("��������ǰ");
		rs.print(array);
		System.out.println("���������");
		rs.sort(array);
		rs.print(array);
	}

	public void sort(int[] array) {
		int maxDigits = 0;
		//��ȡ��ǰ����������Ǹ����ֵĳ���
		for (int i = 0; i < array.length; i++) {
			// ��ȡ����ǰ�����е�������ֳ��� ��Ϊ��λ
			if (maxDigits < String.valueOf(array[i]).length()) {
				maxDigits = String.valueOf(array[i]).length();
			}
			// �����鸳ֵ��������
			mainRadix.add(array[i]);
		}
		// ��ÿһλ���бȽ��жϴ��뵽��������ȥ
		for (int i = 1; i <= maxDigits; i++) {
			// ��ԭ��������ֵʱȡ���ֱ����������
			while (mainRadix.size() > 0) {
				//ȡ����ǰ�����е�Ԫ��
				Integer number = mainRadix.pop();
				//ת�����ַ������ڵ������·����ò���
				String numberTemp = String.valueOf(number);
				//���統ǰԪ�س����жϳ�����ֱ�ӽ������뵽0��������ȥ
				if (numberTemp.length() < i) {
					subQueue[0].add(number);
					continue;
				}
				//��ǰ�����������Ϊ��ǰ���ĳ��ȼ���Ŵ���ֵ��һ
				//��Ϊ���ִ��뵽�����и�λ������ǰ�� ���� 12 1������Ϊ0������ôд����˼��һ��
				int digit = numberTemp.charAt(numberTemp.length() - i) - '0';
				//���������в������Ԫ��
				subQueue[digit].add(number);
			}
			
			for (int j = 0; j < 10; j++) {
				// ��ÿ���ӻ�����д��ԭ����
				mainRadix.addAll(subQueue[j]);
				//�����ÿ���ӻ��������ֹ�´��ж��ظ�
				subQueue[j].clear();
			}
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = mainRadix.get(i);
		}
	}

	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
