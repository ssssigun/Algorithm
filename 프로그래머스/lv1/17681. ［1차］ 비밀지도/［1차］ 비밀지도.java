class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        StringBuilder sb = new StringBuilder();
        String temp="";
        for(int i=0;i<arr1.length; i++){
            temp = Integer.toString(arr1[i]|arr2[i], 2);
            temp =temp.replaceAll("1","#");
            temp =temp.replaceAll("0"," ");
            if(temp.length()<n){
                sb.append(" ".repeat(n-temp.length()));
            }
            sb.append(temp);
            answer[i] =sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
}