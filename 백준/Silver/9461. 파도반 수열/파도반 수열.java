/*
 * 1. 나선형으로 삼각형 붙이기
 * 	- 10까지 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
 *  - (n-1) + (n-5)이 길이가 될 것 같다.
 * 2. 첫째 줄엔 케이스의 개수 T, 둘째줄 부터 테스트 케이스
 * 3. 케이스 마다 p(n) return
*/
import java.util.*;
import java.io.*;
public class Main{
	public static long[] pA = new long[101]; // 변의 길이 저장 함수
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int T = Integer.parseInt(br.readLine());
    	int[] c = new int[T];
    	int max = 0;
    	// 배열 초기값 넣기
    	for(int i=1; i<6; i++) {
    		if(i<4) {
    			pA[i] = 1;    			
    		}else {
    			pA[i] = 2;
    		}
    	}
    	// 테스트 케이스 입력 받기
    	for(int i=0; i<T; i++) {
    		int n = Integer.parseInt(br.readLine());
    		if(max < n) {
    			max = n; // 큰수 찾기
    		}
    		c[i] = n;
    	}
    	// 길이 구하기
    	dp(max);
    	// 출력
    	for(int i=0; i<T; i++) {
    		bw.write(pA[c[i]]+"\n");
    	}
    	bw.flush();
    }
    // 변의 길이 구하는 함수
    public static void dp(int N) {
    	for(int i=6; i<=N; i++) {
    		pA[i] = pA[i-1] + pA[i-5];
    	}
    }
}