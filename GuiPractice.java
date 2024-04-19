
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class GuiPractice extends JFrame implements ItemListener
{
  private JPanel panel;
  private JComboBox<String> imagesComboBox;
  private JLabel imageLabel;

  private ImageIcon ballImage;
  private ImageIcon cardImage;
  private ImageIcon hatImage;
  private ImageIcon shoeImage;

  private String selected;

  public static void main(String[] args)
  {
    JFrame frame = new GuiPractice();
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  GuiPractice()
  {
    super("GuiPractice");
    panel = new JPanel();

    // set up the combo box
    imagesComboBox = new JComboBox<String>();
    imagesComboBox.addItem("ball");
    imagesComboBox.addItem("card");
    imagesComboBox.addItem("hat");
    imagesComboBox.addItem("shoe");
    panel.add(imagesComboBox);

    // the images
    // the extra stuff is to resize it in the begining
    ballImage = new ImageIcon(new ImageIcon("images/ball.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
    cardImage = new ImageIcon(new ImageIcon("images/card.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
    hatImage = new ImageIcon(new ImageIcon("images/hat.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
    shoeImage = new ImageIcon(new ImageIcon("images/shoe.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));;

    // Create the image label
    imageLabel = new JLabel(ballImage);
    panel.add(imageLabel);

    setContentPane(panel);

    imagesComboBox.addItemListener(this);

    // the selected
    selected = "ball";
  }

  public void itemStateChanged(ItemEvent e)
  {
    if (e.getItemSelectable() == imagesComboBox) 
    {
      if (e.getStateChange() == ItemEvent.SELECTED) 
      {
        if(imagesComboBox.getSelectedItem().equals("ball")) imageLabel.setIcon(ballImage);
        if(imagesComboBox.getSelectedItem().equals("card")) imageLabel.setIcon(cardImage);
        if(imagesComboBox.getSelectedItem().equals("hat"))  imageLabel.setIcon(hatImage);
        if(imagesComboBox.getSelectedItem().equals("shoe")) imageLabel.setIcon(shoeImage);

        System.out.println(((String)imagesComboBox.getSelectedItem()) + " selected");
        System.out.println(selected + " deselected");

        selected = (String)imagesComboBox.getSelectedItem();
      }
    }
  }
}
