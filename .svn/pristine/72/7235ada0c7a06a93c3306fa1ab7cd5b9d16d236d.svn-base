/*
 * TCSS 305 Autumn - PowerPaint
 */
package gui;


import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;


/**
 * This class is used for assign the tool bar toggle buttons.
 * @author Ziliang
 * @version 11/8/2015
 */
public class ToolBar extends JToolBar {
    /** Generated Serial Number. */
    private static final long serialVersionUID = 5461217144424499801L;
    /** A button group field. */
    private final ButtonGroup myButtonGroup;
    /** The default constructor, initialize the field. */
    public ToolBar() {
        super();
        myButtonGroup = new ButtonGroup();
    }
    /**
     * Set up the toggle button and assign an icon for the button.
     * @param theAction buttons action.
     */
    public void createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        toggleButton.setIcon(new ImageIcon("./images/" 
                        + theAction.getClass().getSimpleName().toLowerCase() + "_bw.gif"));
        myButtonGroup.add(toggleButton);
//        myButtonGroup.clearSelection();
        add(toggleButton);
    }
}
