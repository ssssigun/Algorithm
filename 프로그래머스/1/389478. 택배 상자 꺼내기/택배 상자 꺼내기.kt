class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 0
        var row: Int = 0
        var col: Int = 0
        // 배열 생성
        val arr = MutableList(n/w+1) {row -> MutableList(w){col-> (row*w) +col+ 1}}
        // 배열 뒤집기
        for(i in arr.indices){
            if(i%2 != 0){
                arr[i].reverse()
            }
        }
        // 값찾기
        for(i in arr.indices){
            for(j in arr[i].indices){
                if(arr[i][j] == num){
                    row = i
                    col = j
                }
            }
        }
        // 깊이 계산
        answer = arr.size - row
        if(arr[arr.size-1][col] > n){
            return answer - 1
        }
        return answer
    }
}