package app.model.board;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public enum Size {

    SMALL(3,3),
    MEDIUM(4,4),
    LARGE(5,5);

    int rows;
    int columns;

    private Size(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int rows() {
        return rows;
    }

    public int columns() {
        return columns;
    }

    @Override
    public String toString() {
        return rows+"x"+columns;
    }
}
