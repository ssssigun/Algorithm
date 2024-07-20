/*
    1. 단순 구현 문제
        - 팀이름, 인원수, 멤버를 해시맵에 저장 (str, str[])
        - 입력에 맞게 팀이름이나 멤버의 이름을 찾아서 return
    2. 첫째 줄엔 걸그룹 수 N, 문제 수 M
        - 이후 팀이름
        - 팀 인원수
        - 팀 멤버 순으로 입력 받는다.
        - 그다음 M개의 문제를 입력 받음
        - 멤버 or 팀이름
        - 0이면 멤버 이름, 1이면 팀이름을 맞추기
    3. 0이면 멤버의 이름을 사전순으로 return
        - 1이면 팀이름을 return
* */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String[]> map = new HashMap<>();
        for(int i=0; i<N; i++){ // 걸그룹 정보 저장
            String gName = br.readLine();
            int gNum = Integer.parseInt(br.readLine());
            String[] member = new String[gNum];
            for(int j=0; j<gNum; j++){
                member[j] = br.readLine();
            }
            Arrays.sort(member); // 사전순을 정렬
            map.put(gName, member);
        }
        // 퀴즈 시작
        for(int i=0; i<M; i++) {
            String quiz = br.readLine();
            int flag = Integer.parseInt(br.readLine());
            if(flag == 1){ // 사람이름이 나오면 팀이름 출력
                for(String str : map.keySet()){
                    String[] temp = map.get(str);
                    for(int j=0; j<temp.length; j++){
                        if(temp[j].equals(quiz)){
                            bw.write(str+"\n");
                            break;
                        }
                    }
                }
            }else{ // 퀴즈로 팀이름이 나오면 멤버 이름 출력
                String[] temp = map.get(quiz);
                for(String str : temp){
                    bw.write(str+"\n");
                }
            }
        }
        // 출력
        bw.flush();
    }
}