/*
    1. 투 포인터 문제인 것 같다.
        - 처음에 set에 담아 종류 확인
        - 1,1부터 시작하면서 set과 같아질 때까지 구간에 보석을 map에 담기
        - Set과 크기가 같아지면 담고 작은 구간 업, 빠진 보석 빼기
        - 정렬해서 작은 구간 return
    2. 보석 배열 gems
    3. 가장 짧은 구간 return
        - 여러개일 경우 시작 번호가 작은 구간 return
*/
import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] ans = {0, gems.length};
        Set<String> set = new HashSet<>();
        for(int i=0; i<gems.length; i++){ // set에 넣고 종류 확인
            set.add(gems[i]);
        }
        
        int start = 0;
        int end = 0;
        Map<String, Integer> map = new HashMap<>(); // 맵에 넣으면서 확인
        
        // 투포인터 시작
        while(true){
            if(map.size() == set.size()){ // 모든 종류가 들어갈 경우
                if(end-(start+1) < ans[1] - ans[0]){ // 범위가 작다면 추가
                    ans[0] = start + 1;
                    ans[1] = end;
                }
                if(map.get(gems[start])-1 == 0){ // 앞 구간 줄이기
                    map.remove(gems[start]);
                }else{
                    map.put(gems[start], map.get(gems[start]) - 1);
                }
                start++;
            }else{ // 모든 종류가 안들어간 경우 추가
                if(end >= gems.length){ // 범위를 벗어나면 종료
                    break;
                }
                map.put(gems[end], map.getOrDefault(gems[end], 0) +1);
                end++;
            }
        }
        return ans;
    }
}