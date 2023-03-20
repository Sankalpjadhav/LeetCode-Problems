class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int temp = n;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] == 0){
                if(i == 0 || flowerbed[i-1] == 0){
                    if(i == flowerbed.length-1 || flowerbed[i+1] == 0){
                        flowerbed[i] = 1;
                        temp--;
                        i++;
                    }
                }
            }
        }
        
        return temp <= 0 ? true : false;
    }
}