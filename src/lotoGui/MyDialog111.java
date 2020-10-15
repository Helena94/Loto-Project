package lotoGui;

import java.awt.*;
import java.awt.event.*;

public class MyDialog111 extends Dialog implements ActionListener {
	private Label lbl_msg;
	private Button btn_yes, btn_no;
	private Panel north_panel, south_panel;

	public MyDialog111() {
		super(new LotoGui(), "Dialog Demo", true);
		north_panel = new Panel();
		south_panel = new Panel();
		Color cl1 = new Color(147, 71, 66);
		Color cl3 = new Color(235, 150, 135);

		setTitle("Confirm Close");
		setSize(100, 100);
		setLocation(50, 80);
		setBackground(cl1);
		lbl_msg = new Label("Do you want to close?");
		lbl_msg.setForeground(Color.cyan);
		btn_yes = new Button("Yes");
		btn_yes.setBackground(cl3);
		btn_yes.setForeground(cl1);
		btn_no = new Button("N0");
		btn_no.setBackground(cl3);
		btn_no.setForeground(cl1);

		north_panel.add(lbl_msg);
		south_panel.add(btn_yes);
		south_panel.add(btn_no);
		add(north_panel, "North");
		add(south_panel, "South");
		btn_yes.addActionListener(this);
		btn_no.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn_yes) {
			System.exit(0);
		} else
			dispose();
	}

}
