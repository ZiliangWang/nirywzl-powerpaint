/*
 * TCSS 305 Autumn - PowerPaint
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * This class is used for set up all of the menu bar for gui.
 * @author Ziliang Wang
 * @version 11/8/2015
 */
public class MenuBar extends JMenuBar implements PropertyChangeListener {
    /** Generated serial number.*/
    private static final long serialVersionUID = -7026913105895275430L;
    /** A constant for maximum thickness. */
    private static final int THICKNESS_RANGE = 5;
    /** Set the default thickness.*/
    private static int myThickness = 1;
    /** A boolean value for grid check.*/
    private static boolean myGridCheck;
    /** The undo button field.*/
    private final JMenuItem myUndo = new JMenuItem("Undo All Changes");
    /** The View menu. */
    private final JMenu myToolMenu = new JMenu("Tools");
    /** The button group.*/
    private final ButtonGroup myButtonGroup;
    /** The grid check box item field.*/
    private final JCheckBoxMenuItem myGrid = new JCheckBoxMenuItem("Grid");

    /**
     * The default constructor.
     */
    public MenuBar() {
        super();
        myButtonGroup = new ButtonGroup();
    }
    /**
     * Set up the menu bar for this project.
     * @return a menu bar.
     */
    public JMenuBar setMenuBar() {
        final JMenuBar menuBar1 = new JMenuBar();
        // setup the file menu
        final JMenu fileMenu1 = new JMenu("File");
        fileMenu1.add(undoAll());
        fileMenu1.addSeparator();
        fileMenu1.add(PPGUI.setupExitActions());
        fileMenu1.setMnemonic(KeyEvent.VK_F);
        menuBar1.add(fileMenu1);
        menuBar1.add(setOption());
        menuBar1.add(myToolMenu);
        menuBar1.add(setHelp());
        return menuBar1;
    }
    /**
     * Set up the action for the tool menu.
     * @param theAction action apply to tool menu.
     */
    public void createMenuBarButton(final Action theAction) {
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);
        myButtonGroup.add(createdButton);
        myToolMenu.add(createdButton);
        myToolMenu.setMnemonic(KeyEvent.VK_T);
    }
    /**
     * Set up the option menu.
     * @return option menu.
     */
    public JMenu setOption() {
        // setup the color menu
        final JMenu optionMenu = new JMenu("Options");
        
        myGrid.setMnemonic(KeyEvent.VK_G);
        myGrid.addActionListener(new GridListener());
        optionMenu.add(myGrid);
        optionMenu.addSeparator();
        optionMenu.add(setThickness());
        optionMenu.addSeparator();
        optionMenu.setMnemonic(KeyEvent.VK_O);
        final ColorChoosing color = new ColorChoosing();
        optionMenu.add(color.colorItem("Color..."));
        return optionMenu;
    }
    /**
     * Set up a menu that contains slider.
     * @return a thickness menu.
     */
    public JMenu setThickness() {
        final JMenu thickness = new JMenu("Thickness"); 
        thickness.setMnemonic(KeyEvent.VK_T);
        final JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 1);
        thicknessSlider.setMajorTickSpacing(THICKNESS_RANGE);
        thicknessSlider.setMinorTickSpacing(1);
        thicknessSlider.setPaintTicks(true);
        thicknessSlider.setPaintLabels(true);
        thicknessSlider.addChangeListener(new SliderListener());
        thickness.add(thicknessSlider);
        return thickness;
    }
    /**
     * Set up the help meny.
     * @return a help menu.
     */
    public JMenu setHelp() {
        final JMenu help = new JMenu("Help"); 
        help.setMnemonic(KeyEvent.VK_H);
        final JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        about.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, "TCSS 305 PowerPaint, Autumn, 2015");
            }
        });
        help.add(about);
        return help;
    }
    /**
     * This is used for setting up an undo all button.
     * @return undo all JMenuItem.
     */
    public JMenuItem undoAll() {
        myUndo.setMnemonic(KeyEvent.VK_U);
        myUndo.setEnabled(false);
        myUndo.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                firePropertyChange("CLEAN", null, null);
                myUndo.setEnabled(false);
            }
        });
        return myUndo;
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("have thing".equals(theEvent.getPropertyName())) {
            myUndo.setEnabled((boolean) theEvent.getNewValue());
        }
        
    }
    /**
     * For getting the integer that slider has.
     * @return the thickness integer.
     */
    public static int getThickness() {
        return myThickness;
    }
    
    /**
     * Get grid boolean value.
     * @return the boolean of grid.
     */
    public static boolean isCheckedGrid() {
        return myGridCheck;
    }
    /**
     * This is used for firing a property change.
     * @author Ziliang Wang
     * @version 11/19/2015
     */
    private class GridListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent theEvent) { 
            firePropertyChange("grid", null, myGrid.getState());
        }
    }
    /**
     * This is used for getting the value from the JSlider.
     * @author Ziliang Wang
     * @version 11/19/2015
     */
    private class SliderListener implements ChangeListener {
        @Override
        public void stateChanged(final ChangeEvent theEvent) {
            final JSlider source = (JSlider) theEvent.getSource();
            myThickness = source.getValue();
        }
    }
}
