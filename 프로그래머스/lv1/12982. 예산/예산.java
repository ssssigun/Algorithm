import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        List<Integer> list = new ArrayList();
        for(int i=0;i<d.length; i++){
            list.add(d[i]);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(budget>=list.get(i)){
                budget-=list.get(i);
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }
}