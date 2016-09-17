import java.util.Scanner;

public class MyGame implements Game {

    private Board board;


    public void initialize() {
         board = new MyBoard(SIZE);
    }


    public void playGame() {
        //Initialize the board's starting positions
        board.setStartingPositions();
        // TODO: Consider setting turn within setStartingPositions or something
        boolean isWhitesTurn = true;
        board.setTurn(isWhitesTurn);
        board.printBoard();
        Scanner scan = new Scanner(System.in);
        while(!board.isGameOver(isWhitesTurn)){
            System.out.print("Select a coordinate, then hit Enter:");
            String coordinates = scan.nextLine();
            int row = Character.getNumericValue(coordinates.charAt(1));
            char column = coordinates.charAt(0);
            /* Keep asking for an input until a valid one is given */
            while(!board.placePiece(row, column, isWhitesTurn)){
               //TODO: When an invalid coordinate is placed, it becomes impossible to escape this loop
                System.out.print("Invalid input.\n"
                        + "Type an unoccupied coordinate" +
                        " with no spaces (e.g. A5), then press enter).\n" +
                        "If you already did this, then this happened because you attempted an illegal move.");
                coordinates = scan.nextLine();
                row = Character.getNumericValue(coordinates.charAt(1));
                column = coordinates.charAt(0);
            }
            board.setTurn(!isWhitesTurn);
            isWhitesTurn = !isWhitesTurn;
        }
    }

    
    public void playGameAgainstComputer() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        Game myGame = new MyGame();
        myGame.initialize();
        myGame.playGame();
    }

}