/*
 * 1. 첫째 줄에 들도 못한 사람 수 N, 보도 못한 사람 수 M
 * 2. 둘쨰 줄 부터 N개의 줄까지 듣도 못한 사람의 이름
 * 3. N+2부터 보도 못한 사람의 이름 순서 대로 입력
 * 4. 듣보잡 수와 
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
		// 듣보잡 수 저장
    	int cnt = 0;
    	// 듣보잡 리스트
    	List<String> list = new ArrayList();
    	// 듣도 못한 사람 저장
    	Map<String, Boolean> map = new HashMap<>();
    	// 첫줄 N,M 입력
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 듣도 못한 사람
    	for(int i=0; i<N; i++) {
    		map.put(br.readLine(), true);
    	}
    	// 보도 못한 사람
    	for(int i=0; i<M; i++) {
    		String temp = br.readLine();
    		if(map.getOrDefault(temp,false)) {
    			cnt++;
    			list.add(temp);
    		}
    	}
    	// 사전순으로 정렬
    	Collections.sort(list);
    	// 출력
    	bw.write(cnt+"\n");
    	for(String i:list) {
    		bw.write(i+"\n");
    	}
    	bw.flush();
    }
}