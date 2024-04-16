import java.io.*;

/*
    1. 브루트포스 알고리즘 문제이다.
        - 입력 숫자가 10000이므로 숫자를 하나씩 올리면서 확인해도 될 것 같다.
        - 6이 연속으로 들어가면 ans++하고 원하는 값이면 return
    2. 입력은 순서 N
    3. N번째에 오는 영화제목 return (N번째로 작은 종말의 수)
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int endNum = 665;
        boolean run = true;
        while(run){
            endNum++;
            String temp = endNum+"";
            int cnt = 0;
            for(int i=0; i<temp.length(); i++){ // 연속된 부분이 있는지 확인
                if(temp.charAt(i) == '6'){
                    cnt++;
                }else{
                    cnt = 0;
                }
                if(cnt==3){
                    ans++;
                    if(ans == N){
                        bw.write(temp);
                        run = false;
                        break;
                    }
                    break;
                }
            }
        }
        // 출력
        bw.flush();
    }
}