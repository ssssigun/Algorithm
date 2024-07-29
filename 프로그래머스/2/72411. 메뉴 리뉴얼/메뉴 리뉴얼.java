/*
    1. 백트래킹과 해시 맵을 사용한 문제
        - 시간 복잡도는 숫자가 작아 가능할 것 같다.
        - 백트래킹으로 단품 메뉴의 조합들을 구한다.
        - 해시 맵에 저장
            - 있다면 갯수 업
            - 없다면 추가
            - 동시에 course에 해당하는 값의 최대값을 저장
        - 이후 최대값과 같은 값들 꺼내기
        - 사전순으로 정렬
*/
import java.util.*;
class Menu implements Comparable<Menu>{ // 메뉴 클래스
    String m;
    int cnt;
    Menu(String m, int cnt){
        this.m = m;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(Menu o1){
        return o1.cnt - this.cnt;
    }
}
class Solution {
    static Map<String, Integer> map = new HashMap<>(); // 조합의 갯수 저장 맵
    
    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<orders.length; i++){ // 손님마다 시키는 메뉴의 조합 구하기
            for(int j=2; j<=orders[i].length(); j++){
                back(0, j, "", 0, orders[i]);
            }
        }
        
        List<Menu> list = new ArrayList<>(); // 개수를 기준으로 오름차순 정렬
        for(String s : map.keySet()){
            if(map.get(s) > 1){ // 1이하는 제외
                list.add(new Menu(s, map.get(s)));    
            }
        }
        Collections.sort(list);
        
        // 음식 조합 구하기
        int[] max = new int[course.length];
        List<String> ans = new ArrayList<>();
        for(Menu m : list){ 
            for(int i=0; i<course.length; i++){
                if(course[i] == m.m.length() && max[i] <= m.cnt){ // 단품 메뉴의 개수가 부합하면서 가장 큰값일 때
                    ans.add(m.m);
                    max[i] = m.cnt;
                }
            }
        }
        Collections.sort(ans); // 사전순으로 정렬
        return ans.toArray(new String[0]);
    }
    // 백트래킹 함수
    public static void back(int depth, int m, String s,int start, String orders){
        if(depth == m){
            char[] c = s.toCharArray();
            String str = "";
            Arrays.sort(c);
            for(int i=0; i<c.length; i++){
                str += c[i];
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for(int i=start; i<orders.length(); i++){
            back(depth + 1, m, s + (orders.charAt(i)+ ""),i+1, orders);
        }
    }
}
