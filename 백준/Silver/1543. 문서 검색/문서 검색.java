/*
 * 1. 주어진 문장에서 문장 찾기
 * 2. 찾으면 인덱스 이동
 * 3. 첫줄은 문서, 두번째 줄은 찾을 단어
 * 4. 몇번 등장하는지 return
 * */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i = 0;
		// 문서 입력 받기
		StringBuilder sb = new StringBuilder(br.readLine());
		// 카운트
		int cnt = 0;
		// 단어 입력 받기
		String word = br.readLine();
		// 단어를 포함하는지 확인
		while(true) {
			// 단어 추출
			String temp = sb.substring(i,sb.length());
			if(temp.contains(word)) {
				cnt++;
				i += temp.indexOf(word) + word.length();
				continue;
			}
			break;
		}
		// 출력
		bw.write(cnt+"");
		bw.flush();
	}

}
