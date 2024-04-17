import java.io.*;
import java.util.*;

/*
    1. 문자열 처리 문제이다.
        - M보다 작은 단어 제외
        - 해시맵으로 갯수 세기
        - comparator로 정렬하기
    2. 첫째 줄엔 단어 개수 N, 외줄 단어의 길이 M
        둘쨰줄부터 N+1줄까지 단어가 주어짐
    3. 우선순위에 맞게 단어장 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 단어 입력 받기
        for(int i=0; i<N; i++){
            String temp = br.readLine();
            if(temp.length() >= M){ // 갯수 세기
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }
        List<String> word = new ArrayList<>(map.keySet()); // 단어장 불러오기
        // 우선 순위대로 정렬하기
        Collections.sort(word, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(Integer.compare(map.get(o1), map.get(o2)) != 0){ // 빈도수 정렬
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                if(o1.length() != o2.length()){ // 단어 길이대로 정렬
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2); // 사전순으로 정렬
            }
        });
        // 출력
        for(String w : word){
            bw.write(w+"\n");
        }
        bw.flush();
    }
}