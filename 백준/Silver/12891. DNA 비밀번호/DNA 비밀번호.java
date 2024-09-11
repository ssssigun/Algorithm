/*
    1. 투포인터를 활용한 구간합 문제인 것 같다.
        - 부분 문자열에 알파벳 갯수 배열 생성
        - p 크기의 부분문자열의 알파벳을 넣는다.
        - 문자의 갯수를 체크하고 해당하면 ans++
        - p부터 s까지 이동하면서 해당하는 알파벳 개수를 갱신
        - 문자 개수 체크
    2. 첫째 줄에 문자열의 크기 S, 부분문자열의 길이 P
        - 둘째 줄에 DNA 문자열이 주어짐
        - 세번째 줄엔 문자의 최소 포함 갯수가 주어짐
            - [A, C, G, T]
    3. 만들 수 있는 비밀번호의 종류 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] str = br.readLine().toCharArray();
        int[] arr = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int[] sum = new int[4];
        for(int i=0; i<P; i++){
            if(str[i] == 'A'){
                sum[0]++;
            }else if(str[i] == 'C'){
                sum[1]++;
            }else if(str[i] == 'G'){
                sum[2]++;
            }else if(str[i] == 'T'){
                sum[3]++;
            }
        }
        if(sum[0] >= arr[0] && sum[1] >= arr[1] && sum[2] >= arr[2] && sum[3] >= arr[3]){
            ans++;
        }
        int low = 0;
        int high = P;
        while(high < str.length){
            if(str[low] == 'A'){
                sum[0]--;
            }else if(str[low] == 'C'){
                sum[1]--;
            }else if(str[low] == 'G'){
                sum[2]--;
            }else if(str[low] == 'T'){
                sum[3]--;
            }
            if(str[high] == 'A'){
                sum[0]++;
            }else if(str[high] == 'C'){
                sum[1]++;
            }else if(str[high] == 'G'){
                sum[2]++;
            }else if(str[high] == 'T'){
                sum[3]++;
            }
            low++;
            high++;
            if(sum[0] >= arr[0] && sum[1] >= arr[1] && sum[2] >= arr[2] && sum[3] >= arr[3]){
                ans++;
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}