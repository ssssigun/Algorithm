/*
    1. 백 트래킹 문제 (조합)
        - 깊이까지 가서 반환이 아닌 중간 과정도 포함
        - 진행할 때 마다 cnt++
        - 해당하는 단어가 나오면 cnt return
*/
class Solution {
    int cnt = -1;
    char[] arr = {'A', 'E', 'I', 'O', 'U'};
    int ans = 0;
    public int solution(String word) {
        back(0, "", word); // 조합 시작
        return ans;
    }
    public void back(int depth, String str, String w){
        cnt++; // 순서 세기
        if(w.equals(str)){ // 해당하는 숫자가 나오면 순서 저장
            ans = cnt;
        }
        if(depth == arr.length){ // 최대 글자수에 도달 했으면 나가기
            return;
        }
        for(int i=0; i<arr.length; i++){
            back(depth+1, str+arr[i], w);
        }
        
    }
}