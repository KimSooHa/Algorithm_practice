package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice2 {
	// ���ĵ� �迭���� Ư�� ���� ���� ���ϱ�

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		// ã���� �ϴ� ���ڿ�
		int x = Integer.parseInt(st.nextToken());
		
		// ��ü ���� �Է¹ޱ�
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// ���� [x, x] ������ �ִ� �������� ���� ���
		int cnt = countByRange(arr, x, x);
		
		
		if(cnt == 0)
			System.out.println(-1);
		else
			System.out.println(cnt);

	}	// end of main

	// ���� [left_value, right_value]�� �������� ������ ��ȯ�ϴ� �Լ�
	public static int countByRange(int[] arr, int leftValue, int rightValue) {
		// ����: lowerBound�� upperBound�� end ������ ���� �迭�� ���̷� ����
		
		int rightIndex = upperBound(arr, rightValue, 0, arr.length);
		int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
		
		return rightIndex - leftIndex;
	}

	public static int lowerBound(int[] arr, int target, int start, int end) {
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= target)
				end = mid;
			else
				start = mid + 1;
		}
		
		return end;
	}

	public static int upperBound(int[] arr, int target, int start, int end) {
		
		while(start < end) {
			int mid = (start + end) / 2;

			// target�� �ش��ϴ� ������ ����ؾ� �ϹǷ� target�� ������ ���� ū �ε����� ���� ��
			if(arr[mid] > target)	
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}

}	// end of class
