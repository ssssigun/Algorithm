class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i=0;i<targets.length;i++){
            
            for(int j=0;j<targets[i].length();j++){
                char c =targets[i].charAt(j);
                int cnt=100;
                
                for(int k =0; k<keymap.length;k++){
                    if(keymap[k].contains(c+"") && keymap[k].indexOf(c+"") < cnt){
                        cnt=keymap[k].indexOf(c+"")+1;
                    }
                }
                if(cnt==100){
                    answer[i]=-1;
                    break;// 하나라도 없으면 -1로 반환해야함
                }           //break 안하면 그냥 -1연산 하게됨
                answer[i]+=cnt;
            }
        }
        return answer;
    }
}