import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    1. ArrayList로 풀었으나 시간 초과
        - map을 사용해야할 것 같다
        - 두 개를 이용해서 쉽게 찾자
        - 하나는 도감 번호가 key, 다른 하나는 이름이 key
        - 문제의 입력값만 도감 번호인지 이름인지 확인 잘 하기
    2. 첫째 줄엔 도감의 포켓몬 갯수 N, 맞춰야 하는 문제의 수 M
        - 이후 도감의 포켓몬 N, 뒤에 맞춰야하는 문제 M개
    3. 문제에 대한 답 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> mapNum = new HashMap<>();
        Map<String, Integer> mapName = new HashMap<>();
        for(int i=1; i<=N; i++){
            String temp = br.readLine();
            mapName.put(temp, i); // key가 이름인 map
            mapNum.put(i, temp); // key가 도감 번호인 map
        }
        // 문제에 답하기
        for(int i=0; i<M; i++){
            String temp = br.readLine();
            int num = 0;
            if(Character.isDigit(temp.charAt(0))){ // 숫자인지 확인
               num = Integer.parseInt(temp);
            }
            if(num == 0){ // 찾는 값이 문자열일 때
                bw.write(mapName.get(temp)+"\n");
            }else{
                bw.write(mapNum.get(num)+"\n");
            }
        }
        // 출력
        bw.flush();
    }
}