package Chess.Pieces;

import Chess.Colour;

public class Piece {
    private Colour colour;

    public Piece(Colour colour) {
        this.colour = colour;
        System.out.print("Piece created: ");
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }
}
