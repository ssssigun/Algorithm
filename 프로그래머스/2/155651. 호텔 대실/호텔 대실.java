/*
    1. 구현 문제인 듯하다
        - book_time 배열 정렬
        - book_time 배열을 돌면서 리스트와 비교
            - 다음 시작 시간이 현재 시간보다 빠른 경우
        - 겹치는 시간대가 있으면 리스트에 추가하고 넣기
    2. 대실 시간 배열 book_time
    3. 최소 필요한 객실의 수 return
*/
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1 ,o2) ->{ // 대실 시간 배열 정렬
            return o1[0].compareTo(o2[0]) == 0 ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]);});
        
        List<List<String[]>> room = new ArrayList<>(); // 객실 배열
        room.add(new ArrayList<>()); // 초기화
        room.get(0).add(new String[]{book_time[0][0], book_time[0][1]});
        
        for(int i=1; i<book_time.length; i++){ // 돌면서 확인하기
            String[] now = book_time[i];
            boolean flag = false;
            for(int j=0; j<room.size(); j++){
                String[] prevTime = room.get(j).get(room.get(j).size()-1); // 끝 시간 확인
                if(timeUp(prevTime[1]).compareTo(now[0]) > 0){ // 객실 자리가 없음
                    flag = true;
                }else{ // 객실의 자리가 있음
                    flag = false;
                    room.get(j).add(new String[]{now[0], now[1]});
                    break;
                }
            }
            if(flag){ // 만약 자리가 없다면 객실 추가
                room.add(new ArrayList<>());
                room.get(room.size()-1).add(new String[]{now[0], now[1]});
            }
        }
        return room.size();
    }
    public static String timeUp(String s){ // 청소 시간 추가
        String[] str = s.split(":");
        int min = Integer.parseInt(str[1]) + 10;
        if(min >= 60){
            int h = Integer.parseInt(str[0]) + 1;
            min %= 60;
            String hour = h<10 ? "0"+h: h+"";
            String minute = min<10 ? "0"+min : min+"";
            return hour + ":" + minute;
        }
        return str[0] + ":" + min;
    }
}