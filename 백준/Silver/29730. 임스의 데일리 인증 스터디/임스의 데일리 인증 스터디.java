/*
    1. 구현문제 (정렬)
        - 백준 링크는 입력 받을 때 따로 분류 (여러 개)
        - 클래스 리스트에 저장
        - 나머지 길이 순서대로 정렬, 같으면 사전순
        - 뒤에 백준 링크 붙이기
        - 백준 링크는 오름차순
    2. 첫째 줄엔 하루의 공부 기록 N개
        - 이후 공부한 목록들이 주어짐
    3. 규칙에 맞게 정렬
        - 길이순, 같으면 사전순
        - 백준 링크는 뒤에
* */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine()); // 공부 N개
        List<String> list = new ArrayList<>(); // 공부 기록 리스트
        List<Integer> boj = new ArrayList<>(); // 백준 따로 저장

        for(int i=0; i<N; i++){ // 입력 받기
            String input = br.readLine();
            if(input.contains("boj.kr/")){ // 백준 링크만 분리
                String[] temp = input.split("/");
                boj.add(Integer.parseInt(temp[1]));
            }else{
                list.add(input);
            }
        }
        Collections.sort(list, new Comparator<String> (){
            @Override
            public int compare(String o1, String o2){
                return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
            }
        }); // 정렬
        Collections.sort(boj); // 백준 문제도 번호순으로 저장

        for(int i=0; i<boj.size(); i++){ // 뒤에 백준 링크 추가
            list.add("boj.kr/" + boj.get(i));
        }
        // 출력
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i)+"\n");
        }
        bw.flush();
    }
}