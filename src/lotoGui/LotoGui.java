package lotoGui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.HashSet;

import loto.List;
import loto.Loto;
import java.lang.Thread;

public class LotoGui extends Frame implements ActionListener {

	private Label lb1, lb2;
	private TextField txt1, txt2, txt3, txt4, txt5, txt6, txt7;
	private TextArea area_txta;
	private Button btn1, btn2, btn3;
	private Canvas cv;

	public LotoGui() {
		super();

		Color cl1 = new Color(147, 71, 66);
		setBackground(cl1);
		setForeground(Color.cyan);
		setLayout(null);
		setTitle("Loto");
		setSize(500, 700);
		setLocation(100, 100);
		setResizable(false);
		/*-------------Labels------------*/
		// cl2 = new Color();
		lb1 = new Label("Enter values of user list(from 1 to 39):");
		lb1.setBounds(60, 200, 270, 30);
		// lb1.setForeground(Color.cyan);
		add(lb1);
		lb2 = new Label("Loto values and result of loto game");
		lb2.setBounds(60, 350, 200, 30);
		// lb2.setForeground(Color.cyan);
		add(lb2);

		/*---------------TextField----------*/
		Color cl3 = new Color(235, 150, 135);
		txt1 = new TextField();
		txt1.setBounds(60, 240, 50, 30);
		txt1.setText("0");
		txt1.setBackground(cl3);
		txt1.setForeground(cl1);
		add(txt1);
		txt2 = new TextField();
		txt2.setBounds(115, 240, 50, 30);
		txt2.setText("0");
		txt2.setBackground(cl3);
		txt2.setForeground(cl1);
		add(txt2);
		txt3 = new TextField();
		txt3.setBounds(170, 240, 50, 30);
		txt3.setText("0");
		txt3.setBackground(cl3);
		txt3.setForeground(cl1);
		add(txt3);
		txt4 = new TextField();
		txt4.setBounds(225, 240, 50, 30);
		txt4.setText("0");
		txt4.setBackground(cl3);
		txt4.setForeground(cl1);
		add(txt4);
		txt5 = new TextField();
		txt5.setBounds(280, 240, 50, 30);
		txt5.setText("0");
		txt5.setBackground(cl3);
		txt5.setForeground(cl1);
		add(txt5);
		txt6 = new TextField();
		txt6.setBounds(335, 240, 50, 30);
		txt6.setText("0");
		txt6.setBackground(cl3);
		txt6.setForeground(cl1);
		add(txt6);
		txt7 = new TextField();
		txt7.setBounds(390, 240, 50, 30);
		txt7.setText("0");
		txt7.setBackground(cl3);
		txt7.setForeground(cl1);
		add(txt7);

		/*-----------------Button------------*/

		btn1 = new Button("Start");
		btn1.setBounds(60, 300, 75, 30);
		btn1.addActionListener(this);
		btn1.setBackground(cl3);
		btn1.setForeground(cl1);
		add(btn1);

		btn2 = new Button("Errace");
		btn2.setBounds(140, 300, 75, 30);
		btn2.addActionListener(this);
		btn2.setBackground(cl3);
		btn2.setForeground(cl1);
		add(btn2);

		btn3 = new Button("Leave");
		btn3.setBounds(365, 620, 75, 30);
		btn3.addActionListener(this);
		btn3.setBackground(cl3);
		btn3.setForeground(cl1);
		add(btn3);

		/*--------------TextArea-----------------*/

		area_txta = new TextArea();
		area_txta.setBounds(60, 400, 380, 180);
		area_txta.setBackground(cl3);
		area_txta.setForeground(cl1);
		area_txta.setEditable(false);
		add(area_txta);

		/*--------------Canvas-----------------*/
		cv = new WinCanvas();
		cv.setBounds(60, 400, 380, 180);
		add(cv);

		/*---------------------------------------*/

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	}

	public void paint(Graphics g) {
		g.setFont(new Font("Informal Roman", Font.BOLD, 80));
		g.setColor(Color.cyan);
		g.drawString("Loto game", 120, 140);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.cyan);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(120, 140, 390, 140);

		// g2d.dispose();

	}

	@Override

	public void actionPerformed(ActionEvent ae) {
		int[] numbers = new int[7];

		if (ae.getSource() == btn1) {
			HashSet<Integer> position = new HashSet<>();
			if (txt1.getText().matches("[0-9]+"))
				numbers[0] = Integer.parseInt(txt1.getText());
			else
				position.add(1);
			if (txt2.getText().matches("[0-9]+"))
				numbers[1] = Integer.parseInt(txt2.getText());
			else
				position.add(2);
			if (txt3.getText().matches("[0-9]+"))
				numbers[2] = Integer.parseInt(txt3.getText());
			else
				position.add(3);
			if (txt4.getText().matches("[0-9]+"))
				numbers[3] = Integer.parseInt(txt4.getText());
			else
				position.add(4);
			if (txt5.getText().matches("[0-9]+"))
				numbers[4] = Integer.parseInt(txt5.getText());
			else
				position.add(5);
			if (txt6.getText().matches("[0-9]+"))
				numbers[5] = Integer.parseInt(txt6.getText());
			else
				position.add(6);
			if (txt7.getText().matches("[0-9]+"))
				numbers[6] = Integer.parseInt(txt7.getText());
			else
				position.add(7);
			position.addAll(invalidEntry(numbers));
			if (!position.isEmpty()) {
				area_txta.setText("Invalid Entry, setting all zeros again.");
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int pos : position) {
					switch (pos) {
					case 1:
						txt1.setText("0");
						break;
					case 2:
						txt2.setText("0");
						break;
					case 3:
						txt3.setText("0");
						break;
					case 4:
						txt4.setText("0");
						break;
					case 5:
						txt5.setText("0");
						break;
					case 6:
						txt6.setText("0");
						break;
					case 7:
						txt7.setText("0");
						break;
					}
				}
				area_txta.setText(" ");
			} else {
				List list = new List();
				for (int number : numbers) {
					list.addNumber(number);;
				}
				Loto loto = new Loto(list);
				loto.drum();
				int win = loto.howMuchOfSameNumbers();
				area_txta.setText("List of user: " + loto.strUserList() + "\n" + "Winning list: "
						+ loto.strLotoList() + "\n" + "Number of same numbers: " + win + "\n");
				if (win == 3) {

					area_txta.setVisible(false);
					cv.repaint();
				} else {
					area_txta.setVisible(true);
				}

			}

		} else if (ae.getSource() == btn3) {
			new MyDialog111().setVisible(true);
		} else if (ae.getSource() == btn2) {
			txt1.setText("0");
			txt2.setText("0");
			txt3.setText("0");
			txt4.setText("0");
			txt5.setText("0");
			txt6.setText("0");
			txt7.setText("0");
			if (!area_txta.isVisible())
				area_txta.setVisible(true);
			area_txta.setText(" ");
		}

	}

	private HashSet<Integer> 
	invalidEntry(int[] array) {
		int i, j;
		HashSet<Integer> pos = new HashSet<Integer>();

		for (i = 0; i < array.length; i++) {
			if (!(array[i] > 0 && array[i] < 40))
				pos.add(i + 1);
			for (j = i + 1; j < array.length; j++) {
				if (array[i] == array[j])
					pos.add(i + 1);
			}
		}
		return pos;
	}

}
