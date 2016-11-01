/*
 * TCSS 305 Autumn - PowerPaint
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;


/**
 * This class is used for setting an color choosing JMenuItem.
 * @author Ziliang Wang
 * @version 11/18/2015
 */
public class ColorChoosing implements ActionListener {
    /**Default Color for color chooser. */
    private static Color myColor = Color.BLACK;
    /**
     * This is for setting JMenuItem that can showing the color dialog.
     * @param theName the button name.
     * @return a functional JMenuItem.
     */
    public JMenuItem colorItem(final String theName) {
        
        final JMenuItem color = new JMenuItem(theName);
        color.setMnemonic(KeyEvent.VK_C);
        final ColorIcon icon = new ColorIcon(10);
        color.setIcon(icon);
        color.addActionListener(this);
        return color;
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myColor = JColorChooser.showDialog(null, "ColorChoosing", myColor);
        
       
    }
    /**
     * A static method that used for get color from color chooser.
     * @return the color that color chooser chose. 
     */
    public static Color getColor() {
        return myColor;
    }
    /**
     * Set the color icon for the JMenuItem.
     * @author Ziliang Wang
     * @version 11/20/2015
     */
    public class ColorIcon implements Icon {
        /** Width field. */
        private final int myWidth;
        /** Color field.*/
        private Color myIconColor;
    
        /**
         * Initialize the field.
         * @param theWidth set the width for icon. 
         */
        public ColorIcon(final int theWidth) {
            myWidth = theWidth;
            myIconColor = myColor;
        }
        /**
         * @return the width.
         */
        public int getIconWidth() {
            return myWidth;
        }
        /**
         * @return the height.
         */
        public int getIconHeight() {
            return myWidth / 2;
        }
        /**
         * Give the color to icon.
         * @param theColor set the icon color.
         */
        public void setColor(final Color theColor) {
            myIconColor = theColor;
        }
    
        @Override
        public void paintIcon(final Component arg0, final Graphics arg1, 
                              final int theX, final int theY) {
            myIconColor = myColor;
            final Graphics2D g2 = (Graphics2D) arg1;
            final Rectangle2D.Double ellipse = new Rectangle2D.Double(
                                                                theX, theY, myWidth, myWidth);
            g2.setColor(myIconColor);
            g2.fill(ellipse);
            
        }
    }
}
