package hash;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Practice4 {
	// 오픈채팅방(프로그래머스 lv2)

	public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int cnt = 0;
        for(int i=0; i<record.length; i++) {
            String[] str = record[i].split(" ");
            if(str.length > 2)
                map.put(str[1], str[2]);
            if(str[0].equals("Change"))
                cnt++;
        }
        
        String[] answer = new String[record.length-cnt];
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        
        int idx = 0;
        for(int i=0; i<record.length; i++) {
            String[] str = record[i].split(" ");
            if(str[0].equals("Change")) continue;
            answer[idx++] = map.get(str[1]) + (str[0].equals("Enter") ? enter : leave);
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws IOException {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = solution(record);
		for(String r : result)
			System.out.println(r);

	}	// end of main

}	// end of class
