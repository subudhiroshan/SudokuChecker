/**
 * Author: Roshan C Subudhi
 * USC, Columbia
 * Ph: 803-743-2899
 * 
 * This class validates the correctness of a Sudoku Solution.
 */

public class SudokuChecker {

	
	int[][] grid = new int[9][9];
	
	public SudokuChecker(int[][] temp) {
		for (int i=0; i<grid.length; i++){
			for (int j=0; j<grid.length; j++){
				grid[i][j] = temp[i][j];
			}
		}
			
	}

	public void drawGrid() {
		System.out.println(" # # # # # # # # # # # # # # # # # # #");
		for (int i=0; i<grid.length; i++){
			System.out.print(" # " );
			for (int j=0; j<grid.length; j++){
				System.out.print(grid[i][j]);
				if (((j+1)%3) == 0){
					System.out.print(" # ");
				}else{
					System.out.print(" | ");					
				}
			}
			if (((i+1)%3) == 0){
				System.out.println("\n # # # # # # # # # # # # # # # # # # #");
			}else{
				System.out.println("\n  --- --- --- --- --- --- --- --- ---");
			}
		}
	}

	public boolean has1to9(StringBuilder str) {
		int sum = 0;
		if (!(str.length() == 9)) return false;
		for (int i=0; i<str.length(); i++){
			sum+= Integer.parseInt(str.substring(i, i+1));
		}
		if (sum == 45){
			return true; // if all 1-9 numbers are present, only then is sum 45
		}else{
			return false;
		}
	}

	public boolean rows() {
		for (int i=0; i<grid.length; i++){
			StringBuilder rowContents = new StringBuilder();
			for (int j=0; j<grid.length; j++){
				rowContents.append(grid[i][j]);
			}
			if (!has1to9(rowContents)){
				return false;
			}else{
				continue;
			}
		}
		return true;
	}
	
	public boolean columns() {
		for (int j=0; j<grid.length; j++){
			StringBuilder colContents = new StringBuilder();
			for (int i=0; i<grid.length; i++){
				colContents.append(grid[i][j]);
			}
			if (!has1to9(colContents)){
				return false;
			}else{
				continue;
			}
		}
		return true;
	}
	
	public boolean boxes() {
		for (int y=0; y<3; y++){
			for (int z=0; z<3; z++){
				
				StringBuilder boxContents = new StringBuilder();
				for (int i=0; i<grid.length; i++){
					for (int j=0; j<grid.length; j++){
						if (((i/3) == y) && ((j/3) == z)){
							boxContents.append(grid[i][j]);
						}
					}
				}
				if (!has1to9(boxContents)){
					return false;
				}else{
}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int[][] board = new int[9][9];
		
		board[0][0] = 5;
		board[0][1] = 3;
		board[0][2] = 4;
		board[0][3] = 6;
		board[0][4] = 7;
		board[0][5] = 8;
		board[0][6] = 9;
		board[0][7] = 1;
		board[0][8] = 2;
		
		board[1][0] = 6;
		board[1][1] = 7;
		board[1][2] = 2;
		board[1][3] = 1;
		board[1][4] = 9;
		board[1][5] = 5;
		board[1][6] = 3;
		board[1][7] = 4;
		board[1][8] = 8;
		
		board[2][0] = 1;
		board[2][1] = 9;
		board[2][2] = 8;
		board[2][3] = 3;
		board[2][4] = 4;
		board[2][5] = 2;
		board[2][6] = 5;
		board[2][7] = 6;
		board[2][8] = 7;
		
		board[3][0] = 8;
		board[3][1] = 5;
		board[3][2] = 9;
		board[3][3] = 7;
		board[3][4] = 6;
		board[3][5] = 1;
		board[3][6] = 4;
		board[3][7] = 2;
		board[3][8] = 3;
		
		board[4][0] = 4;
		board[4][1] = 2;
		board[4][2] = 6;
		board[4][3] = 8;
		board[4][4] = 5;
		board[4][5] = 3;
		board[4][6] = 7;
		board[4][7] = 9;
		board[4][8] = 1;
		
		board[5][0] = 7;
		board[5][1] = 1;
		board[5][2] = 3;
		board[5][3] = 9;
		board[5][4] = 2;
		board[5][5] = 4;
		board[5][6] = 8;
		board[5][7] = 5;
		board[5][8] = 6;
		
		board[6][0] = 9;
		board[6][1] = 6;
		board[6][2] = 1;
		board[6][3] = 5;
		board[6][4] = 3;
		board[6][5] = 7;
		board[6][6] = 2;
		board[6][7] = 8;
		board[6][8] = 4;
		
		board[7][0] = 2;
		board[7][1] = 8;
		board[7][2] = 7;
		board[7][3] = 4;
		board[7][4] = 1;
		board[7][5] = 9;
		board[7][6] = 6;
		board[7][7] = 3;
		board[7][8] = 5;
		
		board[8][0] = 3;
		board[8][1] = 4;
		board[8][2] = 5;
		board[8][3] = 2;
		board[8][4] = 8;
		board[8][5] = 6;
		board[8][6] = 1;
		board[8][7] = 7;
		board[8][8] = 9;

		SudokuChecker sc = new SudokuChecker(board);
		System.out.println("The submitted grid is: ");
		sc.drawGrid();
		
		if (sc.rows() && sc.columns() && sc.boxes()){
			System.out.println("This is a valid Sudoku Solution.");
		}else{
			System.out.println("This is an invalid Sudoku Solution.");
		}
		

	}

}
