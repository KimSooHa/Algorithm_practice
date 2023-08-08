package hash;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice3 {
	// �ǻ�(���α׷��ӽ� lv2)

	public static int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        // A�� ������ N��, B�� ������ M���� �� �����ϴ� ��� ����� �� = (N+1)(M+1) => +1�� �ǹ̴� �ش� ������ �������� ������ �ǹ�
        // �� ������ �ʰ��� ���� +1(�� ��������)���� �ŵ��ؼ� �����ְ�, �������� -1(�� ���� ����� ��)�� ����� �Ѵ�.
        for(String[] clothe : clothes) {
        	if(map.containsKey(clothe[1])) {
        		int tmp = map.get(clothe[1]);
        		map.put(clothe[1], tmp+1);
        	} else
        		map.put(clothe[1], 2); 
        }
        
		for(String k : map.keySet()) 
			answer *= map.get(k);
		
		
		// ���� �ϳ��� �����ؾ� �ϹǷ� �� ���� ����� ���� -1 ����� �Ѵ�.
        return answer -1;
    }
	
	public static void main(String[] args) throws IOException {
		
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));

	}	// end of main

}	// end of class
