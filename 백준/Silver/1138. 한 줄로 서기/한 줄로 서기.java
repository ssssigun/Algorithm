import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
    1. 뒤에 수부터 하나씩 추가하기
        - ex) N = 6이면 6은 순서 상관없이 자기보다 큰 수가 없으므로 먼저 추가
        - 이후 하나씩 내리면서 앞에 큰 수가 있는대로 위치 추가
        - 그 후 리스트 return
    2. 첫째 줄에 사람의 수 N
        - 둘째 줄부터 자기보다 키 큰 사람이 왼쪽에 몇명 있었나 주어짐
    3. 줄은 선 키 대로 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new LinkedList<>();
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] se = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            se[N-i] = Integer.parseInt(st.nextToken());
        }
        // 줄 순서 만들기
        for(int i=0; i<se.length; i++){
            list.add(se[i], N);
            N--;
        }
        // 출력
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i) + (i == list.size()-1 ? "" : " "));
        }
        bw.flush();
    }
}