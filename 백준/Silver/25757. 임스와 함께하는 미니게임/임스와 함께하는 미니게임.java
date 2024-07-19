/*
    1. 해시맵 사용
        - 게임의 종류를 보고 인원수 제한 확인
        - 중복 체크를 하면서 카운트
            - 만약 참여한 적이 없으면 중복 체크하고 카운트
            - 참여한 적이 있으면 지나가기
        - 인원수 제한이 찼으면 게임 판수를 카운트
    2. 첫째 줄에 게임 신청 횟수 N, 게임의 종류
        - 둘째 줄부터 N개만큼 게임을 신청한 사람의 이름이 주어짐
    3. 임스가 게임을 할 수 있는 횟수를 return
* */

import java.io.*;
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
        char game = st.nextToken().charAt(0);

        int limit = 0; // 인원 제한
        Map<String,Boolean> map = new HashMap<>(); // 참여한 인원 중복 확인

        if(game == 'Y'){ // 방 인원수 제한 확인
            limit = 2;
        }else if (game == 'F') {
            limit = 3;
        }else if(game == 'O'){
            limit = 4;
        }

        int cnt = 1; // 방의 인원 확인
        int ans = 0; // 게임 시작 횟수

        for(int i=0; i<N; i++){ // 입장 기록 확인
            String name = br.readLine();
            if(!map.containsKey(name)){
                map.put(name, true);
                cnt++;
            }
            if(cnt == limit){ // 방에 인원이 다 찼으면 게임 시작하기
                ans++;
                cnt = 1;
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}