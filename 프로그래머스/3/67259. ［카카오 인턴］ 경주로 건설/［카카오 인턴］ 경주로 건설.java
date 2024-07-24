/*
    1.bfs문제와 dp를 합친 문제
        - 시간 충분
        - 코너를 돌 때 추가 요금을 계산해야함
        - 이전 방황과 다르면 +500, 같거나 처음이면 +100
        - 이동할 때마다 최소 비용을 저장
    2. N x N 배열이 주어짐
        - 0은 빈칸, 1은 벽
    3. 최소 비용 구하기
*/
import java.util.*;
class Node{
    int x;
    int y;
    int dir;
    int cost;
    
    Node(int x, int y, int dir, int cost){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}
class Solution {
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;
    public int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N];
        // 최단 거리 구하기
        return bfs(0, 0, board);
    }
    public static int bfs(int x, int y, int[][] board){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, y, -1, 0));
        
        int min = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            Node n = que.poll();
            
            if( n.x == N-1 && n.y == N-1){ // 마지막에 도달했으면 최솟값 저장
                min = Math.min(min, n.cost);
            }
            
            for(int i=0; i<4; i++){
                int cx = n.x + dx[i];
                int cy = n.y + dy[i];
                int curCost = n.cost;
                
                if(n.dir == -1 || n.dir == i){ // 방향이 같거나 처음이면 +100
                    curCost += 100;
                }else{ // 다른 방향 (코너)면 +500  
                    curCost += 600;
                }
                if(0<=cx && 0<=cy && cx<N && cy<N && board[cx][cy] == 0){ // 범위 안에 있는 이동 가능한 칸
                    if(visited[cx][cy] == 0){
                        que.offer(new Node(cx, cy, i, curCost));
                        visited[cx][cy] = curCost;
                    }else if (curCost < (visited[cx][cy] + 500)) { // 간 적이 있지만, 비용적으로 이득인 경우
                        que.offer(new Node(cx, cy, i, curCost));
                        visited[cx][cy] = curCost;
                    }                    
                }
            }    
        }
        return min;
    }
}