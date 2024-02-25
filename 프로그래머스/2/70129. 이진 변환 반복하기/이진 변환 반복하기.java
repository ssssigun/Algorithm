/*
    1. 1이 될때까지 이진변환 진행하기
    2. 입력은 0과 1로 이루어진 문자열 s
    3. [ 이진 변환 횟수, 제거된 0의 개수 ] return
*/
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int temp1 =0;
        int temp2 =0;
        while(s.length()>1){
            int cnt=0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='1'){
                    cnt++;
                }
            }
            temp2 += s.length() - cnt;
            s = Integer.toString(cnt,2);
            temp1++;
        }
        answer[0] =temp1;
        answer[1] = temp2;
        return answer;
    }
}