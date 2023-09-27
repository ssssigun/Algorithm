/*
 * 1. 년도 -> 월 -> 일 순으로 비교하기
 * 2. tokenizer 대신 split 사용
 * 3. 첫줄에 학생수 n
 * 4. 둘째줄부터 학생의 생년월일
 * 5. 첫줄에 나이 적은 사람 둘째 줄에 나이 많은 사람 return
 * */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 배열 저장
		String[] max = new String[4];
		String[] min = new String[4];
		// 학생의 수 n
		int n = Integer.parseInt(br.readLine());
		// 입력 받으면서 비교
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			// 인덱스 0번을 초기값으로 넣기
			if(i==0) {
				max = temp.clone();
				min = temp.clone();
			}
			// 나이 많은 사람 찾기
			// 년도
			if(Integer.parseInt(max[3]) > Integer.parseInt(temp[3])) {
				max = temp.clone();
				continue;
			}else if(max[3].equals(temp[3])) {
				// 월
				if(Integer.parseInt(max[2]) > Integer.parseInt(temp[2])) {
					max = temp.clone();
					continue;
				}else if(max[2].equals(temp[2])) {
					// 일
					if(Integer.parseInt(max[1]) > Integer.parseInt(temp[1])) {
						max = temp.clone();
						continue;
					}
				}
			}
			// 나이 적은 사람 찾기
			// 년도
			if(Integer.parseInt(min[3]) < Integer.parseInt(temp[3])) {
				min = temp.clone();
				continue;
			}else if(min[3].equals(temp[3])) {
				// 월
				if(Integer.parseInt(min[2]) > Integer.parseInt(temp[2])) {
					min = temp.clone();
					continue;
				}else if(min[2].equals(temp[2])) {
					// 일
					if(Integer.parseInt(min[1]) > Integer.parseInt(temp[1])) {
						min = temp.clone();
						continue;
					}
				}
			}
		}
		// 출력
		bw.write(min[0]+"\n"+max[0]);
		bw.flush();
	}
}
	