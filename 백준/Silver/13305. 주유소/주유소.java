/*
 * 1. 첫째 줄은 도시의 갯수 N
 * 2. 둘째 줄은 도시간의 거리
 * 3. 셋째 줄은 도시의 기름값 가격
 * 4. 최소 기름 값을 return
 * 5. 다음 도시와 기름 값을 비교하여 작을 경우에 대신 연산하기
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	// 정답용 배열
    	long answer = 0;
    	StringTokenizer st;
    	// 거리 배열
    	long[] dis = new long[N-1]; 
		// 도시 배열
    	long[] city = new long[N]; 
    	// 거리 배열 입력 받기
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N-1; i++){
    		dis[i] = Integer.parseInt(st.nextToken());
    	}
    	// 도시 배열 입력 받기
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++){
    		city[i] = Integer.parseInt(st.nextToken());
    	}
    	// 이전 도시 기름값 저장
    	long last = city[0];
    	// 기름 값 구하기
    	for(int i=0; i<N-1; i++) {
    		if(last>city[i]) {
    			last = city[i];
    		}
    		answer += last * dis[i];
    	}
    	// 출력
    	bw.write(answer+"");
    	bw.flush();
    }
}
