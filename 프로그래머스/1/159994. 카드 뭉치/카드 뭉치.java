/*
    1. 단어 배열 만들기
        - 한번 사용하면 끝
        - 순서대로 한장씩 사용
        - 사용하지 않고 넘어갈 수 없다
        - 단어 순서는 못바꿈
    2. 제한조건
        - 덱 길이는 10
        - 덱1 +덱2 >= 목표 단어
*/
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cnt1 =0;
        int cnt2 =0;
        boolean[] goalAns = new boolean[goal.length];
        
        for(int i=0; i<goal.length; i++){
            //card1 확인
            for(int j=cnt1; j<cards1.length; j++){
                if(goal[i].equals(cards1[j])){
                    if(j-cnt1>1){
                        answer = "No";
                    }
                    cnt1=j;
                    goalAns[i]=true;
                    break;
                }
            }
            //card2 확인
            for(int j=cnt2; j<cards2.length; j++){
                if(goal[i].equals(cards2[j])){
                    if(j-cnt2>1){
                        answer = "No";
                    }
                    cnt2=j;
                    goalAns[i]=true;
                    break;
                }
            }
        }
        for(int i=0; i<goalAns.length; i++){
            if(!goalAns[i]){
                answer = "No";  
            }
        }
        return answer;
    }
}