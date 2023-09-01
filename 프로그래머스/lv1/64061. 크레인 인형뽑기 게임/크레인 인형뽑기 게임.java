/*
    1. N x N 정사각형, board
    2. 크레인 작동시킨 위치 moves
    3. 집은 인형이 2개가 겹칠 때 사라짐, 사라진 인형의 수를 return
*/
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][moves[i]-1] == 0){
                    continue;
                }else{
                    if(stack.empty()){
                        stack.push(board[j][moves[i]-1]);
                    }else if(stack.peek() == board[j][moves[i]-1]){
                        answer++;
                        stack.pop();
                    }else{
                        stack.push(board[j][moves[i]-1]);
                    }   
                    board[j][moves[i]-1]=0;
                    break;
                }
            }
        }
        return answer*2;
    }
}