import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
class OutputHelper extends JPanel
{
    private static final Position s1pos = new Position(0, Constants.TRUEHEIGHT - 50);
    private static final Position s2pos = new Position(Constants.TRUEWIDTH - 100, Constants.TRUEHEIGHT - 50);
    Data data;
    public OutputHelper()
    {
        super();
        setBackground(Constants.BACKGROUNDCOLOR);
    }
    public void redraw(Data data)
    {
        this.data = data;
        repaint();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Constants.RACKBACKGROUNDCOLOR);
        drawRect(g, new Position(100, 50), 2, 2);
        drawRect(g, Constants.RACKPOSITION, Constants.TILEWIDTH * 9 + Constants.TILEBORDERTHICKNESS * 6, Constants.TILEHEIGHT + 2 * Constants.TILEBORDERTHICKNESS);
        g.setColor(Constants.BOARDBACKGROUNDCOLOR);
        drawRect(g, Constants.BOARDPOSITION, Constants.BOARDWIDTH, Constants.BOARDHEIGHT);
        for (int y = 0; y < 15; y++)
        {
            for (int x = 0; x < 15; x++)
            {
                g.setColor(getColor(x, y));
                drawRect(g, new Position((Constants.TILEWIDTH + Constants.TILEBORDERTHICKNESS) * x + Constants.BOARDPOSITION.getX() - Constants.BOARDWIDTH / 2 + Constants.TILEWIDTH / 2 + Constants.TILEBORDERTHICKNESS, ((Constants.TILEHEIGHT + Constants.TILEBORDERTHICKNESS) * y) + Constants.BOARDPOSITION.getY() - (Constants.BOARDHEIGHT / 2) + (Constants.TILEHEIGHT / 2) + Constants.TILEBORDERTHICKNESS), Constants.TILEWIDTH, Constants.TILEHEIGHT);
            }
        }
        for (int pos = 0; pos < data.getPRack().getNumTiles(); pos++)
        {
            g.setColor(Constants.TILECOLOR);
            Position p = data.getPRack().getTile(pos).getPosition();
            drawRect(g, p, Constants.TILEWIDTH, Constants.TILEHEIGHT);
            drawLetter(g, p, data.getPRack().getTile(pos).getLetter());
            drawNumber(g, p, data.getPRack().getTile(pos).getPoints());
        }
        for (int y = 0; y < 15; y++)
        {
            for (int x = 0; x < 15; x++)
            {
                if (data.getBoard().getTile(x, y) != null)
                {
                    g.setColor(Constants.TILECOLOR);
                    Position p = data.getBoard().getTile(x, y).getPosition();
                    drawRect(g, p, Constants.TILEWIDTH, Constants.TILEHEIGHT);
                    drawLetter(g, p, data.getBoard().getTile(x, y).getLetter());
                    drawNumber(g, p, data.getBoard().getTile(x, y).getPoints());
                }
            }
        }
        for (int pos = 0; pos < data.getLimbo().getNumTiles(); pos++)
        {
            g.setColor(Constants.TILECOLOR);
            Position p = data.getLimbo().getTile(pos).getPosition();
            drawRect(g, p, Constants.TILEWIDTH, Constants.TILEHEIGHT);
            drawLetter(g, p, data.getLimbo().getTile(pos).getLetter());
            drawNumber(g, p, data.getLimbo().getTile(pos).getPoints());
        }
        if (data.getMode())
        {
            g.setColor(Color.BLACK);
            drawRect(g, new Position(Constants.XCENTER, Constants.YCENTER), Constants.TRUEWIDTH, Constants.TRUEHEIGHT);
        }
        //score
        drawNumber(g, false, data);
        drawNumber(g, true, data);
    }
    private void drawNumber(Graphics g, boolean turn, Data d)
    {
        g.setColor(Color.WHITE);
        g.setFont(Constants.SCOREFONT);
        Position p;
        if (turn)
        {
            p = s2pos;
        }
        else
        {
            p = s1pos;
        }
        Position newCenter = p.output();
        g.drawString(d.getScore(turn) + "", newCenter.getX(), newCenter.getY());
    }
    private void drawNumber(Graphics g, Position p, int n)
    {
        g.setColor(Color.BLACK);
        g.setFont(Constants.NUMBERFONT);
        Position newCenter = p.output();
        if (n == 10)
        {
            g.drawString(n + "", newCenter.getX() + 5, newCenter.getY() + 16);
        }
        else
        {
            g.drawString(n + "", newCenter.getX() + 10, newCenter.getY() + 16);
        }
    }
    private Color getColor(int x, int y)
    {
        if (Constants.DLS.contains(new Position(x, y)))
        {
            return Constants.DLSCOLOR;
        }
        else
        {
            if (Constants.TLS.contains(new Position(x, y)))
            {
                return Constants.TLSCOLOR;
            }
            else
            {
                if (Constants.DWS.contains(new Position(x, y)))
                {
                    return Constants.DWSCOLOR;
                }
                else
                {
                    if (Constants.TWS.contains(new Position(x, y)))
                    {
                        return Constants.TWSCOLOR;
                    }
                    return Constants.SPACECOLOR;
                }
            }
        }
    }
    private void drawRect(Graphics g, Position center, int width, int height)
    {
        Position newCenter = center.output();
        g.fillRect(newCenter.getX() - width / 2, newCenter.getY() - height / 2, width, height);
    }
    private void drawLetter(Graphics g, Position center, char letter)
    {
        g.setColor(Color.BLACK);
        g.setFont(Constants.TILEFONT);
        Position newCenter = center.output();
        g.drawString(Character.toString(letter).toUpperCase(), newCenter.getX() - 10, newCenter.getY() + 10);
    }
}