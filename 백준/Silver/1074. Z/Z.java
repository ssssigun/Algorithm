import java.io.*;
import java.util.StringTokenizer;

/*
    1. 규칙 찾는 구현 문제인 줄 알았으나 재귀 + 분할 정복 알고리즘이였다
        - 4등분 하고 범위를 좁히는 식으로 진행
        - 쪼개진 범위의 첫값을 기준으로 값의 위치 찾기
        - ex) (4*4)*0 = 0, (4*4)*1 = 16, (4*4)*2 = 32, (4*4)*3 = 48
        - 점점 더 쪼개면서 값 찾기 (재귀 사용)
    2. 첫째 줄에 N, r, c
    3. r행 c열을 몇번째로 방문했는지 return
* */
class Main {
    static int r;
    static int c;
    static int cnt = 0;
    static boolean ch;
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2,N);
        partition(0,0, size);
        // 출력
        bw.write((cnt-1)+"");
        bw.flush();
    }
    public static void partition(int startX, int startY, int size){
        if(size <= 2){ // 종료 조건 (원하는 부분을 찾으면 종료조건 실행)
            findXY(startX, startY);
            return;
        }
        int half = size/2;
        boolean left = startX <= c && c < startX + half;
        boolean right = startX + half <= c && c < startX + size;
        boolean top = startY <= r && r < startY + half;
        boolean bottom = startY + half <= r && r < startY + size;

        if(left && top){ // 왼쪽 위
            partition(startX, startY, half);
        }else if(right && top){ // 오른쪽 위
            cnt += (half * half) * 1;
            partition(startX + half, startY, half);
        }else if(left && bottom){ // 왼쪽 아래
            cnt += (half * half) * 2;
            partition(startX, startY + half, half);
        }else if(right && bottom){ // 오른쪽 아래
            cnt += (half * half) * 3;
            partition(startX + half , startY + half, half);
        }
    }
    public static void findXY(int x, int y){
        // Z 모양으로 확인
        for(int i=y; i<y+2; i++){
            for(int j=x; j<x+2; j++){
                cnt++;
                if(i == r && j == c){ // 필요한 값을 찾으면 나가기
                    return;
                }
            }
        }
    }
}