/*
    1. N개의 배열을 만들어서 체크하면 될 것 같다.
    2. lost는 1, reserve는 2로 
    3. 총 수업 들을 수 있는 학생 수 return
*/
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 체크 배열
        int[] ch = new int[n];
        // 도난 당한 학생
        for(int i : lost){
            ch[i-1] = 1;
        }
        // 여분을 가지고 있는 학생
        for(int i : reserve){
            // 도난을 당한 학생이면 체육복을 빌려줄 수 없다.
            if(ch[i-1] == 1){
                ch[i-1] = 0;
            }else{
                ch[i-1] = 2;
            }
        }
        for(int i=0; i<ch.length; i++){
            // 도난 당한 학생 중에 양 옆에 여분을 가진 학생이 있으면 빌려주기
            if(ch[i] == 1){
                // 왼쪽 사람
                if( i>0 && ch[i-1] == 2){
                    ch[i-1] = 0;
                    ch[i] = 0;
                // 오른쪽 사람
                }else if(i<ch.length-1 && ch[i+1] == 2){
                    ch[i+1] = 0;
                    ch[i] = 0;
                }
            }
        }
        // 수업 참여 가능한 학생 수 세기
        for(int i : ch){
            if(i != 1){
                answer++;
            }
        }
        return answer;
    }
}