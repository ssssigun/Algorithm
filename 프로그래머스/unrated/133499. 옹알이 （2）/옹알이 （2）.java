import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        List<String> list = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));
        for(String ele : babbling){
            for(int i =0; i<list.size(); i++){
                if(ele.contains("ayaaya") || ele.contains("yeye")
                  || ele.contains("woowoo") || ele.contains("mama")){
                    continue;
                }
                while(ele.contains(list.get(i))){
                  ele = ele.replaceFirst(list.get(i)," ");
                }
            }
            ele = ele.trim();
            if("".equals(ele)){
                answer++;
            }
        }
        return answer;
    }
}