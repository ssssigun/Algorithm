/*
 * 1. 정렬해서 출력하기
 * 2. 첫줄에 기억하고 있는 핸들의 개수 N, I, 둘째줄부터는 무작위 순서의 핸들이 주어진다
 * 3. 핸들 중 사전 순으로 I번째인 핸들을 출력하기
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int I = Integer.parseInt(st.nextToken());
    	String[] str = new String[N];
    	// 입력 받기
    	for(int i=0; i<N; i++) {
    		str[i] = br.readLine();
    	}
        // 정렬
    	Arrays.sort(str);
        // 출력
    	bw.write(str[I-1]);
    	bw.flush();
    }
}