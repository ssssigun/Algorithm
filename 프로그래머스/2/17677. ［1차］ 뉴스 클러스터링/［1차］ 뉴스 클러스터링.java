/*
    1. 두 글자씩 끊어서 배열 만들고 자카드 지수 구하기
        - 교집합과 합집합 구해야한다.
    2. 대소문자는 구분하지 않는다. 하지만 특수 문자 및 공백은 제외
    3. 입력은 문자열 두개
    4. 65536  * 자카드 지수 return
*/
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        double inter = 0;
        List<String> A = new ArrayList();
        // 집합 A
        for(int i=0; i<str1.length()-1; i++){
            if(Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i+1))){
                A.add(str1.substring(i,i+2).toUpperCase());
            }
        }
        // 집합 B
        for(int i=0; i<str2.length()-1; i++){
            if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))){
                String temp = str2.substring(i,i+2).toUpperCase();
                // A에 있는 값이면 없애고 교집합 수 카운트
                if(A.contains(temp)){
                    A.remove(A.indexOf(temp));
                    inter++;
                }else{
                    // B에서 추가하는 값은 뒤에 공백을 붙여서 구분하기
                    A.add(temp+" ");
                }
            }
        }
        if(A.isEmpty()){
            return 65536;
        }
        return (int)(65536 * (inter/(A.size()+inter)));
    }   
}   