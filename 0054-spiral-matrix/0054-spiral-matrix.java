class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix==null || matrix.length<1 || matrix[0].length<1){
            return result;
        }
        int startRow=0,startColumn=0;
        int endRow=matrix.length-1,endColumn=matrix[0].length-1;
        
        while(startRow<=endRow && startColumn<=endColumn){
            for(int col=startColumn;col<=endColumn;col++){
                result.add(matrix[startRow][col]);
            }
            startRow++;
            for(int row=startRow;row<=endRow;row++){
                result.add(matrix[row][endColumn]);
            }
            endColumn--;
            if(startRow<=endRow){
                for(int col=endColumn;col>=startColumn;col--){
                    result.add(matrix[endRow][col]);
                }
                endRow--;
            }
            if(startColumn<=endColumn){
                for(int row=endRow;row>=startRow;row--){
                    result.add(matrix[row][startColumn]);
                }
                startColumn++;
            }
        }
        return result;
    }
}