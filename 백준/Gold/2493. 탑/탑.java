import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    1. 문제 유형이 헷갈렸다. 알고 보니 stack을 활용한 문제
        - 재귀를 활용해서 이전 탑의 정보를 찾아가는 것이라고 생각했으나 stack으로 접근해야함
        - stack이 비어있으면 0을 저장하고 stack에 추가
        - 스택이 비어있지 않고 현재 탑의 높이가 peek값보다 크면 pop
        - 스택이 비어있지 않고 현재 탑의 높이가 peek값보다 작으면 peek값의 인덱스를 반환하고 현재 값을 추가
    2. 첫쨰 줄엔 탑의 수를 나타내는 N
        - 둘째 줄엔 탑의 높이를 N개 주어짐
    3. 발사한 레이저 신호가 어느 타워에서 막혔는지 return
* */
class Top{ // 탑의 정보
    int height; // 높이 정보
    int index; // 위치 정보
    Top(int height, int index){
        this.height = height;
        this.index = index;
    }
}
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int cur = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) { // 초기 조건
                sb.append("0 ");
                stack.push(new Top(cur, i));
            }else{
                while(true){
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Top(cur, i));
                        break;
                    }
                    Top top = stack.peek();
                    if(cur >= top.height){ // 값이 크면 pop
                        stack.pop();
                    }else{ // 값이 작으면 peek의 index값을 답에 적고 본인을 push
                        sb.append(top.index).append(" ");
                        stack.push(new Top(cur, i));
                        break;
                    }
                }
            }
        }
        sb.deleteCharAt(sb.length()-1); // 마지막 공백 제외
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
}