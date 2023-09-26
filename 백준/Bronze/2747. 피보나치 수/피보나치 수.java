/*
 * 1. 피보나치 수는 대표적인 다이나믹 프로그래밍 문제
 * 2. 배열로 만들어서 구해보자
 * */
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// 구해야 할 피보나치 수 위치
    	int n = Integer.parseInt(br.readLine());
    	// 피보나치 수 배열
    	int[] p = new int[n+2];
    	p[1] = 1;
    	// 피보나치 수 구하기
    	for(int i=2; i<p.length; i++) {
    		p[i] = p[i-1] + p[i-2];
    	}
    	// 출력
    	bw.write(p[n]+"");
    	bw.flush();
    }
}