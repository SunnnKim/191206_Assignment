package awt;

import java.awt.Button;
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

import sources.Select;
import sources.Update;

public class UpdateClass extends Frame 
			implements WindowListener , ActionListener, ItemListener {
	
	Label label[];
	TextField txt[];
	Button menu, update;
	Label nameLabel;
	TextField searchName;
	Button searchBtn;
	Update u;
	Object[] str;
	String[] s;
	Choice year,month,day;
	
	
	public UpdateClass() {

		setLayout(null);
		
		Label mainLabel = new Label("< 선수 수정 >");
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		mainLabel.setBounds(0, 10, 640, 80);
		add(mainLabel);
		
		// 이름 검색패널
		Panel searchPanel = new Panel();
		searchPanel.setSize(640, 50);
		searchPanel.setLocation(0, 100);
//		searchPanel.setBackground(Color.blue);
		add(searchPanel);
		
		nameLabel = new Label("이름");
		searchName = new TextField(20);
		searchBtn = new Button("검색");
		searchBtn.setSize(100, 50);
		searchBtn.addActionListener(this);
		
		searchPanel.add(nameLabel);
		searchPanel.add(searchName);
		searchPanel.add(searchBtn);
		
		
		// 선수정보 뿌리는 텍스트 필드
		Panel[] p = new Panel[8];
		label = new Label[8];
		txt = new TextField[7];
		int w=0;
		for (int i = 0; i < label.length; i++) {
			p[i] = new Panel();
			p[i].setLayout(null);
			p[i].setBounds(0, 150+(i*35), 640, 30);
			add(p[i]);

			label[i] = new Label();
			label[i].setBounds(200, 0, 50, 30);
			p[i].add(label[i]);
			if(i == 4) continue;
			txt[w] = new TextField(20);
			txt[w].setBounds(270, 0, 130, 20);
			p[i].add(txt[w]);
			w++;
		}
		
		label[0].setText("번호");
		txt[0].setEditable(false);
		label[1].setText("이름");
		txt[1].setEditable(false);
		label[2].setText("나이");
		label[3].setText("키");
		label[4].setText("생년월일");
		label[5].setText("-");
		label[6].setText("-");
		label[7].setText("-");
		
		
		

		// 생년월일 
		year = new Choice();
		
		year.add("---");
		for (int i = 1960; i <= 2010; i++) {
			year.add(i+"");
		}
		month = new Choice();
		month.add("---");
		for (int i = 1; i <= 12; i++) 
			month.add(i+"");

		day = new Choice();
		day.add("---");
		for (int i = 1; i <=31; i++) 
			day.add(i+"");
		
		year.setBounds(270, 0, 90, 30);
		month.setBounds(360, 0, 80, 30);
		day.setBounds(440, 0, 80, 30);
		year.addItemListener(this);
		month.addItemListener(this);
		day.addItemListener(this);
		
		
		
		
		
		
		// 메뉴 버튼
		Panel menuPanel = new Panel(); 
		menuPanel.setBounds(0, 440, 640, 100);
		menu = new Button("메뉴"); 
		menu.setSize(160,80);
		menu.setLocation(200, 0);
		menuPanel.add(menu);
		
		update = new Button("수정");
		update.setBounds(400, 0, 180, 80);
		update.addActionListener(this);
		menuPanel.add(update);
		
		
		menu.addActionListener(this); 
				  
		add(menuPanel); 
		
		
		p[4].add(year);
		p[4].add(month);
		p[4].add(day);
		
		
		
		
		
		
		
		setSize(640,500);
		setLocation(350, 150);
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
		// 선수 검색 
		if(nowBtn ==  searchBtn) {
			Select s = new Select();
			String name = searchName.getText();
			str = s.process(name);
			if(str == null) {
				JOptionPane.showMessageDialog(null, "잘못 검색하셨습니다!");
				searchName.setText("");
				searchName.requestFocus();
				return;
			}
			else {
				//	 선수 찾았을 때 
				if((int)str[0] < 2000) { // 1000~ 투수
					label[5].setText("승");
					label[6].setText("패");
					label[7].setText("방어율");
				}
				else { // 2000~ 타자
					label[5].setText("타수");
					label[6].setText("안타수");
					label[7].setText("타율");
				}
				int w=0;
				for (int i = 0; i < label.length; i++) {
					if(i==4) {
						String ss = (String)str[4];
						String sp[] = ss.split("/");
						year.select(Integer.parseInt(sp[0])-59);
						month.select(Integer.parseInt(sp[1]));
						day.select(Integer.parseInt(sp[2]));
						continue;
					}
					txt[w].setText(str[i]+"");
					w++;
				}
				return;
				
			}
		}
		// 선수 정보 수정하기 
		if(nowBtn == update) {
			s= new String[8];
			int w=0;
			for (int i = 0; i < str.length; i++) {
				s[i] = new String();
				s[i] = txt[w].getText();
				if(i==4) {
					s[i] = ""+year.getSelectedItem().charAt(2)+""+year.getSelectedItem().charAt(3)+"/";
					s[i] += month.getSelectedItem()+"/";
					s[i] += day.getSelectedItem();
					continue;
				}
				w++;
			}
			
			u = new Update();
			boolean b = u.process(s);
			if(!b) {
				JOptionPane.showMessageDialog(null, "수정할 수 없는 데이터 입니다!");
			}
			else {
				JOptionPane.showMessageDialog(null, "수정을 완료했습니다!");
				for (int i = 0; i < txt.length; i++) {
					txt[i].setText("");
				}
				searchName.setText("");
				year.select(0);
				month.select(0);
				day.select(0);
				str = null;
			}
			return;
			
		}
		
		
		
		
		
		
		
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
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
