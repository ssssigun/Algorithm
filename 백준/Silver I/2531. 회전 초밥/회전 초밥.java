import java.io.*;
import java.util.*;

/*
    1. 나올 수 있는 최댓값은 k+1 (쿠폰 번호 초밥이 포함되지 않을 때)
        - k개를 선택해서 중복되는 값이 있나 확인하고 쿠폰 번호가 있는지 확인해서 return 하면 될 것 같다.
    2. 첫째 줄에 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속에서 먹는 접시 수 k, 쿠폰 번호 c
        - 둘째 줄부터는 초밥들이 주어짐
    3. 주어진 회전 초밥벨트에서 먹을 수 있는 초밥의 가짓 수의 최대값 return
* */
public class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0; // 최대값
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 벨트 위 초밥 개수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수(종류)
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수 (선택하는 개수)
        int c = Integer.parseInt(st.nextToken()); // 쿠폰번호
        List<Integer> list = new ArrayList<>();
        List<Integer> select = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        for(int i=0; i<k-1; i++){ // 끝에 k-1개 추가 (겹치는 부분)
            list.add(list.get(i));
        }
        for(int i=0; i<N; i++){
            for(int j=i; j<i+k; j++){ // k개 선택
                select.add(list.get(j));
            }
            Set<Integer> set = new HashSet<>(select); // 중복제거
            int size = set.size();
            if(!set.contains(c)){ // 쿠폰 번호가 포함되지 않을 때
                size++;
            }
            if(ans < size){ // 최대값 갱신
                ans = size;
            }
            select.clear();
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}
