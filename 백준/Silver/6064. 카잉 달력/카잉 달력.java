import java.io.*;
import java.util.StringTokenizer;

/*
    1. 완전 탐색으로 풀었으나 시간 초과 발생
        - x값을 고정시키고 y 값을 변경하여 맞는 조건을 찾아야함
        - 최소 공배수 값을 넘으면 오답처리
        - 카운트는 한 사이클 지날때마다 M 더하기
    2. 첫 번째줄엔 테스트 케이스 T
        -  두번째줄부터는 M, N, x, y 순서대로 주어짐
    3. x,y의 해가 몇번째 해인지 return
        - 단 구할 수 없을 때 -1 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cnt = x % (M+1);
            int tempY = x;

            for(int j=0; j< N; j++){ // y값 찾기
                int ty = tempY % N == 0 ? N : tempY % N;
                if(ty == y){
                    break;
                }

                tempY = ty + M;
                cnt += M;
            }
            bw.write((cnt > lcm(M,N) ? "-1" : cnt )+"\n" ); // 최소 공배수를 넘으면 오답
        }
        // 출력
        bw.flush();
    }
    public static int gcd(int a, int b){ // 최대 공약수 구하기
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static int lcm(int a, int b){ // 최소 공배수 구하기
        return a*b/ gcd(a,b);
    }
}