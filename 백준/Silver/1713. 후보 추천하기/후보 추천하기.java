import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
    1. 추천 받은 횟수, 얼마나 오래 됬는지 두 개가 핵심이다.
        - 두 개의 리스트로 진행하면 될 것 같다. (맵은 순서 정보를 기억할 수 없음)
        - 하나는 추천 받은 사람의 번호를 저장
        - 다른 하나는 추천 받은 수를 저장
        - 인덱스는 들어온 순서를 의미한다.
        - 크기만큼 꽉 차게되면 가장 적은 추천 수 찾기
        - 여러개라면 오래된 숫자를 지우고 추가
        - 마지막엔 sort해서 출력
    2. 첫째 줄엔 사진틀의 개수 N
        - 둘째 줄엔 전체 학생의 총 추천 횟수
        - 셋째 줄엔 추천 받은 학생 목록이 순서대로 주어짐
    3. 최종 후보의 학생 번호를 오름차순으로 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> numList = new ArrayList<>();
        List<Integer> reList = new ArrayList<>();
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 진행
        numList.add(Integer.parseInt(st.nextToken())); // 초기값 넣기
        reList.add(1);
        for(int i=1; i<R; i++){
            int num = Integer.parseInt(st.nextToken());
            if(numList.size() < N){ // 사진틀 갯수만큼 못 채웠을 때
                if(numList.contains(num)){ // 이미 존재하면 추천 수 증가
                    int t = numList.indexOf(num);
                    reList.set(t,reList.get(t)+1);
                }else{ // 그게 아니면 그냥 추가
                    numList.add(num);
                    reList.add(1);
                }
            }else{ // 사진틀만큼 채워졌을 떄
                int min = Collections.min(reList); // 작은 값 구하기
                if(numList.contains(num)){ // 이미 존재하면 추천 수 증가
                    int t = numList.indexOf(num);
                    reList.set(t,reList.get(t)+1);
                }else{ // 그게 아니면 그냥 추가
                    int idx = reList.indexOf(min);
                    numList.remove(idx);
                    reList.remove(idx);
                    numList.add(num);
                    reList.add(1);
                }
            }
        }
        // 정렬 및 출력
        Collections.sort(numList);
        for(int p : numList){
            bw.write(p+" ");
        }
        bw.flush();
    }
}