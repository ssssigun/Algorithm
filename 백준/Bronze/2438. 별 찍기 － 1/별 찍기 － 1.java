import java.io.*;
/*
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                sb.append("*");
            }
            sb.append("\n");
            bw.write(sb.toString());
            sb.setLength(0);
        }
        bw.flush();
    }
}