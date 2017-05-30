package model.board;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public enum Size {

    SMALL(3),
    MEDIUM(4);

    private int size;

    private Size(int size) {
        this.size = size;
    }

    public int get() {
        return size;
    }
}
