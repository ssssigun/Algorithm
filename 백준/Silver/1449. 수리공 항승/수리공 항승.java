/*
 * 1. 첫째 줄에 물이 새는 곳 N, 테이프의 기리 L
 * 2. 둘째 줄은 물이 새는 곳 위치
 * 3. 테이프가 필요한 갯수 return
 * 4. 정렬 후 순서대로 테이프 길이 안에 들어가면 스킵하고 안들어가면 테이프의 갯수 추가
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	List<Integer> list = new ArrayList();
    	int ans = 1;
    	int taping = 0;
    	// N과 L 입력 받기
    	int N = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	// 물 새는 곳 위치 입력 받기
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		list.add(Integer.parseInt(st.nextToken()));
    	}
    	// 오름 차순으로 정렬 (왼쪽부터 샌다)
    	Collections.sort(list);
    	// 초기값(맨 왼쪽 테이핑)
    	taping = list.get(0)+L-1;
    	// 테이핑 시작
    	for(int i=1; i<N; i++) {
    		// 테이핑 한 범위에 있으면 스킵
    		if(taping>=list.get(i)) {
    			continue;
			// 없으면 테이프 갯수 추가
    		}else if(taping<list.get(i)) {
    			ans++;
    			taping = list.get(i)+L-1;
    		}
    	}
    	bw.write(ans+"");
    	bw.flush();
    }
}