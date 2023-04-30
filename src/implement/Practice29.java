package implement;

import java.io.IOException;
import java.util.Scanner;

class Practice29 {
	// ���ڿ� ����(���α׷��ӽ� lv2)
	
	public static int solution(String s) {
        int answer = 0;
        for(int i=1; i<=(s.length()/2)+1; i++) {
        	int result = getSplitedLength(s, i, 1).length();
        	answer = i == 1 ? result : Math.min(answer, result);
        }
        return answer;
    }
	
	public static String getSplitedLength(String s, int n, int repeat) {
		// ���ڿ� ���̰� �ڸ��� �����ε������� ������ ���� ���ڿ� ��ȯ
		if(s.length() < n) return s;
		
		String result = "";
		String preString = s.substring(0, n);	// n��°���� �ڸ���(�ڸ��� ���ع���)
		String postString = s.substring(n);	// �ڸ��� ������ �޺κ�
		
		// ����ġ -> ������� [�ݺ�Ƚ�� + �ݺ�����] ����
		if(!postString.startsWith(preString)) {
			if(repeat == 1) return result += preString + getSplitedLength(postString, n, 1);
			return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
		}
		
		return result += getSplitedLength(postString, n, repeat+1);
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int answer = solution(s);
		System.out.println(answer);
		
	}	// end of main

}	// end of class