class Data
{
    private Bag bag;
    private Rack pRack;
    private Rack cRack;
    private TileCollection limbo;
    private Dictionary dictionary;
    private boolean turn;
    private Board board;
    private boolean mode;
    //score
    private int s1;
    private int s2;
    public Data()
    {
        bag = new Bag();
        pRack = new Rack(bag);
        cRack = new Rack(bag);
        limbo = new TileCollection();
        dictionary = new Dictionary();
        turn = false;
        board = new Board();
        mode = false;
        //score
        s1 = 0;
        s2 = 0;
    }
    public void updateScore(int increment)
    {
        if (turn)
        {
            s2 += increment;
        }
        else
        {
            s1 += increment;
        }
    }
    public int getScore(boolean b)
    {
        if (b)
        {
            return s2;
        }
        return s1;
    }
    public void setMode(boolean mode)
    {
        this.mode = mode;
    }
    public boolean getMode()
    {
        return mode;
    }
    public Rack getPRack()
    {
        if (turn)
        {
            return cRack;
        }
        return pRack;
    }
    public TileCollection getLimbo()
    {
        return limbo;
    }
    public Dictionary getDictionary()
    {
        return dictionary;
    }
    public void nextTurn()
    {
        if (turn)
        {
            turn = false;
        }
        else
        {
            turn = true;
        }
    }
    public Bag getBag()
    {
        return bag;
    }
    public Board getBoard()
    {
        return board;
    }
    public boolean getTurn()
    {
        return turn;
    }
}