package model.board;

import model.field.Field;
import model.field.Mark;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Board {

    private List<Field> fields;
    private int columns;
    private int rows;

    public Board(Size size) {
        columns = size.get();
        rows = size.get();
        initBoard();
    }

    private void initBoard() {
        fields = new LinkedList<>();
        int size = rows*columns;
        for (int i = 0; i < size; i++) {
            fields.add(new Field());
        }
    }

    public void showBoard() {
        int counter = 0;
        for(Field f : fields) {
            if(counter == columns) {
                System.out.println();
                counter = 0;
            }
            System.out.print(f.getMark());
            counter++;
        }
    }

    public void setField(int field, Mark mark) {
        if(field > fields.size() || field < 0)
            throw new ArrayIndexOutOfBoundsException();
        if(fields.get(field).getMark().equals(Mark.X) || fields.get(field).getMark().equals(Mark.O))
            throw new FieldIsAlreadyMarkedException();

        fields.get(field).setMark(mark);
    }

    public boolean isBoardFull() {
        for(Field f : fields) {
            if(f.getMark().equals(Mark.EMPTY))
                return false;
        }
        return true;
    }

}