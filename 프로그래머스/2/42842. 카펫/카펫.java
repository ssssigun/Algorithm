/*
    1. 배열 크기 구하기
        - Y 크기만 구해도 될듯
    2. 가로가 길거나 같아야함
        - col이 커야함
    3. 가운데에 노란색 들어가고 갈색이 둘러싸기
        - Y 배열 크기 구해서 둘러싸기
            - 약수 구하기
            - 약수에 연산하기 (갈색 범위 더하기)
*/
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1; i<=Math.sqrt(yellow); i++){
            if(yellow%i == 0){
                int col = yellow/i;
                int row = i;
                if((col+row)*2 + 4 == brown){
                    answer[0] = Math.max(row,col)+2;
                    answer[1] = Math.min(row,col)+2;
                }
            }else{
                continue;
            }
        } 
        return answer;
    }
}