/*
 * */
import java.io.*;
import java.util.*;
public class Main {
 	public static void main(String[] args) throws IOException{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 		StringBuilder sb = new StringBuilder();
 		String temp = br.readLine();
 		char[] t = temp.toCharArray();
 		Arrays.sort(t); // 정렬
 		for(int i=0; i<t.length; i++) {
 			sb.append(t[i]);
 		}
 		// 출력
 		bw.write(sb.reverse().toString());
 		bw.flush();
 	}
 	
}