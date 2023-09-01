import java.io.*;
import java.util.*;
public class Main{
	//방문 처리 배열
	public static boolean[] b;
	//그래프 만들기
	public static ArrayList<ArrayList<Integer>> list = new ArrayList();
	//dfs 메서드
	public static void dfs(int num) {
		b[num] = true;
		for(int i=0; i<list.get(num).size(); i++) {
			int y = list.get(num).get(i);
			if(!b[y]) {dfs(y);}
		}
	}
	
    public static void main(String[] args) throws IOException{
		int answer = 0;
    	// 입력
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//초기값 입력 받기 (정점, 간선 갯수)
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int vertex = Integer.parseInt(st.nextToken());
    	int edge = Integer.parseInt(st.nextToken());
    	// 방문 처리 배열
    	b = new boolean[vertex+1];

    	//정점 갯수만큼 list 생성
    	for(int i=0; i<=vertex; i++) {
    		ArrayList alist = new ArrayList();
    		list.add(alist);
    	}
    	boolean[] ch = new boolean[vertex];
    	// 그래프 형태 만들어주기 (간선 입력 받기)
    	for(int i=0; i<edge; i++) {
    		st = new StringTokenizer(br.readLine());
    		int fir = Integer.parseInt(st.nextToken());
    		int sec = Integer.parseInt(st.nextToken());
    		ArrayList<Integer> tempList1 = list.get(fir);
    		ArrayList<Integer> tempList2 = list.get(sec);
    		tempList1.add(sec);
    		tempList2.add(fir);    		
    	}
        // dfs 실행
    	dfs(1);
    	answer++;
        // 전부 방문할 때까지 처리
    	for(int i=1; i<b.length; i++) {
    		if(!b[i]) {
    			dfs(i);
    			answer++;
    			i=0;
    		}
    	}
        // 출력
    	System.out.println(answer);
    }
}