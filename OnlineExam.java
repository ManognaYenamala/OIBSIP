package onlineExam;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
public class OnlineExam {
	static String user="Manogna";
	static String pwd="Manogna";
	static int quesno=0,count=0;
	static JFrame exam;
	static JLabel ques;
	static JRadioButton one,two,three,four;
	static JFrame score;
	public static void main(String[] args)
	{
		JFrame login=new JFrame("LOGIN DETAILS");
		login.setSize(500,300);
		login.setVisible(true);
		login.setLayout(null);
		login.setLocation(400,60);
		JLabel username=new JLabel("USERNAME :");
		login.getContentPane().add(username);
		username.setBounds(20,0,300,30);
		JTextField userentry=new JTextField(20);
		userentry.setBounds(150,0,300,30);
		login.add(userentry);
		JLabel password=new JLabel("PASSWORD :");
		password.setBounds(20,45,300,50);
		login.getContentPane().add(password);
		JTextField passwordentry=new JTextField(20);
		login.add(passwordentry);
		passwordentry.setBounds(150,50,300,30);
		JButton button=new JButton("LOGIN");
		login.getContentPane().add(button);
		button.setBounds(100,100,300,50);
		button.setFont(new Font("Tlwg Typo", Font.BOLD, 26));
		button.setBackground(new Color(0, 0, 51));
		button.setForeground(Color.green);
		button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 51, 102), null));
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(userentry.getText().equals(user)&&passwordentry.getText().equals(pwd))
				{
					exam=new JFrame("Start the Test");
					exam.setSize(900,600);
					exam.setVisible(true);
					exam.setLayout(null);
					exam.setLocation(300,60);
					Timer timer=new Timer();
					JLabel l1=new JLabel();
					l1.setBounds(30,30,600,50);
					l1.setFont(new Font("z003",Font.BOLD,20));
					exam.getContentPane().add(l1);
					JButton save=new JButton("Next");
					save.setFont(new Font("Tlwg Typo",Font.BOLD,20));
					save.setBounds(15,500,300,50);
					save.setBackground(new Color(0, 0, 51));
					save.setForeground(Color.green);
					save.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 51, 102), null));
					exam.add(save);
					JButton submit=new JButton("Submit");
					submit.setFont(new Font("Tlwg Typo",Font.BOLD,20));
					submit.setBounds(325,500,300,50);
					submit.setBackground(new Color(0, 0, 51));
					submit.setForeground(Color.green);
					submit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 51, 102), null));
					exam.add(submit);
					ques=new JLabel("");
					ques.setBounds(30,100,900,50);
					one=new JRadioButton("");
					two=new JRadioButton("");
					three=new JRadioButton("");
					four=new JRadioButton("");
					ques.setFont(new Font("Tlwg Typo",Font.BOLD,20));
					one.setFont(new Font("Tlwg Typo",Font.BOLD,20));
					two.setFont(new Font("Tlwg Typo",Font.BOLD,20));
					three.setFont(new Font("Tlwg Typo",Font.BOLD,20));
					four.setFont(new Font("Tlwg Typo",Font.BOLD,20));
					ButtonGroup g=new ButtonGroup();
					g.add(one);
					g.add(two);
					g.add(three);
					g.add(four);
					one.setBounds(30,150,400,50);
					two.setBounds(30,200,400,50);
					three.setBounds(30,250,400,50);
					four.setBounds(30,300,400,50);
					g.clearSelection();
					method(quesno);
					save.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									if(quesno==0 && four.isSelected()==true)
									{
										count++;
									}
									if(quesno==1&&three.isSelected()==true)
									{
										count++;
									}
									if(quesno==2&&one.isSelected()==true)
									{
										count++;
									}
									if(quesno==3&&one.isSelected()==true)
									{
										count++;
									}
									if(quesno==4)
									{
										save.setEnabled(false);
										if(two.isSelected()==true)
										{
											count++;
										}
									}
									else
									{
										g.clearSelection();
										quesno++;
										method(quesno);
									}
								}
							});
					submit.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							score=new JFrame();
							score.setBounds(100,100,300,100);
							score.setVisible(true);
							score.setLocation(400,100);
							JLabel marks=new JLabel("Your score is "+" "+count);
							marks.setBounds(0,0,300,30);
							marks.setFont(new Font("Tlwg Typo",Font.BOLD,20));
							score.getContentPane().add(marks);
							timer.cancel();
						}
					});
					timer.scheduleAtFixedRate(new TimerTask()
					{
						int i=50;
						public void run()
						{
							l1.setText("Time left"+" "+i+"sec");
							i--;
							if(i<=0)
							{
								timer.cancel();
								l1.setText("Time out Please click on the submit button to view your score");
								save.setEnabled(false);
							}
						}
					},0,1000);
				}
				else
				{
					userentry.setText("INVALID DETAILS");
					passwordentry.setText("INVALID DETAILS");
				}
			}
		});
	}
	public static void method(int quesno)
	{
		if(quesno==0)
		{
			ques.setText((quesno+1)+" "+"."+"The basic architecture of computer was developed by");
			one.setText("Charles Babbage");
			two.setText("Blaise Pascal");
			three.setText("Garden Moore");
			four.setText("John Von Neumann");
		}
		else if(quesno==1)
		{
			ques.setText((quesno+1)+" "+"."+"In how many generationn a computer can be classified?");
			one.setText("3");
			two.setText("4");
			three.setText("5");
			four.setText("6");
		}
		else if(quesno==2)
		{
			ques.setText((quesno+1)+" "+"."+"Fifth generation computers are based on");
			one.setText("Artificial Intelligence");
			two.setText("System Knowledge");
			three.setText("VVLSI");
			four.setText("None of these");
		}
		else if(quesno==3)
		{
			ques.setText((quesno+1)+" "+"."+"Which of the following is non-volatile?");
			one.setText("SRAM");
			two.setText("DRAM");
			three.setText("ROM");
			four.setText("All of the above");
		}
		else if(quesno==4)
		{
			ques.setText((quesno+1)+" "+"."+"Which protocol provides e-mail facility among different hosts?");
			one.setText("FTP");
			two.setText("SMTP");
			three.setText("TELNET");
			four.setText("None of these");
		}
		exam.getContentPane().add(ques);
		exam.add(four);
		exam.add(three);
		exam.add(two);
		exam.add(one);
	}
}
