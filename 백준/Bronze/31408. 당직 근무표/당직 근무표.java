import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/*
    1. 이틀 연속 숫자가 겹치면 안된다.
        - 가장 많이 차지하는 숫자의 수를 구한다
        - (가장 많은 병사 - 1) <= (전체 병사수 - 가장 많은 병사)
        - (2 * 많은 병사 - 1) <= 전체 병사 수
    2. 첫째 줄에 당직 근무표 일수 N
        - 둘째 당직 근무표가 주어진다.
    3. 근무표 개선 가능이면 Yes, 불가능하면 No를 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 0 )+1);
        }
        Set<Integer> t = map.keySet();
        int max = 0;
        for (int i : t) { // 최대값 구하기
            if(max < map.get(i)){
                max = map.get(i);
            }
        }
        // 출력
        if((2*max)-1 <= N){
            bw.write("YES");
        }else{
            bw.write("NO");
        }
        bw.flush();
    }
}