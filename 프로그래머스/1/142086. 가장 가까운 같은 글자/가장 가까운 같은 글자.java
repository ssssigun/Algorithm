import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        List<Character> list = new ArrayList();
        for(int i=0; i<s.length();i++){
            char temp = s.charAt(i);
            if(list.indexOf(temp)>=0){
                if(list.indexOf(temp) == list.lastIndexOf(temp)){
                    answer[i] = i - list.indexOf(temp);
                    list.add(temp);
                }else{
                    if(Math.abs(i - list.indexOf(temp)) >Math.abs(i - list.lastIndexOf(temp))){
                        answer[i] =i - list.lastIndexOf(temp);
                        list.add(temp);
                    }else{
                        answer[i] =i - list.indexOf(temp);
                        list.add(temp);
                    }
                }
            }else{
                answer[i] = -1;
                list.add(temp);
            }
        }
        return answer;
    }
}