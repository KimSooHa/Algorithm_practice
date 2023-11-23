package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice6 {
	// ����(���� 2512)
	// ������ �� �ִ��� �� ���� ����
	// 1. ��� ��û�� ������ �� �ִ� ��쿡�� ��û�� �ݾ��� �״�� ����
	// 2. ��� ��û�� ������ �� ���� ��쿡�� Ư���� ���� ���Ѿ��� ����Ͽ� �� �̻��� �����û���� ��� ���Ѿ��� ����. ���Ѿ� ������ �����û�� ���ؼ��� ��û�� �ݾ� �״�� ����. 

	static int n; // ������ ��
	static int m; // �� ����
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		// ����Ž���� ���� ����
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr[n-1];
		int result = 0; // ���Ѿ�
		
		while(start <= end) {
			long total = 0;
			int mid = (start + end) / 2;
			for(int i=0; i<n; i++) {
				if(arr[i] > mid)
					total += mid;
				else
					total += arr[i];
			}
			// �� ������ ���� ��� �� ���� �ڸ���(������ Ž��)
			if(total <= m) {
				start = mid + 1;
				result = mid;				
			}
			else // �� ������ ������ ��� �� �ڸ���(���� Ž��)
				end = mid - 1;
		}
		System.out.println(result);
	}	// end of main
}	// end of class
