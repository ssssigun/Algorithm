/*
    1. 10일 내에서 원하는 항목이 존재해야함
    2. 10개씩 가져와서 비교하기
*/
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        int cnt =0;
        for(int i=0; i<=discount.length-10; i++){
            // 10개씩 가져오기
            String[] temp = Arrays.copyOfRange(discount,i,i+10);
            // 종류별로 몇개씩 있는지 확인
            for(int j=0; j<temp.length; j++){
                if(map.containsKey(temp[j])){
                    map.put(temp[j], map.get(temp[j])+1);
                }else{
                    map.put(temp[j],1);
                }
            }
            //필요 항목과 비교하기
            for(int j=0; j<want.length; j++){
                if(map.containsKey(want[j]) && number[j] == map.get(want[j])){
                    cnt++;
                }else{
                    break;
                }
            }
            if(cnt == want.length){
                answer++;
            }
            map.clear();
            cnt=0;
        }
        return answer;
    }   
}