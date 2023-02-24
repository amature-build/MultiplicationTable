import java.util.Scanner;

public class MultiTable {
    private int _starting_value, _ending_value;
    private int[][] _table;

    public  MultiTable(){}

    private void setStartingValue(int startingValue) {
        this._starting_value = startingValue;
    }

    private void setEndingValue(int endingValue) {
        this._ending_value = endingValue;
    }

    public int getEndingValue() {
        return _ending_value;
    }

    public int getStartingValue() {
        return _starting_value;
    }

    public int[][] getTable() {
        return _table;
    }

    private void setTable(int[][] table) {
        this._table = table;
    }

    private void setValueToTable(int row, int col, int value){
        this._table[row][col] = value;
    }

    public void askStartingValue(){
        String msg = "Enter the Starting value";
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        int input = scan.nextInt();
        setStartingValue(input);
    }

    public void askEndingValue(){
        String msg = "Enter the Ending value";
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        int input = scan.nextInt();
        setEndingValue(input);
    }

}
