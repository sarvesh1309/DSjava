package com.practice.string;

public class FindAllSquareSurroundedBySea {
	
	public int FindSquaresSurroundedBySea(int[][] array){
		int length = array.length;
		int [][]visited = new int[length][length];
		int count =0;
		for(int i =0;i<length;i++){
			for(int j=0;j<length;j++){
				// find whether there is a safe path from this land squares to outside 
				if(array[i][j]==1 && FindLandSquaresSurroundedBySeaHelper(array,visited,i,j)){
					count++;
                     }
				}
			}
		return count;
	}

	private boolean FindLandSquaresSurroundedBySeaHelper(int[][] array, int[][] visited,int row,int col){
	   // if this node is already visited then we do not have backtrack in that direction .Thus return true
         if(visited[row][col]==1){
         	return true;
         }
         // currnt node is sea and it is not visited then return true
         if(array[row][col]==0){
         	return true;
         }
        // current square is at border  means is is not surrounded by sea so return false 
        if(row==0 || (row==array.length-1) || col ==0 || (col==array.length-1)){
			return false;
		}
		boolean isSurroundedBySea = false;
		visited[row][col]= 1;
		// if all four direction of current square is sea then it implies that currnet land square is surrounded by sea 
		isSurroundedBySea = (row>0?FindLandSquaresSurroundedBySeaHelper(array,visited,row-1,col):false)&&
                             (row<(array.length-1)?FindLandSquaresSurroundedBySeaHelper(array,visited,row+1,col):false)&&
                             (col>0?FindLandSquaresSurroundedBySeaHelper(array,visited,row,col-1):false)&&
                             (col<(array.length-1)?FindLandSquaresSurroundedBySeaHelper(array,visited,row,col+1):false);
        visited[row][col]= 0;
        return isSurroundedBySea;

	}

}
