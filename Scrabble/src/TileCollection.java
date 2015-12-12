import java.util.ArrayList;
class TileCollection
{
    public static int[] distribution = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
    public ArrayList<Tile> tiles;
    public TileCollection()
    {
        tiles = new ArrayList<Tile>();
    }
    public void addTile(Tile tile)
    {
        tiles.add(tile);
    }
    public int getNumTiles()
    {
        return tiles.size();
    }
    public Tile getTile(int i)
    {
        return tiles.get(i);
    }
    public void delete(int i)
    {
        tiles.remove(i);
    }
    public Tile pick()
    {
        int i = Constants.random(0, tiles.size() - 1);
        Tile temp = tiles.get(i);
        tiles.remove(i);
        return temp;
    }
    public void clear()
    {
        tiles.clear();
    }
    public Tile getTile(Position p)
    {
        for (Tile t: tiles)
        {
            if (t.getBoardPosition().equals(p))
            {
                return t;
            }
        }
        return null;
    }
}