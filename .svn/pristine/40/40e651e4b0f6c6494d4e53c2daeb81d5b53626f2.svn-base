/*
 * TCSS 305 Autumn - PowerPaint
 */
package shapes;

import gui.DrawingPanel;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.Action;

/**
 * 
 * @author Ziliang Wang
 * @version 11/19/2015
 */
public final class Rectangle extends AbstractTools {
    /** Generated Serial Number. */
    private static final long serialVersionUID = -1946407088291079667L;
    /** The JPanel to associate with this Action. */
    private final DrawingPanel myPanel;
    /** The reference point.*/
    private Point myReferPoint; 
    /** The rectangle shape.*/
    private final Rectangle2D.Double myRect;
    /**
     * The constructor that initialize filed and assign the panel.
     * @param thePanel 
     */
    public Rectangle(final DrawingPanel thePanel) {
        super("Rectangle");
        myPanel = thePanel;
        myRect = new Rectangle2D.Double();
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(Action.SELECTED_KEY, true);
    }
    @Override
    public void setInitialPoint(final Point thePoint) {
        myReferPoint = thePoint;
        myRect.x = thePoint.getX();
        myRect.y = thePoint.getY();
    }
    @Override
    public void setEndPoint(final Point thePoint) {
        myRect.setFrameFromDiagonal(myReferPoint, thePoint);
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setTool(this);
        myPanel.setShape(myRect);
    }
    @Override
    public Shape getShape() {
        final Rectangle2D.Double rRect;
        rRect = new Rectangle2D.Double
        (myRect.x, myRect.y, myRect.width, myRect.height);
        return (Rectangle2D.Double) rRect;
    }
}
