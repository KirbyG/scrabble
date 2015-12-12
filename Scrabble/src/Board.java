class Board
{
    private Tile[][] tiles;
    public Board()
    {
        tiles = new Tile[15][15];
    }
    public void add(TileCollection additions)
    {
        for (int i = 0; i < additions.getNumTiles(); i++)
        {
            tiles[additions.getTile(i).getBoardPosition().getX()][additions.getTile(i).getBoardPosition().getY()] = additions.getTile(i);
        }
    }
    public Tile getTile(int x, int y)
    {
        if (x < 0 || x > 14 || y < 0 || y > 14)
        {
            return null;
        }
        return tiles[x][y];
    }
    public Tile getTile(Position p)
    {
        int x = p.getX();
        int y = p.getY();
        return getTile(x, y);
    }
}