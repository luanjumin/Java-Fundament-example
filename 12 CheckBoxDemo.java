import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxDemo extends JPanel implements ItemListener {
           JCheckBox chinButton;
           JCheckBox glassesButton;
           JCheckBox hairButton;
           JCheckBox teethButton;

           StringBuffer choices;
           JLabel pictureLabel;

           public CheckBoxDemo() {super(new BorderLayout());

                   chinButton = new JCheckBox("下巴(c)");
                   chinButton.setMnemonic(KeyEvent.VK_C);
                   chinButton.setSelected(true);

                   glassesButton = new JCheckBox("眼镜(g)");
                   glassesButton.setMnemonic(KeyEvent.VK_G);
                   glassesButton.setSelected(true);

                   hairButton = new JCheckBox("头发(h)");
                   hairButton.setMnemonic(KeyEvent.VK_H);
                   hairButton.setSelected(true);

                   teethButton = new JCheckBox("头发(h)");
                   teethButton.setMnemonic(KeyEvent.VK_H);
                   teethButton.setSelected(true);

                   chinButton.addItemListener(this);
                   glassesButton.addItemListener(this);
                   hairButton.addItemListener(this);
                   teethButton.addItemListener(this);

                   choices = new StringBuffer("cght");

                   pictureLabel = new JLabel();
                   pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
                   updatePicture();

                   JPanel checkPanel = new JPanel(new GridLayout(0,1));
                   checkPanel.add(chinButton);
                   checkPanel.add(glassesButton);
                   checkPanel.add(hairButton);
                   checkPanel.add(teethButton);

                   add(checkPanel,BorderLayout.LINE_START);
                   add(pictureLabel,BorderLayout.CENTER);
                   setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
           }
      
           public void itemStateChanged(ItemEvent e) {
                 int index = 0;
                 char c = '-';
                 Object source = e.getItemSelectable();

                 if (source == chinButton) {
                     index = 0;
                     c = 'c';
                 } else if (source == glassesButton) {
                     index = 1;
                     c = 'g';
                 } else if (source == hairButton) {
                     index = 2;
                     c = 'h';
                 } else if (source == teethButton) {
                     index = 3;
                     c = 't';
                 } 

                 if (e.getStateChange() == ItemEvent.DESELECTED) {
                     c = '-';
                 }

                 choices.setCharAt(index,c);

                 updatePicture();
        }
 
        protected void updatePicture() {
             
                  ImageIcon icon = createImageIcon ("images/geek/geel-" + choices.toString() + ".gif");
                  if (icon == null) {
                      pictureLabel.setText("没有发现图片");
                  } else {
                      pictureLabel.setText(null);
                  }
        }

        protected static ImageIcon createImageIcon(String path) {
             java.net.URL imgURL = CheckBoxDemo.class.getResource(path);
             if (imgURL != null) {
                 return new ImageIcon(imgURL);
             } else {
                 System.out.println("Couldn't find file" + path);
                 return null;
             }
        }

        public static void main(String s[]) {
   
              JFrame frame = new JFrame("CheckBoxDemo");
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

              JComponent newContentPane = new CheckBoxDemo();
              newContentPane.setOpaque(true);
              frame.setContentPane(newContentPane);

              frame.pack();
              frame.setVisible(true);
      }
}   









