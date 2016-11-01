/*
 * TCSS 305 Autumn - PowerPaint
 */
package gui;
import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.KeyStroke;



import shapes.Ellipse;
import shapes.Line;
import shapes.Pencil;
import shapes.Rectangle;


/**
 * This is for setting all of the gui function for the powerpaint.
 * @author Ziliang
 * @version 11/6/2015
 */
public class PPGUI {

    /** Generated Serial Number. */
    private static final Dimension DEFAULT_SIZE = new Dimension(400, 200);
    /** A constant for the string "Exit". */
    private static final String EXIT_STRING = "Exit";
    /** A JFrame field.*/
    private static JFrame myFrame = new JFrame("PowerPaint");
    /** The panel for user can draw with a pencil, lines, and/or shapes. */
    private final DrawingPanel myDrawingPanel = new DrawingPanel();
    /** The menu field.*/
    private final MenuBar myMenu = new MenuBar();
    /** The tool bar field.*/
    private final ToolBar myJTB = new ToolBar();

    /**
     * Start up the frame.
     */
    public void start() {
        myFrame.setIconImage(new ImageIcon("./images/w.gif").getImage());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpGUI();
        myFrame.add(myDrawingPanel, BorderLayout.CENTER);
        myFrame.setLocationRelativeTo(null);
        myFrame.pack();
        myFrame.setVisible(true);
    }
    /**
     * Set up all the gui.
     */
    private void setUpGUI() {
        myFrame.setSize(DEFAULT_SIZE);
        myFrame.setJMenuBar(myMenu.setMenuBar());
        myMenu.addPropertyChangeListener(this.myDrawingPanel);
        myDrawingPanel.addPropertyChangeListener(myMenu);
        setUpToolBar();
        myFrame.add(myJTB, BorderLayout.SOUTH);
    }
    
    /**
     * assign the buttons.
     */
    private void setUpToolBar() {
        final Action[] actionGroup = 
        {new Pencil(myDrawingPanel), new Line(myDrawingPanel), 
         new Rectangle(myDrawingPanel), new Ellipse(myDrawingPanel)};
        for (final Action action : actionGroup) {
            myJTB.createToolBarButton(action);
            myMenu.createMenuBarButton(action);
        }
    }
    /**
     * make an exit functional button.
     * @return an exit button.
     */
    public static Action setupExitActions() {
        /** The exit action. */
        Action exitAction;
        // anonymous inner class in use here
        exitAction = new AbstractAction(EXIT_STRING) {
            /** A generated serialization ID. */
            private static final long serialVersionUID = -3641127125217134863L;
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myFrame.dispose();
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, EXIT_STRING);
        exitAction.putValue(Action.ACCELERATOR_KEY,
                                KeyStroke.getKeyStroke('Q',
                                                       java.awt.event.InputEvent.CTRL_MASK));
        exitAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
        return exitAction;
    }
}
