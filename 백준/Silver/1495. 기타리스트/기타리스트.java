/*
 * 1. 
 * 2. 첫째 줄에 N, S, M
 * 	- 둘째 줄부터 볼륨의 차이
 * 3. 마지막 곡의 볼륨 중 최대값 return
 * 	- 중간에 조절 불가능하거나, 마지막 연주가 불가능하면 -1 return
 * */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dp = new int[M+1];
		int[] v = new int[N+1];
		int ans = -1;
		for(int i=0; i<=M; i++) {
			dp[i] = -1;
		}
		dp[S] = 0;
		// 입력 받기
		String[] temp = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			v[i] = Integer.parseInt(temp[i-1]);
		}
		// 볼륨 연산
		for(int i=1; i<=N; i++) {
			int diff = v[i];
			List<Integer> list = new ArrayList();
			for(int j=0; j<=M; j++) {
				if(i-1 == dp[j]) {
					int p = j + diff;
					int m = j - diff;
					if(p>=0 && p<=M) {
						list.add(p);
					}
					if(m>=0 && m<=M) {
						list.add(m);
					}
				}
			}
			for(int t : list) {
				dp[t] = i;
			}
		}
		// 큰 수 찾기
		for(int i=0; i<=M; i++) {
			if(dp[i] == N) {
				ans = Math.max(i, ans);
			}
		}
		// 출력
		bw.write(ans+"");
		bw.flush();
	}
}