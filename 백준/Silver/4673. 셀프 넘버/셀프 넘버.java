/*
 * 1. 10,000보다 작은 생성자가 없는 숫자를 구하기 
 * 2. 생성자 있는 숫자를 구해서 결과물을 출력할 때 빼주기
 * 3. 입력 값 없고 셀프 넘프를 return
 * */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList();
		// 셀프 넘버가 아닌 것들부터 찾기
		for(int i=1; i<10000; i++) {
			String temp = i+"";
			int total = i;
			// 각 자리수로 더해주기
			for(int j=0; j<temp.length(); j++) {
				total += temp.charAt(j) - '0';
			}
			list.add(total);
		}
		// 출력
		for(int i=1; i<=10000; i++) {
			// 셀프 넘버가 아닌 것들 넘어가기
			if(list.contains(i)) {
				continue;
			}
			bw.write(i+"\n");
		}
		bw.flush();
	}
}