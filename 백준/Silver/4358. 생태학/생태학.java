/*
 * 1. 나무가 주어지면 분포 퍼센트를 사전순으로 출력하기
 * 2. 한줄에 하나의 나무 종 이름(30자 이내)
 * 3. 사전순으로 퍼센트 출력 소수점 4째 자리까지 반올림
 * */
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
    	// 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        int size = 0;
        // 입력 받기
        while(true){
            String word = br.readLine();

            if(word == null || word.equals("")) break;

            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
            size++;
        }
        
        Object[] str = map.keySet().toArray();
        Arrays.sort(str); // 정렬
        // 반올림 및 숫자 포매팅
        for(Object obj:str){
            String key = (String) obj;
            String value = String.format("%.4f", (map.get(key) * 100.0f/ size));

            sb.append(key).append(' ').append(value).append('\n');
        }
        System.out.print(sb); // 출력
    }
}