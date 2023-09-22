/*
    1. 해시로 다시 풀기
    2. 완주한 사람들을 boolean으로 관리
    3. 없으면 false 반환하여 return
*/
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 완주자 관리 해시
        Map<String,Integer> map = new HashMap<>();
        // 완주한 사람들 체크
        for(int i=0; i<completion.length; i++){
            map.put(completion[i],  map.getOrDefault(completion[i], 0) + 1);
        }
        // 참가자 중에서 완주 못한 사람 찾기
        for(int i=0; i<participant.length; i++){
            if(map.getOrDefault(participant[i], 0) == 0){
                return participant[i];
            }else{
                map.put(participant[i], map.get(participant[i])-1);
            }
        }
        return answer;
    }
}