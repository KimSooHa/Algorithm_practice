class Solution {

    public String solution(String new_id) {
        String answer = "";
        
        // 1. 대문자 -> 소문자
        answer = new_id.toLowerCase();
        
        // 2. 소문자, 숫자, -, _, . 제외한 문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3. 마침표 연속 2개 1개로 치환
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");        
        }
        
        // 4.마침표가 처음 or 끝이라면 제거
        if(answer.length() > 0 && answer.charAt(0) == '.') 
            answer = answer.substring(1);
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') 
            answer = answer.substring(0, answer.length() - 1);
        
        
        // 5. 빈 문자열이라면 a 대입
        if (answer.length() == 0) answer = "a";
        
        // 6. 16자 이상이면 첫 15개 제외한 나머지 문자 모두 제거 -> 제거 후 끝에 마침표 있으면 제거
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        // 7. 2자 이하이면 마지막 문자를 3이 될때까지 반복해서 끝에 추기
        if (answer.length() == 1) {
            answer += String.valueOf(answer.charAt(0)) + String.valueOf(answer.charAt(0));
        } else if (answer.length() == 2) {
            answer += String.valueOf(answer.charAt(1));
        }
        
        return answer;
    }
}