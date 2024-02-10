/*
    1. 조건 확인
        - 차가 출차 되지 않았으면 23:59분에 출차된 걸로 간주
        - 그날 모든 시간을 누적해서 주차비 계산
        - 기본 시간 이하면 기본 요금 청구
        - 기본 시간 이상이면 단위 시간마다 단위 요금 청구
            - 단 단위 시간으로 나눠지지 않으면 올림으로 계산
    2. 입력은 요금제 fees배열, 기본 시간, 기본 요금, 단위 시간, 단위 요금 순서
        - 자동차의 출차를 나타내는 배열 records, 문자열에 시간, 차량 번호, 출차 여부가 주어진다.
    3. 차량 번호가 작은 자동차부터 청구할 주차 요금을 배열에 담아 return
*/
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>(); // 누적 시간 저장용 테이블
        Map<String, String> re = new HashMap<>();// 차량 출차 계산용 테이블
        // 출차 기록 확인
        for(int i=0; i<records.length; i++){
            String[] temp = records[i].split(" ");
            if("IN".equals(temp[2])){ // 입장할 때
                re.put(temp[1], temp[0]);
            }else{  // 나갈 때
                map.put(temp[1], map.getOrDefault(temp[1], 0) + cal(re.get(temp[1]), temp[0]) );
                re.remove(temp[1]);
            }
        }
        // 나가지 않은 차 확인
        if(!re.isEmpty()){
           for(String key : re.keySet()){
               map.put(key, map.getOrDefault(key, 0) + cal(re.get(key), "23:59") );
           }
        }
        // 요금 계산하기
        for(String key : map.keySet()){
            int t = map.get(key);
            if(t < fees[0]){ // 기본 시간 이하일 때
                map.put(key, fees[1]);
            }else{ // 기본 시간 이상일 때
                t -= fees[0];
                int sum = fees[1];
                if(t % fees[2] == 0){ // 단위 시간으로 나누어 떨어질 때
                    sum += t / fees[2] * fees[3];
                }else{ // 안나누어져서 올림
                    System.out.println(t +" " + fees[2] + " " + fees[3]);
                    sum += Math.ceil(t / (double)fees[2]) * fees[3];
                }
                map.put(key, sum);
            } 
        }
        int[][] price = new int[map.size()][2];
        int[] ans = new int[map.size()];
        int cnt = 0;
        // 배열 넣기
        for(String key : map.keySet()){
            price[cnt][0] = Integer.parseInt(key);
            price[cnt][1] = map.get(key);
            cnt++;
        }
        // 정렬하기
        Arrays.sort(price, (o1,o2) ->{ return o1[0] -o2[0]; });
        // 정답 배열 담기
        for(int i=0; i<price.length; i++){
            ans[i] = price[i][1];
        }
        return ans;
    }
    // 누적 시간 계산 함수
    public static int cal(String a, String b){
        String[] sub = a.split(":");
        String[] t = b.split(":");
        int sum = ( Integer.parseInt(t[0]) - Integer.parseInt(sub[0]) ) * 60; // 시간 계산
        sum += Integer.parseInt(t[1]) - Integer.parseInt(sub[1]); // 분 계산
        return sum;
    }

}