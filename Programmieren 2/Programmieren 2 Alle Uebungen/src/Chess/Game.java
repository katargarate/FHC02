package Chess;

import Chess.Pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();
    private final List<Piece> allPieces = new ArrayList<>();

    public void gameInit() {

        // for each colour (b&w) make the following:
        for (Colour colour : Colour.values()) {
            // 1 king, 1 queen
            allPieces.add(new King(colour));
            allPieces.add(new Queen(colour));

            // 2 rooks, 2 knights, 2 bishops
            for (int i = 0; i < 2; i++) {
                allPieces.add(new Rook(colour));
                allPieces.add(new Knight(colour));
                allPieces.add(new Bishop(colour));
            }

            // 8 pawns
            for (int i = 0; i < 8; i++) {
                allPieces.add(new Pawn(colour));
            }
        }

        // loop through all pieces and add them to their respective lists
        for (Piece piece : allPieces) {
            if (piece.getColour() == Colour.WHITE) whitePieces.add(piece);
            else blackPieces.add(piece);

        }
    }


}
