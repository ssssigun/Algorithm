/*
    1. 붕대 감기
        - t초 동안 감으면서 1초에 x만큼 체력 회복
        - 붕대 감는데 성공하면 y만큼 추가 회복
        - 최대 체력 제한 있음
        - 붕대 감는 중 공격을 당하거나 공격을 당하는 순간에는 회복 x
        - 취소되는 즉시 다시 사용, 연속 성공 시간 0
        - 체력이 0이되면 사망
    2. 붕대 감기 기술 정보 배열 bandage, 최대 채력 정수 health, 몬스터의 공격 시간 및 피해량 배열 attacks 
    3. 모든 공격이 직후 남은 체력 return, 체력이 0이하가 되면 -1 return
*/
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 마지막 공격 시간 저장
        int lastAt = attacks[attacks.length-1][0];
        // 최대 체력 저장
        int maxHealth = health;
        // 공격 순서 카운트
        int cntAt = 0;
        // 연속 회복 시간 카운트
        int cntRe = 0;
        // 게임 시작
        for(int i=1; i<=lastAt; i++){
            // 공격 시간이면 피해량만큼 체력 깎기
            if(i == attacks[cntAt][0]){
                cntRe = 0;
                health -= attacks[cntAt][1];
                // 체력이 0이하일 때 -1 return
                if(health<=0){
                    return -1;
                }
                cntAt++;
            // 그게 아니면 연속 회복 시간 증가 및 회복
            }else{
                cntRe++;
                if(health <= maxHealth){
                    health += bandage[1];
                    // 연속 회복 성공시 보너스 회복 및 초기화
                    if(cntRe == bandage[0]){
                        cntRe = 0;
                        health += bandage[2];
                    }
                    // 최대 체력 이상 회복 못하게하기
                    if( maxHealth < health ){
                        health = maxHealth;
                    }
                }

            }
        }
        return health;
    }
}