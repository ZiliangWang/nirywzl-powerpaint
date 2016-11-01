/*
 * TCSS 305 Autumn - PowerPaint
 */
package shapes;
import gui.DrawingPanel;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

import javax.swing.Action;



/**
 * 
 * @author Ziliang Wang
 * @version 11/8/2015
 */
public final class Line extends AbstractTools {
    /** Generated Serial Number. */
    private static final long serialVersionUID = -1946407088291079667L;
    //Instance Fields
    /** The JPanel to associate with this Action. */
    private final DrawingPanel myPanel;
    /** The line shape. */
    private final Line2D.Double myLine;
    /**
    * Default constructor for Line.
     * @param thePanel the drawing panel.
     */
    public Line(final DrawingPanel thePanel) {
        super("Line");
        myPanel = thePanel;
        myLine = new Line2D.Double();
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_L);
        putValue(Action.SELECTED_KEY, true);
    }
    /** {@inheritDoc}
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */


    @Override
    public void setInitialPoint(final Point thePoint) {
        myLine.x1 = thePoint.getX();
        myLine.y1 = thePoint.getY();
    }
    
    @Override
    public void setEndPoint(final Point thePoint) {
        myLine.x2 = thePoint.getX();
        myLine.y2 = thePoint.getY();
        
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setTool(this);
        myPanel.setShape(myLine);
    }
    @Override
    public Shape getShape() {
        final Line2D.Double rLine;
        rLine = new Line2D.Double(myLine.x1, myLine.y1, myLine.x2, myLine.y2);
        return (Line2D.Double) rLine;
    }
//    
}