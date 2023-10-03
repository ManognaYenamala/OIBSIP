package firstFrame;
import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.util.Random;
import java.lang.Math;
public class Image
{
	private static final JLabel lblNewLabel = new JLabel("");
	static int rand;
	static int a;
	static int count=0,score=0;
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("JAVA GAME");
		frame.setSize(738,500);
		frame.getContentPane().setLayout(null);
		Border border=BorderFactory.createBevelBorder(500,Color.black,Color.orange);
		JButton button =new JButton("PLAY");
		button.setBounds(304,222, 170, 50);
		button.setFont(new Font("Tlwg Typo", Font.BOLD, 26));
		button.setBackground(new Color(0, 0, 51));
		button.setForeground(Color.green);
		button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 51, 102), null));
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e)
			{
				JFrame frame2=new JFrame("PLAY THE GAME");
				frame2.setSize(1800,500);
				frame2.getContentPane().setLayout(null);
				frame2.getContentPane().setBackground(Color.black);
				JLabel gamel=new JLabel("The computer will generate a random number.");
				gamel.setBounds(550,50,600,50);
				JLabel gamel1=new JLabel("If you guess you win othewise you lose.You will have only three attempsts.Let's start");
				gamel1.setBounds(400,100,900,50);
				gamel.setFont(new Font("Z003",Font.BOLD,20));
				gamel1.setFont(new Font("Z003",Font.BOLD,20));
				JLabel label2=new JLabel("Guess the number::");
				label2.setBounds(550,150,600,50);
				label2.setFont(new Font("Tlwg Typo", Font.BOLD, 26));
				label2.setForeground(Color.white);
				frame2.getContentPane().add(label2);
				JTextField text=new JTextField(20);
				text.setBounds(550,200,300,25);
				frame2.getContentPane().add(text);
				gamel.setForeground(Color.white);
				gamel1.setForeground(Color.white);
				frame2.getContentPane().add(gamel);
				frame2.getContentPane().add(gamel1);
				frame2.setVisible(true);
				JLabel label3=new JLabel("RESULT");
				label3.setFont(new Font("Tlwg Typo", Font.BOLD, 26));
				label3.setForeground(Color.white);
				frame2.getContentPane().add(label3);
				label3.setBounds(660,300,300,50);
				JButton resu=new JButton("CHECK");
				resu.setBounds(625,250, 170, 50);
				resu.setFont(new Font("Tlwg Typo", Font.BOLD, 26));
				resu.setBackground(new Color(0, 0, 51));
				resu.setForeground(Color.green);
				resu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 51, 102), null));
				frame2.getContentPane().add(resu);
				resu.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						count+=1;
						if(count>=3)
						{
							text.setEditable(false);
							resu.setEnabled(false);
							label3.setText("Your score is"+score+"/3");
							count=0;
						}
						else {
						Random r=new Random();
						rand=Math.abs(r.nextInt(5));
						a=Integer.parseInt(text.getText());
						if(rand==a)
						{
							score++;
							label3.setText("Congrats! You won");
						}
						else
						{
							label3.setText("Number not matched");
						}}
					}
				});
			}
		});
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/rguktrkvalley/eclipse-workspace/SwingDemo/src/space.jpg"));
		lblNewLabel_1.setBounds(0, 0, 738, 470);
		frame.getContentPane().add(lblNewLabel_1);
		//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}