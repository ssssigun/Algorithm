/*
    1. 완주하지 못한 사람 한명 찾기
    2. 일단 이중 for문으로 접근해보자
*/
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")){
            answer = participant[participant.length-1];
        }
        return answer;
    }
}