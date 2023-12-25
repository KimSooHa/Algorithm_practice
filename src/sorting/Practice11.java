package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice11 {
	//[3차] 파일명 정렬(프로그래머스 lv2 2018 KAKAO BLIND RECRUITMENT)
	
	static class File implements Comparable<File> {
        private String name;
        private String head;
        private int number;

        public File(String name, String head, int number) {
            this.name = name;
            this.head = head;
            this.number = number;
        }
        
        public String getName() {
            return name;
        }
        
        @Override
        public int compareTo(File o) {
            if(!this.head.toUpperCase().equals(o.head.toUpperCase()))
                return this.head.toUpperCase().compareTo(o.head.toUpperCase());
            else if(this.number != o.number)
                return Integer.compare(this.number, o.number);
            else
                return 0;
        }
    }
    
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<>();
        
        for(int i=0; i<files.length; i++) {
            String file = files[i];
            
            String head = "";
            String numStr = "";
            int prevNumIdx = -1;
            
            for(int j=0; j<file.length(); j++) {
                if(Character.isDigit(file.charAt(j))) {
                    if(prevNumIdx == -1 || prevNumIdx == j-1) {
                        numStr += file.charAt(j);
                        prevNumIdx = j;
                    }
                } else if(prevNumIdx == -1) 
                    head += file.charAt(j);
                 else
                    break;
            }
            
            list.add(new File(file, head, Integer.parseInt(numStr)));
        }
        
        Collections.sort(list);
        
        for(int i=0; i<list.size(); i++) 
            answer[i] = list.get(i).getName();
        
        return answer;
    }

	public static void main(String[] args) {
		
		String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] answer1 = solution(files1);
		
		for(String str : answer1)
			System.out.println(str);
		
		System.out.println("============");
		
		String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] answer2 = solution(files2);
		
		for(String str : answer2)
			System.out.println(str);
		
	} // end of main
} // end of class
