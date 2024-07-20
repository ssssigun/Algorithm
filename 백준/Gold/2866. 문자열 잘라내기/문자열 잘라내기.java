/*
    1. 문제를 이해하는데 오래 걸렸지만 문자열 + 이분 탐색이다.
        - 먼저 문자열을 생성하기
        - 이분 탐색을 하면서 같은 것이 있나 확인
        - 있으면 cnt return
        - 없으면 카운트 하고 앞 문자 자르기
    2. 테이블의 행 R, 열 C
        - 이후 테이블 정보가 주어짐
    3. 카운트 값 return
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] str = new String[R];
        for(int i=0; i<R; i++){
            str[i] = br.readLine();
        }
        // 문자열 생성하기
        String[] arr = new String[C];
        Arrays.fill(arr,"");
        for(int i=0; i<C; i++){
            for(int j=1; j<R; j++){
                arr[i] += str[j].charAt(i)+"";
            }
        }
        int cnt = 0;
        for(int k=1; k<R; k++){ // 없어질 때까지 돌리기
            Arrays.sort(arr); // 문자열 정렬
            boolean flag = false; // 중복이 하나라도 있는지 확인
            for(int i=0; i<arr.length; i++){ // 문자열 중복 검사
                String c = arr[i];
                int low = 0;
                int high = arr.length - 1;
                while(low < high){
                    int mid = (high + low) / 2;
                    if(i != mid && arr[mid].equals(c)){
                        flag = true;
                        break;
                    }else{
                        if(c.compareTo(arr[mid]) > 0){
                            low = mid +1;
                        }else{
                            high = mid;
                        }
                    }
                }
                if(flag){ // 중복이 있으면 검사 중단하고 나가기
                    break;
                }
            }
            if(flag){ // 중복이 있으면 카운트 반환
                bw.write(cnt+"");
                bw.flush();
                return;
            }else{ // 그게 아니면 cnt 추가
                cnt++;
            }
            for(int i=0; i<arr.length; i++){
                arr[i] = arr[i].substring(1);
            }
        }
        bw.write(cnt+"");
        bw.flush();
    }
}