/*
    1. 스택이 아니여도 가능할 것 같다.
    2. 정수를 빼고 더해서 접근
    3. 잘 닫아있으면 true return
*/
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int bracket =0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                bracket++;
            }else{
                bracket--;
            }
            if(bracket<0){
                return false;
            }
        }
        if(bracket==0){
            answer =true;
        }
        return answer;
    }
}