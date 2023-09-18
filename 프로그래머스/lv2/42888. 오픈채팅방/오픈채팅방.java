/*
    1. 일단 유저 uk를 해시 형태로 저장
    2. 이후 String에 저장 후 return
*/
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        // 채팅방 액션 저장 배열
        String[] option = new String[]{"Enter", "Leave", "Change"};
        // 아이디 및 로그 저장
        List<String[]> list = new ArrayList();
        // 닉네임 저장
        Map<String, String> map = new HashMap<>();
        // 행동에 따른 아이디와 로그 저장
        for(int i=0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            // 들어온 경우
            if(option[0].equals(temp[0])){
                map.put(temp[1], temp[2]);
                list.add(new String[]{temp[1], "님이 들어왔습니다."});
            // 나간 경우
            }else if(option[1].equals(temp[0])){
                list.add(new String[]{temp[1], "님이 나갔습니다."});
            // 닉네임 변경한 경우
            }else if(option[2].equals(temp[0])){
                map.put(temp[1], temp[2]);
            }
        }
        // 로그 출력
        answer = new String[list.size()];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<answer.length; i++){
            // 닉네임 가져오기
            sb.append(map.get(list.get(i)[0]));
            sb.append(list.get(i)[1]);
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
}