/*
    1. 구현 문제인데 아이디어를 떠올리지 못했다.
        - 시간 복잡도 배열만큼 소모하므로 가능
        - 형, 동생 해시맵을 두개 만들기
        - 형은 비어있고, 동생은 채우기
        - 하나씩 이동하면서 형은 채우고 동생은 소모하기
        - 해시맵의 크기가 같아졌을 때 카운트
    2. 롤 케이크의 토핑 배열 topping이 주어진다.
    3. 공평하게 자르는 가지수 return
*/
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int ans = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i : topping){ // 동생 맵 채우기
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        for(int i : topping){ // 하나씩 진행
            map1.put(i, map1.getOrDefault(i, 0) + 1); // 형 맵에 추가
            map2.put(i, map2.get(i) - 1); // 동생 맵에선 지우기
            if(map2.get(i) == 0){ // 0이면 없애기
                map2.remove(i);
            }
            if(map1.size() == map2.size()){ // 맵의 개수가 같으면 카운트 (토핑의 개수가 같다)
                ans++;
            }
        }
        return ans;
    }
}