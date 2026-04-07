package Figures;

public class FigureI extends Figure{
    public FigureI(int size){
        this.size = size;
        symbol[0][0] = ' ';
        symbol[1][0] = 'X';
        symbol[2][0] = ' ';

        symbol[0][1] = ' ';
        symbol[1][1] = 'X';
        symbol[2][1] = ' ';

        symbol[0][2] = ' ';
        symbol[1][2] = 'X';
        symbol[2][2] = ' ';
    }
}
