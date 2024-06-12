import java.io.*;
import java.util.*;

/*
    1. 단순 구현 문제이다.
        - 이동 방향을 맵으로 정의해서 입력 받자마자 값을 이어 받는다. (str, int[])
        - 대각 방향은 두개를 합친 값이다.
        - 리턴 받은 값으로 킹의 위치를 이동한다.
        - 단, 돌의 위치일 때 똑같은 방향으로 돌을 이동시킨다.
        - 주의할 점은 원점이 왼쪽 위가 아니라 "왼쪽 아래"이다.
        - 또한 체스판이 나갈 경우 그 이동은 건너 뛴다.
    2. 첫째 줄에 킹의 위치, 돌의 위치, 움직이는 횟수 N
        - 둘째 줄부터 N개의 줄에는 이동방향이 주어짐
    3. 킹의 마지막 위치와 돌의 마지막 위치를 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> charToInt = new HashMap<>(Map.of('A', 1, 'B', 2, 'C', 3, 'D', 4, 'E', 5, 'F', 6, 'G', 7, 'H',8));
        Map<Integer, Character> intToChar = new HashMap<>(Map.of(1,'A', 2,'B', 3,'C', 4, 'D', 5,  'E', 6,'F', 7, 'G', 8,'H'));
        // 방향 정보 맵
        Map<Character, int[]> map = new HashMap<>(Map.of('R', new int[]{0, 1}, 'L',new int[]{0, -1}, 'B', new int[]{-1, 0}, 'T', new int[]{1, 0}));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        String k = st.nextToken();
        String s = st.nextToken();
        int[] kingPos = {k.charAt(1) - '0', charToInt.get(k.charAt(0))}; // 킹의 위치
        int[] stonePos = {s.charAt(1) - '0', charToInt.get(s.charAt(0))}; // 돌의 위치
        int N = Integer.parseInt(st.nextToken());
        // 입력 받으면서 이동
        for(int i=0; i<N; i++){
            String move = br.readLine();
            int[] m = new int[]{0,0};
            for(int j=0; j<move.length(); j++){ // 이동방향 연산
                int[] t = map.get(move.charAt(j));
                m[0] += t[0];
                m[1] += t[1];
            }
            kingPos[0] += m[0];
            kingPos[1] += m[1];
            if(ch(kingPos[0], kingPos[1])){ // 킹이 체스판을 나가면 이동 무효
                kingPos[0] -= m[0];
                kingPos[1] -= m[1];
                continue;
            }
            if(stonePos[0] == kingPos[0] && stonePos[1] == kingPos[1]){ // 돌에 위치로 이동하면 돌도 같은 방향으로 이동
                stonePos[0] += m[0];
                stonePos[1] += m[1];
                if(ch(stonePos[0], stonePos[1])){ // 돌이 체스판을 나가면 이동 무효
                    kingPos[0] -= m[0];
                    kingPos[1] -= m[1];
                    stonePos[0] -= m[0];
                    stonePos[1] -= m[1];
                }
            }
        }
        // 다시 파싱해서 출력
        StringBuilder sb = new StringBuilder();
        sb.append(intToChar.get(kingPos[1])).append(kingPos[0]).append("\n");
        sb.append(intToChar.get(stonePos[1])).append(stonePos[0]);
        bw.write(sb.toString());
        bw.flush();
    }
    public static boolean ch(int a, int b){ // 체스판을 나갔는지 검사하는 함수
        return a<1 || a>8 || b<1 || b>8;
    }
}