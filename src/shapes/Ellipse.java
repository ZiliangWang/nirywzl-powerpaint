/*
 * TCSS 305 Autumn - PowerPaint
 */
package shapes;
import gui.DrawingPanel;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.Action;


/**
 * 
 * @author Ziliang Wang
 * @version 11/19/2015
 */
public final class Ellipse extends AbstractTools {
    /** Generated Serial Number. */
    private static final long serialVersionUID = -1946407088291079667L;
    /** The JPanel to associate with this Action. */
    private final DrawingPanel myPanel;
    /** The reference point.*/
    private Point myReferPoint; 
    /** The ellipse shape.*/
    private final Ellipse2D.Double myEllipse;
    /**
     * Default constructor for Ellipse.
     * @param thePanel the drawing panel.
     */
    public Ellipse(final DrawingPanel thePanel) {
        super("Ellipse");
        myPanel = thePanel;
        myEllipse = new Ellipse2D.Double();
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
        putValue(Action.SELECTED_KEY, true);
    }

    @Override
    public void setInitialPoint(final Point thePoint) {
        myReferPoint = thePoint;
        myEllipse.x = thePoint.getX();
        myEllipse.y = thePoint.getY();
    }
    @Override
    public void setEndPoint(final Point thePoint) {
        myEllipse.setFrameFromDiagonal(myReferPoint, thePoint);
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setTool(this);
        myPanel.setShape(myEllipse);
    }
    @Override
    public Shape getShape() {
        final Ellipse2D.Double rEllipse;
        rEllipse = new Ellipse2D.Double
        (myEllipse.x, myEllipse.y, myEllipse.width, myEllipse.height);
        return (Ellipse2D.Double) rEllipse;
    }
    
}