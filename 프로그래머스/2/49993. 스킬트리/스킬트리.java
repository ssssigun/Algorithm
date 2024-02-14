/*
    1. 선행 스킬이 필요한 스킬들은 list에 넣고 확인하기
    2. 입력은 선행 스킬 순서 skill 배열, 유저의 스킬트리 skill_trees
    3. 가능한 스킬트리의 개수 return
*/
import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        List<String> list;
        int answer = 0;
        // 선행 스킬 검사
        for(String s : skill_trees){
            list = new ArrayList<>();
            boolean ch = false;
            for(int i=0; i<s.length(); i++){
                char temp = s.charAt(i); // 현재 스킬
                if(skill.contains(temp+"")){
                    int idx = skill.indexOf(temp+""); // 스킬의 우선순위
                    if(idx == 0){
                        list.add(temp+"");
                    }else if(idx > 0){ // 선행 스킬일 때 확인하기
                        if(list.contains(skill.charAt(idx-1)+"")){
                            list.add(temp+"");
                        }else{
                            ch = true;
                        }
                    }
                }
            }
            if(ch){ // 선행 스킬이 안 찍혀있으면 중단하기
                continue;
            }
            answer++;
        }
        return answer;
    }
}