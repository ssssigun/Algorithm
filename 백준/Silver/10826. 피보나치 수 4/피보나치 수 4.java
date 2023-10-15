/*
 * 1. DP의 대표적인 예시
 * 	- 바텀업으로 풀 예정 (반복문 이용)
 * 	- 탑다운으로는 시간 초과 났음
 *  - 숫자 단위가 말도 안되게 높아서 overflow
 *  -  숫자 연산을 string으로 해줘야함
 * 2. 첫쨰 줄은 n
 * 3. n번째 피보나치 수 return
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 피보나치 함수
	public static String[] pibo;
	// 숫자 계산 함수
	public static String add(String a, String b) {
		StringBuilder sb =  new StringBuilder();
		// 연산 횟수 (가장 작은 길이 기준)
		int n = Math.min(a.length(), b.length());
		// 올라가는 수
		int d = 0; 
		// 뒤에서부터 더하기
		for(int i=0; i<n; i++) {
			int tempA = a.charAt(a.length()-1-i) - '0';
			int tempB = b.charAt(b.length()-1-i) - '0';
			String sum = Integer.toString(tempA + tempB + d);
			// 올라가는 수가 있으면 올려주기
			if(sum.length()>=2) {
				d = sum.charAt(0) - '0';
				sb.append(sum.charAt(1)+"");
			// 없으면 더하기
			}else {
				d = 0;
				sb.append(sum.charAt(0)+"");
			}
		}
		// 나머지 자리 더하기
		if(a.length() > b.length()) {
			int diff = a.length() - b.length();
			for(int i=0; i<diff; i++) {
				if(i == 0) {
					String sum = Integer.toString( (a.charAt(diff-1-i)-'0') + d);
					// 올라가는 수가 있으면 올려주기
					if(sum.length()>=2) {
						d = sum.charAt(0) - '0';
						sb.append(sum.charAt(1)+"");
					// 없으면 더하기
					}else {
						d = 0;
						sb.append(sum.charAt(0)+"");
					}
				}else {
					sb.append(a.charAt(diff-1-i)+"");
				}
			}
		}else if(a.length() == b.length()) {
			if(d>=1) {
				sb.append(Integer.toString(d));
			}
		}else {
			int diff = b.length() - a.length();
			for(int i=0; i<diff; i++) {
				if(i == 0) {
					String sum = Integer.toString( (b.charAt(diff-1-i)-'0') + d);
					// 올라가는 수가 있으면 올려주기
					if(sum.length()>=2) {
						d = sum.charAt(0) - '0';
						sb.append(sum.charAt(1)+"");
					// 없으면 더하기
					}else {
						d = 0;
						sb.append(sum.charAt(0)+"");
					}
				}else {
					sb.append(b.charAt(diff-1-i)+"");
				}
			}
		}
		
		// 마지막에 뒤집어서 반환
		return sb.reverse().toString();
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int n = Integer.parseInt(br.readLine());
    	// 피보나치 배열
    	pibo = new String[n+2];
    	if(n==0) {
        	bw.write("0");
        	bw.flush();
        	return;
    	}
    	// 초기값
    	pibo[0] = "0";
    	pibo[1] = "1";
    	pibo[2] = "1";
    	for(int i=3; i<=n; i++) {
    		pibo[i] = add(pibo[i-1],pibo[i-2]);
    	}
    	bw.write(pibo[n]);
    	bw.flush();
    }
}