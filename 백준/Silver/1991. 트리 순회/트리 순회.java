/*
    1. dfs 문제이다.
        - 그래프 탐색을 하되 전위, 중위, 후위대로 프린트 해야됨
    2. 첫째 줄엔 이진 트리의 노드 갯수 N
        - 둘째 줄부터 N개의 노드의 왼쪽 노드와 오른쪽 노드가 주어짐
        - 단 없으면 .
    3. 첫째 줄에 전위, 둘째 줄에 중위, 마지막 줄에 후위 순회한 결과를 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sbF = new StringBuilder();
    static StringBuilder sbM = new StringBuilder();
    static StringBuilder sbL = new StringBuilder();
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            arr[a][0] = st.nextToken().charAt(0);
            arr[a][1] = st.nextToken().charAt(0);
        }
        dfs(arr, 0);
        // 출력
        bw.write(sbF.toString()+'\n');
        bw.write(sbM.toString()+'\n');
        bw.write(sbL.toString());
        bw.flush();
    }
    // dfs
    public static void dfs(char[][] arr, int idx){
        sbF.append(((char)('A'+idx))); // 전위
        for(int i=0; i<2; i++){
            if(i==1){
                sbM.append(((char)('A'+idx))); // 중위
            }
            if(arr[idx][i] != '.'){
                dfs(arr, arr[idx][i] - 'A');
            }
        }
        sbL.append(((char)('A'+idx))); // 후위
    }
}