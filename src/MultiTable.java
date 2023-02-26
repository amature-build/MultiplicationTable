import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MultiTable {
    private int _starting_value, _ending_value;
    private int[][] _table;
    private List<Integer> _list;
    private final int INDEX_SECTION = 8;

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
    private void setList(){
        this._list = IntStream.rangeClosed(this._starting_value, this._ending_value).boxed().toList();
    }
    private int generateTableSize(){
        return this._ending_value - this._starting_value + 1;
    }

    private int[][] createTable() {
        int length = generateTableSize();
        return new int[length][length];
    }
    private void setTable() {
        this._table = createTable();
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

    public void loadArray(){
        int length = generateTableSize();
        setList();
        setTable();
        for (int i = 0; i < length; i++) {
            int row = this._list.get(i);
            for (int j = 0; j < length; j++) {
                int col = this._list.get(j);
                setValueToTable(i, j, row * col);
            }
        }
    }
    private int generateDisplayWidth(){
        return this.INDEX_SECTION + (generateTableSize() * 4);
    }
    private String generateColHeader(){
        StringBuilder output = new StringBuilder();
        int width = generateDisplayWidth();
        Iterator<Integer> it = this._list.iterator();
        for (int i = 0; i < width; i++) {
            if (i > this.INDEX_SECTION){
                if (i % 4 == 1){
                    String word = it.next().toString();
                    output.append(word);
                } else {
                    output.append(" ");
                }
            } else {
                output.append(" ");
            }
        }
        return output.toString();
    }
    private String generateHeaderSep(){
        StringBuilder output = new StringBuilder();
        int width = generateDisplayWidth();
        output.append("#".repeat(Math.max(0, width)));
        return output.toString();
    }
    private String generateRowString(int index){
        int rowHeader = this._list.get(index);
        int[] row = this._table[index];
        int width = generateDisplayWidth();
        StringBuilder output = new StringBuilder();
        Iterator<Integer> it = Arrays.stream(row).iterator();

        for (int i = 0; i < width; i++) {
           if (i > this.INDEX_SECTION){
               if (i % 4 == 1) {
                   output.append(it.next());
               } else {
                   output.append(" ");
               }
           } else if (i == this.INDEX_SECTION - 1) {
               output.append("#");
           } else {
               if (i == 6){
                   output.append(rowHeader);
               } else {
                   output.append(" ");
               }
           }
        }
        return output.toString();
    }
    public void printMultiplicationTable(){
        String header = generateColHeader();
        System.out.println(header);
        String sep = generateHeaderSep();
        System.out.println(sep);

        int length = generateTableSize();
        for (int i = 0; i < length; i++) {
            String row = generateRowString(i);
            System.out.println(row);
            }
    }

}
