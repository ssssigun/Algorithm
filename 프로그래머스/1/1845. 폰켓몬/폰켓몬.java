import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        LinkedHashSet<Integer> list = new LinkedHashSet();
        for(int i=0;i<nums.length; i++){
            list.add(nums[i]);
        }
        if(list.size() > nums.length/2 ){
            answer = nums.length/2;
        }else{
            answer = list.size();
        }
        return answer;
    }
}