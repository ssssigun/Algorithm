/*
    1. 게임 만족 조건
        - 한번에 한 원판만 이동
        - 큰 원판이 작은 것보다 위에 있으면 안됨
        - 1번 원판에서 3번 원판으로 이동하는 최소 횟수
    2. 이동할 원판의 갯수 n개
        - retrun 1 -> 3 최소로 이동하는 방법
        - retrun 배열은 이동 기둥 기준
          a. ex) [2,3] 2->으로 이동했다.
    3. 스택인줄 알았으나 대표적인 재귀함수 문제이다
        - 원판의 갯수, 출발,경유지, 도착점을 입력 받는 hanoi 메서드 생성
        - 1개는 바로 옮기면 되므로 예외 처리
        - 나머지는 경유지로 먼저 옮기기 (재귀 함수) 1
        - 그리고 다시 경유지에서 목적지로 이동
*/
import java.util.*;
class Solution {
    static List<int[]> list = new ArrayList();
    public List<int[]> solution(int n) {
        int[][] answer = {};
        hanoi(n,1,3,2);
        return list;
    }
    public static void hanoi(int n, int start, int end, int mid){
        int[] move ={start, end};
        if(n==1){
            list.add(move);
        }else{
            hanoi(n-1,start,mid,end);
            list.add(move);
            hanoi(n-1,mid,end,start);
        }
    }
}