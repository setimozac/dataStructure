package Q2;

public class Main {
    public static void main(String[] args) {
        SuperFibs f = new SuperFibs();

        System.out.printf("1 : %d, steps %d%n",f.getNthFib(0), SuperFibs.stepsCount);
        System.out.printf("2 : %d, steps %d%n",f.getNthFib(1), SuperFibs.stepsCount);
        System.out.printf("3 : %d, steps %d%n",f.getNthFib(2), SuperFibs.stepsCount);
        System.out.printf("4 : %d, steps %d%n",f.getNthFib(3), SuperFibs.stepsCount);
        System.out.printf("5 : %d, steps %d%n",f.getNthFib(4), SuperFibs.stepsCount);
        System.out.printf("6 : %d, steps %d%n",f.getNthFib(5), SuperFibs.stepsCount);
        System.out.printf("7 : %d, steps %d%n",f.getNthFib(6), SuperFibs.stepsCount);
        System.out.printf("8 : %d, steps %d%n",f.getNthFib(200), SuperFibs.stepsCount);
    }
}
