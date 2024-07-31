/*
    1. bfs 변형으로 풀 수 있을 것 같다.
        - 최단 거리 구하기
        - 큐에 넣고 방문 처리
        - 큐에서 하나씩 꺼내서 문자 하나만 다르면 큐에 저장
        - 방문 처리, 거리 +1
*/
import java.util.*;
class Word{
    String w;
    int dis;
    Word(String w, int dis){
        this.w = w;
        this.dis = dis;
    }
}

class Solution {
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        return bfs(begin, target, words);
    }
    
    // bfs
    public int bfs(String begin, String target, String[] words){
        Queue<Word> que = new LinkedList<>();
        que.offer(new Word(begin, 0)); // 초기값
        while(!que.isEmpty()){
            Word w = que.poll();
            if(target.equals(w.w)){ // 만약 타겟에 도착하면 거리값 반환
                return w.dis;
            }
            for(int i=0; i<words.length; i++){ // 배열 순회
                if(!visited[i] && ch(w.w, words[i])){ // 한글자 차이나면 방문x
                    visited[i] = true;
                    que.offer(new Word(words[i], w.dis + 1));
                }
            }
        }
        return 0;
    }
    
    // 한글자만 다른지 확인 함수
    public boolean ch(String str1, String str2){
        int cnt = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)){
                cnt++;
            }
        }
        if(str1.length() - cnt == 1){
            return true;
        }
        return false;
    }
}