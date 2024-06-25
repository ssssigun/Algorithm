/*
    1. 출석 체크
        - 시간을 네자리 수로 치환해도 될 것 같다.
            ex) 02:20 -> 0220
        - 시작시간 이전의 사람들을 해시맵에 담기
        - 그 이후 종료 시간과 스트리밍 종료 사이에 시간의 사람들이 해시맵에 포함 되어 있으면 카운트
    2. 첫째 줄에 시작 시간 S, 끝난 시간 E, 스트리밍 종료 Q
        - 둘째 줄부터 채팅 로그
    3. 출석 확인 인원 return
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
        Map<String, Boolean> map = new HashMap<>();
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = changeT(st.nextToken());
        int E = changeT(st.nextToken());
        int Q = changeT(st.nextToken());
        int ans = 0;
        while(br.ready()){ // 채팅 로그 확인하기
            st = new StringTokenizer(br.readLine());
            int time = changeT(st.nextToken());
            String name = st.nextToken();
            if(time <= S){ // 시작 시간 전에 채팅 기록이 있을 때 확인하고 리스트 추가
                map.put(name, false);
            }else if(E<=time && time<=Q ){ // 종료 시간과 스트리밍 종료 사이에 로그가 있을 때
                if(map.containsKey(name)){ // 시작 시간에도 있었나 확인하고 카운트
                    if(!map.get(name)){
                        map.put(name, true);
                        ans++;
                    }
                }
            }else if(Q < time){ // 스트리밍 시간 넘어가면 종료
                break;
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    public static int changeT(String s){ // 시간을 정수로 변환
        String[] t = s.split(":");
        int sum = Integer.parseInt(t[0]+t[1]);
        return sum;
    }
}