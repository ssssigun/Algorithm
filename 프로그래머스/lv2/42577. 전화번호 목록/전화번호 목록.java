/*
    1. 이중 for문으로 시간 초과가 난다.
    2. 해시로 접근하기
    3. 번호를 key로 하고 substring을 사용해서 해보기
        - 이중 for문보다는 확실히 실행 횟수가 작다
*/
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호 해시
        Map<String, Integer> map = new HashMap<>();
        // 해시에 값 넣기
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i],1);
        }
        // 접두사인지 찾기
        for(int i=0; i<phone_book.length; i++){
            String temp = phone_book[i];
            for(int j=1; j<temp.length(); j++){
                // 접두사 발견하면 false return
                if(map.containsKey(temp.substring(0,j))){
                    return false;
                }
            }
        }
        return true;
    }
}