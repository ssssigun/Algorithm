/*
    1. 문자열 DFS 문제 같다.
        - tickets 문자열을 먼저 정렬
        - 이후 dfs
*/
import java.util.*;
class Solution {
    boolean[] visited;
    List<String> ans = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs("ICN", 0,"", tickets);

        Collections.sort(ans);
        
        return ans.get(0).substring(1, ans.get(0).length()).split(" ");
    }
    public void dfs(String k,int depth,String str, String[][] tickets){
        if(depth == tickets.length){
            ans.add(str+" "+k);
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(k) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], depth +1,str+" "+k, tickets);
                visited[i] = false;
            }
        }
    }
}