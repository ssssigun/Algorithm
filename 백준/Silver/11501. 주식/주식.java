/*
 * 1. 역주행 해서 큰 값 기준으로 팔기
 * 2. 첫줄엔 테스트 케이스 개수
 * 3. 각각 처음에 테스트 케이스당 날의 수, 날 별 주가
 * 4. 최대 이익을 return
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	// 테스트 케이스 수
    	int T = Integer.parseInt(br.readLine());
    	// 반복하기
    	for(int i=0; i<T; i++) {
    		// 이득
    		long benefit = 0;
    		// 날 수
    		int day = Integer.parseInt(br.readLine());
    		int[] dayP =  new int[day];
    		// 날별 주식 값 입력
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<dayP.length; j++) {
    			dayP[j] = Integer.parseInt(st.nextToken());
    		}
    		// 끝에서 부터 계산
    		int max = dayP[dayP.length-1];
    		for(int j=dayP.length-2; j>=0; j--) {
    			// 최대값 갱신
    			if(dayP[j] > max) {
    				max = dayP[j];
    			}else {
    				benefit +=  max - dayP[j];
    			}
    		}
    		// 출력
    		bw.write(benefit+"\n");
    	}
    	bw.flush();
    }
}