/*
 * 1. Pn 문자열 찾기 (생성해줘야한다)
 * 	- 문자열로 생성해서 비교하면 부분 점수만 나온다.
 * 	- to.charArray로 비교해서 숫자로 카운트하기
 * 2. 첫 줄엔 N, 둘째 줄엔 문자열 길이 M, 셋째 줄엔 문자열
 * 3. Pn이 몇개 들어가는지 확 return
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int ans = 0;
    	int cnt = 0;
    	// N
    	int N = Integer.parseInt(br.readLine());
    	// M
    	int M = Integer.parseInt(br.readLine());
    	// S
    	char[] S = br.readLine().toCharArray();
    	// Pn이 몇개 있는지 확인
    	for(int i=1; i<M-1; i++) {
    		// Pn의 작은단위를 찾았을 때
    		if(S[i-1] == 'I' && S[i] == 'O' && S[i+1] == 'I') {
    			cnt++;
    			// cnt의 갯수가 Pn과 같아질 때
    			if(cnt == N) {
    				ans++;
    				cnt--;
    			}
    			// 두칸 건너뛰기
    			i++;
			// 연속되지 않으면 초기화
    		}else {
    			cnt=0;
    		}
    	}
    	// 출력
    	bw.write(ans+"");
    	bw.flush();
    }
}