/*
    1. 우선순위 큐 문제이다.
    2. 입력은 중요도가 담긴 배열 priorities, 실행 순서를 알고싶은 위치 location
    3. location이 몇번째로 실행 되는지 return
*/
import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] priorities, int location) {
        // 선언
        int ans = 0;
        // 우선순위 큐 (내림 차순)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 요소 추가
        for (int i : priorities) {
            queue.offer(i);
        }

        // 순서 찾기
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    ans++;
                    if (location == i) { // 현재 작업이 location과 같으면 answer 반환
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}
