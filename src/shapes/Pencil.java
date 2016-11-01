/*
 * TCSS 305 Autumn - PowerPaint
 */
package shapes;
import gui.DrawingPanel;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

import javax.swing.Action;


/**
 * 
 * @author Ziliang Wang
 * @version 11/19/2015
 */
public class Pencil extends AbstractTools {
    /** The serial number. */
    private static final long serialVersionUID = -1946407088291079667L;
    /** The JPanel to associate with this Action. */
    private final DrawingPanel myPanel;
    /** The path field.*/
    private Path2D myPath;
    /** The end point field.*/
    private Point myEndPoint;
    /**
    * Default constructor for Pencil.
     * @param thePanel the drawing panel.
     */
    public Pencil(final DrawingPanel thePanel) {
        super("Pencil");
        myPanel = thePanel;
        myPath = new Path2D.Double();
        myPanel.setShape(myPath);
        this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
        this.putValue(Action.SELECTED_KEY, true);
    }
    @Override
    public void setInitialPoint(final Point thePoint) {
        if (myEndPoint != null) {
            myPath = new Path2D.Double();
        }
        myPanel.setShape(myPath);
        myPath.moveTo(thePoint.getX(), thePoint.getY());
    }
    @Override
    public void setEndPoint(final Point thePoint) {
        myEndPoint = thePoint;
        myPath.lineTo(myEndPoint.x, myEndPoint.y);
    }
    @Override
    public Shape getShape() {
        return (Path2D.Double) myPath;
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setTool(this);
        myPanel.setShape(myPath);
    }
}