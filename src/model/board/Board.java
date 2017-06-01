package model.board;

import model.field.Field;
import model.field.Mark;

/**
 * Created by Przemysław Konik on 2017-06-01.
 */
public interface Board {
    void show();
    void clear();
    boolean isFull();
    int size();
    int rows();
    int columns();
    void setField(int row, int column, Mark mark);
    Field getField(int row, int column);
    Field getField(int position);

}
