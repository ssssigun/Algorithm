import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    1. 이분 탐색 연습
        - 존재 확인 배열은 정렬하기
        - 확인 배열을 키워드로 하나씩 반복문 진행
        - 이분 탐색을 사용하지 않으면 시간 초과가 날 것 같음
    2. 첫째 줄엔 자연수 N
        - 둘째 줄엔 N개의 정수
        - 셋째 줄엔 M
        - 넷째 줄엔 M개의 정수
    3. 넷째 줄에 정수에서 둘째 배열에서 수가 존재하면 1, 없으면 0 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] findArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            findArr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(findArr); // 정렬
        // 숫자가 존재하는지 찾기
        for(int i=1; i<=M; i++){
            int num = arr[i];
            int low = 0;
            int high = N-1;
            int mid = 0;
            boolean flag = false;
            while(low <= high){ // 이분 탐색
                mid = (low+high)/2;
                if(findArr[mid] == num){
                    flag = true;
                    break;
                }else if(findArr[mid] > num){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            if(flag){ // 존재함
                bw.write("1\n");
            }else{ // 존재하지 않음
                bw.write("0\n");
            }
        }
        // 출력
        bw.flush();
    }
}