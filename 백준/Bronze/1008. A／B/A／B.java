import java.io.*;
import java.util.StringTokenizer;

/*
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());
        bw.write((a/b)+"");
        bw.flush();
    }
}