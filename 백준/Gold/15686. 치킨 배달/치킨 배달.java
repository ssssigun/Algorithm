import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    1. 치킨집의 정보를 모와서 M개 선택해서 진행
        - 주어지는 입력의 수가 적으므로 브루트포스 가능
        - 집에서 가장 가까운 치킨집과의 거리가 치킨 거리이므로 bfs 활용인줄 알았으나...... 여기서 상당히 고생했다
        - 경우의 수를 뽑는거면 백트래킹을 활용하면 되고 bfs는 굳이 사용하지 않아도 된다.
        - 최단 거리 치킨집은 그냥 선택한 치킨집 경우의 수 모두 계산해도 시간초과가 뜨지 않기 때문이다. (입력이 상당히 작음)
        - 백트래킹을 더 풀어보자..ㅜㅠ
    2. 첫째 줄에 맵크기 N, 최대 치킨집의 수 M
        - 둘째 줄부터 N개의 줄은 도시의 정보가 주어짐
    3. M개 골랐을 때 도시의 치킨거리 최솟값 return
* */
class Point{ // 좌표 저장용 클래스
    int x;
    int y;
    Point(int x,int y){ // 생성자
        this.x = x;
        this.y = y;
    }
}
class Main {
    public static int N; // 배열의 크기
    public static int M; // 치킨집 선택하는 갯수
    public static int min = Integer.MAX_VALUE; // 치킨 거리 최솟값
    public static boolean[] open; // 선택처리 배열
    public static List<Point> chicken = new ArrayList<>(); // 치킨집 위치 배열
    public static List<Point> house = new ArrayList<>(); // 집 위치 배열
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){ // 집 위치
                    house.add(new Point(i,j));
                }else if(temp == 2){ // 치킨집 위치
                    chicken.add(new Point(i,j));
                }
            }
        }
        open = new boolean[chicken.size()];
        // 치킨집 M개 선택해서 치킨 거리 계산하기
        back(0,0);
        // 출력
        bw.write(min+"");
        bw.flush();
    }
    // 백트래킹
    public static void back(int start, int depth){
        if(depth == M){ // M개 완료했으면 치킨 거리 계산하기
            int sum = 0;
            for(Point h : house){ // 모든 집에서 치킨 거리 구하기
                int minDis = Integer.MAX_VALUE;
                for(int i=0; i< chicken.size(); i++){
                    if(open[i]){ // 선택한 치킨집이면
                        int dis = Math.abs(chicken.get(i).x - h.x) + Math.abs(chicken.get(i).y - h.y); // 거리 계산
                        minDis = Math.min(minDis, dis); // 최소인 값으로 변경
                    }
                }
                sum += minDis; // 집마다 최솟값 더해주기
            }
            min = Math.min(min, sum); // 치킨 거리가 최소인 걸로 변경
            return;
        }
        for(int i=start; i<chicken.size(); i++){
            open[i] = true;
            back(i+1,depth+1);
            open[i] = false;

        }
    }
}