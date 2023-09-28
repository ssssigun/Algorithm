/*
 * 1. 숫자 추출하기
 * 	- 연속된 숫자 주의
 * 2. arrayList에 추가
 * 3. 첫줄엔 테스트 케이스 개수 N
 * 4. 둘째 줄부터 테스트 케이스
 * 5. 숫자를 오름차순으로 출력
 * */
import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<BigInteger> digit = new ArrayList();
		StringBuilder sb = new StringBuilder();
		// N
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for(int j=0; j<temp.length(); j++) {
				// 숫자면 추가
				if(Character.isDigit(temp.charAt(j))) {
					sb.append(temp.charAt(j));
				// 숫자가 아니면 넘어가기
				}else {
					if(sb.length()>0) {
						digit.add(new BigInteger(sb.toString()));
						sb.setLength(0);
					}
				}
			}
			if(sb.length()>0) {
				digit.add(new BigInteger(sb.toString()));
				sb.setLength(0);
			}
		}
		// 비 내림차순 (오름차순)
		Collections.sort(digit);
		// 출력
		for(int i=0; i<digit.size(); i++) {
			bw.write(digit.get(i)+"\n");
		}
		bw.flush();
	}
}