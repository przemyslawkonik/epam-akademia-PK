package model.field;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public class Field {

    private Mark mark;

    public Field() {
        this.mark = Mark.EMPTY;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        return mark == field.mark;
    }

    @Override
    public int hashCode() {
        return mark != null ? mark.hashCode() : 0;
    }
}
