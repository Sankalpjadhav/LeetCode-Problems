class Solution {
    public boolean isValid(int nextI, int nextJ, int N){
        if(nextI>=0 && nextJ>=0 && nextI<N && nextJ<N){
            return true;
        }
        return false;
    }
    
    public double knightProbability(int N, int K, int r, int c) {
        double [][] current = new double[N][N];
        double [][] next = new double[N][N];
        int[][] moves = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { 1, -2 }, { -2, 1 }, { 2, -1 }, { -1, -2 }, { -2, -1 } };
        current[r][c] = 1;
        for(int m=1;m<=K;m++){
            
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(current[i][j]!=0){
                        // 1st method
                        for (int move = 0; move < moves.length; move++) {
							int nr = i + moves[move][0];
							int nc = j + moves[move][1];
							if (isValid(nr,nc,N)){
								next[nr][nc] += current[i][j] / 8.0;
								
							}
						}
                        /*
                        2nd method
                        int nextI = 0;
                        int nextJ = 0;
                        
                        nextI = i-2;
                        nextJ = j+1;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0); 
                        }
                        nextI = i-1;
                        nextJ = j+2;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0); 
                        }
                        nextI = i+1;
                        nextJ = j+2;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0); 
                        }
                        nextI = i+2;
                        nextJ = j+1;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0); 
                        }
                        nextI = i+2;
                        nextJ = j-1;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0); 
                        }
                        nextI = i+1;
                        nextJ = j-2;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0); 
                        }
                        nextI = i-1;
                        nextJ = j-2;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0); 
                        }
                        nextI = i-2;
                        nextJ = j-1;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0); 
                        }
                        */
                    }
                }
            }
            
            current =  next;
            next = new double[N][N];
        }
        double probability = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                probability += current[i][j];
            }
        }
        
        return probability;
    }
}