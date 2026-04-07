package Figures;

public class FigureL extends Figure{
    public FigureL(int size){
        this.size = size;
        symbol[0][0] = 'X';
        symbol[1][0] = ' ';
        symbol[2][0] = ' ';

        symbol[0][1] = 'X';
        symbol[1][1] = ' ';
        symbol[2][1] = ' ';

        symbol[0][2] = 'X';
        symbol[1][2] = 'X';
        symbol[2][2] = ' ';
    }
}
