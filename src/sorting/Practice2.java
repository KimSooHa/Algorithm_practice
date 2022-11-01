package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice2 {
	// ������(���� 10825)
	
	// �л��� ���� ���� Ŭ����
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
			// ��� ������ ������ �̸��� ���� ������ �����ϴ� ����
			if(this.kor == other.kor && this.eng == other.eng && this.math == other.math)
				return this.name.compareTo(other.name);
			// ���� ������ ���� ������ ������ ���� ������ �����ϴ� ������ 
			if(this.kor == other.kor && this.eng == other.eng)
				return Integer.compare(other.math, this.math);
			// ���� ������ ������ ���� ������ �����ϴ� ������
			if(this.kor == other.kor)
				return Integer.compare(this.eng, other.eng);
			// ���� ������ �����ϴ� ������
			return Integer.compare(other.kor, this.kor);
		}
		
	}	// end of inner class
	
	public static int n, kor, eng, math;
	public static String name;
	public static ArrayList<Student> students = new ArrayList<>();
	
	public static void main(String[] args ) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// �л� ��
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			name = st.nextToken();
			kor = Integer.parseInt(st.nextToken());
			eng = Integer.parseInt(st.nextToken());
			math = Integer.parseInt(st.nextToken());
			
			// �Է¹��� �л����� ����Ʈ�� �߰�
			students.add(new Student(name, kor, eng, math));
		}
		
		// �л����� ���� �������� ����
		Collections.sort(students);
		
		// ���ĵ� �л��� �̸� ���
		for(int i=0; i<n; i++) 
			System.out.println(students.get(i).getName());
		
	}	// end of main

}	// end of class
