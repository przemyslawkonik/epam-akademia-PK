package model.board;

/**
 * Created by Beton on 2017-05-30.
 */
public enum Size {
    SMALL(3);

    private int size;

    private Size(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
