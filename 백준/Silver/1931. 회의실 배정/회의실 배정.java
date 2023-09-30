/*
 * 1. 그리디는 기준을 잘 잡아야할 것 같다.
 * 	- 종료 시간을 기준
 * 2. 첫줄은 회의의 수 N, 둘째줄 부터 회의의 정보
 * 3. 최대 사용할 수 있는 회의의 개수 return
 * */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		 // 선언
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st;
		 // 회의 수
		 int N = Integer.parseInt(br.readLine());
		 int[][] inp = new int[N][2];
		 // 입력 받기
		 for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 inp[i][0] = Integer.parseInt(st.nextToken());
			 inp[i][1] = Integer.parseInt(st.nextToken());
		 }
		 // 정렬
		 Arrays.sort(inp,(o1,o2) ->{return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];});
		 // 초기값
		 int temp = inp[0][1];
		 int cnt = 1;
		 // 회의 수 구하기
		 for(int i=1; i<inp.length; i++) {
			 // 시작 시간이 종료 시간보다 늦을 때
			 if(inp[i][0]>=temp) {
				 cnt++;
				 temp = inp[i][1];
			 }
		 }
		 // 출력
		 bw.write(cnt+"");
		 bw.flush();
	}
}