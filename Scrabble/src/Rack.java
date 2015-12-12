class Rack extends TileCollection
{
    public Rack(Bag bag)
    {
        super();
        for (int tile = 0; tile < 7; tile++)
        {
            tiles.add(bag.pick());
        }
        fixPositions();
        
    }
    public void addTile(Tile tile)
    {
        super.addTile(tile);
        fixPositions();
    }
    public void delete(int i)
    {
        super.delete(i);
        fixPositions();
    }
    private void fixPositions()
    {
        for (int tile = 0; tile < tiles.size(); tile++)
        {
            tiles.get(tile).setPosition(new Position(Constants.XCENTER + (tile - 3) * (Constants.TILEBORDERTHICKNESS + Constants.TILEWIDTH), Constants.RACKPOSITION.getY()));
        }   
    }
    public void draw(Bag bag)
    {
        while (tiles.size() < 7 && bag.getNumTiles() > 0)
        {
            tiles.add(bag.pick());
        }
        //"tiles" is a list of the tiles on the player's rack. "bag.getNumTiles()" is the number of tiles left in the bag. This code 
        fixPositions();
    }
}