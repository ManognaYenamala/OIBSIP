package firstFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.Window.Type;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Task2{
	static String account1="123456789123";
	static String pin1="1234";
	static String account2="987654321987";
	static String pin2="3112";
	static JLabel wrongpin;
	static int balance=100000;
	static int balance2=50000;
	static int amount=0;
	static String transaction_history="";
	static JFrame txndetails;
	static JFrame txndetails2;
	static int y=0;
	static JLabel txn_history;
	public static void main(String[] args)
	{
		txndetails2=new JFrame();
		txndetails2.setBounds(100,100,900,600);
		txndetails2.getContentPane().setBackground(new Color(204,255,255));
		txndetails2.setLayout(null);
		JFrame txndetails=new JFrame();
		txndetails.setBounds(100,100,900,600);
		txndetails.getContentPane().setBackground(new Color(204,255,255));
		txndetails.setLayout(null);
		JFrame frame=new JFrame("WELCOME TO THE ATM");
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.setBackground(new Color(102, 51, 102));
		frame.setBounds(100,100,900,600);
		frame.setLayout(null);
		frame.setVisible(true);
		Border border=BorderFactory.createRaisedBevelBorder();
			JLabel acno=new JLabel("ENTER YOUR ACCOUNT NUMBER:");
			acno.setBounds(250,200,600,50);
			frame.getContentPane().add(acno);
			acno.setFont(new Font("Tlwg Typo",Font.BOLD,20));
				JTextField ac=new JTextField(100);
				frame.getContentPane().add(ac);
				ac.setBounds(600,200,600,50);
			JLabel pin=new JLabel("ENTER PIN NUMBER:");
			pin.setBounds(250,300,600,50);
			pin.setFont(new Font("Tlwg Typo",Font.BOLD,20));
			frame.getContentPane().add(pin);
				JPasswordField pinnum=new JPasswordField(100);
				frame.getContentPane().add(pinnum);
				pinnum.setBounds(600,300,600,50);
			JButton proceed=new JButton("PROCEED");
			proceed.setBackground(Color.yellow);
			proceed.setFont(new Font("Tlwg Typo",Font.BOLD,20));
			proceed.setBounds(900,400,300,50);
			frame.add(proceed);
			proceed.setBorder(border);
			JButton clear=new JButton("CLEAR");
			clear.setBackground(Color.red);
			clear.setFont(new Font("Tlwg Typo",Font.BOLD,20));
			clear.setBounds(250,400,300,50);
			clear.setBorder(border);
			frame.add(clear);
			clear.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							ac.setText(null);
							pinnum.setText(null);
							wrongpin.setVisible(false);
						}
					});
			//ACTION LISTENER FOR THE BUTTON PROCEED
			proceed.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JFrame frame2=new JFrame("Welcome to the details section");
					frame2.setBounds(100,100,900,600);
					frame2.getContentPane().setBackground(new Color(204,255,255));
					frame2.setLayout(null);
					int withdraw_amount;
					if((account1.equals(ac.getText())==true && pin1.equals(pinnum.getText())==true) || (account2.equals(ac.getText())==true && pin2.equals(pinnum.getText())==true)) 
					{		
							frame2.setVisible(true);
							JButton button1 =new JButton("WITHDRAW");
							button1.setBackground(new Color(255,255,255));
							button1.setFont(new Font("Tlwg Typo",Font.BOLD,20));
							frame2.add(button1);
							Border border1=BorderFactory.createMatteBorder(3,2,1,1,Color.black);
							button1.setBorder(border1);
							button1.setBounds(0,100,300,50);
								button1.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e)
											{
												JFrame framewithdraw=new JFrame();
												framewithdraw.setBounds(100,100,900,600);
												framewithdraw.getContentPane().setBackground(new Color(204,255,255));
												framewithdraw.setLayout(null);
												framewithdraw.setVisible(true);
												JLabel drawinglabel=new JLabel("Enter the amount you want to withdraw below");
												drawinglabel.setFont(new Font("Tlwg Typo",Font.BOLD,20));
												drawinglabel.setBounds(150,50,600,50);
												framewithdraw.getContentPane().add(drawinglabel);
												JTextField drawamount=new JTextField(15);
												drawamount.setBounds(300,100,300,35);
												framewithdraw.add(drawamount);
												JButton yes=new JButton("OK");
												yes.setBackground(Color.yellow);
												yes.setForeground(Color.black);
												yes.setFont(new Font("Tlwg Typo",Font.BOLD,20));
												framewithdraw.add(yes);
												Border border1=BorderFactory.createMatteBorder(3,2,1,1,Color.black);
												yes.setBorder(border1);
												yes.setBounds(400,150,75,30);
												yes.addActionListener(new ActionListener()
														{
															public void actionPerformed(ActionEvent e)
															{
																amount=Integer.parseInt(drawamount.getText());
																if(amount>balance)
																{
																			JFrame popup1=new JFrame();
																			popup1.setBounds(100,100,500,400);
																			JLabel labeldraw=new JLabel("MORE THAN BALANCE");
																			drawamount.setText(null);
																			labeldraw.setBounds(300,200,300,50);
																			labeldraw.setFont(new Font("Tlwg Typo",Font.BOLD,20));
																			popup1.getContentPane().add(labeldraw);
																			popup1.setVisible(true);
																			//popup1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
																}
																else if(amount<500)
																{
																	JFrame popup2=new JFrame();
																	popup2.setBounds(100,100,900,300);
																	JLabel labeldraw=new JLabel("LESS THAN 500");
																	drawamount.setText(null);
																	labeldraw.setBounds(300,200,300,50);
																	labeldraw.setFont(new Font("Tlwg Typo",Font.BOLD,20));
																	popup2.getContentPane().add(labeldraw);
																	popup2.setVisible(true);
																	//popup2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
																}
																else if(amount>10000)
																{
																	JFrame popup3=new JFrame();
																	popup3.setBounds(100,100,500,400);
																	JLabel drawlimit=new JLabel("YOU CANNOT WITHDRAW MORE THAN 10000 ON A SINGLE DAY");
																	drawamount.setText(null);
																	drawlimit.setBounds(300,200,300,50);
																	drawlimit.setFont(new Font("Tlwg Typo",Font.BOLD,20));
																	popup3.getContentPane().add(drawlimit);
																	popup3.setVisible(true);
																	//popup3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
																}
																else
																{
																	balance=balance-amount;
																	JFrame popup4=new JFrame();
																	popup4.setBounds(100,100,800,200);
																	transaction_history=amount+" "+"has been withdrawn";
																	txn_history=new JLabel(transaction_history);
																	if(ac.getText().equals(account1))
																		txndetails.getContentPane().add(txn_history);
																	else
																		txndetails2.getContentPane().add(txn_history);
																	txn_history.setBounds(0,y,500,50);
																	txn_history.setFont(new Font("Twlg Typo",Font.BOLD,20));
																	y=y+30;
																	JLabel amountwithdraw=new JLabel("AMOUNT"+" "+amount+" "+"WITHDRAWN SUCCESSFULLY");
																	popup4.getContentPane().add(amountwithdraw);
																	drawamount.setText(null);
																	amountwithdraw.setFont(new Font("Tlwg Typo",Font.BOLD,20));
																	amountwithdraw.setBounds(300,200,600,50);
																	popup4.setVisible(true);
																}
															}
														});
											}
										});
							JButton button2=new JButton("DEPOSIT");
							button2.setBackground(new Color(255,255,255));
							button2.setFont(new Font("Tlwg Typo",Font.BOLD,20));
							button2.setBounds(600,100,300,50);
							frame2.add(button2);
							button2.setBorder(border1);
								button2.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e)
											{
												JFrame framedeposit=new JFrame();
												framedeposit.setBounds(100,100,900,600);
												framedeposit.getContentPane().setBackground(new Color(204,255,255));
												framedeposit.setLayout(null);
												framedeposit.setVisible(true);
												JLabel drawinglabel=new JLabel("Enter the amount you want to deposit below");
												drawinglabel.setFont(new Font("Tlwg Typo",Font.BOLD,20));
												drawinglabel.setBounds(150,50,600,50);
												framedeposit.getContentPane().add(drawinglabel);
												JTextField drawamount=new JTextField(15);
												drawamount.setBounds(300,100,300,35);
												framedeposit.add(drawamount);
												JButton yes=new JButton("OK");
												yes.setBackground(Color.yellow);
												yes.setForeground(Color.black);
												yes.setFont(new Font("Tlwg Typo",Font.BOLD,20));
												framedeposit.add(yes);
												Border border1=BorderFactory.createMatteBorder(3,2,1,1,Color.black);
												yes.setBorder(border1);
												yes.setBounds(400,150,75,30);
												yes.addActionListener(new ActionListener()
														{
															public void actionPerformed(ActionEvent e)
															{
																int amountdeposit=Integer.parseInt(drawamount.getText());
																if(amountdeposit==0)
																{
																	JLabel wrongdepo=new JLabel("ENTER VALID AMOUNT");
																	JFrame popup5=new JFrame();
																	popup5.setBounds(100,100,500,200);
																	popup5.getContentPane().add(wrongdepo);
																	popup5.setVisible(true);
																}
																else {
																	balance=balance+amountdeposit;
																	JFrame popup6=new JFrame();
																	popup6.setBounds(100,100,500,200);
																	transaction_history=amountdeposit+" "+"deposited into your account";
																	JLabel txn_history=new JLabel(transaction_history);
																	if(ac.getText().equals(account1))
																		txndetails.getContentPane().add(txn_history);
																	else
																		txndetails2.getContentPane().add(txn_history);
																	txn_history.setBounds(0,y,600,50);
																	txn_history.setFont(new Font("Twlg Typo",Font.BOLD,20));
																	y=y+30;
																	JLabel success=new JLabel(amountdeposit+" "+"deposited successfully into your account");
																	popup6.getContentPane().add(success);
																	popup6.setVisible(true);
																}
															}
														});
											}
										});
							JButton balan=new JButton("BALANCE");
							balan.setBackground(new Color(255,255,255));
							balan.setFont(new Font("Tlwg Typo",Font.BOLD,20));
							balan.setBounds(600,200,300,50);
							frame2.add(balan);
							balan.setBorder(border1);
								balan.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e)
											{
												int balanced=0;;
												if(ac.getText().equals(account1)) 
												{
													balanced=balance;
												}
												else
													balanced=balance2;
												JFrame framebalance=new JFrame("BALANCE DETAILS");
												framebalance.setBounds(100,100,500,100);
												JLabel balancelabel=new JLabel("YOUR BALANCE IS "+balanced+" ");
												framebalance.getContentPane().add(balancelabel);
												balancelabel.setFont(new Font("Tlwg Typo",Font.BOLD,20));
												framebalance.setVisible(true);
											}
										});
							JButton button3=new JButton("TRANSFER");
							button3.setBackground(new Color(255,255,255));
							button3.setFont(new Font("Tlwg Typo",Font.BOLD,20));
							button3.setBounds(0,200,300,50);
							frame2.add(button3);
							button3.setBorder(border1);
							button3.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e)
										{
											JFrame frametransfer=new JFrame();
											frametransfer.setBounds(100,100,900,600);
											frametransfer.getContentPane().setBackground(new Color(204,255,255));
											frametransfer.setLayout(null);
											frametransfer.setVisible(true);
											JLabel totransfer=new JLabel("Enter the account number to whom you want to transfer:");
											totransfer.setFont(new Font("Tlwg Typo",Font.BOLD,20));
											totransfer.setBounds(150,30,900,50);
											frametransfer.getContentPane().add(totransfer);
											JTextField accountno=new JTextField(15);
											accountno.setBounds(300,100,300,25);
											frametransfer.add(accountno);
											JLabel amounttotransfer=new JLabel("Enter the amount to transfer:");
											amounttotransfer.setFont(new Font("Tlwg Typo",Font.BOLD,20));
											amounttotransfer.setBounds(150,150,900,50);
											frametransfer.getContentPane().add(amounttotransfer);
											JTextField transferamount=new JTextField(15);
											transferamount.setBounds(300,200,300,25);
											frametransfer.add(transferamount);
											JButton yes=new JButton("TRANSFER");
											yes.setBackground(Color.yellow);
											yes.setForeground(Color.black);
											yes.setFont(new Font("Tlwg Typo",Font.BOLD,20));
											frametransfer.add(yes);
											Border border1=BorderFactory.createMatteBorder(3,2,1,1,Color.black);
											yes.setBorder(border);
											yes.setBounds(400,300,100,50);
											yes.addActionListener(new ActionListener()
													{
														public void actionPerformed(ActionEvent e)
														{
															int tranferamount=Integer.parseInt(transferamount.getText());
															if(accountno.getText().equals(account2))
															{
																if(ac.getText().equals(account1))
																{
																	if(balance!=0 || tranferamount<balance)
																	{
																	balance2=balance2+tranferamount;
																	balance=balance-tranferamount;
																	JFrame trnfer=new JFrame();
																	trnfer.setBounds(100,100,600,100);
																	transaction_history=tranferamount+" "+"has been transfered into"+" "+account2;
																	JLabel txn_history=new JLabel(transaction_history);
																	txndetails.getContentPane().add(txn_history);
																	txn_history.setBounds(0,y,600,50);
																	y=y+30;
																	txn_history.setFont(new Font("Twlg Typo",Font.BOLD,20));
																	JLabel successful=new JLabel("Transaction successful");
																	successful.setFont(new Font("Tlwg Typo",Font.BOLD,20));
																	successful.setBounds(0,30,900,50);
																	trnfer.getContentPane().add(successful);
																	trnfer.setVisible(true);
																	}
																	else
																	{
																		JFrame nobalance=new JFrame();
																		nobalance.setBounds(100,100,300,100);
																		JLabel nill=new JLabel("INSUFFICIENT BALANCE");
																		nill.setFont(new Font("Tlwg Typo",Font.BOLD,20));
																		nill.setBounds(150,150,900,50);
																		nobalance.getContentPane().add(nill);
																		nobalance.setVisible(true);
																	}
																}
															}
															else if(accountno.getText().equals(account1))
															{
																
																if(ac.getText().equals(account2))
																{
																	if(balance2!=0 || tranferamount<balance2)
																	{
																	balance=balance+tranferamount;
																	balance2=balance2-tranferamount;
																	JFrame trnfer=new JFrame();
																	trnfer.setBounds(100,100,600,100);
																	JLabel successful=new JLabel("Transaction successful");
																	transaction_history=tranferamount+" "+"has been transfered into"+" "+account1;
																	JLabel txn_history=new JLabel(transaction_history);
																	txndetails2.getContentPane().add(txn_history);
																	txn_history.setBounds(0,y,600,50);
																	y=y+30;
																	txn_history.setFont(new Font("Twlg Typo",Font.BOLD,20));
																	successful.setFont(new Font("Tlwg Typo",Font.BOLD,20));
																	successful.setBounds(0,30,900,50);
																	trnfer.getContentPane().add(successful);
																	trnfer.setVisible(true);
																	}
																	else
																	{
																		JFrame nobalance=new JFrame();
																		nobalance.setBounds(100,100,300,100);
																		JLabel nill=new JLabel("INSUFFICIENT BALANCE");
																		nill.setFont(new Font("Tlwg Typo",Font.BOLD,20));
																		nill.setBounds(150,150,900,50);
																		nobalance.getContentPane().add(nill);
																		nobalance.setVisible(true);
																	}
																}
															}
														}
													});
										}
									});
							JButton button4=new JButton("TRANSACTION DETAILS");
							button4.setBackground(new Color(255,255,255));
							button4.setFont(new Font("Tlwg Typo",Font.BOLD,20));
							button4.setBounds(0,300,300,50);
							frame2.add(button4);
							button4.setBorder(border1);
							button4.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e)
										{
											if(ac.getText().equals(account1))
											{
												txndetails.setVisible(true);
											}
											else if(ac.getText().equals(account2))
											{
												txndetails2.setVisible(true);
											}
										}
									});
							JButton button5=new JButton("QUIT");
							button5.setBackground(new Color(255,255,255));
							button5.setFont(new Font("Tlwg Typo",Font.BOLD,20));
							button5.setBounds(600,300,300,50);
							frame2.add(button5);
							button5.setBorder(border1);
							button5.addActionListener(b ->{
								frame2.dispose();
								pinnum.setText(" ");
								ac.setText(" ");
								transaction_history=" ";
								//y=0;
							});
					}
					else {
						ac.setText("INVALID DETAILS");
					}
				}
			});
	}
}
