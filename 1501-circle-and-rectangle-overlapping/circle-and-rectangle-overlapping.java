class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = 0;
        int y = 0;
        if(xCenter<x1){
            x = x1;
        }else if(xCenter >= x1 && xCenter<=x2){
            x = xCenter;
        }else{
            x = x2;
        }

        if(yCenter<y1){
            y = y1;
        }else if(yCenter >= y1 && yCenter<=y2){
            y = yCenter;
        }else{
            y = y2;
        }
        int dx = x-xCenter;
        int dy = y-yCenter;
        return (dx*dx + dy*dy) <= radius*radius;
    }
}