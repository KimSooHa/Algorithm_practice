package implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Practice78 {
	// 스킬트리(프로그래머스 lv2)

	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
            String st = skill_trees[i];
            int[] skillIdx = new int[st.length()];
            if(isRightOrder(st, skillIdx, skill))
                answer++;
        }
        return answer;
    }
    
	// 수정전 코드
//	static boolean isRightOrder(String st, int[] skillIdx, String skill) {
//        int idx = -1;
//        boolean[] isVisited = new boolean[skill.length()];
//        for(int j=0; j<st.length(); j++) {
//            for(int k=0; k<skill.length(); k++) {
//                if(st.charAt(j) == skill.charAt(k)) {
//                    skillIdx[j] = k;
//                    isVisited[k] = true;
//                    break;
//                }
//                skillIdx[j] = -1;
//            }
//            if(idx > skillIdx[j] && skillIdx[j] != -1) 
//                return false;
//            
//            idx = Math.max(idx, skillIdx[j]);
//            for(int i=0; i<idx; i++) {
//                if(!isVisited[i]) 
//                    return false;              
//            }
//        }
//        return true;
//    }
	
	// 수정 후 코드
	static boolean isRightOrder(String st, int[] skillIdx, String skill) {
        int idx = -1;
        int currentIdx = 0;
        for(int j=0; j<st.length(); j++) {
            for(int k=0; k<skill.length(); k++) 
            	idx = skill.indexOf(st.charAt(j));
            
            if(idx == -1) continue;
            if(currentIdx == idx)
            	currentIdx++;
            else
            	return false;
        }
        return true;
    }
	
	// 다른 방식의 풀이
	// 1.
//	public static int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
//        Iterator<String> it = skillTrees.iterator();
//
//        while (it.hasNext()) {
//            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
//                it.remove();
//            }
//        }
//        answer = skillTrees.size();
//        return answer;
//    }
	
	// 2
//	public static int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//        for (String skillTree : skill_trees) {
//            int learningIdx = 0;
//            boolean isAble = true;
//            for (char curSkill : skillTree.toCharArray()) {
//                int skillIdx = skill.indexOf(curSkill); // skill에 없는 인덱스는 -1이 나옴
//                if (skillIdx == -1)
//                    continue;
//                else if (skillIdx == learningIdx)
//                    learningIdx++;
//                else {
//                    isAble = false;
//                    break;
//                }
//            }
//            if (isAble)
//                answer++;
//        }
//        return answer;
//    }
	
	
	public static void main(String[] args) {
		String skill = "CBD";
		String[] sill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, sill_trees));

	} // end of main

} // end of class
