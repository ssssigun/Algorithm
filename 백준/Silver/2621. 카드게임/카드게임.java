/*
    1. 많은 조건의 구현 문제이다. (많이 헤맸다..)
        - 조건에 순서에 따라 구현
        - 숫자가 연속적인지 확인
        - 숫자의 중복 갯수 확인
        - 컬러의 중복 갯수 확인
        - 여러가지 조건에 부합하면 점수가 높은 점수를 return
            - 근데 점수 차이가 커서 조건 우선순위대로 구현하면 문제 없을듯 (else if)
    2. 첫째 줄부터 다섯째 줄까지 한 줄에 카드 하나씩 입력
    3. 가장 높은 카드 점수 return
* */

import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] colorList = new String[5]; // 컬러 배열
        int[] numList = new int[5]; // 숫자 배열
        int colorCount = 1; // 같은 색 카운트
        int[] numCount = new int[10]; // 같은 숫자 카운트 1~9
        // 입력 받기
        for(int i=0; i<5; i++){
            String[] card = br.readLine().split(" ");
            int num = Integer.parseInt(card[1]);
            numList[i] = num;
            colorList[i] = card[0];
            if(i>=1 && colorList[i-1].equals(colorList[i])){ // 같은 색, 숫자 카운트
                colorCount++;
            }
            numCount[num]++;
        }
        Arrays.sort(numList); // 연속 확인을 위해 오름차순 정렬
        int continuedNumCnt = 1; // 연속적인지 카운트하는 변수
        for(int i=0; i<5; i++){
            if(i>=1 && numList[i] == numList[i-1] + 1){
                continuedNumCnt++;
            }
        }
        // 같은 숫자 계산 코드
        int fourSameNum = 0;
        int threeSameNum = 0;
        int twoSameNum = 0;
        int twoOtherSameNum = 0;
        for(int i=1; i<=9; i++){
            if(numCount[i] == 4){
                fourSameNum = i;
                break; // 같은 숫자가 4개이면 나머지 조건은 될 수 없음
            }else if(numCount[i] == 3){
                threeSameNum = i;
            }else if(numCount[i] == 2){
                if(twoSameNum ==0){
                    twoSameNum = i;
                }else{
                    twoOtherSameNum = i;
                }
            }
        }
        // 점수 조건대로 실행
        // 점수를 정하는 규칙대로 실행
        int max = numList[4]; // 가장 높은 숫자
        int score; // 점수
        if (colorCount == 5 && continuedNumCnt == 5) { // 1번 규칙
            score = max + 900;
        } else if (fourSameNum > 0) { // 2번 규칙
            score = fourSameNum + 800;
        } else if (threeSameNum > 0 && twoSameNum > 0) { // 3번 규칙
            score = threeSameNum * 10 + twoSameNum + 700;
        } else if (colorCount == 5) { // 4번 규칙
            score = max + 600;
        } else if (continuedNumCnt == 5) { // 5번 규칙
            score = max + 500;
        } else if (threeSameNum > 0) { // 6번 규칙
            score = threeSameNum + 400;
        } else if (twoSameNum > 0 && twoOtherSameNum > 0) { // 7번 규칙
            score = Math.max(twoSameNum, twoOtherSameNum) * 10 + Math.min(twoSameNum, twoOtherSameNum) + 300;
        } else if (twoSameNum > 0) { // 8번 규칙
            score = twoSameNum + 200;
        } else { // 9번 규칙
            score = max + 100;
        }
        // 출력
        bw.write(score+"");
        bw.flush();
    }
}