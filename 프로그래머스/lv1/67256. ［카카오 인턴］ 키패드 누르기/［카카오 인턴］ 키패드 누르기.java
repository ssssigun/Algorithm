/*
    1. 왼손위치, 오른손 위치 변수에 저장해서 가운데 숫자일 때 체크
    2. case문으로 분류해서 기록
    3. 가운데일 때 거리 구해서 가까운 손으로 누르기가 핵심이다.
        - 2차원 배열 인덱스로 계산하기
*/
class Solution {
    public String solution(int[] numbers, String hand) {
        // 정답 저장
        StringBuilder sb = new StringBuilder();
        // 왼손, 오른손 현재 위치 기록 배열
        int[] h = new int[] {10,12};
        // 버튼 누르기
        for(int i :numbers){
            switch(i){
                // 왼손일 때
                case 1: case 4: case 7:
                    sb.append("L");
                    h[0] = i;
                break;
                // 오른손일 때
                case 3: case 6: case 9:
                    sb.append("R");
                    h[1] = i;
                break;
                // 가운데일 때
                case 2: case 5: case 8: case 0:
                    if(i == 0){
                        i = 11;
                    }
                    // 거리 구하기
                    int disL = Math.abs(i - h[0])/3 + Math.abs(i - h[0])%3;
                    // 
                    int disR = Math.abs(i - h[1])/3 + Math.abs(i - h[1])%3;
                    // 가까운 거리 고르기 (같으면 주손으로)
                    if(disL == disR){
                        char temp = Character.toUpperCase(hand.charAt(0));
                        sb.append(temp);
                        if(temp == 'R'){
                            h[1] = i;
                        }else if(temp == 'L'){
                            h[0] = i;
                        }
                    }else if(disL > disR){
                        sb.append("R");
                        h[1] = i;
                    }else if(disL < disR){
                        sb.append("L");
                        h[0] = i;
                    }
                break;
            }
        }
        return sb.toString();
    }
}