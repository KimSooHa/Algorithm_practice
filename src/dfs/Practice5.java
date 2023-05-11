package dfs;

import java.io.IOException;

public class Practice5 {
	// ��ȣ ��ȯ(���α׷��ӽ� lv2)
	
	public static String solution(String p) {
        String answer = "";
        
        // �Է��� �� ���ڿ��� ���, �� ���ڿ� ��ȯ
        if(p.equals(""))
        	return answer;
        
        int idx = balancedIndex(p);
        // '�������� ��ȣ ���ڿ�'(u)�� �и�
        String u = p.substring(0, idx+1);
        // u ���� ������ ���ڿ�(v)
        String v = p.substring(idx+1);
        
        // '�ùٸ� ��ȣ ���ڿ�'�̶��, v�� ���� �Լ��� ������ ����� �ٿ� ��ȯ
        if(checkProper(u)) 
            answer = u + solution(v);
        else { // u�� '�ùٸ� ��ȣ ���ڿ��� �ƴ϶��'
            answer += "(";
            answer += solution(v);
            answer += ")";
            // u�� ù ��°�� ������ ���� ����
            u = u.substring(1, u.length()-1);
            // u�� ������ ���ڿ��� ��ȣ ������ ����� �ڿ� ���̱�
            StringBuffer sb = new StringBuffer();
            
            for(int i=0; i<u.length(); i++) 
                sb.append(u.charAt(i) == '(' ? ")" : "(");
             
            answer += sb;
        }
        return answer;
    }
    
    // '�������� ��ȣ ���ڿ�'�� �ε��� ��ȯ
    public static int balancedIndex(String p) {
        int cnt = 0; // ���� ��ȣ�� ����
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
    
    // '�ùٸ� ��ȣ ���ڿ�'���� �Ǵ�
    public static boolean checkProper(String u) {
        int cnt = 0; // ���� ��ȣ�� ����
        for(int i=0; i<u.length(); i++) {
            if(u.charAt(i) == '(') cnt++;
            else {
                // ���� ���� �ʴ� ��쿡 false ��ȯ
                if(cnt == 0)
                    return false;
                cnt--;
            }
        }
        // ���� �´� ��쿡 true ��ȯ
        return true;
    }

	public static void main(String[] args) throws IOException {
		String p = "(()())()";
		System.out.println(solution(p));
	}

}	// end of class
