class Solution {
    static long [] answer;
    // static StringBuilder sb = new StringBuilder();
    
    public long[] solution(long[] numbers) {
        answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            func(i, numbers[i]);
        }
        return answer;
    }
    
    public static void func(int index, long cur){
        // String str = toBinary(cur);
        String str = Long.toBinaryString(cur);
        int lastIndex = -1;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0') 
                lastIndex = i;
        }
        long result = 0;
        int size = str.length();
        // 0이 없는 경우 
        if(lastIndex == -1){
            // 1을 추가하고 바로 오른쪽을 0으로 변경
            // result = toLong("10" + str.substring(1, size));
            result = Long.parseLong("10" + str.substring(1, size), 2);
        }
        else {
            // 0이 제일 끝에 있는 경우 
            if(lastIndex == str.length() - 1) {
                // 0을 1로 교체
                // result = toLong(str.substring(0, size -1) + "1");
                result = Long.parseLong(str.substring(0, size-1) + "1", 2);
            } 
            // 0이 가운데에 있는 경우
            else {
                // 가장 큰 index 기준으로 0이 숫자를 1로 바꾸고 그 오른쪽을 0으로 교체
                // result = toLong(str.substring(0, lastIndex) + "10" + str.substring(lastIndex + 2));
                result = Long.parseLong(str.substring(0, lastIndex) + "10" + str.substring(lastIndex + 2), 2);
            }
        }
        answer[index] = result;
    }
    
    // long -> (String)Binary
    // public static String toBinary(long num) { 
    //     sb.setLength(0);
    //     while(num >= 2) {
    //         sb.append(num % 2);
    //         num /= 2;
    //     }
    //     sb.append(num);
    //     return sb.reverse().toString();
    // }
        
     // (String)Binary -> long (2진수에서 10진수로 변환)
    // public static long toLong(String str) {
    //     long sum = 0;
    //     int cnt = 0;
    //     for(int i = str.length() - 1; i >= 0; i--) {
    //         if(str.charAt(i) == '1') 
    //             sum += (long) Math.pow(2, cnt);
    //         
    //         cnt++;
    //     }
    //     return sum;
    // }
}