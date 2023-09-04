/*
    1. dfs로 풀이해야함
    2. 구상이 안되서 솔루션 참고
*/
class Solution {
    // target과 같으면 카운트
    public static int answer = 0;
    // dfs
    public void dfs(int[] num, int depth, int target, int sum){
        //마지막에 target 과 같으면 카운트
        if(depth == num.length){
            if(target == sum){answer++;}
        }else{
            // 더할 때
            dfs(num, depth+1, target, sum + num[depth]);
            // 뺄 때
            dfs(num, depth+1, target, sum - num[depth]);
        }
    }
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
}