/*
 * TCSS 305 Autumn - PowerPaint
 */
package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import shapes.Pencil;
import shapes.Tools;

/**
 * This is the drawing panel class, that is used for make drawing objects and 
 * mouse listening.
 * @author Ziliang Wang
 * @version 11/8/2015
 */
public class DrawingPanel extends JPanel implements PropertyChangeListener {
    /** A generated serialization ID. */
    private static final long serialVersionUID = 5378597116905801274L;
    /** The default size of panel.*/
    private static final Dimension WINDOW_SIZE = new Dimension(400, 200);
    /** The default grid space.*/
    private static final int SPACE_GRID = 10;
    
    /** The thickness field.*/ 
    private List<Integer> myThicknessList;
    /** Shape field. */
    private List<Shape> myShapesList;
    /** Color field.*/
    private List<Color> myColorList;
    /** The default thickness.*/
    private int myThickness = 1;
    /** The boolean for checking listener.*/
    private boolean myPressed;
    /** The boolean to active grid.*/
    private boolean myGrid;
    /** The shape field.*/
    private Shape myShape;
    /** The tool field.*/
    private Tools myTool;

    
    /**
     * Sets the shape that will be drawn in the panel.
     */
    
    public DrawingPanel() {
        super();
        setUpDrawingPanel();
        myTool = new Pencil(this);
        myGrid = false;
        myThicknessList = new ArrayList<Integer>();
        myShapesList = new ArrayList<Shape>();
        myColorList = new ArrayList<Color>();

    }
    /**
     * set the shapes.
     * @param theShape 
     */
    public void setShape(final Shape theShape) {
        myShape = theShape;
    }
    /**Set up the drawing panel.*/
    private void setUpDrawingPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WINDOW_SIZE));
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseListener());
    }
    /**
     * set the tools. 
     * @param theTool 
     */
    public void setTool(final Tools theTool) {
        myTool = theTool;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("CLEAN".equals(theEvent.getPropertyName())) {
            myThicknessList = new ArrayList<Integer>();
            myShapesList = new ArrayList<Shape>();
            myColorList = new ArrayList<Color>();
            myPressed = false;
            repaint();
        } else if ("grid".equals(theEvent.getPropertyName())) {
            myGrid = (boolean) theEvent.getNewValue();
            repaint();
        }
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D pen = (Graphics2D) theGraphics;
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                               RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setStroke(new BasicStroke(myThickness));
        pen.setColor(ColorChoosing.getColor());
        
        if (!myShapesList.isEmpty()) {
            for (int i = 0; i < myShapesList.size(); i++) {
                pen.setColor(myColorList.get(i));
                pen.setStroke(new BasicStroke(myThicknessList.get(i)));
                pen.draw(myShapesList.get(i));
                firePropertyChange("have thing", null, true);
            }
        }
        
        if (myPressed) {
            pen.setStroke(new BasicStroke(MenuBar.getThickness()));
            pen.setColor(ColorChoosing.getColor());
            pen.draw(myShape);
        }
        
        if (myGrid) {
            pen.setColor(Color.GRAY);
            pen.setStroke(new BasicStroke(1));
            for (int i = 0; i <= this.getHeight(); i += SPACE_GRID) {
                pen.draw(new Line2D.Double(0, i, this.getWidth(), i));
                for (int j = 0; j <= this.getWidth(); j += SPACE_GRID) {
                    pen.draw(new Line2D.Double(j, 0, j, this.getHeight()));
                }
            }
        }
    }
    

    /**
     * This is the mouse listener about drawing.
     * @author Ziliang Wang
     * @version 11/18/2015
     */
    private class MyMouseListener extends MouseInputAdapter {

        @Override
        public void mousePressed(final MouseEvent theEvent) {
            if (MenuBar.getThickness() != 0) {
                myPressed = true;
            }
            myTool.setInitialPoint((Point) theEvent.getPoint());
            myTool.setEndPoint((Point) theEvent.getPoint());
            repaint();
            
        }

        @Override
        public void mouseDragged(final MouseEvent theEvent) {     
            myTool.setEndPoint((Point) theEvent.getPoint());
            repaint();
        }
         
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            if (MenuBar.getThickness() != 0) {
                myThickness = MenuBar.getThickness();
                myShapesList.add(myTool.getShape());
                myColorList.add(ColorChoosing.getColor());
                myThicknessList.add(myThickness);
            }
            myPressed = false;
            repaint();
        }
        
        @Override
        public void mouseMoved(final MouseEvent theEvent) {
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
    
}
