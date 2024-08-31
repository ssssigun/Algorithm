/*
    1. 스택 문제
        - n까지의 숫자 중에서 스택을 통해서 수열을 만들 수 있는지 확인
        - cnt를 기준으로 잡고 수열과 비교
        - cnt보다 수열의 원소가 크면 스택에 cnt ~ 수열[i]까지의 값 넣고 빼기
        - 작다면 위에 값이 같은지 확인하고 같다면 pop, 다르다면 만들기 불가능 No
    2. 첫쨰 줄 n
        - 둘쨰 줄부터 수열이 주어짐
    3. 수열을 만들기 위한 연산 과정 return
        - push +
        - pop -
        - 불가능한 경우 NO
* */

import java.io.*;
import java.util.Stack;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 연산 시작
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<N; i++){
            if(arr[i] > cnt){
                for(int j=cnt+1; j<=arr[i]; j++){
                    st.push(j);
                    sb.append("+\n");
                }
                st.pop();
                sb.append("-\n");
                cnt = arr[i];
            }else{
                if(st.peek() == arr[i]){
                    st.pop();
                    sb.append("-\n");
                }else{
                    bw.write("NO");
                    bw.flush();
                    return;
                }
            }
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
}