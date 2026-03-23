import Models.Auto;

void main() {
    Auto meinAuto = new Auto();
    Auto spezAuto = new Auto("Porsche", 600);
    Auto anderesAuto = new Auto("BMW");

    System.out.println(anderesAuto.toString());
}
