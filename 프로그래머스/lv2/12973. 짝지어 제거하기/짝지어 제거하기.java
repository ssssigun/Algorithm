/*
    1. 처음에 문자열 처리 했는데 시간초과 났음
    2. 스택으로 풀어야할듯
    3. s 하나씩 push하고 중복이면 pop
*/
import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack();
        
        for(int i=0; i<s.length(); i++){
            if(!st.empty()){
                if(st.peek() == s.charAt(i)){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }else{
                st.push(s.charAt(i));
            }
        }
        if(st.empty()){
            return 1;
        }
        return 0;
    }
}