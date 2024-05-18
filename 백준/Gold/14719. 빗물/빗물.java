import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    1. 세로 기준 위에서 체크하기
        - 해당 높이에 블럭이 있다면 사이에 고인 빗물을 더해서 계산한다.
    2. 첫 번째 줄에는 세로 길이 H, 가로 길이 W
        - 두 번째 줄에는 블록의 높이 H개
    3. 빗물의 총량을 return
* */
class Main {
    public static void main(String[] arg) throws Exception {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0; // 빗물 총량 저장
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] world = new int[W+1];
        for(int i=1; i<=W; i++){
            world[i] = Integer.parseInt(st.nextToken());
        }
        // 가장 1 ~ H에 해당하는 높이를 찾기
        for(int i=1; i<=H; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=1; j<=W; j++){
                if(world[j] >= i){ // j 높이와 크거나 같은 인덱스들을 저장
                    list.add(j);
                }
            }
            // 빗물 계산
            for(int j=1; j<list.size(); j++){
                int prev = list.get(j-1);
                int cur = list.get(j);
                if(cur - prev > 1){ // 인덱스 사이의 거리
                    ans += cur - prev - 1;
                }
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}