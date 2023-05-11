package dfs;

import java.io.IOException;

public class Practice5 {
	// 괄호 변환(프로그래머스 lv2)
	
	public static String solution(String p) {
        String answer = "";
        
        // 입력이 빈 문자열인 경우, 빈 문자열 반환
        if(p.equals(""))
        	return answer;
        
        int idx = balancedIndex(p);
        // '균형잡힌 괄호 문자열'(u)로 분리
        String u = p.substring(0, idx+1);
        // u 빼고 나머지 문자열(v)
        String v = p.substring(idx+1);
        
        // '올바른 괄호 문자열'이라면, v에 대해 함수를 수행한 결과를 붙여 반환
        if(checkProper(u)) 
            answer = u + solution(v);
        else { // u가 '올바른 괄호 문자열이 아니라면'
            answer += "(";
            answer += solution(v);
            answer += ")";
            // u의 첫 번째와 마지막 문자 제거
            u = u.substring(1, u.length()-1);
            // u의 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙이기
            StringBuffer sb = new StringBuffer();
            
            for(int i=0; i<u.length(); i++) 
                sb.append(u.charAt(i) == '(' ? ")" : "(");
             
            answer += sb;
        }
        return answer;
    }
    
    // '균형잡힌 괄호 문자열'의 인덱스 반환
    public static int balancedIndex(String p) {
        int cnt = 0; // 왼쪽 괄호의 개수
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            
            if(cnt == 0)
                return i;
        }
        return -1;
    }
    
    // '올바른 괄호 문자열'인지 판단
    public static boolean checkProper(String u) {
        int cnt = 0; // 왼쪽 괄호의 개수
        for(int i=0; i<u.length(); i++) {
            if(u.charAt(i) == '(') cnt++;
            else {
                // 쌍이 맞지 않는 경우에 false 반환
                if(cnt == 0)
                    return false;
                cnt--;
            }
        }
        // 쌍이 맞는 경우에 true 반환
        return true;
    }

	public static void main(String[] args) throws IOException {
		String p = "(()())()";
		System.out.println(solution(p));
	}

}	// end of class
