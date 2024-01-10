/*
 * 1. 1 집의 색은,2 집의 색이 같지 않아아야 함
 * 	- N, N-1집의 색이 같지 않아야 함
 * 	- i집은 i-1 또는 i+1집의 색과 같지 않아야 함
 * 	-- 요약하자면 앞뒤로 겹치는 녀석이 있으면 안됨
 * 2. 첫줄의 집의 수 N, 둘째줄부터 각각 집의 빨강, 초록, 파랑으로 칠하는 비용이 주어진다.
 * 3. 모든 집을 칠하느 비용의 최솟값 return
*/
import java.util.*;
import java.io.*;
public class Main{
	public static int N; // 집의 수
	public static int[][] color;  // 색상 저장
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
    	// 선언
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	N = Integer.parseInt(br.readLine());	
    	color = new int[N][3];
    	// 입력 받기
    	for(int i=0; i<N; i++) {
    		String[] temp = br.readLine().split(" ");
    		color[i][0] = Integer.parseInt(temp[0]);
    		color[i][1] = Integer.parseInt(temp[1]);
    		color[i][2] = Integer.parseInt(temp[2]);
    	}
    	// 색상 연산
    	cal();
    	// 최솟값 출력
    	bw.write(Math.min(color[N-1][0], Math.min(color[N-1][1], color[N-1][2]))+"");
    	bw.flush();
    }
    public static void cal() {
    	for(int i=1; i<N; i++) {
    		color[i][0] += Math.min(color[i-1][1], color[i-1][2]);
    		color[i][1] += Math.min(color[i-1][0], color[i-1][2]);
    		color[i][2] += Math.min(color[i-1][0], color[i-1][1]);
    	}
    }
}