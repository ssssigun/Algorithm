class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int Xmax=0,Ymax=0;
        int Xmin = wallpaper.length, Ymin = wallpaper[0].length();
        for(int i=0; i<wallpaper.length;i++){
            int YminCur = wallpaper[i].indexOf("#");
            int YmaxCur =wallpaper[i].lastIndexOf("#");
            if(YminCur==-1){continue;}
            if(Xmax<i){Xmax=i;}
            if(Ymax<YmaxCur){Ymax=YmaxCur;}
            if(Xmin>i){Xmin=i;}
            if(Ymin>YminCur){Ymin=YminCur;}
        }
        return answer= new int[]{Xmin, Ymin,++Xmax,++Ymax};
    }
}