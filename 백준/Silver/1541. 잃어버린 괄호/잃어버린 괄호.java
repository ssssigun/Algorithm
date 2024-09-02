/*
    1. 그리디 문제인 것 같다.
        - 플러스 연산은 직전 값과 더해준다.
        - 마이너스 연산은 따로 나눠놓고 나중에 연산한다.
    2. 첫째 줄에 연산자와 숫자들이 주어짐
    3. 괄호를 쳐서 식의 최솟값 return
* */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        String f = br.readLine();
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int idx = 0;
        for(int i=0; i<f.length(); i++){
            char cur = f.charAt(i);
            if('0' <= cur && cur <= '9'){ // 숫자면 입력 받기
                sb.append(cur);
            }else{ // 부호이면 확인
                int num = Integer.parseInt(sb.toString());
                sb.setLength(0); // 초기화
                list.set(idx, list.get(idx) + num); // 더해주기
                if(cur == '-'){ // 다음 연산이 마이너스라면 추가
                    list.add(0);
                    idx++;
                }
            }
        }
        int num = Integer.parseInt(sb.toString());
        list.set(idx, list.get(idx) + num);
        int ans = list.get(0);
        for(int i=1; i<list.size(); i++){ // 리스트 값 빼주기
            ans -= list.get(i);
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}