/*
    1. 단순 구현문제이다.
        - L이면 커서를 왼쪽으로 이동 (단 맨 앞이면 변화 없음)
        - D이면 커서를 오른쪽으로 이동 (단 맨 뒤면 변화 없음)
        - B이면 커서 왼쪽에 있는 문자 삭제 (단 맨 앞이면 변화 없음)
        - P (문자)이면 커서 왼쪽에 추가
        - 커서는 인덱스 번호로 관리
        - 문자열은 StringBuilder로 관리
    2. 첫째 줄에 초기에 저장 되어 있는 문자열이 주어짐
        - 둘째 줄엔 입력할 명령어의 개수 M
        - 셋째 줄부터 M개의 명령어가 주어짐
    3. 명령어를 수행하고 난 뒤 문자열 return
* */

import java.io.*;
import java.util.*;
class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(br.readLine());
        int idx = sb.length();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if(c == 'L' && idx > 0){
                idx--;
            }else if(c == 'D' && idx < sb.length()){
                idx++;
            }else if(c == 'B' && idx > 0){
                sb.deleteCharAt(idx-1);
                idx--;
            }else if(c == 'P'){
                sb.insert(idx, st.nextToken());
                idx++;
            }
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
}