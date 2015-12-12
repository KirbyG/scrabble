import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
class Input implements MouseListener, MouseMotionListener, KeyListener
{
    private boolean mouse;
    private boolean enter;
    private Position position = new Position(-1, -1);
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            enter = false;
        }
    }
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            enter = true;
        }
    }
    public void keyTyped(KeyEvent e) {}
    public boolean getMouseDown()
    {
        return mouse;
    }
    public Position getMousePosition()
    {
        return position;
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e)
    {
        mouse = true;
    }
    public void mouseReleased(MouseEvent e)
    {
        mouse = false;
    }
    public void mouseMoved(MouseEvent e)
    {
        updatePosition(e);
    }
    public void mouseDragged(MouseEvent e)
    {
        updatePosition(e);
    }
    private void updatePosition(MouseEvent e)
    {
        position.setXY(e.getX(), e.getY());
        position.input();
    }
    public boolean getEnter()
    {
        return enter;
    }
}