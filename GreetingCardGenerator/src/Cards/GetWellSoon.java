package Cards;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GetWellSoon extends CardType {
	
	public GetWellSoon(){
		cardTypeName = "Get Well Soon";
		setUpInfoFormPanel();
	}
	
	@Override
	protected void setUpInfoFormPanel() {
		panel = new JPanel();
		panel.setLayout(null);
	
		
	}

	@Override
	public void onGenerate() {
		System.out.println("On gen");
	}

}
