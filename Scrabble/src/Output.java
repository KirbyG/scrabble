import javax.swing.JFrame;
class Output extends JFrame
{
    private OutputHelper outputHelper;
    public Output(Input input)
    {
        outputHelper = new OutputHelper();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(outputHelper);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setVisible(true);
        addMouseListener(input);
        addMouseMotionListener(input);
        addKeyListener(input);
    }
    public void redraw(Data data)
    {
        outputHelper.redraw(data);
    }
}