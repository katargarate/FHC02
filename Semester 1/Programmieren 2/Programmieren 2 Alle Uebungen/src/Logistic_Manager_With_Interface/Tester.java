package Logistic_Manager_With_Interface;

public class Tester implements InterfaceWithStaticMethod{
    @Override
    public void move() {
        System.out.println("MOVE");
    }

    @Override
    public void run() {
        System.out.println("RUN");
    }
}
