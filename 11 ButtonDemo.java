import java.awt.*;
import java.awt.event.*;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class ButtonDemo extends JPanel implements ActionListener {
          protected JButton b1,b2,b3;

          public ButtonDemo() {
                ImageIcon leftButtonIcon      = createImageIcon("images/right.gif");
                ImageIcon middleButtonIcon    = createImageIcon("images/middle.gif");
                ImageIcon rightButtonIcon     = createImageIcon("images/right.gif");

                b1 = new JButton("失效中间按钮(D)", leftButtonIcon);
                b1.setVerticalTextPosition     (AbstractButton.CENTER);
                b1.setHorizontalTextPosition   (AbstractButton.LEADING);
                b1.setMnemonic                 (KeyEvent.VK_D);
                b1.setActionCommand            ("disable");

                b2 = new JButton                 ("M中间按钮", middleButtonIcon);
                b2.setVerticalTextPosition       (AbstractButton.BOTTOM);
                b2.setHorizontalTextPosition     (AbstractButton.CENTER);
                b2.setMnemonic                   (KeyEvent.VK_M);

                b3 = new JButton                ("e激活中间按钮", rightButtonIcon);
                b3.setMnemonic                  (KeyEvent.VK_E);
                b3.setActionCommand             ("enable");
                b3.setEnabled                   (false);
        
                b1.addActionListener(this);
                b3.addActionListener(this);

                b1.setToolTipText("点击这个按钮，将使中间的按钮失效!");
                b2.setToolTipText("点击这个按钮，没有任何的事件发生!");
                b2.setToolTipText("点击这个按钮，将使中间的按钮有效!");

                add(b1);
                add(b2);
                add(b3);
          }

          public void actionPerformed(ActionEvent e) {
                if ("disable".equals(e.getActionCommand())) {
                    b2.setEnabled(false);
                    b1.setEnabled(false);
                    b3.setEnabled(true);
                } else {
                    b2.setEnabled(true);
                    b1.setEnabled(true);
                    b3.setEnabled(false);
                }
          }
          
          protected static ImageIcon createImageIcon (String path) {
                 java.net.URL imgURL = ButtonDemo.class.getResource(path);
                 if (imgURL != null) {
                     return new ImageIcon(imgURL);
                 } else {
                     System.err.println("Couldn't find file:" + path);
                     return null;
                 } 
         }

         public static void main(String[] args) {
                  JFrame.setDefaultLookAndFeelDecorated(true);
     
                  JFrame frame = new JFrame("ButtonDemo");
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                  ButtonDemo newContentPane = new ButtonDemo();
                  newContentPane.setOpaque(true);
                  frame.setContentPane(newContentPane);

                  frame.pack();
                  frame.setVisible(true);
         }
}


                  


 
 
 
 



 












