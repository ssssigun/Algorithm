import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            int c_x = X.length() - X.replace(i+"","").length();
            int c_y = Y.length() - Y.replace(i+"","").length();
            if(c_x>c_y){
                list.add(c_y);
            }else{
                list.add(c_x);
            }
        }
        for(int i=0; i<10; i++){
            for(int j=0;j<list.get(9-i); j++){
                sb.append(9-i+"");
            }
        }
        answer = sb.toString();
        if("".equals(answer)){
            answer="-1";
        }
        if(answer.indexOf("0")==0){
            answer="0";
        }
        
        return answer;
    }
}