/*
 * 1. DP의 대표적인 예시
 * 	- 탑다운으로 풀 예정 (재귀함수 이용)
 * 2. 첫째 줄엔 테스트 케이스의 갯수
 * 3. 둘째줄부터 수할 수 나열
 * 4. 0과 1이 나온 수 return
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	int max = 0;
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    		if(max < arr[i]) {
    			max = arr[i];
    		}
    	}
    	// 피보나치 배열
    	int[][] pibo = new int[max+2][2];
    	// 초기값
    	pibo[0][0] = 1;
    	pibo[0][1] = 0;
    	pibo[1][0] = 0;
    	pibo[1][1] = 1;
    	// 피보나치 수 구하기
    	for(int i=2; i<pibo.length; i++) {
    		pibo[i][0] = pibo[i-1][0] + pibo[i-2][0];
    		pibo[i][1] = pibo[i-1][1] + pibo[i-2][1];
    	}
    	// 출력
    	for(int i=0; i<n; i++) {
    		bw.write(pibo[arr[i]][0] +" " + pibo[arr[i]][1]+"\n");
    	}
    	bw.flush();
    }
}