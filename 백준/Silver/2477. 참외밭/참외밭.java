/*
 * 1. 첫째 줄에 참외의 갯수 K
 * 2. 둘째 줄부터 반시계 방향으로 변의 길이(0<길이<500)와 방향이 주어진다.
 * 3. 방향은 동쪽 1, 서쪽 2, 남쪽 3, 북쪽 4
 * 4. 사이즈가 두개면 큰 길이로 면적 - 작은 길이 면적하면 나올 것 같다.
 * 5. 큰 길이 위치를 구하고 큰 길이 양옆의 변의 길이를 빼주면 작은 변의 길이가 나오므로 활용
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws  IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	// 길이 저장
    	int[] arr = new int[6]; 
    	// 큰 변의 길이 인덱스
    	int maxH = 0;
    	int idxH = 0;
    	int maxV = 0;
    	int idxV = 0;
    	// K 입력 받기
    	int K = Integer.parseInt(br.readLine());
    	// 변의 길이 입력 받기
    	for(int i=0; i<6; i++) {
    		st = new StringTokenizer(br.readLine());
    		int dir = Integer.parseInt(st.nextToken());
    		int len = Integer.parseInt(st.nextToken());
			// 세로 큰 길이 저장
    		if(dir == 1 || dir == 2) {
    			if(maxH < len) {
    				maxH = len;
    				idxH = i;
    			}
			// 가로 큰 길이 저장
    		}else if(dir == 3 || dir == 4) {
    			if(maxV < len) {
    				maxV = len;
    				idxV = i;
    			}
    		}
    		// 길이 저장
    		arr[i] = len;
    	}
    	// 작은 사각형 넓이 구하기
    	int small = Math.abs( (arr[(idxH-1) < 0 ? arr.length-1 : (idxH-1)] - arr[idxH+1 == arr.length? 0 : idxH+1]) 
    			* (arr[(idxV-1) < 0 ? arr.length-1 : (idxV-1)]-arr[idxV+1 == arr.length? 0 : idxV+1]) );
    	// 참외밭의 넓이 (큰 사각형 - 작은 사각형)
    	int field = (maxH * maxV) - small;
    	// 정답 출력
    	bw.write((K * field)+"");
    	bw.flush();
    }
}