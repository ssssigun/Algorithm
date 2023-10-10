/*
 * 1. 주어진 수들을 배열에 넣고 sort
 * 2. 첫줄에 수의 개수  N(홀수)
 * 3. 산술평균, 중앙값, 최빈값, 범위 출력
 * */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList();
		List<Integer> many = new ArrayList();
		Map<Integer, Integer> map = new HashMap();
		int[] ans = new int[4];
		int temp = 0;
		int max = 0;
		// 입력 받기 
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
			map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
		}
		// 정렬
		Collections.sort(list);
		// 산술 평균 구하기
		for(int i=0; i<N; i++) {
			temp += list.get(i);
		}
		ans[0] = (int)Math.round((double)temp/N);
		// 중앙값 구하기
		ans[1] = list.get(N/2);
		// 최빈값 구하기
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			int key = keys.next();
			if(map.get(key)>max) {
				max = map.get(key);
			}
		}
		keys = map.keySet().iterator();
		while(keys.hasNext()) {
			int key = keys.next();
			if(max == map.get(key)) {
				many.add(key);
			}
		}
		Collections.sort(many);
		ans[2] = many.size()>=2 ? many.get(1) : many.get(0);
		// 범위 구하기
		ans[3] = list.get(list.size()-1) - list.get(0);
		// 출력
		for(int i=0; i<ans.length; i++) {
			bw.write(ans[i]+"\n");
		}
		bw.flush();
	}
}