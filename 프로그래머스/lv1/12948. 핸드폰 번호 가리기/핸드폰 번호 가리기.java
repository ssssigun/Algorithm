class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int prevNum = phone_number.length()-4;
        for(int i=0;i<prevNum;i++){
            answer+="*";
        }
        return answer+phone_number.substring(prevNum);
    }
}