/*
 * 1. 마니또 체인 구하기
 * 2. 첫줄엔 테스트 케이스 갯수 N, 테스트 케이스는 여러개 나올 수 있음
 * 3. 테스트 케이스 마다 체인의 개수를 return
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	// 정답 담을 배열
    	List<Integer> list = new ArrayList();
    	// 마니또 해시
    	Map<String,String> map = new HashMap<>();
    	// N이 0일 때까지 반복
    	while(true) {
    		// 사람 수 N 입력
    		int N = Integer.parseInt(br.readLine());
    		// 체인 개수 저장
    		int cnt = 0;
    		// 0이면 종료
    		if(N == 0) break;
    		// 사람과 마니또 입력 받기
    		for(int i=0; i<N; i++) {
    			st = new StringTokenizer(br.readLine());
    			String peo = st.nextToken();
    			String mani = st.nextToken();
    			map.put(peo, mani);
    		}
    		// 체인 개수 세기
			for(String key : map.keySet()) {
				int tCnt = 0;
				while(true) {
					String temp = map.get(key);
					// 방문한 키면  나가기
					if("".equals(temp)) {
						break;
					// 방문한 적 없는 키면 체인 찾기
					}else {
						map.put(key, "");
						key = temp;
						tCnt++;
					}
				}
				// 체인을 찾은 경우 cnt+1
				if(tCnt>0) {
					cnt++;
				}
			}
			// 체인 수 추가
			list.add(cnt);
    	}
    	// 출력
    	for(int i=0; i<list.size(); i++) {
    		bw.write((i+1) + " " + list.get(i)+"\n");
    		bw.flush();
    	}
    }
}