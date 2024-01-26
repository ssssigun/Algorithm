/*
    1. 1~n 순서대로 상자가 주어진다.
        - 기사님이 원하는 순서대로 짐을 실어야함 (order)
        - 보조 컨테이너 활용이 가능(Stack 구조)
    2. 입력은 기사님이 원하는 상자 순서 order
    3. 몇개를 실을 수 있는지 return
        - 조건에 부합하지 않으면 멈춤
*/
import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] order) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0; // 적재한 상자 수
        int cnt = 0; // 현재 위치
        Stack<Integer> stack = new Stack();
        Queue<Integer> que = new LinkedList();
        // 상자 입력
        for(int i=1; i<=order.length; i++){
            que.offer(i);
        }
        // 컨테이너 벨트 시작
        for(int i : order){
            while(true){
                if(cnt > i){
                    if(stack.peek() == i){
                        stack.pop();
                        answer++;
                        break;
                    }else{
                        return answer;
                    }
                }else if(!que.isEmpty()){
                    if(que.peek() == i){
                        answer++;
                        cnt = que.poll();
                        break;
                    }else{
                        stack.push(que.poll());
                    }
                }
            }
        }
        bw.write(answer+"");
        bw.flush();
        return answer;
    }
}