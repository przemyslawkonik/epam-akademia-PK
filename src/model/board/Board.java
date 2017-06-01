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
    int getSize();
    int getRows();
    int getColumns();
    void setField(int position, Mark mark);
    Field getField(int position);

}
