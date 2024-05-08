import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
    1.
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Double> map = new HashMap<>();
        // 성적 입력
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        double div = 0;
        double ans = 0;
        // 입력 받기
        for(int i=0; i<20; i++){
            String[] temp = br.readLine().split(" ");
            if(temp[2].equals("P")){
                continue;
            }
            double sc = Double.parseDouble(temp[1]);
            ans += sc * map.get(temp[2]);
            div += sc;
        }
        ans /= div;
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}