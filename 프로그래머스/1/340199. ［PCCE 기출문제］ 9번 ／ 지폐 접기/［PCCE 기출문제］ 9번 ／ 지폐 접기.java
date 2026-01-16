/*
    1. 단순 구현 문제 
    2. 시간 복잡도 널널
    3. 지갑크기와 지폐 크기를 비교 후 안들어가면 큰쪽 접기
*/
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int ans = 0;
        while(check(wallet, bill)){
            ans++;
            // 지폐 큰쪽 접기
            if(bill[0] > bill[1]){
                bill[0] = bill[0]/2;
            }else{
                bill[1] = bill[1]/2;
            }
        }
        return ans;
    }
    
    // 지폐가 들어가지는 비교하는 함수
    public Boolean check(int[] w, int[] b){
        // 들어가는지 확인
        if(w[0] >= b[0] && w[1] >= b[1]) {
            return false;    
        }else if(w[0] >= b[1] && w[1] >= b[0]){ // 90도 돌려서 확인
            return false; 
        }
        return true;
    }
}

