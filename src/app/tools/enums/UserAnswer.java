package app.tools.enums;

/**
 * Created by Przemysław Konik on 2017-06-02.
 */
public enum UserAnswer {

    Y(true),
    y(true),
    n(false),
    N(false);

    private boolean answer;

    private UserAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isYes() {
        return answer;
    }
}
