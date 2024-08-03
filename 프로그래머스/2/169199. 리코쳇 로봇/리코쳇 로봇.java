/*
    1. 최단 거리 bfs 문제이다.
        - R과 G의 위치를 찾고 저장
        - bfs 시작
            - 진행 방향의 다음 지역이 장애물이거나 맵 밖이면 정지
                - 이후 이동 가능한 곳으로 방향 변경 후 추가
            - 그게 아니면 이동 방향대로 진행
        - 방문 처리를 헤야함 무한 반복 방지
            - 멈추는 부분(맵 끝 직전, 장애물 앞)에서 방문 처리를 하자
    2. 맵 정보 board
    3. 최소거리 return
        - 도달하지 못하면 -1
*/
import java.util.*;
class Move{
    int x;
    int y;
    int dis;
    int dir;
    Move(int x, int y, int dis, int dir){
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.dir = dir;
    }
}
class Solution {
    int[] dx = {1, 0, -1, 0}; // 방향 벡터
    int[] dy = {0, -1, 0, 1};
    int[][] visited; // 방문 처리 배열
    int[] end ={0, 0}; // 도착 지점
    int ans = Integer.MAX_VALUE; // 최소거리
    public int solution(String[] board) {
        int x = 0; // 시작 지점
        int y = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                char c = board[i].charAt(j);
                if(c == 'R'){ // 시작 지점
                    x = i;
                    y = j;
                }else if(c == 'G'){ // 도착 지점
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        visited = new int[board.length][board[0].length()];
        for(int i=0; i<board.length; i++){ // 방문 배열 초기값 채우기
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        bfs(x, y, board);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public void bfs(int x, int y, String[] board){
        Queue<Move> que = new LinkedList<>();
        // 초기값 저장
        visited[x][y] = 1;
        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx>=0 && cy>=0 && cx<board.length && cy<board[0].length() && board[cx].charAt(cy) != 'D'){
                que.offer(new Move(cx, cy, 1, i));
            }
        }
        
        while(!que.isEmpty()){
            Move m = que.poll();
            while(true){ // 모서리나 장애물을 만날 때까지 직진
                int cx = m.x + dx[m.dir];
                int cy = m.y + dy[m.dir];
                if(cx<0 || cy<0 || cx>=board.length || cy>=board[0].length() || board[cx].charAt(cy) == 'D'){ // 끝에 도달했을 때
                    if(board[m.x].charAt(m.y) == 'G'){ // 도착시 거리 반환하고 종료
                        ans = Math.min(ans, m.dis);
                        break;
                    }else if(visited[m.x][m.y] > m.dis){ // 방문한 적이 없거나 더 최소값으로 도달한 경우
                        visited[m.x][m.y] = m.dis; // 방문 처리
                        for(int i=0; i<4; i++){ // 새로운 방향으로 이동 추가
                            cx = m.x + dx[i];
                            cy = m.y + dy[i];
                            if(cx>=0 && cy>=0 && cx<board.length && cy<board[0].length() && board[cx].charAt(cy) != 'D'){
                                que.offer(new Move(cx, cy, m.dis + 1, i));
                            }
                        }
                    }
                    break;
                }else{ // 끝이 아니면 이동
                    m.x = cx;
                    m.y = cy;   
                }
            }
        }
    }
    
}