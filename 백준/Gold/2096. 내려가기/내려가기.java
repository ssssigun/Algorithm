import java.io.*;
import java.util.StringTokenizer;

/*
    1. dp문제였다...
        - 바보같이 해맸다..
        - 제한 메모리가 적으므로 저장하지 않고 입력 받으면서 진행
        - 그리고 최대, 최소 dp배열을 1차원으로 잡고 진행
    2. 첫째 줄에 행의 갯수 N
        - 다음 N개의 줄에는 숫자들이 주어짐 (0 ~ 9)
    3. 최대 점수와 최소 점수를 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            if(i == 0){ // 초기갑 입력
                dpMax[0] = one;
                dpMin[0] = one;
                dpMax[1] = two;
                dpMin[1] = two;
                dpMax[2] = three;
                dpMin[2] = three;
            }else{
                // 최댓값 구하기
                int tempOne = dpMax[0];
                int tempThree = dpMax[2];
                dpMax[0] = Math.max(dpMax[0], dpMax[1]) + one;
                dpMax[2] = Math.max(dpMax[1], dpMax[2]) + three;
                dpMax[1] = Math.max(tempOne, Math.max(dpMax[1], tempThree)) + two;

                // 최솟값 구하기
                tempOne = dpMin[0];
                tempThree = dpMin[2];
                dpMin[0] = Math.min(dpMin[0], dpMin[1]) + one;
                dpMin[2] = Math.min(dpMin[1], dpMin[2]) + three;
                dpMin[1] = Math.min(tempOne, Math.min(dpMin[1], tempThree)) + two;
            }
        }
        // 출력
        bw.write(Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]))+" ");
        bw.write(Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]))+"");
        bw.flush();
    }
}