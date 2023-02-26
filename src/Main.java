public class Main {
    public static void main(String[] args) {
        MultiTable mt = new MultiTable();

        mt.askStartingValue();
        mt.askEndingValue();
        mt.loadArray();
        mt.printMultiplicationTable();
        System.out.println();
    }
}