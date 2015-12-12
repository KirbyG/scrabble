import java.util.ArrayList;
class Word
{
    private ArrayList<Tile> tiles;
    private int direction;
    public Word()
    {
        tiles = new ArrayList<Tile>();
    }
    public void setDirection(int direction)
    {
        this.direction = direction;
    }
    public void addTile(Tile tile)
    {
        tiles.add(tile);
    }
    public void addTile(Tile tile, int or, int dir)
    {
        if (tile != null)
        {
            if (or == 0)
            {
                if (dir == -1)
                {
                    addTileStart(tile);
                }
                else
                {
                    addTile(tile);
                }
            }
            else
            {
                if (dir == -1)
                {
                    addTile(tile);
                }
                else
                {
                    addTileStart(tile);
                }
            }
        }
    }
    public String getWord()
    {
        String word = "";
        for (Tile t: tiles)
        {
            word += Character.toString(t.getLetter());
        }
        return word;
    }
    public void clear()
    {
        tiles.clear();
    }
    public void addTileStart(Tile tile)
    {
        tiles.add(0, tile);
    }
    public int getLength()
    {
        return tiles.size();
    }
    public Tile getTile(int i)
    {
        return tiles.get(i);
    }
    public int getDirection()
    {
        return direction;
    }
    public boolean containsBoard(Board b)
    {
        for (Tile t: tiles)
        {
            if (b.getTile(t.getBoardPosition()) != null)
            {
                return true;
            }
        }
        return false;
    }
    public int score(Board board)
    {
        int multiplier = 1;
        int score = 0;
        int letterMultiplier;
        Position p;
        boolean flag = false;
        int lettersPlayed = 0;
        for (Tile t: tiles)
        {
            p = t.getBoardPosition();
            letterMultiplier = 1;
            if (board.getTile(p) == null)
            {
                flag = true;
                lettersPlayed++;
                if (Constants.DLS.contains(p))
                {
                    letterMultiplier = 2;
                }
                else
                {
                    if (Constants.TLS.contains(p))
                    {
                        letterMultiplier = 3;
                    }
                    else
                    {
                        if (Constants.DWS.contains(p))
                        {
                            multiplier *= 2;
                        }
                        else
                        {
                            if (Constants.TWS.contains(p))
                            {
                                multiplier *= 3;
                            }
                        }
                    }
                }
            }
            score += t.getPoints() * letterMultiplier;
        }
        score *= multiplier;
        if (lettersPlayed == 7)
        {
            score += 50;
        }
        if (flag)
        {
            return score;
        }
        return 0;
    }
}