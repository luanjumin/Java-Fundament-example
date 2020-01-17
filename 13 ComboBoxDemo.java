import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.SimpleDateFormat;
@SuppressWarnings("unchecked")
public class ComboBoxDemo extends JPanel implements ActionListener {
       static JFrame frame;
       JLabel result;
       String currentPattern;
 
       public ComboBoxDemo() {
             setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
             String[] patternExamples = {
                         "dd MMMMM yyyy",
                         "dd.MM.yy",
                         "MM/dd/yy",
                         "yyyy.MM.dd G 'at' hh:mm:ss z",
                         "EEE, MMM d, ' 'yy",
                         "h:mm a",
                         "H:mm:ss:SSS",
                         "K:mm a,z",
                         "yyyy.MMMMM.dd GGG hh:mm aaa" };

               currentPattern = patternExamples[0];

               JLabel patternLabel1 = new JLabel("输入一个字符格式或者");
               JLabel patternLabel2 = new JLabel("从下拉列表中选择一种");

               JComboBox patternList = new JComboBox(patternExamples);
               patternList.setEditable(true);
               patternList.addActionListener(this);

               JLabel resultLabel = new JLabel("当前 日期/时间",JLabel.LEADING);
               result = new JLabel(" ");
               result.setForeground(Color.black);
               result.setBorder(BorderFactory.createCompoundBorder(
                                        BorderFactory.createLineBorder(Color.black),
                                        BorderFactory.createEmptyBorder(15,15,15,15)
               ));

               JPanel patternPanel = new JPanel();
               patternPanel.setLayout(new BoxLayout(patternPanel,BoxLayout.PAGE_AXIS));
               patternPanel.add(patternLabel1);
               patternPanel.add(patternLabel2);
               patternList.setAlignmentX(Component.LEFT_ALIGNMENT);
               patternPanel.add(patternList);
            
               JPanel resultPanel = new JPanel(new GridLayout(0,1));
               resultPanel.add(resultLabel);
               resultPanel.add(result);

               patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
               resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

               add(patternPanel);        
               add(Box.createRigidArea(new Dimension(0,10)));
               add(resultPanel);

               setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

               reformat();
          }

          public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String newSelection = (String)cb.getSelectedItem();
                currentPattern = newSelection;
                reformat();
          }

          public void reformat() {
                Date today = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat(currentPattern);
                try {
                      String dateString = formatter.format(today);
                      result.setForeground(Color.black);
                      result.setText(dateString);
                } catch (IllegalArgumentException iae) {
                      result.setForeground(Color.red);
                      result.setText("Error:" + iae.getMessage());
                }
          }
@SuppressWarnings("unchecked")
          public static void main(String[] args) {
              JFrame.setDefaultLookAndFeelDecorated(true);

              frame = new JFrame("ComboBoxDemo");
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

              JComponent newContentPane = new ComboBoxDemo();
              newContentPane.setOpaque(true);
              frame.setContentPane(newContentPane);

              frame.pack();
              frame.setVisible(true);
       }
}
           








 

