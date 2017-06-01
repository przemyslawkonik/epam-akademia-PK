package model.board;

import model.field.Field;
import model.field.FieldIsAlreadyMarkedException;
import model.field.Mark;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Przemysław Konik on 2017-06-01.
 */
public class TicTacToeBoard implements Board{

    private final List<Field> fields;
    private int columns;
    private int rows;

    public TicTacToeBoard(Size size) {
        fields = new LinkedList<>();
        setRowsAndColumns(size);
        init();
    }

    public TicTacToeBoard(int rows, int columns) {
        fields = new LinkedList<>();
        setRowsAndColumns(rows, columns);
        init();
    }

    private void setRowsAndColumns(Size size) {
        switch (size) {
            case SMALL: {
                columns = 3;
                rows = 3;
            }
        }
    }

    private void setRowsAndColumns(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    private void init() {
        int size = rows*columns;
        for (int i = 0; i < size; i++)
            fields.add(new Field());
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public void setField(int position, Mark mark) {
        if(fields.get(position).getMark().equals(Mark.X) || fields.get(position).getMark().equals(Mark.O))
            throw new FieldIsAlreadyMarkedException();
        fields.get(position).setMark(mark);
    }

    @Override
    public Field getField(int position) {
        if(position < 0 || position > fields.size())
            throw new ArrayIndexOutOfBoundsException();
        return fields.get(position);
    }

    @Override
    public int getSize() {
        return columns*rows;
    }

    @Override
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

    @Override
    public void clear() {
        for(Field f : fields)
            f.setMark(Mark.EMPTY);
    }

    @Override
    public boolean isFull() {
        for(Field f : fields) {
            if(f.getMark().equals(Mark.EMPTY))
                return false;
        }
        return true;
    }

}
