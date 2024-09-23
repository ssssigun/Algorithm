/*
    1. 오랜만에 N과 M 시리즈 (백트래킹)
        - N개 자연수 중에 M개를 골아야함 (중복 가능)
        - 재귀로 탐색하면서 M개를 고르고 리스트에 저장
        - 중복 제거를 set이 아닌 해쉬 맵으로 처리
        - 출력
    2. 첫째 줄에 N과 M이 주어짐
        - 둘째 줄엔 N개의 수가 주어진다.
    3. 조건에 만족하는 수열 오름차순 return
* */

import java.io.*;
import java.util.*;

class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> arr= new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr = new ArrayList<>(set);
        Collections.sort(arr);
        back(0, arr, M, ""); // 백트래킹으로 숫자 구하기
        // 출력
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i));
            if(i != list.size()-1){
                bw.write("\n");
            }
        }
        bw.flush();
    }
    // 재귀
    public static void back(int cnt, List<Integer> arr, int M, String str){
        if(M == cnt){
            list.add(str.substring(0, str.length()-1));
            return;
        }
        for(int i=0; i<arr.size(); i++){
            back(cnt+1, arr, M, str+arr.get(i)+" ");
        }
    }
}