/*
    1. 튜플을 찾는 문제
        - 문자열을 파싱해야할 줄 알았는데 굳이 할 필요 없을 것 같음
        - 중복된 수가 없으므로 hash로 숫자의 수를 센다
        - 수가 많은 순서대로 내림차순
    2. 입력은 튜플 집합 문자열 s 
    3. s가 표현하는 튜플의 배열을 return
*/
import java.util.*;
class Solution {
    public int[] solution(String s) {
        // key 숫자, value 숫자의 갯수
        Map<Integer, Integer> map = new HashMap();
        // 숫자 생성을 도와줄 StringBuilder
        StringBuilder sb = new StringBuilder();
        // 돌면서 숫자 확인
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                sb.append(c);
            }else {
                // 아무 값도 없으면 넘기기
                if(sb.toString().equals("")){
                    continue;
                }
                // 숫자 갯수 추가
                int num = Integer.parseInt(sb.toString());
                map.put(num, map.getOrDefault(num,0)+1);
                // 문자열 초기화
                sb.setLength(0);
            }
        }
        // map에서 값의 갯수를 확인하고 갯수가 많은 것을 기준으로 배열 생성
        Iterator<Integer> iter = map.keySet().iterator();
        int max = 0;
        while(iter.hasNext()){
            int num = iter.next();
            if(max < map.get(num)){
                max = map.get(num);
            }
        }
        int[] answer = new int[max];
        
        // 다시 반복자 돌면서 인덱스에 값 넣어주기
        iter = map.keySet().iterator();
        while(iter.hasNext()){
            int num = iter.next();
            answer[max - map.get(num)] = num;
        }
        return answer;
    }
}