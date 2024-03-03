import java.io.*;
import java.util.*;

/*
    1. 만식어 정렬하기
        - a b k d e g h i l m n ng o p r s t u w y 순서이다
        - k와 ng만 다르므로 각각  k -> c, ng -> n~로 변환해서 정렬해주고 다시 변경해준다.
        - 단어의 갯수와 길이 둘 다 최대 50이므로 시간 복잡도는 널널할 듯 하다
    2. 첫째 줄에 만식어의 갯수 N
        - 둘째 줄부터 단어가 주어짐
    3. 만식어 순서대로 정렬해서 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr  = new String[N];// 단어 저장용 배열
        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(str.contains("k")){
                str = str.replace("k", "c");
            }
            if(str.contains("ng")){
                str = str.replace("ng", "n~");
            }
            arr[i] = str;
        }
        // 정렬하기
        Arrays.sort(arr);
        // 원래대로 변경하기
        for(int i=0; i<N; i++){
            if(arr[i].contains("c")){
                arr[i] = arr[i].replace("c", "k");
            }
            if(arr[i].contains("n~")){
                arr[i] = arr[i].replace("n~", "ng");
            }
        }
        // 출력
        for(int i=0; i<N; i++){
            bw.write(arr[i]+"\n");
        }
        bw.flush();
    }
}