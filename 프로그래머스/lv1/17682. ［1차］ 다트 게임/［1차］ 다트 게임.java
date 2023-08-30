/*
    1. 3번 던지기, 한번에 0~10점, 제곱이 존재
    2. 옵션으로 스타상(*) = 전 점수와 지금 점수 두배 획득, 아차상(#) = 마이너스하기
    3. 첫번째에 스타상이 나오면 그 점수의 두배, 스타상과 아차상은 중첩가능 -2배
    4. 스타상끼리도 중첩가능 
*/
import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList();
        char[] ch = dartResult.toCharArray();
        int curCnt =0;
        int temp=1;
        //점수 계산하기
        //초기값 추가
        if(ch[0] == '1' && ch[1] == '0'){
            list.add(10);
            temp++;
        }else{
            list.add(ch[0] -'0');
        }
        
        for(int i=1; i<ch.length; i++){
            //정수 먼저 추가
            if(Character.isDigit(ch[i])){
                if(ch[i] == '1' && ch[i+1] == '0'){
                    list.add(10);
                    curCnt++;
                    i++;
                }else{
                    list.add(ch[i]-'0');
                    curCnt++;
                }
            }
            // 제곱 영역
            if(ch[i]=='D'){
                list.set(curCnt, (int)Math.pow(list.get(curCnt),2));
            }else if(ch[i]=='T'){
                list.set(curCnt, (int)Math.pow(list.get(curCnt),3));
            }
            
            //스타상 
            if(ch[i]=='*'){
                list.set(curCnt, list.get(curCnt) * 2);
                if(curCnt!=0){
                    list.set(curCnt-1, list.get(curCnt-1) * 2);    
                }
            }
            //아차상
            if(ch[i]=='#'){
                list.set(curCnt, list.get(curCnt) * (-1));
            }
        }
        // 모두 더하기
        for(int i=0; i<list.size(); i++){
            answer += list.get(i);
        }
        return answer;
    }
}