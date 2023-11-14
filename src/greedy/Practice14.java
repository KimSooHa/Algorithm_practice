package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Practice14 {
	// ������ ����ġ(���� 2138)
	
	static int n; // ���� ����
	static boolean[] currentBulbA; // ��������(ù��° ���� ����Ī)
	static boolean[] currentBulbB; // ��������(ù��° ���� ����Ī x)
	static boolean[] goalBulb;
	static int answer = Integer.MAX_VALUE; // ����ġ Ƚ��
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String current = br.readLine();
		String goal = br.readLine();
		
		currentBulbA = new boolean[n];
		currentBulbB = new boolean[n];
		goalBulb = new boolean[n];
		
		for(int i=0; i<n; i++) {
			currentBulbA[i] = current.charAt(i) != '0';
			currentBulbB[i] = current.charAt(i) != '0';
			goalBulb[i] = goal.charAt(i) != '0';
		}
		
		// ù��° ���� ����Ī �����ʰ� ����
		greedyChoice(currentBulbA, 1, 0);
		// ù��° ���� ����Ī �ϰ� ����
		greedyChoice(switchBulb(0, currentBulbB), 1, 1);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
				
	} // end of main

	static void greedyChoice(boolean[] givenBulb, int idx, int cnt) {
		
		if(idx == n) {
			if(givenBulb[idx-1] == goalBulb[idx-1])
				answer = Math.min(answer, cnt);
			return;
		}
		
		if(givenBulb[idx-1] != goalBulb[idx-1]) 
			greedyChoice(switchBulb(idx, givenBulb), idx+1, cnt+1);
		else
			greedyChoice(givenBulb, idx+1, cnt);
	}

	// ���� ����Ī�ϱ�
	static boolean[] switchBulb(int idx, boolean[] givenBulb) {
		for(int i=idx-1; i<=idx+1; i++) {
			if(i >= 0 && i < n)
				givenBulb[i] = !givenBulb[i];
		}
		return givenBulb;
	}

}	// end of class