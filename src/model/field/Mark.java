package model.field;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public enum Mark {

    O("O"),
    X("X"),
    EMPTY("-");

    private String mark;

    private Mark(String mark) {
        this.mark = mark;
    }

    public Mark setOpposite() {
        if(this.equals(X))
            return Mark.O;
        else
            return Mark.X;
    }

    @Override
    public String toString() {
        return mark;
    }
}
