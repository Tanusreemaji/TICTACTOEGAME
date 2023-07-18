import java.util.Scanner;

class TicTacToe {
    // Declearing Board
    static char [][] board;
    public TicTacToe() {
        board = new char [3][3];                        // default value == /u0000 == null character
        initBoard();
    }
    // Initialized Board
    void initBoard() {
        for (int i = 0; i<board.length; i++) {          //row
            for (int j=0; j<board[i].length; j++) {     //column
                board[i][j] = ' ';                      //fill the cells with space.
            }
        }

    }
    //Display Board
    static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i<board.length; i++) {
            System.out.print("| ");
            for (int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    // Place Marke
    static void placeMark(int row, int col, char mark)
    {
        System.out.println("Game Started..!!");
        if(row>=0 && row<=2 && col>=0 && col<=2) {
            board[row][col] = mark;
        }
        else {
            System.out.print("Invalid Position!!");
        }
    }
    // Col Win Condition
    static boolean checkColWin() {
        for (int j=0; j<=2; j++) {
            if(board[0][j] != ' ' && board[0][j] == board[1][j]  && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    // Row Win Condition
    static boolean checkRowWin() {
        for (int i=0; i<=2; i++) {
            if(board[i][0] != ' ' && board[i][0] == board[i][1]  && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    // Digonally Win Condition
    static boolean checkDiaWin() {
        for (int i=0; i<=2; i++) {
            if(board[0][0] != ' ' && board[0][0] == board[1][1]  && board[1][1] == board[2][2] ||
                    board[0][2] != ' ' && board[0][2] == board[1][1]  && board[1][1] == board[2][0])
            {
                return true;
            }
        }
        return false;
    }
}

class HumanPlayer {
    String name;
    char mark;

    HumanPlayer(String name, char makr) {
        this.name=name;
        this.mark=mark;
    }

    void makeMove() {
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Enter the row and col");
            row = sc.nextInt();
            col = sc.nextInt();
        }while(! isValidMove(row,col));
        TicTacToe.placeMark(row, col, mark);
    }

    boolean isValidMove(int row, int col) {
        if(row>=0 && row<=2 && col>=0 && col<=2)
        {
            if(TicTacToe.board[row][col] == ' ')
            {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();

        HumanPlayer p1 = new HumanPlayer("Bob ", 'X');
        HumanPlayer p2 = new HumanPlayer("Marley ", '0');
        HumanPlayer cp;     //current player reference create
        cp=p1;
        while(true) {
            System.out.println(cp.name + "turn..");
            cp.makeMove();
            TicTacToe.displayBoard();
            if (TicTacToe.checkColWin() || TicTacToe.checkRowWin()  || TicTacToe.checkDiaWin()) {
                System.out.println(cp.name + "Win the match..!!");
                break;
            }
            else {
                if (cp == p1)
                {
                    cp=p2;
                }
                else
                {
                    cp=p1;
                }
            }
        }

    }
}




