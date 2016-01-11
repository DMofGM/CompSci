import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BabyHangman extends JFrame implements ActionListener {
	JPanel nPanel;
	JPanel cPanel;
	JLabel label;
	BabyHangmanMethods baby;
	String dashes = "";
	public static void main(String [] args){
		BabyHangman obj = new BabyHangman();
		obj.setVisible(true);
	}
	
	public BabyHangman(){
		baby = new BabyHangmanMethods();
		baby.makeButtons();
		setLayout(new BorderLayout());
		setSize(800,400);
		//System.out.println("WHAT?");
		JButton [] hButtons = baby.buttons;
		//System.out.println("WHAT?");
		nPanel = new JPanel();
			for(int i = 0; i < baby.buttons.length; i++){
				
				
				baby.buttons[i].addActionListener(this);
				nPanel.add(baby.buttons[i]);
				
				
			}
		add(nPanel, BorderLayout.NORTH);
		cPanel = new JPanel();
			for(int i = 0; i < baby.word.length(); i++){
				dashes += "_ ";
			}
			label = new JLabel(dashes);
			cPanel.add(label);
		
		add(cPanel, BorderLayout.CENTER);
		JPanel sPanel = new JPanel();
			JButton exit = new JButton("Exit");
			exit.addActionListener(this);
			sPanel.add(exit);
		add(sPanel, BorderLayout.SOUTH);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		String let = e.getActionCommand();
		String newset = "";
		int index =0;
		if(let.equals("Exit"))
			System.exit(0);
		for(int i = 0; i < baby.buttons.length; i++){
			if(let.equals(baby.buttons[i].getActionCommand())){
				baby.buttons[i].setText("");
				baby.buttons[i].disable();
			}
		}
		for(String mlet: baby.lets){
			if(let.equals(mlet) || baby.guessed[index]){
				newset += mlet;
				//baby.buttons[index].setText("");
				baby.guessed[index] = true;
			}else{
				newset += "_ ";
			}
			index++;
		}
		label.setText(newset);
		
		
	}
	
	

}
