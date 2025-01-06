import java.util.*;
class Solution {
    
    public int[] solution(int[] sequence, int k) {
        // 인덱스(왼쪽, 오른쪽)
        int left = 0;
        int right = 0;
        
        int length = sequence.length;
        int sum = sequence[0];
        // 부분 합계가 k인 리스트
        List<int[]> list = new ArrayList<>();
        while(left < length && right < length) {
            // 부분합계가 k이면 리스트에 추가
            if(sum == k) {
                list.add(new int[]{left, right});
            }
            // k 이하이면, 오른쪽 인덱스 이동
            if(sum <= k) {
                right++;
                if(right<length) {
                    sum += sequence[right];
                }
            } // k보다 크면, 왼쪽 인덱스 이동
            else {
                if(left < length) {
                    sum -= sequence[left];
                    left++;
                }
            }
        }
        
        // 수열의 길이가 짧은 순으로 오름차순으로 정렬
        Collections.sort(list, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                int len1 = o1[1] - o1[0];
                int len2 = o2[1] - o2[0];
                return len1 - len2;
            }
        });
        int[] answer = {list.get(0)[0], list.get(0)[1]};
        return answer;
    }
    
}