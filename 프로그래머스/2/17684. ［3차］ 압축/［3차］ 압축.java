/*
    1. 투포인터 문제인 것 같다.
        - 사전을 영 대문자로 초기화
        - 입력 문자열을 돌면서 한문자씩 문자 확인
        - 현재 문자가 존재하면 다음 문자와 합쳐서 확인 (subString)
        - 존재하지 않는 문자까지 왔다면 사전에 추가 
        - 현재 문자열의 사전 인덱스를 리스트에 추가
    2. 1000자 이하의 문자열
    3. 사전의 반환되는 인덱스를 배열에 담아 return
*/
import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        List<String> dictionary = new ArrayList<>(List.of("", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 1;
        int prev = 0;
        // System.out.println(msg.substring(0,1));
        while(end <= msg.length()){
            String temp = msg.substring(start, end);
            if(dictionary.contains(temp)){
                end++;
                prev = dictionary.indexOf(temp);
            }else{
                dictionary.add(temp);
                ans.add(prev);
                prev = 0;
                start = end-1;
            }
        }
        ans.add(prev);
        return ans;
    }
}