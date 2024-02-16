import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    1. 투포인터 문제이다
        - 순서는 상관 없으므로 정렬해서 진행
        - 두 마리를 채우면서 무게가 넘지 않으면 행복한 사람++;
    2. 첫째 줄 정수 N(고양이 수)과 K(무게의 합)
        - 둘째 줄부터 각 고양이의 무게 N개
    3. 행복해지는 사람의 최댓갑 return
* */
public class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr); // 정렬
        int left = 0;
        int right = N - 1;
        while(left < right){
            long sum = arr[left] + arr[right];
            if(sum > K){ // 무게 초과
                right--;
            }else{ // 무게 이하
                right--;
                left++;
                ans++;
            }
        }
        // 결과 출력
        bw.write(ans+"");
        bw.flush();
    }
}
