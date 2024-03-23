class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length(); i++){
            int temp = s.charAt(i);
            if(temp==' '){
                sb.append(" ");
                continue;
            }
            if(temp>='a' && temp<='z'){
                if(temp+n >'z'){
                    temp -= 'z' - 'a'+1;
                    sb.append((char)(temp+n));
                }else{
                    sb.append((char)(temp+n));
                }
            }else if(temp>='A' && temp<='Z'){
                if(temp+n > 'Z'){
                    temp -= 'z' - 'a'+1;
                    sb.append((char)(temp+n));
                }else{
                    sb.append((char)(temp+n));
                }
            }

        }
        answer = sb.toString();
        return answer;
    }
}