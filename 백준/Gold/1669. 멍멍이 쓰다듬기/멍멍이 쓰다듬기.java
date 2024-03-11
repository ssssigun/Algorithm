import java.io.*;
import java.util.StringTokenizer;

/*
    1. 수학 계산이 필요한 문제인 듯 하다.
        - 입력 값이 상당히 크다 Y < 2^31
        - 일단 두 수의 차이로 접근해보자
        - 양 끝(시작점, 종료점)은 반드시 1이여야한다.
    2. 첫째 줄에 원숭이의 키 X, 멍멍이의 크기 Y
    3. X == Y 되는 최소일 수 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int diff = Y - X;
        int ans = 0;
        int cnt = 1;
        while(diff > 0){
            if(diff - (cnt*2) >= 0) { // 양끝에서 하나씩 지우기
                diff -= cnt * 2;
                ans += 2;
                cnt++;
            }else if(diff <= cnt){ // 만약 남은 값이 지나간값이나 이후값+1 사이 값이면 카운트하고 종료
                ans++;
                diff -=  cnt;
                break;
            }else{ // cnt < diff < cnt*2인 상황일 때 값 빼주기
                diff -= cnt;
                cnt++;
                ans++;
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}