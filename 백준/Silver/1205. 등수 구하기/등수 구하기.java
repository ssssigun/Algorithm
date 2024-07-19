/*
    1. 단순 구현 문제
        - 배열에 저장
        - 하나씩 돌면서 등수 계산
        - 같은 점수이면 등수는 변화가 없고 카운트를 진행
        - 만약 태수의 점수보다 낮으면 기존 등수 자리를 태수가 가짐
        - but, P를 넘어가면 안됨
    2. 첫째 줄에 점수 개수 N, 태수의 점수 , 랭킹판 등수 P
        - 둘째 줄에 점수 리스트
    3. 태수의 등수 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        if(N == 0 && P>=1){
            bw.write("1");
            bw.flush();
            return;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N == P && score <= arr[N]){ // 태수의 점수가 뒤로 밀리는 경우 제외
            bw.write("-1");
            bw.flush();
            return;
        }else{
            int rank = 1;
            for(int i=1; i<=N; i++){
                if(arr[i] > score){ // 태수의 점수가 낮으면 랭크업
                    rank++;
                }else{ // 그게 아니면 점수 반환
                    break;
                }
            }
            bw.write(rank+"");
            bw.flush();
        }
    }
}