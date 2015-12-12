class Position
{
    private int x;
    private int y;
    private static final int X = 0;
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void setXY(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void input()
    {
        x -= Constants.WIDTHMARGIN;
        y = Constants.HEIGHT - Constants.HEIGHTMARGIN - y;
    }
    public Position output()
    {
        return new Position(x + Constants.WIDTHMARGIN - 8, Constants.TRUEHEIGHT - 8 + Constants.HEIGHTMARGIN - y);
    }
    public boolean equals(Object p)
    {
        
        if (((Position)p).getX() == x && ((Position)p).getY() == y)
        {
            return true;
        }
        return false;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getXorY(int i)
    {
        if (i == X)
        {
            return x;
        }
        return y;
    }
}