/*
    1. 로또는 1~45까지 숫자 중 6개를 찍어서 맞추기
    2. 부분 블락(0), 최고 순위와 최저 순위를 알고 싶음
    3. 0의 개수와 맞는 숫자 갯수를 카운트하고 순위로 변환하는 문제
*/
class Solution {
    public static int tranNum(int num){
        int rank = 7-num;
        if(rank>=6){rank =6;}
        return rank;
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win = 0;
        int block = 0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                block++;
                continue;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    win++;
                    break;
                }
            }
        }
        answer[1] = tranNum(win);
        answer[0] = tranNum(win+block);
        return answer;
    }
}