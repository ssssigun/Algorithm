import java.util.*;
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList();
        String[] temp = today.split("[.]");
        int toDayY = Integer.parseInt(temp[0]);
        int toDayM = Integer.parseInt(temp[1]); 
        int toDayD = Integer.parseInt(temp[2]);
        Map<String, Integer> term = new HashMap<>();
        
        for(int i=0; i<terms.length; i++){
            String[] temp1 = terms[i].split(" ");
            term.put(temp1[0], Integer.parseInt(temp1[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] temp2 = privacies[i].split(" ");
            String[] day = temp2[0].split("[.]");
            int Year = Integer.parseInt(day[0]);
            int Mon = Integer.parseInt(day[1]) + term.get(temp2[1]);
            int dd = Integer.parseInt(day[2]);
            if(Mon>12){
                Year+= Mon/12;
                Mon = Mon%12;
                if(Mon==0){
                    Mon=12;
                    Year--;
                }
            }
            if(toDayY>Year){ answer.add(i+1); }
            else if (toDayY==Year){ 
                if(toDayM >Mon){
                    answer.add(i+1);
                }else if(toDayM == Mon){
                    if(toDayD >=dd){
                        answer.add(i+1);
                    }
                }
            }
        }
        return answer;
    }
}