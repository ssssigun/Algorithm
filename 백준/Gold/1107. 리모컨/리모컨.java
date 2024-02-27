import java.io.*;
import java.util.StringTokenizer;

/*
    1. 구현 문제인듯하다
        - 리모콘으로 채널이동하기
            - but, 버튼이 고장나있음
            - 현재 채널은 100
            - 0~9 버튼 +, - 버튼으로 이루어짐
        - 단순 구현인줄 알았으니 브루트포스 문제
        - 아직 문제의 요점을 찾는 것이 부족한 것 같다...
    2. 첫째 줄에 이동하려는 채널 N
        - 둘째 줄엔 고장난 버튼의 갯수
        - 셋째 줄엔 고장난 버튼 목록
    3. N으로 이동하기 위 버튼을 눌러야하는 최소 횟수 returns
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if(M !=0){ // 고장난 버튼이 0이 아니면 진행하기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int t = Integer.parseInt(st.nextToken());
                broken[t] = true;
            }
        }
        // 버튼의 최솟값 찾기
        int ans = Math.abs(N-100); // 초기값 (100에서 원하는 채널까지 +,- 버튼으로 조작했을 경우)
        for(int i=0; i<999999; i++){
            boolean yes = false;
            if(N == 100){ // 원하는 채널이 현재 위치면 탈출
                ans = 0;
                break;
            }
            String temp = i+"";
            int min = 0;
            for(int j=0; j<temp.length(); j++){
                if(broken[temp.charAt(j)-'0']) { // 고장난 버튼이 들어가있으면 넘어가기
                    yes = true;
                    break;
                }
            }
            if(!yes){ // 고장난 버튼이 없을때만 계산하기
                min = Math.abs(N - i) + temp.length(); // 버튼 누르는 수 계산 (원하는 채널과 현재 누른 채널의 차이 값 + 숫자버튼 누른 수)
                if(min < ans){ // 구한 값이 최솟값이면 교체
                    ans = min;
                }
            }
        }
        //출력
        bw.write(ans+"");
        bw.flush();
    }
}