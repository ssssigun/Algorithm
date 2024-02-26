import java.io.*;
import java.util.*;

/*
    1. 백트레킹 문제이다
        - C개 중에 L개 조합 찾기
        - 근데 사전순으로 가능해야함
        - 조건 하나 더 추가하기 (이전 문자보다 아스키 코드값이 커야함)
        - 또한 모음 하나가 꼭 포함되는지 확인
    2. 첫째 줄에 문자 조합 수 L, 문자열의 개수 C가 주어짐
    3. 사전적으로 조합 가능한 모든 암호 return
* */
class Main {
    static char[] arr; // 조합할 문자 배열
    static String[] gather = new String[]{"a", "e", "i", "o", "u"}; // 모음 배열
    static boolean[] visited; // 방문처리 배열
    static int L; // 암호 길이
    static int C; // 암호 문자 후보 수
    static StringBuilder sb = new StringBuilder();
    static List<String> ans = new ArrayList<>(); // 정답 배열

    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        // 암호 조합하기
        back(0);
        // 중복 제거
        Set<String> set = new HashSet<>(ans);
        ans = new ArrayList<>(set);
        Collections.sort(ans);
        // 출력
        for(String s : ans){
            bw.write(s+"\n");
        }
        bw.flush();
    }
    // 백트래킹
    public static void back(int depth){
        if(depth == L){
            int cnt = 0;
            for(int i=0; i<gather.length; i++){
                if(sb.indexOf(gather[i]) >= 0){ // 모음 개수 세기
                    cnt++;
                }
            }
            if(cnt>0 && L-cnt>=2){ // 모음이 1개 이상 포함하면서 자음을 2개 이상 포함할 때 포함
                ans.add(sb.toString());
            }
            return;
        }

        for(int i=0; i<C; i++){
            if(visited[i]){ // 선택한 문자면 지나가기
                continue;
            }
            if(sb.length() == 0){ // 첫 문자를 추가할 때 그냥 추가
                visited[i] = true;
                sb.append(arr[i]);
                back(depth+1);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }else { // 그 이후엔 사전 순으로 추가
                char t = sb.charAt(sb.length()-1);
                if (t < arr[i]) { // 현재 알파벳이 이전 알파벳보다 사전순으로 높을 때 실행
                    visited[i] = true;
                    sb.append(arr[i]);
                    back(depth + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}