import app.model.board.Board;
import app.model.board.Size;
import app.model.board.TicTacToeBoard;
import app.model.field.Field;
import app.model.field.Mark;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Przemysław Konik on 2017-06-02.
 */
public class TicTacToeBoardTest {
    private Board board;

    @Before
    public void createBoard() {
        board = new TicTacToeBoard(Size.SMALL);
    }

    @Test
    public void boardNotNull() {
        Assert.assertNotNull(board);
    }

    @Test
    public void setFieldTest1() {
        board.setField(2, Mark.O);
        Assert.assertEquals(Mark.O, board.getField(2).getMark());
    }

    @Test
    public void setFieldTest2() {
        board.setField(1,2,Mark.X);
        Assert.assertEquals(Mark.X, board.getField(1,2).getMark());
    }

    @Test
    public void setFieldTest3() {
        board.setField(0,Mark.O);
        Assert.assertEquals(Mark.O, board.getField(0).getMark());
    }

    @Test
    public void setFieldTest4() {
        board.setField(0,0,Mark.X);
        Assert.assertEquals(Mark.X, board.getField(0,0).getMark());
    }
    
    @Test
    public void clearTest() {
        board.clear();
        for(int i=0; i<board.size(); i++)
            Assert.assertEquals(Mark.EMPTY, board.getField(i).getMark());
    }

    @Test
    public void isFullTest() {
        for(int i=0; i<board.size(); i++)
            board.setField(i, Mark.O);
        Assert.assertTrue(board.isFull());
    }
}
