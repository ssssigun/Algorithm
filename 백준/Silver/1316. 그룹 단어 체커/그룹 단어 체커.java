import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
    1. 문자열 문제
        - 문자열이 연속되어 있으면 그냥 지나간다.
        - 지나온 문자열을 배열에 저장해놓고 처음 문자열이 바뀌었을 때 존재하는 문자열이면 제외
        - 그런거 없이 끝까지 가면 cnt++
    2. 첫째 줄엔 문자열의 갯수 N
        - 둘쨰 줄부터 N개의 문자열
    3. 그룹 단어의 갯수 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++){ // 문자열 입력 받으면서 확인
            boolean flag = true;
            String str = br.readLine();
            List<Character> list = new ArrayList<>();
            char c = str.charAt(0);
            list.add(c);
            for(int j=1; j<str.length(); j++){ // 문자열 확인하기
                char curC = str.charAt(j);
                if(c != curC){
                    if(list.contains(curC)){ // 이전에 확인한 적이 있으면 나가기
                        flag = false;
                        break;
                    }
                    c = curC;
                    list.add(c);
                }
            }
            if(flag){ // 끝까지 마쳤으면 그룹 단어이다
                cnt++;
            }
        }
        // 출력
        bw.write(cnt+"");
        bw.flush();
    }
}