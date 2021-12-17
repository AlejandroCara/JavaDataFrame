package Data;

import Comparators.CustomComparator;
import Predicates.CustomPredicate;
import Predicates.GreaterThanPredicator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataFrame {

    //private  DataFrame this = new DataFrame();

    private List<String> columns;
    private List<List<String>> values = new ArrayList<>();

    public DataFrame(){
        
    }
    

    public void setColumns(List inColumns){
        this.columns = inColumns;
    }

    public void setValues(List<List<String>> inValues){
        this.values = inValues;
    }

    public List<List<String>> getValues(){
        return this.values;
    }

    public int numOfTags(){
        return this.columns.size();
    }

    public String getTagAt(int i){
        return this.columns.get(i);
    }

    public List<String> getColumns(){
        return this.columns;
    }

    public void addValue(List<String> inValue){
        this.values.add(inValue);
    }

    public String at(int row, String col){
        List srow = this.values.get(row);
        int fd = this.columns.indexOf(col);
        return this.values.get(row).get(this.columns.indexOf(col));
    }

    public String iat(int row, int col) {
        return this.values.get(row).get(col);
    }

    public int columns() {
        return this.columns.size();
    }

    public int size() {
        return this.values.size();
    }

    public <T> void sort(String column, CustomComparator comparator) {
        comparator.setColumnIndex(columns.indexOf(column));
        Collections.sort(values, comparator);
        //Collections.sort(compararator.compare(values.));
    }

    public List<List<String>> query(String column, CustomPredicate predicator) {
        predicator.setColumnIndex(this.columns.indexOf(column));
        return (List<List<String>>) values.stream().filter(predicator).collect(Collectors.toList());

        /*
        values.stream()
                .filter(row -> row.get(columns.indexOf(column)) >= 0.2)
                .collect(Collectors.toList());
        */
        /*List<List<String>> returnValue = (List<List<String>>) values.stream()
                                            .filter(new Predicator())
                                            .collect(Collectors.toList());*/
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
}
