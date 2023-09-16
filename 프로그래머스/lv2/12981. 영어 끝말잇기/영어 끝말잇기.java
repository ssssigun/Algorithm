/*
    1. n은 끝말잇기 참여자의 수, word는 끝말잇기 진행 단어
    2. 중복되는 단어나 끝말 잇기가 안되면 탈락
    3. 탈락한 사람의 순번과 몇번째에서 탈락했는지 return
        - 문제 없이 잘 완료 됬으면 0,0 return
*/
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        // 순번 돌리기
        int cnt = 1;
        // 전체 순환(turn) 확인
        int turn = 1;
        // 중복확인 체크용 배열
        Stack<String> st = new Stack();
        // 초기값 생성
        st.push(words[0]);
        // 끝말 잇기 진행
        for(int i=1; i<words.length; i++){
            // 순서 카운팅
            cnt++;
            // 중복 확인
            if(st.contains(words[i])){
                return new int[]{cnt, turn};
            }
            
            // 끝말잇기가 됬는지 확인
            String temp = st.peek();
            
            if(temp.charAt(temp.length()-1) != words[i].charAt(0)){
                return new int[]{cnt, turn};
            }
            // 다 진행 했으면 처음부터
            if(cnt == n){
                cnt = 0;
                turn++;
            }
            // 순서 지나면 stack에 저장
            st.push(words[i]);
        }
        // 문제 없이 잘 진행 됬으면 0,0 return
        return answer;
    }
}