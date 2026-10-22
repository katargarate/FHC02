package Figures;

public class FigureO2 extends Figure{
    StringBuilder sb = new StringBuilder();

    public FigureO2(int size) {
        this.size = size;
        symbol[0][0] = ' ';
        symbol[1][0] = 'X';
        symbol[2][0] = ' ';

        symbol[0][1] = 'X';
        symbol[1][1] = ' ';
        symbol[2][1] = 'X';

        symbol[0][2] = ' ';
        symbol[1][2] = 'X';
        symbol[2][2] = ' ';


    }


}
