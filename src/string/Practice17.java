package string;

public class Practice17 {
	// 비밀지도 (프로그래머스)

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			String str1 = getBinary(arr1[i], n);
			String str2 = getBinary(arr2[i], n);

			String result = "";

			for (int j = 0; j < str1.length(); j++)
				result += (str1.charAt(j) == '0' && str2.charAt(j) == '0') ? " " : "#";

			StringBuilder sb = new StringBuilder(result);
			String reverseSb = sb.reverse().toString();
			answer[i] = reverseSb;
		}

		return answer;
	}

	public static String getBinary(int num, int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += num % 2;
			num /= 2;
		}
		return s;
	}

	// 다른 풀이
//    public static String[] solution(int n, int[] arr1, int[] arr2) {
//    	String[] answer = new String[n];
//    	for(int i=0; i<n; i++) {        	
//    		String str = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
//    		
//    		str = str.replaceAll("0", " ");
//    		str = str.replaceAll("1", "#");
//    		
//    		answer[i] = str;
//    	}
//    	
//    	return answer;
//    }

// =========================

	// 다른 사람 풀이(비트 연산자 이용)
	// 1.
//	public String[] solution(int n, int[] arr1, int[] arr2) {
//	    String[] result = new String[n];
//	    for (int i = 0; i < n; i++) {
//	        result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
//	    }
//	
//	    for (int i = 0; i < n; i++) {
//	        result[i] = String.format("%" + n + "s", result[i]); // n칸을 확보해놓고 넣고싶은 문자열을 채워넣음
//	        result[i] = result[i].replaceAll("1", "#");
//	        result[i] = result[i].replaceAll("0", " ");
//	    }
//	
//	    return result;
//	}

// ---------------------------
	// 2.
//    public String[] solution(int n, int[] arr1, int[] arr2) {
//        String[] answer = new String[n];
//        String temp;
//
//        for(int i = 0 ; i < n ; i++){
//            temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
//            temp = temp.substring(temp.length() - n);
//            temp = temp.replaceAll("1", "#");
//            temp = temp.replaceAll("0", " ");
//            answer[i] = temp;
//        }
//
//        return answer;
//    }

	public static void main(String[] args) {

		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		String[] result = solution(n, arr1, arr2);

		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);

	}
}