package implement;

import java.io.IOException;

class Practice30 {
	// �ڹ���� ����(���α׷��ӽ� lv3)
	
	// 2���� ����Ʈ 90�� ȸ���ϱ�
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // ��� ����Ʈ
        
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                result[j][n-i-1] = a[i][j]; // 90���� �������� i�ڸ� = j�ڸ�, j�ڸ� = n-i-1�ڸ�
        
        return result;
    }
    
    // �ڹ����� �߰� �κ��� ��� 1���� Ȯ��
    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length/3;
        
        for(int i=lockLength; i<lockLength*2; i++) 
            for(int j=lockLength; j<lockLength*2; j++) 
                if(newLock[i][j] != 1)
                    return false;
            
        return true;
    }
    
    public static boolean solution(int[][] key, int[][] lock) {
        
        int n = lock.length;
        int m = key.length;
        
        // �ڹ����� ũ�⸦ ������ 3��� ��ȯ(���� �־ �� �迭 ����� ���� ����ؼ� �ڹ��� �迭 �ø���)
        int[][] newLock = new int[n*3][n*3];
        // ���ο� �ڹ����� �߾� �κп� ������ �ڹ��� �ֱ�
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                newLock[i+n][j+n] = lock[i][j];
        
        // 4���� ���⿡ ���ؼ� Ȯ��
        for(int rotation=0; rotation<4; rotation++) {
            key = rotateMatrixBy90Degree(key); // ���� ȸ��
            
            for(int x=0; x<n*2; x++) {
                for(int y=0; y<n*2; y++) {
                    // �ڹ��迡 ���踦 ���� �ֱ�
                    for(int i=0; i<m; i++)
                        for(int j=0; j<m; j++)
                            newLock[x+i][y+j] += key[i][j];
                    
                    // ���ο� �ڹ��迡 ���谡 ��Ȯ�� ���´��� �˻�
                    if(check(newLock))
                        return true;
                    
                    // �ڹ��迡�� ���踦 �ٽ� ����
                    for(int i=0; i<m; i++)
                        for(int j=0; j<m; j++)
                            newLock[x+i][y+j] -= key[i][j];
                }
            }
        }
        
        return false;
    }

	public static void main(String args[]) throws IOException {
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock= {{1,1,1}, {1,1,0}, {1,0,1}};
		
		System.out.println(solution(key, lock));
		
	}	// end of main

}	// end of class