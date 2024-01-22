/*
 * 1. 전에 풀었던 dp 문제랑 유사한 것 같다
 * 	- n-5, n-3 중에 적은 봉지의 수에 +1 하면 될듯함
 * 2. 첫째 줄에 N
 * 3. 배달하는 봉지의 최소 개수 return
 * 	- 배달이 불가능하면 -1 return
 * */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] su = new int[5001];
		int maxV = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());
		// 초기값
		su[0] = maxV;
		su[1] = maxV;
		su[2] = maxV;
		su[3] = 1;
		su[4] = maxV;
		su[5] = 1;
		su[6] = 2;
		su[7] = maxV;
		if(N > 7){
			for(int i=8; i<=N; i++) {
				su[i] = Math.min(su[i-3],su[i-5]) + 1;
			}
		}
		// 변환 불가능한 수 -1 return
		if(su[N] == maxV) { 
			su[N] = -1;
		}
		bw.write(su[N]+"");
		bw.flush();
	}
}