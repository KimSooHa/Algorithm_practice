package hash;

import java.io.IOException;
import java.util.Arrays;

public class Practice2 {
	// ��ȭ��ȣ ���(���α׷��ӽ� lv2)

	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // �� ���ڿ� ����� ù���� �ε����� ���� �������� ���ĵ�
        Arrays.sort(phone_book); // ex) 11, 1, 1117, 213, 123456789 => 1, 11, 1117, 123456789, 213
        
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) { // startsWith: �� ��� ���ڿ��� �ش� ���ڿ��� ���۵Ǵ��� �� 
                answer = false;
                break;
            }
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));

	}	// end of main

}	// end of class
