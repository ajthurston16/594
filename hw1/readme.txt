{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf470
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww16080\viewh12520\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 \
The implementation of reversi in MyGame.java follows all the game\'92s standard rules.  When this program is run, it will set up the user to play a game against the computer.  To play against another human, comment out game.playGameAgainstComputer() in the main.   In either case, the board is printed in the console, and instructions for making moves are provided.\
\
The MyGame class implements the basics of the game, including swapping turns between the user and the opponent, reading their moves from the console, initializing the Board object, and printing output when the game ends and a winner is determined.\
\
Most of the intricacies of the game are implemented in MyBoard.java, which has methods for placing pieces on the board, determining if a move is legal, determining if the game is over, printing the board, setting the turn, etc.  The board is represented as a 2D array of integers, which can take on three possible values: 0 for blank spaces, 1 for white spaces, and -1 for black spaces.  \
\
placePiece modifies the 2D array to place new pieces, either black or white, on the board.  To do this, it calls isMoveLegal, which searches the squares immediately adjacent to the proposed move.  If it finds a square of the opposite color, it performs a directional search outward for a piece of the original color that \'93sandwiches\'94 the opponent\'92s squares.  If it finds this, it pushes the coordinates of the opponent\'92s sandwiched pieces to a stack.  A stack was chosen because there could be anywhere between 1 and 6 sandwiched pieces in any given direction (for an 8x8 board) and 8 directions in which pieces may need to be flipped.  A stack can easily store an indeterminate number of elements and retrieve them one by one. When the piece is finally placed, each set of coordinates is popped off the stack and flipped to the current player\'92s color.\
\
To determine if the game is over, isMoveLegal is simply called on each square on the board to determine if a legal move still exists for the current player.  Similarly, the computer player chooses moves by finding all possible legal moves, pushing the coordinates to another stack, and then selecting one of the possible moves at random.  When the game is over, the winner is determined by iterating through the board and counting/comparing the black and white player\'92s squares.}