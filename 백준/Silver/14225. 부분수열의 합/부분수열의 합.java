/*
    1. DFS 문제인듯 하다 (부분 수열 구하기)
        - DFS를 돌때마다 set에 저장 (중복 제거)
        - 0부터 100000까지 탐방하면서 존재하지 않는 작은 수 찾기
    2. 첫째 줄엔 수열의 크기 N
        - 둘째 줄엔 수열이 주어짐
    3. 수열의 합으로 나올 수 없는 작은 수 return
* */

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int[] arr;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){ // 수열 입력
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0); // DFS 진행
        int ans = 0;
        while(true){ // 없는 작은 수 찾기
            if(!set.contains(ans)){ // 포함 되어있지 않으면 나가기
                break;
            }
            ans++;
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    // dfs
    public static void dfs(int start, int sum){
        set.add(sum); // 조합된 숫자 저장
        for(int i=start; i<arr.length; i++) {
            dfs(i + 1, sum + arr[i]);
        }
    }
}