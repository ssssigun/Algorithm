/*
    1. 서로 다른 종류의 수를 최소화
    2. 귤 크기당 갯수를 구해서 빼주면 될듯
*/
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        List<Integer> list = new ArrayList();
        int temp = tangerine[0];
        int cnt = 0;
        //갯수 세기
        for(int i=0; i<tangerine.length; i++){
            if(temp == tangerine[i]){
                cnt++;
            }else{
                list.add(cnt);
                cnt=1;
            }
            temp = tangerine[i];
        }
         list.add(cnt);
        //내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        for(int i=0; i<list.size(); i++){
            if(k<=0){
                break; 
            }
            k-=list.get(i);
            answer++;
        }
        return answer;
    }
}