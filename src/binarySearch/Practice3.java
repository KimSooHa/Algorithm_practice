package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice3 {
	// ������ ã��

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ���� ����
		int n = Integer.parseInt(st.nextToken());
		
		// ��ü ���� �Է¹ޱ�
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// ���� [������, ����] ������ �ִ� ������(���� �ε����� ������ ����) ã��
		int index = binarySearch(arr, 0, n-1);	// �迭, ������, ����
		
		System.out.println(index);

	}	// end of main

	// ����Ž�� �ҽ��ڵ�
	public static int binarySearch(int[] arr, int start, int end) {
		
		if(start > end)
			return -1;
		
		int mid = (start + end) / 2;
		
		// �������� ã�� ��� ������ �ε��� ��ȯ
		if(arr[mid] == mid)
			return mid;
		// �߰����� ������ �߰����� ���� ��� ���� Ȯ��
		if(arr[mid] > mid)
			return binarySearch(arr, start, mid-1);
		// �߰����� ������ �߰����� ū ��� ������ Ȯ��
		else
			return binarySearch(arr, mid+1, end);	
	}

	
}	// end of class
