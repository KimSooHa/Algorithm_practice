package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Practice77 {
	// 한 줄로 서기(백준 1138)
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n]; // 인덱스만큼 왼쪽에 있을 수 있는 사람 수
		List<Integer> list = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		/**
		 * 4
		 * 2 1 1 0 => 4 2 1 3
		 * 5
		 * 0 0 0 0 0 => 1 2 3 4 5
		 */
		
		// 방법1
		for (int i = n-1; i >= 0; i--) 
			list.add(arr[i], i+1); // 1 , 7 / 5, 6 / 7, 5 / 4, 4 / 3, 3 / 2, 2 / 6, 1 = 6 2 3 4 7 5 1
		

		// 방법2
//		for(int i=arr.length-1, j=0; i>=0; i--, j++) {
//		int cnt = arr[i]; // 0, 1, 1
//		if(cnt == j)
//			result[j] = i+1; // result[0] = 4, result[1] = 3
//		else {
//			for (int k = j; k > cnt; k--) // 2 
//				result[k] = arr[k-1]; // result[2] = arr[1];
//			
//			result[cnt] = i+1; // result[1] = 2;
//		}
//	}
		
		// 방법3
//		for (int i = 0; i < n; i++) {
//			int j = 0;
//
//			while (true) {
//				int cnt = arr[i];
//				if (cnt == 0 && result[j] == 0) {
//					result[j] = i + 1;
//					break;
//				} else if (result[j] == 0) 
//					arr[i]--;
//				
//				j++;
//			}
//		}

		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");

	} // end of main
} // end of class
