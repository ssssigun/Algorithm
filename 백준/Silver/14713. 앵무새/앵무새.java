/*
    1. 각각의 문장의 단어들을 조합하는 문제
        - 큐 리스트로 가능할 것 같다.
        - 가능하면 Possible
        - 불가능하면 Impossible
    2. 첫번째 줄에 앵무새의 수 N
        - 두번째 줄부터 N개 줄에는 앵무새가 말하는 문장
        - 마지막 줄엔 완성될 문장
    3. 가능하면 Possible, 불가능하면 Impossible return
* */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        Queue<String>[] que = new LinkedList[N];
        for(int i=0; i<N; i++){
            que[i] = new LinkedList<>(){};
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<temp.length; j++){
                que[i].offer(temp[j]);
            }
        }
        String[] target = br.readLine().split(" ");
        boolean check = false;
        for(String str : target){
            boolean flag = false;
            for(int i=0; i<N; i++){ // 큐 리스트 순회
                if(str.equals(que[i].peek())){ // 문장을 만들 수 있는 지 확인
                    que[i].poll();
                    flag = true;
                    break;
                }
            }
            if(!flag){ // 큐 리스트를 다 돌았는데 만들지 못하면 반복문을 나감
                check = true; // 중간에 나가면 못 만드는 문장이므로 체크
                break;
            }
        }
        // 이 조건 때문에 많이 헤맸다...
        if(!check){ // 큐 리스트에 남은 단어가 있으면 틀림
            for(int i=0; i<N; i++){
                if(!que[i].isEmpty()){
                    check = true;
                    break;
                }
            }
        }
        // 출력
        bw.write(check ? "Impossible" : "Possible");
        bw.flush();
    }
}