package model.board;

import model.field.Field;
import model.field.FieldIsAlreadyMarkedException;
import model.field.Mark;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Board {

    private final List<Field> fields;
    private final int columns;
    private final int rows;

    public Board(Size size) {
        fields = new LinkedList<>();
        columns = size.get();
        rows = size.get();
        initBoard();
    }

    private void initBoard() {
        int size = rows*columns;
        for (int i = 0; i < size; i++) {
            fields.add(new Field());
        }
    }

    public void show() {
        int counter = 0;
        for(Field f : fields) {
            if(counter == columns) {
                System.out.println();
                counter = 0;
            }
            System.out.print(f.getMark());
            counter++;
        }
        System.out.println();
    }

    public void clear() {
        for(Field f : fields)
            f.setMark(Mark.EMPTY);
    }

    public void setField(int row, int column, Mark mark) {
        int field = row*rows+column;
        if(fields.get(field).getMark().equals(Mark.X) || fields.get(field).getMark().equals(Mark.O))
            throw new FieldIsAlreadyMarkedException();

        fields.get(field).setMark(mark);
    }

    public boolean isFull() {
        for(Field f : fields) {
            if(f.getMark().equals(Mark.EMPTY))
                return false;
        }
        return true;
    }

    public int size() {
        return fields.size();
    }

    public Field getField(int field) {
        if(field < 0 || field > fields.size())
            throw new ArrayIndexOutOfBoundsException();
        return fields.get(field);
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

}