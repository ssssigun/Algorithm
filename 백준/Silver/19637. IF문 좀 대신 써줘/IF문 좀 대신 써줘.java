/*
    1. 구현 문제인 줄 알았는데 이분 탐색 같음 (순차로 탐색하면 시간 초과)
        - 칭호를 리스트에 저장
        - low를 처음 high를 마지막 범위로 저장
        - low보다 낮거나 high보다 높으면 칭호 출력
        - 그게 아니면 미들값을 구해서 확인
        - mid-1 ~ mid에 포함 되는 값이면 칭호 return
    2. 첫째 줄에 칭호의 개수 N, 캐릭터의 개수 M
        - 둘째 줄부터 N개만큼 칭호의 정보가 주어짐 (이름, 전투력)
        - 이후 M개의 캐릭터 정보가 주어짐
    3. M개의 캐릭터를 칭호에 맞게 return
* */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Title{
    String name;
    int boundary;
    Title(String name, int boundary){
        this.name = name;
        this.boundary = boundary;
    }

}

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Title> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int boundary = Integer.parseInt(st.nextToken());
            if(i == 0){
                list.add(new Title(name, boundary));
            }else{ // 이후 범위가 중복되면 덮어쓰기
                if(list.get(i-1).boundary == boundary){
                    list.add(new Title(list.get(i-1).name, boundary));
                }else{
                    list.add(new Title(name, boundary));
                }
            }
        }
        for(int i=0; i<M; i++){
            int low = 0;
            int high = N-1;
            int player = Integer.parseInt(br.readLine());
            if(list.get(low).boundary >= player){ // 범위의 최소값보다 낮으면 리턴
                bw.write(list.get(0).name + "\n");
                continue;
            }else if(list.get(high).boundary <= player){ // 범위의 최대값보다 크면 리턴
                bw.write(list.get(N-1).name + "\n");
                continue;
            }
            while (low < high) { // 이분 탐색
                int mid = (high + low) / 2;
                Title midT = list.get(mid);
                if(midT.boundary < player){
                    low = mid +1;
                }else{
                    high = mid;
                }
            }
            bw.write(list.get(low).name+"\n");
        }
        // 출력
        bw.flush();
    }
}