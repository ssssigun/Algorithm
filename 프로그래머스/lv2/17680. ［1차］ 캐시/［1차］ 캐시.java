/*
    1. cacheSize 캐시 크기, 도시이름 배열 cities 입력
    2. LRU 캐시교체 알고리즘은 최근 데이터를 캐시 크기 만큼 담고 
        새로운 데이터가 들어오면 가장 오래된 데이터를 삭제하고 담고
        있는 데이터가 들어오면 위치를 맨 끝으로 옮기는 알고리즘이다.
    3. 대소문자 구분이 없으므로 소문자로 저장 및 비교하기!
    4. 이대로 linkedList 구현해서 풀어보자
*/
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 캐시 배열
        List<String> cache = new LinkedList();
        
        // 캐시 유무에 따라서 실행 시간 변화
        for(int i = 0; i<cities.length; i++){
            // 캐시 크기가 0일 때
            if(cacheSize == 0){
                answer += 5;
            // 캐시 안에 있으면 최근으로 이동하고 실행 시간 + 1
            }else if(cache.contains(cities[i].toLowerCase())){
                cache.remove(cache.indexOf(cities[i].toLowerCase()));
                cache.add(cities[i].toLowerCase());
                answer++;
            // 캐시 안이 비었을 때
            }else if(cache.isEmpty()){
                cache.add(cities[i].toLowerCase());
                answer += 5;
            }else{
                // 캐시 안에 없으면 오래된 캐시 삭제 후 추가한 뒤 실행 시간 + 5 (캐시 크기가 다 찼을 때)
                if(cache.size() == cacheSize){
                    cache.remove(0);
                    cache.add(cities[i].toLowerCase());
                    answer += 5;
                // 캐시 크기가 남을 때
                }else {
                    cache.add(cities[i].toLowerCase());
                    answer += 5;
                }
            }
        }
        return answer;
    }
}