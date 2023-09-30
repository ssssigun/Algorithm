/*
 * 1. 해시로 책당 개수 저장
 * 2. 최대값을 저장하고 최대값 return
 * 	- 여러개인 경우 사전순으로 빠른거 출력
 * 3. 첫줄은 책의 개수  N
 * */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 0;
		List<String> maxB = new ArrayList();
		// 책을 담을 해시맵
		Map<String, Integer> map = new HashMap();
		// 책 개수
		int N = Integer.parseInt(br.readLine());
		// 책 입력 받기
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			map.put(temp, map.getOrDefault(temp, 0)+1);
			// 최대값 저장
			if(max<map.get(temp)) {
				max = map.get(temp);
			}
		}
		// 최대값 찾기
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			if(max == map.get(key)) {
				maxB.add(key);
			}
		}
		// 사전순으로 정렬 후 출력
		Collections.sort(maxB);
		bw.write(maxB.get(0));
		bw.flush();
	}
}