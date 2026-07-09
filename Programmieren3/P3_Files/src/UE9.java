import java.io.*;

public class UE9 {

    static void main(String[] args) throws IOException {
        optionOne();


        optionTwo();


    }

    private static void optionOne() throws IOException {
        File filey = new File("filey");

        FileWriter fw = new FileWriter(filey);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("FirstLn");
        pw.println("SecondLn");

        pw.close();
    }

    public static void optionTwo() throws IOException {
        File filey = new File("filey2");
        FileWriter fw = new FileWriter(filey);
        BufferedWriter bw = new BufferedWriter(fw);

        String data = "Testing...";

        bw.write(data);

        bw.newLine();
        bw.write(data);

        bw.flush();

        bw.close();

    }
}
