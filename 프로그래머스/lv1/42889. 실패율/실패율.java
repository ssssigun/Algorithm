/*
    1. 전체 스테이지 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
    2. 실패율이 높은 스테이지부터 내림차순으로 return 
*/
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] ans = new int[N];
        double[][] fail = new double[N][2];
        Map<Integer, Integer> map = new HashMap();
        int len = stages.length;
        int temp = 0;
        //정렬
        Arrays.sort(stages);
        // 스테이지에 남아 있는 유저 숫자 구하기 
        map.put(stages[0], 1);
        for(int i=1; i<stages.length; i++){
            if(map.containsKey(stages[i])){
                map.put(stages[i], map.get(stages[i])+1);
            }else{
                map.put(stages[i], 1);  
            }
        }
        //실패율 구하기
        for(int i=1; i<=N; i++){
            temp = map.get(i) == null ? 0 : map.get(i);
            
            fail[i-1][0] = i; 
            if(len==0){
                len=1;
            }
            fail[i-1][1] = temp/(double)len; 
            len -= temp; 
        }
        // 실패율 내림차순으로 정렬
        Arrays.sort(fail, (o1, o2) -> {
            return o2[0] == o1[0] ? Double.compare(o1[0],o2[0]) : Double.compare(o2[1], o1[1]);
        });
        
        //담기
        for(int i=0; i<ans.length; i++){
            ans[i] = (int)fail[i][0];
        }
        return ans;
    }
} 
