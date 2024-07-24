/*
    1. 문자열 처리 문제
        - 자음 모음 리스트를 구분해서 선언한다.
        - 모음 리스트는 +3, 자음 리스트는 +10 크기를 추가 (앞에 문자열이 반복하도록)
        - 대문자인지 소문자인지 판별하고 소문자로 전부 변경, 대문자는 표시만 해놓기
        - 자음인지 모음인지 판별하고 해당 리스트에서 본인 것을 찾는다.
        - 모음은 인덱스 +3, 자음은 인덱스 + 10 인 문자를 저장한다.
    2. 변경한 문자열 제공
* */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 모음 리스트
        List<Character> list1 = new ArrayList<>(List.of('a', 'i', 'y', 'e', 'o', 'u', 'a', 'i', 'y'));
        // 자음 리스트
        List<Character> list2 = new ArrayList<>(List.of('b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f', 'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g'));
        // 입력 받기
        StringBuilder sb = new StringBuilder();
        while(br.ready()){
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char t = str.charAt(i);
                boolean flag = false;
                if (Character.isUpperCase(t)) { // 대문자이면 소문자로 변경
                    flag = true;
                    t = Character.toLowerCase(t);
                }
                if (list1.contains(t)) { // 모음일 경우
                    char temp = list1.get(list1.indexOf(t) + 3);
                    if (flag) { // 대문자였으면 대문자로 변환
                        temp = Character.toUpperCase(temp);
                    }
                    sb.append(temp);
                } else if (list2.contains(t)) { // 자음일 겨우
                    char temp = list2.get(list2.indexOf(t) + 10);
                    if (flag) { // 대문자였으면 대문자로 변환
                        temp = Character.toUpperCase(temp);
                    }
                    sb.append(temp);
                } else { // 공백이나 마침표의 경우 그냥 출력
                    sb.append(t);
                }
            }
            sb.append("\n");
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
}