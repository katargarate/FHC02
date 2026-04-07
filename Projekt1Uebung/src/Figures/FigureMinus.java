package Figures;

public class FigureMinus extends Figure {
    public FigureMinus(int size) {
        this.size = size;
        symbol[0][0] = ' ';
        symbol[1][0] = ' ';
        symbol[2][0] = ' ';

        symbol[0][1] = 'X';
        symbol[1][1] = 'X';
        symbol[2][1] = 'X';

        symbol[0][2] = ' ';
        symbol[1][2] = ' ';
        symbol[2][2] = ' ';
    }
}
