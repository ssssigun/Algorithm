import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
    1. 문자열 처리 문제이다.
        - 실행 함수를 저장
        - 입력 배열을 분리해서 숫자 저장
        - 실행 함수대로 실행하기
        - 뒤집기 함수는 reverse를 이용하면 시간초과가 난다
        - 따라서 포인터처럼 인덱스 값을 변경하면서 지우기
        - 그리고 마지막에만 뒤집어져있는지 확인해서 뒤집어서 출력하기
        - 단 배열이 비어있을 때 D를 사용한다면 error return
    2. 첫째 줄엔 테스트 케이스의 개수 T
        - 테스트 케이스 첫번째 입력은 수행할 함수 p
        - 두번째는 배열 안에 수의 개수 n
        - 마지막으로 [1,2,3]과 같은 형태의 배열이 주어진다.
    3. 함수 실행 결과를 return (error도 출력 가능)
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){ // 시작
            List<Integer> list = new ArrayList<>(); // 배열을 담을 리스트
            String func = br.readLine(); // 실행 함수 저장
            int n = Integer.parseInt(br.readLine()); // 배열 안에 숫자 수 저장
            String[] tempArr = br.readLine().split(","); // 배열 저장
            boolean err = false; // 에러 체크 변수
            int idx = 0; // 삭제 포인터 위치
            // 입력 배열 변환해서 리스트에 담기
            for(String temp : tempArr){
                if(n == 0){ // 입력 배열이 없을 떄는 제외
                    break;
                }
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<temp.length(); j++){
                    char t = temp.charAt(j);
                    if(Character.isDigit(t)){
                        sb.append(t);
                    }
                }
                list.add(Integer.parseInt(sb.toString()));
            }
            // 함수 실행하기
            for(int j=0; j<func.length(); j++){
                char t = func.charAt(j);
                if(t == 'R'){ // 배열 뒤집기 함수일 때
                    if(idx == 0){ // 처음이면 끝으로 이동
                        idx = list.size()-1;
                    }else{ // 끝이면 처음으로 이동
                        idx = 0;
                    }
                }else if(t == 'D'){ // 배열 삭제 함수일 때
                    if(list.isEmpty()){ // 비어 있으면 에러 처리
                        err = true;
                        break;
                    }else{ // 그게 아니면 포인터 위치 문자 버리기
                        list.remove(idx);
                        if(idx > 0){ // 앞 위치가 아니면 삭제해주고 포인터 이동
                            idx--;
                        }
                    }
                }
            }
            // 실행 결과 문자열에 담기
            if(err){
                bw.write("error\n");
            }else{
                StringBuilder sb = new StringBuilder("[");
                if(idx > 0){ // 뒤집어져 있는 상태이면 그렇게 변경해주기
                    Collections.reverse(list);
                }
                for(int j=0; j<list.size(); j++){
                    sb.append(list.get(j));
                    if(j != list.size()-1){ // 마지막 수만 컴마 빼기
                        sb.append(",");
                    }
                }
                sb.append("]\n");
                bw.write(sb.toString());
            }
        }
        // 출력
        bw.flush();
    }
}