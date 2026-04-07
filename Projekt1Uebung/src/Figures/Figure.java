package Figures;

public abstract class Figure {
    protected char[][] symbol = new char[3][3];
    public int size;

    public Figure() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 3; row++) {

            // repeat each row vertically depending on size (once for 1, twice for 2, etc)
            for (int i = 1; i <= size; i++) {

                for (int col = 0; col < 3; col++) {

                    // repeat each character horizontally depending on size
                    for (int j = 1; j <= size; j++) {
                        sb.append(symbol[col][row]);
                    }
                }

                sb.append('\n');
            }
        }

        return sb.toString();
    }
}