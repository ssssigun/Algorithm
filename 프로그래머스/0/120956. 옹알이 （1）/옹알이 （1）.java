class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] bb = {"aya", "ye", "woo", "ma"};
        for(int i=0;i<babbling.length; i++){
            for(int j=0;j<bb.length;j++){
                babbling[i]= babbling[i].replaceFirst(bb[j]," ");
            }
            System.out.println(babbling[i]);
            if(babbling[i].trim().equals("")){
                answer++;
            }
        }
        return answer;
    }
}