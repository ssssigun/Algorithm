/*
 * 1. 그리디 알고리즘 문제
 * 2. 첫줄은 로프의 갯수
 * 3. 두번째부터 로프 당 들 수 있는 무게
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// N 입력 받기
    	int N = Integer.parseInt(br.readLine());
    	// 로프 입력 받기
    	Integer[] roop = new Integer[N];
    	for(int i=0; i<N; i++) {
    		roop[i] = Integer.parseInt(br.readLine());
    	}
    	// 작은 값부터 정렬
    	Arrays.sort(roop,Collections.reverseOrder());
    	// 큰 값 저장
    	int max = 0;
    	// 값 구하기
    	for(int i=1; i<=N; i++) {
    		if(roop[i-1]*i>max) {
    			max = roop[i-1]*i;
    		}
    	}
    	// 답 출력
    	bw.write(max+"");
    	bw.flush();
    }
}