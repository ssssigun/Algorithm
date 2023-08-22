import java.util.*;
public class Main{
    public static void main(String arg[]){
        
        Scanner sc = new Scanner(System.in);
        //조건 받기
        String temp = sc.nextLine();
        String[] temp2 = temp.split(" ");
        int len = Integer.parseInt(temp2[0]);
        String ansP = temp2[1];
        String[] inp = new String[len];
        String answer ="";
        int ans = 0;
        //입력 받기
        for(int i=0; i<len; i++){
            inp[i] = sc.nextLine();
            //정답자 확인
            String[] temp3 = inp[i].split(" ");
            if(ansP.equals(temp3[0])){
                len = i;
                answer = temp3[1];
            }
        }
        //아쉬운 사람 숫자 세기
        for(int i=0; i<len; i++){
            String[] temp4 = inp[i].split(" ");
            if(answer.equals(temp4[1])){
                ans++;
            }
        }
        System.out.println(ans);
    }
}