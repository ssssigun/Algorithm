import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        for(int i=0;i<10; i++){
            if(list.indexOf(i)<0){
                answer+=i;
            }
        }
        return answer;
    }
}