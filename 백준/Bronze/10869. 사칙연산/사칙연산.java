import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int fNum = Integer.parseInt(st.nextToken());
    	int sNum = Integer.parseInt(st.nextToken());
    	bw.write(fNum + sNum +"\n");
    	bw.write(fNum - sNum +"\n");
    	bw.write(fNum * sNum +"\n");
    	bw.write(fNum / sNum +"\n");
    	bw.write(fNum % sNum +"\n");
    	bw.flush();
    }
}