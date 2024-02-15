import java.io.*;

/*
    1. 수학문제로 접근헀는데 어려움이 있어 확인해보니 투 포인터를 활용한 문제이다.
       - 현재 몸무게와 기억하는 몸무게 두개를 가지고 진행
       - 10만의 제곱까지 나오므로 자료형의 주의(long 사용)
    2. 첫째 줄에 G가 주어진다. (G<100000)
    3. 한줄에 하나씩 가능한 몸무게의 수를 return
        - 가능한 몸무게가 없을때는 -1 return
* */
public class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int G = Integer.parseInt(br.readLine());
        long present = 2;
        long remember = 1;
        boolean flag = false;
        // 찾기
        while(present < 100000){
            long preW = present * present;
            long reW = remember * remember;
            if(preW - reW == G){ // 같으면 출력
                bw.write(present+"\n");
                flag = true;
            }
            if(preW - reW >= G){ // 오차가 크면 줄이기
                remember++;
            }else{ // 적으면 늘리기
                present++;
            }
        }
        if(!flag){
            bw.write("-1");
        }
        // 출력
        bw.flush();
    }
}
