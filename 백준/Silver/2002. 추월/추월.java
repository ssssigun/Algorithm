import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
    1. 순서 확인 문제
        - 해시 맵에 처음 들어간 순서를 저장 (XXXX, 1)
        - 그 이후 나온 순서를 배열에 저장
        - 순차적으로 보면서 뒤에 큰수가 없다면 추월로 카운팅
    2. 첫째 줄엔 차의 대수 N
        - 둘째 줄부터 N개는 터널에 들어간 순서
        - N+1줄부터는 터널에서 나온 순서이다.
    3. 추월한 차의 대수를 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){ // 들어온 순서
            map.put(br.readLine(), i);
        }
        for(int i=1; i<=N; i++){ // 나간 순서
            arr[i] = map.get(br.readLine());
        }
        for(int i=1; i<N; i++){
            for(int j=i+1; j<=N; j++){
                if(arr[i] > arr[j]) { // 현재 순서보다 숫자가 크다면 추월
                    cnt++;
                    break;
                }
            }
        }
        // 출력
        bw.write(cnt+"");
        bw.flush();
    }
}