
public class MainClass {
    
    private static final int SIZE = 9;
    
    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for(int i = 0; i < SIZE; i++) {
            if(board[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    private static boolean isNumberInColumn(int[][] board, int number, int col) {
        for(int i = 0; i < SIZE; i++) {
            if(board[i][col] == number) {
                return true;
            }
        }
        return false;
    }
    private static boolean isNumberInSquare(int[][] board, int number, int row, int col) {
        int squareRow = row - row % 3;
        int squareColumn = col - col % 3;
        for(int i = squareRow; i < squareRow + 3; i++) {
             for(int j = squareColumn; j < squareColumn; j++) {
                 if(board[i][j] == number) {
                     return true;
                 }
            }
        }
        return false;
    }
    
    private static boolean isValidPlacement(int[][] board, int number, int row, int col) {
        return !isNumberInRow(board, number, row) && 
               !isNumberInColumn(board, number, col) && 
               !isNumberInSquare(board, number, row, col);
    } 
    
    private static boolean solveBoard(int[][] board) {
        for(int row = 0; row < SIZE; row++) {
            for(int column = 0; column < SIZE; column++) {
                if(board[row][column] == 0) {
                    for(int tryNumber = 1; tryNumber <= SIZE; tryNumber++) {
                        if(isValidPlacement(board, tryNumber, row, column)) {
                            board[row][column] = tryNumber;
                            
                            if(solveBoard(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void printBoard(int[][] board) {
        for(int row = 0; row < SIZE; row++) {
            if(row % 3 == 0 && row != 0) {
                System.out.println("------------");
            }
            for(int col = 0 ; col < SIZE; col++) { 
                if(col % 3 == 0 && col != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
       
    }
    
    public static void main(String[] args) {
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3} 
        };
        System.out.println("Original board");
        printBoard(board);
        if(solveBoard(board)) {
            System.out.println("Result");
            printBoard(board);
        }
        else {
            System.out.println("Can't solve");
        } 
    } 
}
