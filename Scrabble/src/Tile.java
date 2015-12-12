import java.util.ArrayList;
class Tile
{
    private char letter;
    private int points;
    private static int[] pointValues = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private Position position;
    private Position boardPosition;
    public Tile(char letter)
    {
        this();
        this.letter = letter;
        points = pointValues[char2int(letter)];
    }
    public Tile(int letter)
    {
        this();
        this.letter = int2char(letter);
        points = pointValues[letter];
    }
    public Tile()
    {
        position = new Position(-1, -1);
        boardPosition = new Position(-1, -1);
    }
    private char int2char(int letter)
    {
        return Character.toChars(97 + letter)[0];
    }
    private int char2int(char letter)
    {
        return Character.compare(letter, '`');
    }
    public char getLetter()
    {
        return letter;
    }
    public void setPosition(Position p)
    {
        position = p;
    }
    public Position getPosition()
    {
        return position;
    }
    public int getPoints()
    {
        return points;
    }
    public void setBoardPosition(Position p)
    {
        boardPosition = new Position(p.getX(), p.getY());
    }
    public Position getBoardPosition()
    {
        return boardPosition;
    }
    public void lock()
    {
        position = toRealPos(boardPosition);
    }
    private Position toRealPos(Position p)
    {
        Position np = new Position(p.getX(), p.getY());
        np.setX(np.getX() * (Constants.TILEWIDTH + Constants.TILEBORDERTHICKNESS));
        np.setY(np.getY() * (Constants.TILEHEIGHT + Constants.TILEBORDERTHICKNESS));
        np.setX(np.getX() + (Constants.TRUEWIDTH - Constants.BOARDWIDTH) / 2 + Constants.TILEBORDERTHICKNESS + Constants.TILEWIDTH / 2);
        np.setY(np.getY() + (Constants.BOARDPOSITION.getY() - Constants.BOARDHEIGHT / 2 + Constants.TILEBORDERTHICKNESS + Constants.TILEHEIGHT / 2));
        return np;
    }
    public Tile clone()
    {
        Tile clone = new Tile(letter);
        clone.setBoardPosition(boardPosition);
        clone.lock();
        return clone;
    }
}