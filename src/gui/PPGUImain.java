/*
 * TCSS 305 Autumn - PowerPaint
 */
package gui;

import java.awt.EventQueue;

/**
 * @author Ziliang
 * @version 11/6/2015
 */
public final class PPGUImain {
    /**
     * Default constructor, but nothing in there.
     */
    private PPGUImain() {
        //do nothing
    }
    /**
     * The main method.
     * @param theArgs 
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final PPGUI gui = new PPGUI();
                gui.start();
            }
        });
    }

}
