package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice2 {
	// 국영수(백준 10825)
	
	// 학생별 과목 점수 클래스
	public static class Student implements Comparable<Student> {

		private String name;
		private int kor;
		private int eng;
		private int math;
		
		
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}


		public String getName() {
			return name;
		}


		@Override
		public int compareTo(Student other) {
			// 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서
			if(this.kor == other.kor && this.eng == other.eng && this.math == other.math)
				return this.name.compareTo(other.name);
			// 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로 
			if(this.kor == other.kor && this.eng == other.eng)
				return Integer.compare(other.math, this.math);
			// 국어 점수가 같으면 영어 점수가 증가하는 순서로
			if(this.kor == other.kor)
				return Integer.compare(this.eng, other.eng);
			// 국어 점수가 감소하는 순서로
			return Integer.compare(other.kor, this.kor);
		}
		
	}	// end of inner class
	
	public static int n, kor, eng, math;
	public static String name;
	public static ArrayList<Student> students = new ArrayList<>();
	
	public static void main(String[] args ) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 학생 수
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			name = st.nextToken();
			kor = Integer.parseInt(st.nextToken());
			eng = Integer.parseInt(st.nextToken());
			math = Integer.parseInt(st.nextToken());
			
			// 입력받은 학생들을 리스트에 추가
			students.add(new Student(name, kor, eng, math));
		}
		
		// 학생들을 정렬 기준으로 정렬
		Collections.sort(students);
		
		// 정렬된 학생의 이름 출력
		for(int i=0; i<n; i++) 
			System.out.println(students.get(i).getName());
		
	}	// end of main

}	// end of class
