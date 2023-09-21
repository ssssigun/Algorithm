/*
    1. 옷 종류로 경우의 수 구하면 될 것 같다.
    2. 해시맵 이용해서 갯수를 구해서 경우의 수 구하기
*/
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap();
        // 옷 종류 개수 구하기
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0) + 1);
        }
        
        // 경우의 수 구하기
        Iterator<Integer> iter = map.values().iterator();
        
        while(iter.hasNext()){
            answer *= iter.next().intValue()+1;
        }
        
        // 전부 안 입는 경우 빼기
        return answer-1;
    }
}