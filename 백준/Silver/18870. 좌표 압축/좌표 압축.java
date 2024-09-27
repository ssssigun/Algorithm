/*
    1. 구현문제인 것 같다.
        - 본인보다 작은 수 개수로 압축
        - set으로 중복 제거
        - 오름차순 정렬 후 인덱스가 값이 압축 값
        - 해시맵에 넣고 필요 숫자만 return
    2. 첫째 줄엔 N
        - 둘째 줄엔 공백으로 구분된 숫자 N개
    3. 압축 문자를 순서대로 return
* */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> set = new HashSet<>(list);
        List<Integer> listC = new ArrayList<>(set);
        Collections.sort(listC);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<listC.size(); i++){
            map.put(listC.get(i), i);
        }
        // 출력
        for(int i=0; i<N; i++){
            bw.write(map.get(list.get(i))+" ");
        }
        bw.flush();
    }
}