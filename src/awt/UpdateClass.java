package awt;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import sources.Human;
import sources.Select;

public class UpdateClass extends Frame implements WindowListener , ActionListener {
	
	Label label[];
	TextField txt[];
	Button menu, add;
	Label nameLabel;
	TextField searchName;
	Button searchBtn;
	
	
	public UpdateClass() {
		// TODO Auto-generated constructor stub
	setLayout(new GridLayout(4,1));
		
		Label mainLabel = new Label("< 선수 수정 >");
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		add(mainLabel);
		
		

		Panel searchPanel = new Panel();
		searchPanel.setSize(640, 200);
		add(searchPanel);
		
		nameLabel = new Label("이름");
		searchName = new TextField(20);
		searchBtn = new Button("검색");
		searchBtn.setSize(100, 80);
		searchBtn.addActionListener(this);
		
		searchPanel.add(nameLabel);
		searchPanel.add(searchName);
		searchPanel.add(searchBtn);
		
		Panel addBtd = new Panel(); 
		addBtd.setSize(600, 200); 
		menu = new Button("메뉴"); 
		menu.setSize(200,100); 
		addBtd.add(menu);
		
		menu.addActionListener(this); 
				  
		add(addBtd); 
		
		
		/*
		 * Panel p[] = new Panel[7]; for (int i = 0; i < p.length; i++) { p[i] = new
		 * Panel(); p[i].setBounds(10, 10, 600, 100); }
		 * 
		 * label = new Label[7]; txt = new TextField[7];
		 * 
		 * for (int j = 0; j < p.length; j++) { label[j] = new Label(); }
		 * 
		 * label[0] = new Label("이름 :"); label[1] = new Label("나이 :"); label[2] = new
		 * Label("키 :"); label[3] = new Label("생일:"); label[4] = new Label("타수 :");
		 * label[5] = new Label("안타수 :"); label[6] = new Label("타율 :");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * for (int i = 0; i < label.length; i++) { label[i].setBounds(10, 10, 30, 30);
		 * txt[i] = new TextField(30);
		 * 
		 * p[i].add(label[i]); p[i].add(txt[i]); add(p[i]); }
		 * 
		 * 
		 * Panel addBtd = new Panel(); add(addBtd); addBtd.setSize(600, 200); menu = new
		 * Button("메뉴"); menu.setSize(200,100); add = new Button("추가");
		 * add.setSize(250,100);
		 * 
		 * 
		 * menu.addActionListener(this); add.addActionListener(this);
		 * 
		 * 
		 * 
		 * 
		 * addBtd.add(menu); addBtd.add(add);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * pit.addItemListener(new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * label[4].setText("타수:"); label[5].setText("안타수:"); label[6].setText("타율:");
		 * 
		 * 
		 * 
		 * 
		 * } });
		 * 
		 * bat.addItemListener(new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) { // TODO Auto-generated
		 * method stub label[4].setText("승:"); label[5].setText("패:");
		 * label[6].setText("방어율:"); } });
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		setSize(640,500);
		setLocation(100, 100);
		addWindowListener(this);
		setVisible(true);
	}
	
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	//TODO: ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button nowBtn = (Button)e.getSource();
		if(nowBtn == menu) {
			dispose();
			new MenuClass();
			return;
		}
		
		if(nowBtn ==  searchBtn) {
			Select a = null;
			try {
				a = new Select();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String name = searchName.getText();
			System.out.println(name	);
			Human h = null;
			try {
				h = a.process(name);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(h == null) {
				JOptionPane.showMessageDialog(null, "잘못 검색하셨습니다!");
			}
			
			else {
				nameLabel.setText(h.getName());
			}
			
			
			
			
		}
		
		
		
		
		
		
		
	}
}
