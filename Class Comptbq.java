package projet2;
import java.util.Scanner;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comptbq extends JFrame{
	float compt=1000;
	JPanel p=new JPanel();
	 JPanel p1=new JPanel();
	 JPanel p2=new JPanel();
	JLabel l=new JLabel("entrer la carte bancaire");
	 JLabel l3=new JLabel("entre le code de ton carte,.....");
	 JLabel l1=new JLabel("Bonjours, tu peut tirer:");
	JOptionPane op=new JOptionPane();
	String[] t= {"100 DH","200 DH","300 DH","400 DH","500 DH"};
	String[] tb= {"0","1","2","3","4","5","6","7","8","9","SUPPRIMER","ENTRER"};
	JButton[] tabb=new JButton[tb.length];
	JButton b= new JButton("ok");
	JComboBox c=new JComboBox(t);
	JMenuBar M=new JMenuBar();
	JMenu m=new JMenu("mon solde");
	JMenu s=new JMenu("solde restant");
	ButtonGroup gr=new ButtonGroup();
	JRadioButtonMenuItem r=new JRadioButtonMenuItem("oui");
	JRadioButtonMenuItem r1=new JRadioButtonMenuItem("non");
	
	public Comptbq() {
		l3.setHorizontalAlignment(JLabel.CENTER);
		l3.setPreferredSize(new Dimension(325, 125));
		this.setSize(500, 500);
		this.setTitle("CB");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		fct();
		this.setContentPane(p);
		this.setJMenuBar(M);
		this.setVisible(true);
		
	}
 public void fct() {
	 JPanel p3 =new JPanel();
	 gr.add(r);
	 gr.add(r1);
	 s.add(r); s.add(r1); m.add(s);
	 M.add(m);
	 for(int i=0;i<tb.length;i++) {
		 tabb[i]=new JButton(tb[i]);
		 tabb[i].setEnabled(false);
		 p3.add(tabb[i]);
		 switch(i) {
		 case 10: 
			 tabb[i].addActionListener(new ActionListener(){
				 public void actionPerformed(ActionEvent e) {
					 l3.setText(" "); 
				 }
			 });
			 break;
		 case 11:
			 tabb[i].setEnabled(false);
				
			 tabb[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					op.showMessageDialog(null,"si tu veux vérifier ton solde ou tirer l'argent cliquer en haut sur mon solde puis solde restant puis oui sinon cliquer sur non pour reçevoire ton carte","CB",op.INFORMATION_MESSAGE);
					r1.setEnabled(true);
					r.setEnabled(true);
					}
			 });
			 break;
			 
			 default:
				 tabb[i].addActionListener(new ActionListener(){
					 public void actionPerformed(ActionEvent e) {
						 tabb[11].setEnabled(true);
						 l3.setText(((JButton)e.getSource()).getText()); 
					 }
				 });
				break;
		 }
			 
		 }
	 
	 r1.setEnabled(false);
	 r.setEnabled(false);
 b.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
			for(int i=0;i<tb.length-1;i++) {
				tabb[i].setEnabled(true);
				
			}
					
		r1.setEnabled(false);
		b.setEnabled(false);
		r.setEnabled(false);
	}
 });
 
 r.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
		int i= op.showOptionDialog(null,"combien d'argent tu veux tirer ","CB",op.YES_NO_CANCEL_OPTION,op.QUESTION_MESSAGE,null,t,t[0]);
			 switch(i) {
			 case 0:compt=compt-100; break;
			 case 1:compt=compt-200;break;
			 case 2: compt=compt-300;break;
			 case 3: compt=compt-400; break;
			 case 4: compt=compt-500;break;
			 }
	if (compt<=0)
		l3.setText("impossible d'éffectuer l'opération tu a zéro DH"); 
	else
	l3.setText("il vous reste "+compt + " DH");
	b.setEnabled(false);
	r.setEnabled(true);
		}
 });
 
 r1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		r1.setEnabled(false);
		b.setEnabled(true);
		r.setEnabled(false);
		for(int i=0;i<tb.length;i++)
			tabb[i].setEnabled(false);
			
	}
 });
 p.setLayout(new BorderLayout());
 p1.add(l);
 p1.add(b);
 p2.add(l1);
 p2.add(c);
p2.add(l3);
 p.add(p1,BorderLayout.SOUTH);
 p.add(p2,BorderLayout.NORTH);
 p.add(p3,BorderLayout.CENTER);
 }
  }
  



