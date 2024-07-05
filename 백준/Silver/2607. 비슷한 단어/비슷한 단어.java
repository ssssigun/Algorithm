/*
    1. 같은 단어가 몇개인지 확인
        - 같은 종류의 문자가 같은 개수만큼 있어야함
        - 혹은 한 문자를 더하거나 빼거나, 하나의 문자를 다른 문자로 바꾸었을 때 같은 구성이면 비슷한 문자
        - 해시 맵에 넣어서 구성요소를 비교해도 될 것 같다.
    2. 첫째 줄에 단어의 개수
        - 둘째 줄부터 단어 한개씩 주어진다.
        - 단어는 100개 이하
    3. 첫번째 단어와 비슷한 단어의 개수 return
* */

import java.io.*;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0;
        int[] alpha = new int[26];
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            char t = str.charAt(i);
            alpha[t - 'A']++;
        }
        // 단어 확인하기
        for(int i=0; i<N-1; i++){
            String temp = br.readLine();
            int[] alphaCopy = alpha.clone();
            int cnt = 0;
            for(int j=0; j< temp.length(); j++){
                int c = temp.charAt(j) - 'A';
                if(alphaCopy[c] > 0){
                    alphaCopy[c]--;
                }else{
                    cnt++;
                }
            }
            if(str.length() > temp.length()){
                cnt += str.length() - temp.length();
            }
            int diffLeng = Math.abs(temp.length() - str.length());
            if((diffLeng == 0 || diffLeng == 1) && (cnt == 0 || cnt == 1)){
                ans++;
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}