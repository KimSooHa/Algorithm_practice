package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice74 {
	// 빗물(백준 14719)

	static int h, w; // 세로(h), 가로(w)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int[] height = new int[w];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) 
			height[i] = Integer.parseInt(st.nextToken());
		
		int total = 0;
		for(int i=1; i<w-1; i++) { // 인덱스 별 모이는 빗물. 첫, 마지막 인덱스 제외(첫, 마지막 블록에는 빗물이 고일 수 없음)
			int left = 0;
			int right = 0;
			
			for(int j=0; j<i; j++)
				left = Math.max(height[j], left); // 현재 기준블록의 높이보다 높은 블록이 왼쪽에 있어야 함 
			
			for(int j=i+1; j<w; j++)
				right = Math.max(height[j], right); // 현재 기준블록의 높이보다 높은 블록이 오른쪽에 있어야 함
			
			if(height[i] < left && height[i] < right) // 현재 블록이 두 블록보다 낮은지 확인(낮아야 물이 고일 수 있음)
				total += Math.min(left, right) - height[i]; // 둘 중에 더 낮은 블록을 기준으로 현재 블록의 빗물이 고일 수 있는 높이 계산
		}
		
		System.out.println(total);

	} // end of main

} // end of class
