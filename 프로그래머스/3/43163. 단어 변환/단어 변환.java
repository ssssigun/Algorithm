/*
    1. dfs로 풀어보기
        - 만약 도착지에 도착하면 반환
        - 그게 아니라면 배열 순회
        - 한글자만 다른 단어를 발견하면 방문 처리 후 dfs
*/
class Solution {
    int ans = Integer.MAX_VALUE;
    String[] w;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        w = words.clone();
        visited = new boolean[w.length];
        dfs(begin, target, 0);
        return ans == Integer.MAX_VALUE ? 0 : ans; // 값이 변한 적 없으면 도달x
    }
    // dfs 함수
    public void dfs(String begin, String target, int depth){
        if(target.equals(begin)){ // target 단어에 도착했다면 최솟값 저장
            ans = Math.min(ans, depth);
            return;
        }
        for(int i=0; i<w.length; i++){ // 배열 순회
            if(!visited[i] && ch(begin, w[i])){ // 방문 x, 알파벳 하나 차이일 때
                visited[i] = true;
                dfs(w[i], target, depth+1);
                visited[i] = false;
            }
        }
    }
    // 알파벳 하나 차이인지 확인하는 함수
    public boolean ch(String str1, String str2){
        int cnt = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                cnt++;
            }
        }
        if(cnt == 1){
            return true;
        }
        return false;
    }
}