package com.chesstpa.pieces;

public enum PieceType {
    KING(King.class,new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1}, //Moves up
            {0, -1}, /* Current field */ {0, 1}, // Moves left and right
            {1, -1}, {1, 0}, {1, 1} //Moves down
    }),
    KNIGHT(Knight.class,new int[][]{
            {-2, -1}, {-2, 1}, // Moves upper left and upper right
            {-1, -2}, {-1, 2}, // Moves left upper and right upper
            {1, -2}, {1, 2},   // Moves left lower and right lower
            {2, -1}, {2, 1}    // Moves lower left and lower right
    }),
    BISHOP(Bishop.class,new int[][]{
            {-1, -1},

            {-2, -2},

            {-3, -3},

            {-4, -4},

            {-5, -5},

            {-6, -6},

            {-7, -7},

            {1, -1},

            {2, -2},

            {3, -3},

            {4, -4},

            {5, -5},

            {6, -6},

            {7, -7},

            {-1, 1},

            {-2, 2},

            {-3, 3},

            {-4, 4},

            {-5, 5},

            {-6, 6},

            {-7, 7},

            {1, 1},

            {2, 2},

            {3, 3},

            {4, 4},

            {5, 5},

            {6, 6},

            {7, 7}
    }),
    QUEEN(Queen.class,new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1}, //Moves up
            {0, -1}, /* Current field */ {0, 1}, // Moves left and right
            {1, -1}, {1, 0}, {1, 1} //Moves down
    }),
    ROOK(Rook.class,new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1}, //Moves up
            {0, -1}, /* Current field */ {0, 1}, // Moves left and right
            {1, -1}, {1, 0}, {1, 1} //Moves down
    }),
    WHITEPAWN(Pawn.class,new int[][]{
            {-1, -1}, {-1, 1} //Moves up
    }),
    BLACKPAWN(Pawn.class,new int[][]{
        {1, -1}, {1, 1} //Moves down
    });

    private final int[][] moves;
    private final Class aClass;

    PieceType(Class aClass,int[][] moves) {
        this.aClass = aClass;
        this.moves = moves;
    }

    public int[][] getMoves() {
        return moves;
    }

    public Class getaClass() {
        return aClass;
    }
}
