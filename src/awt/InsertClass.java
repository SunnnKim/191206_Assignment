package awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import sources.Insert;

public class InsertClass  extends Frame 
				implements WindowListener, ActionListener, ItemListener{
	
	Label label[];
	TextField txt[];
	Button menu, add;
	Checkbox pit, bat;
	Choice year,month,day;
	int w=0;
	
	public InsertClass() {
		// TODO Auto-generated constructor stub
		
		setLayout(null);
		
		Label mainLabel = new Label("< 선수 추가 >");
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setBounds(0, 10, 640, 80);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		add(mainLabel);
		
		
		Panel select = new Panel();
		select.setBounds(0, 90, 640, 30);
		CheckboxGroup g = new CheckboxGroup();
		pit = new Checkbox("타자", true, g);
		bat = new Checkbox("투수", false, g);
		select.add(pit);
		select.add(bat);
		add(select);
		
		
		
		Panel p[] = new Panel[7];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel();
			p[i].setLayout(null);
			p[i].setBounds(0, 125+(i*45), 640, 40);
//			p[i].setBackground(Color.darkGray);
			
		}
		
		label = new Label[7];
		txt = new TextField[6];
		
		
		
		label[0] = new Label("이름 :");
		label[1] = new Label("나이 :");
		label[2] = new Label("키 :");
		label[3] = new Label("생일:");
		label[4] = new Label("타수 :");
		label[5] = new Label("안타수 :");
		label[6] = new Label("타율 :");
		
		year = new Choice();
		
		year.add("---");
		for (int i = 1960; i <= 2010; i++) {
			year.add(i+"");
		}
		month = new Choice();
		month.add("---");

		day = new Choice();
		day.add("---");
		
		

		// 레이블 추가 
		int w=0;
		for (int j = 0; j < p.length; j++) {
			label[j].setSize(80, 30);
			label[j].setLocation(150, 0);
			label[j].setAlignment(Label.RIGHT);
			p[j].add(label[j]);
			add(p[j]);
			if(j==3) continue;
			txt[w] = new TextField(30);
			txt[w].setBounds(240, 0, 200, 30);
			p[j].add(txt[w]);
			w++;
		}
		

		year.setBounds(240, 0, 90, 30);
		month.setBounds(330, 0, 80, 30);
		day.setBounds(410, 0, 80, 30);
		year.addItemListener(this);
		month.addItemListener(this);
		day.addItemListener(this);
		
		p[3].add(year);
		p[3].add(month);
		p[3].add(day);
		
		
		Panel addBtd  = new Panel();
		addBtd.setBounds(0, 400, 640, 100);
		addBtd.setLayout(null);
		menu = new Button("메뉴");
		menu.setBounds(200, 45, 100, 40);
		add = new Button("추가");
		add.setSize(250,100);
		add.setBounds(360, 45, 100, 40);
		
		
		menu.addActionListener(this);
		add.addActionListener(this);
		
		
		
		
		addBtd.add(menu);
		addBtd.add(add);
		add(addBtd);
		
		

		
		
		pit.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
					label[4].setText("타수:");
					label[5].setText("안타수:");
					label[6].setText("타율:");
					
				
					
				
				}
		});
		
		bat.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label[4].setText("승:");
				label[5].setText("패:");
				label[6].setText("방어율:");
			}
		});
		
		
		
		
		
		setSize(640,500);
		setLocation(350, 150);
		addWindowListener(this);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// 메뉴로 돌아가기
		Button nowBtn = (Button)e.getSource();
		if(nowBtn == menu) {
			dispose();
			new MenuClass();
			return;
		}
		
		// 추가하기
		String str[] = new String[7];
		w=0;
		for (int i = 0; i < str.length; i++) {
			str[i] = txt[w].getText().trim();
			if(i==3) {
				try {
				str[i] = year.getSelectedItem().charAt(2)+"";
				str[i] += year.getSelectedItem().charAt(3)+"/";
				str[i] += month.getSelectedItem()+"/";
				str[i] += day.getSelectedItem();
				continue;
				}catch (Exception e2) {
					str[i] = null;
					continue;
				}
			}
			w++;
		}
		Insert a = new Insert();
		boolean b=false;
		if(pit.getState()) {
			b = a.process(str,1);	// 투수
		}else if(bat.getState()){
			b = a.process(str,2);	// 타자
		}
		if(!b) {
			JOptionPane.showMessageDialog(null, "숫자나 문자를 잘못 입력했습니다.");
		}
		else {
			JOptionPane.showMessageDialog(null, "선수를 성공적으로 추가했습니다.");
		}
		
		for (int i = 0; i < txt.length; i++) {
			txt[i].setText("");
			year.select(0);
			month.select(0);
			day.select(0);
		}
		txt[0].requestFocus();
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
	
	// TODO: 아이템 리스너
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice c = (Choice)e.getSource();
		
		if(!year.getSelectedItem().equals("---")) {
			for (int i = 1; i <= 12; i++) {
				month.add(i+"");
			}
			if(month.getSelectedItem().equals("---")) {
				day.removeAll();
				day.add("---");
			}
			else if(month.getSelectedItem().equals("2")) {
				for (int i = 1; i <= 28; i++) 
					day.add(i+"");
			}
			else if( month.getSelectedItem().equals("4")
					|| month.getSelectedItem().equals("6")
					|| month.getSelectedItem().equals("9")
					|| month.getSelectedItem().equals("11")) {
				for (int i = 1; i <= 30; i++) 
					day.add(i+"");
			}
			else {
				for (int i = 1; i <= 31; i++) 
					day.add(i+"");
			}
			
		}else {
			month.removeAll();
			day.removeAll();
			month.add("---");
			day.add("---");
			
		}
		
	}

}
