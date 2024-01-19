/*
 * 1. bfs로 풀어보기
 * 2. 첫줄에 A와 B
 * 3. A를 B로 바꾸는데 필요한 연산의 최솟값+1 return
 * 	- 만들 수 없는 경우 -1
 * */
import java.io.*;
import java.util.*;
public class Main{
	// A, B
	public static long A;
	public static long B;
	public static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	// bfs
    	bfs(A);
    	// 출력
    	bw.write((map.containsKey(B) ? map.get(B) : -1) + "");
    	bw.flush();
    }
    // bfs
    public static void bfs(long start) {
    	Queue<Long> que = new LinkedList();
    	que.offer(start);
    	map.put(start, 1);
    	while(!que.isEmpty()) {
    		long x = que.poll();
    		long mul = x * 2;
    		long add = (x*10) + 1;
    		if(mul>=0 && mul<=B && !map.containsKey(mul)) { 
    			que.offer(mul);
    			map.put(mul, map.get(x) + 1);
    		}
    		if(add>=0 && add <=B && !map.containsKey(add)) {
    			que.offer(add);
    			map.put(add, map.get(x) + 1);
    		}
    	}
    }
}