/*
    1. 미로 생성하기
        - 미리 배열을 생성해서 가운데에서 시작
        - 이동한 위치를 .으로 바꾼다.
        - 범위를 저장해서 출력하기
    2. 첫째줄에 이동 명령어의 수 N
        - 둘째줄에 명령어
    3. 미로 지도 return .은 이동 가능 칸, #은 벽
* */

import java.io.*;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] map = new String[101][101];
        // 초기값
        int x = 50;
        int y = 50;
        // 범위 저장 함수
        int maxX = x;
        int maxY = y;
        int minX = x;
        int minY = y;
        map[x][y] = ".";
        int[] dx = {1, 0, -1, 0}; // 방향 벡터
        int[] dy = {0, -1, 0, 1};
        int idx = 0;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i=0; i<N; i++){
            char t = str.charAt(i);
            if(t == 'R'){ // 오른쪽으로 돌기 (시계 방향)
                idx = idx == 3 ? 0 : idx + 1;
            }else if(t == 'L'){ // 왼쪽으로 돌기 (반시계 방향)
                idx = idx == 0 ? 3 : idx - 1;
            }else if(t == 'F'){
                x += dx[idx];
                y += dy[idx];
                map[x][y] = ".";
                // 범위 갱신
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }
        }
        // 출력하기
        for(int i=minX; i<=maxX; i++){
            for(int j=minY; j<=maxY; j++){
                if(map[i][j] == null){
                    bw.write("#");
                }else{
                    bw.write(map[i][j]);
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}