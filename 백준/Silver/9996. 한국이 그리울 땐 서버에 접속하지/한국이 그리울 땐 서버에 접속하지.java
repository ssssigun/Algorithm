/*
 * 1. 문자열 처리
 * 2. 입력
 *   - 파일의 갯수 N
 *   - 패턴 
 *   - N개의 파일 이름
 * 3. 패턴이 일치하면  DA, 불일치 하면 NE return
 * */
import java.io.*;
public class Main {

 	public static void main(String[] args) throws IOException{
 		// 선언
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 		// 입력 받기
 		int N = Integer.parseInt(br.readLine());
 		String[] pattern = br.readLine().split("[*]");
 		// 확인하기
 		for(int i=0; i<N; i++) {
 			String temp = br.readLine();
 			if(pattern[0].length() + pattern[1].length() > temp.length()) {
 				bw.write("NE");
			// 패턴과 같으면 DA
 			}
 			else if(pattern[0].equals(temp.substring(0,pattern[0].length()))
				&& pattern[1].equals(temp.substring(temp.length() - pattern[1].length(), temp.length()))) {
 				bw.write("DA");
			// 다르면 NE
 			}else {
 				bw.write("NE");
 			}
 			bw.write("\n");
 		}
 		// 출력
 		bw.flush();
	}
}