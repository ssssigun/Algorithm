/*
    1. 패턴이 정해져있음
        - 짝수는 0이 다 채워진 상태이므로 짝수는 다 0을 채워서 return
        - 홀수일때는 번갈아가면서 나와야함
            - 첫번째는 첫 상태 그대로
            - 두번째는 첫 상태가 터졌을때
    2. 첫째 줄에 배열의 크기 R, C, 시간 초 N
    3. N초 후 상태 return
* */

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R+2][C+2];
        for(int i=1; i<=R; i++){
            String temp =br.readLine();
            for(int j=1; j<=C; j++){
                char t = temp.charAt(j-1);
                if(t == '.'){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        if(N == 1){
            for(int i=1; i<=R; i++){
                for(int j=1; j<=C; j++){
                    if(arr[i][j] == 1){
                        sb.append(".");
                    }else{
                        sb.append("O");
                    }
                }
                sb.append("\n");
            }
        }else if(N % 2 == 0){ // 짝수일 때는 전부 다 0으로 나옴
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    sb.append("O");
                }
                sb.append("\n");
            }
        }else{
            Queue<int[]> que = new LinkedList<>();
            for(int i=1; i<=R; i++){
                for(int j=1; j<=C; j++){
                    if(arr[i][j] == 0){
                        que.offer(new int[]{i,j});
                    }
                }
            }
            for(int i=1; i<=R; i++){
                Arrays.fill(arr[i], 0);
            }
            while(!que.isEmpty()){
                int x = que.peek()[0];
                int y = que.peek()[1];
                que.poll();
                arr[x][y] = 1;
                arr[x-1][y] = 1;
                arr[x+1][y] = 1;
                arr[x][y-1] = 1;
                arr[x][y+1] = 1;
            }
            if((N/2) % 2 == 0){ // 한번 더 터진 상태로 나옴
                que = new LinkedList<>();
                for(int i=1; i<=R; i++){
                    for(int j=1; j<=C; j++){
                        if(arr[i][j] == 0){
                            que.offer(new int[]{i,j});
                        }
                    }
                }
                for(int i=1; i<=R; i++){
                    Arrays.fill(arr[i], 0);
                }
                while(!que.isEmpty()){
                    int x = que.peek()[0];
                    int y = que.peek()[1];
                    que.poll();
                    arr[x][y] = 1;
                    arr[x-1][y] = 1;
                    arr[x+1][y] = 1;
                    arr[x][y-1] = 1;
                    arr[x][y+1] = 1;
                }
                for(int i=1; i<=R; i++){
                    for(int j=1; j<=C; j++){
                        if(arr[i][j] == 1){
                            sb.append(".");
                        }else{
                            sb.append("O");
                        }
                    }
                    sb.append("\n");
                }
            }else{
                for(int i=1; i<=R; i++){
                    for(int j=1; j<=C; j++){
                        if(arr[i][j] == 1){
                            sb.append(".");
                        }else{
                            sb.append("O");
                        }
                    }
                    sb.append("\n");
                }
            }
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
}