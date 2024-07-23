/*
    1. 백트래킹 문제인 것 같다.
        - 최대 시간 8 * 8 * 8 ? 암튼 안넘는다.
        - user_id만큼의 방문 처리 배열 생성
        - banned_id과 문자열을 비교하고 일치하면 depth + 1하고 방문 처리, 그리고 문자열 저장
        - 백트래킹 함수를 통해 banned_id.length만큼 되었으면 return
        - 단 여기서 문자열을 분리해서 정렬하고 다시 연결해서 Set에 저장 (중복 처리)
    2. 이벤트 응모자 아이디 목록 user_id
        - 불량 사용자 아이디 목록 banned_id
    3. 제외 되어야 할 경우의 수 return
*/
import java.util.*;
class Solution {
    static int ans = 0;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        back(0, "", user_id, banned_id);
        return set.size();
    }
    public static void back(int depth, String res, String[] user_id, String[] banned_id){
        if(depth == banned_id.length){
            String[] temp = res.split(" ");
            Arrays.sort(temp);
            String temp2 = "";
            for(String s : temp){
                temp2 += s + " ";
            }
            set.add(temp2);
            return;
        }
        for(int i=0; i<user_id.length; i++){
            String str1 = banned_id[depth];
            String str2 = user_id[i];
            boolean flag = true;
            if(str1.length() != str2.length()){ // 길이가 안맞으면 나가기
                continue;
            }else if(visited[i]){
                continue;
            }
            for(int j=0; j<str1.length(); j++){
                char t1 = str1.charAt(j);
                char t2 = str2.charAt(j);
                if(t1 != '*' && t1 != t2){
                    flag = false;
                    break;
                }
            }
            if(flag){
                visited[i] = true;
                back(depth + 1, res + " " + user_id[i], user_id, banned_id);
                visited[i] = false;
            }
        }
    }
}