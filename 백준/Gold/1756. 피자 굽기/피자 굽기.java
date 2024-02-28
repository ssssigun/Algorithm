import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    1. 구현 문제인듯하다.
        - 반죽 순서대로 들어갈 수 있는 지름 순서대로 넣으면 될 것 같다.
        - 하지만 주의해야할 점은 위에 작은 지름의 오븐이면 밑에가 아무리 커도 들어가지 못한다.
        - 그러므로 오븐 크기 먼저 조절해볼까한다.
        - 다 들어가지 못하면 0 출력
    2. 첫째 줄 오븐 깊이 D, 피자 반죽의 개수 N
        - 둘째 줄엔 오븐 최상단부터 아래 오븐의 지름이 주어진다.
        - 셋째 줄엔 피자 반죽이 완성 순서대로 주어짐
    3. 마지막 피자 반죽의 위치 return
        - 전부 들어가지 않는다면 0 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> dough = new LinkedList<>();
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken()); // 오븐의 깊이
        int N = Integer.parseInt(st.nextToken()); // 반죽 갯수
        int[] oven = new int[D];
        st = new StringTokenizer(br.readLine()); // 오븐 크기
        for(int i=0; i<D; i++){
            oven[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()); // 피자 반죽
        for(int i=0; i<N; i++){
            dough.offer(Integer.parseInt(st.nextToken()));
        }
        int last = D; // 마지막 넣은 위치 저장 (초기값은 오븐 끝위치)
        // 오븐 크기 조절
        for(int i=0; i<D-1; i++){
            if(oven[i] < oven[i+1]){
                oven[i+1] = oven[i];
            }
        }
        // 반죽 넣기
        while(!dough.isEmpty()){
            if(last < 1){ // 다 찼으면 나기기
                last = -1;
                break;
            }
            int temp = dough.poll();
            boolean flag = true;
            for(int i=last-1; i>=0; i--){
                if(oven[i] >= temp){
                    last = i;
                    flag = false;
                    break;
                }
            }
            if(flag){ // 모든 피자가 오븐에 들어가지 못했으면 나가기
                last = -1;
                break;
            }
        }
        // 출력
        bw.write((last+1)+"");
        bw.flush();
    }
}
