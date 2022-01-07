package Data;

import Comparators.CustomComparator;
import Composite.AComponent;
import Factories.ReaderFactory;
import Predicates.CustomPredicate;
import Visitor.Visitor;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DataFrame implements AComponent {

    //private  DataFrame this = new DataFrame();

    private List<String> columns;
    private List<List<String>> values = new ArrayList<>();

    public DataFrame(){

    }

    public void readDataFromFile(ReaderFactory rf){
        DataFrame df = rf.read();
        this.columns = df.getColumns();
        this.values = df.getValues();
    }

    public void setColumns(List inColumns){
        this.columns = inColumns;
    }

    public void setValues(List<List<String>> inValues){
        this.values = inValues;
    }

    //Return all the rows of the dataframe
    public List<List<String>> getValues(){
        return this.values;
    }

    //Return the label at the index
    public String getTagAt(int i){
        return this.columns.get(i);
    }

    //Return the list of labels
    public List<String> getColumns(){
        return this.columns;
    }

    //Add a new row to values list
    public void addValue(List<String> inValue){
        this.values.add(inValue);
    }

    //Return the value at the label and row specified
    public String at(int row, String col){
        return this.values.get(row).get(this.columns.indexOf(col));
    }

    //Return the value at the coordinates
    public String iat(int row, int col) {
        return this.values.get(row).get(col);
    }

    //Return the number of labels
    public int columns() {
        return this.columns.size();
    }

    //Return the number of rows
    public int size() {
        return this.values.size();
    }

    //Sort the values by a columnt
    public <T> void sort(String column, CustomComparator comparator) {
        comparator.setColumnIndex(columns.indexOf(column));
        Collections.sort(values, comparator);
    }

    //Return a list of rows that
    public List<List<String>> query(String column, CustomPredicate predicator) {
        predicator.setColumnIndex(this.columns.indexOf(column));
        return (List<List<String>>) values.stream().filter(predicator).collect(Collectors.toList());
    }

    public void list(){
        for(int i = 0; i < this.columns.size(); i++){
            System.out.print(columns.get(i) + "  ");
        }
        System.out.println();
        for (int i = 0; i < this.values.size(); i++){
            for(int j = 0; j < this.columns.size(); j++){
                System.out.print(this.values.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    //Accept a visitor and calls visit function of that visitor
    public void accept(Visitor v){
        v.visit(this);
    }
}
