/*
 * 1. 나무가 주어지면 분포 퍼센트를 사전순으로 출력하기
 * 2. 한줄에 하나의 나무 종 이름(30자 이내)
 * 3. 사전순으로 퍼센트 출력 소수점 4째 자리까지 반올림
 * */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	HashMap<String,Integer> map = new HashMap<>();
    	StringBuilder sb = new StringBuilder();
    	int cnt = 0;
    	// 입력 받기
    	while(true) {
    	    String temp = br.readLine();
    	    if( temp == null || temp.equals("")) {
    	    	break;
    	    }
      		map.put(temp, map.getOrDefault(temp, 0)+1);
    		cnt++;
    	}
    	Object[] str = map.keySet().toArray();
    	Arrays.sort(str); // 사전 순 정렬
    	// 분포수 계산
    	for( Object obj :str) {
    		String key = (String)obj;
            String value = String.format("%.4f", (map.get(key) * 100.0f/ cnt));
            sb.append(key).append(' ').append(value).append('\n');
    	}
    		
    	//출력
		bw.write(sb.toString());
    	bw.flush();
    }
}