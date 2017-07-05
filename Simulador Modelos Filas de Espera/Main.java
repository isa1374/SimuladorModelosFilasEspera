import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame implements ActionListener{
	JPanel controlPanel=new JPanel(new FlowLayout());
	JPanel contentPanel=new JPanel(new FlowLayout());
	JPanel answerPanel=new JPanel(new FlowLayout());
	
	JButton MMS = new JButton("MMS"); 
	JButton MM1= new JButton("MM1"); 
	JButton MMSK= new JButton("MMSK"); 
	JButton MG1= new JButton("MG1"); 
	
	JLabel warning = new JLabel("");
	
	JLabel lm= new JLabel("λ: ", SwingConstants.CENTER); 
	JTextField Tlm=new JTextField(5); 
	JLabel mu= new JLabel("μ: ", SwingConstants.CENTER); 
	JTextField Tmu=new JTextField(5); 
	JLabel c= new JLabel("Número de servidores: ", SwingConstants.CENTER);
	JTextField Tc=new JTextField(5);
	JLabel k=new JLabel("Capacidad: ", SwingConstants.CENTER); 
	JTextField Tk=new JTextField(5);
	JLabel o=new JLabel("σ2: ", SwingConstants.CENTER);
	JTextField To= new JTextField(5); 
	JLabel pnum= new JLabel("P. # personas en línea: ", SwingConstants.CENTER);
	JTextField Tpnum = new JTextField(5);
	
	JLabel se=new JLabel("Servidores ocupados ",10);
	JTextField Tse=new JTextField(15); 
	JLabel wq=new JLabel("Tiempo de espera en línea ",10);
	JTextField Twq=new JTextField(15);
	JLabel lq= new JLabel("Número de personas en línea ",10);
	JTextField Tlq=new JTextField(15);
	JLabel ws=new JLabel("Tiempo de espera en sistema ",10);
	JTextField Tws=new JTextField(15);
	JLabel ls=new JLabel("Número de persona en sistema ",10);
	JTextField Tls=new JTextField(15); 
	JLabel p=new JLabel("Utilización del sistema ",10);
	JTextField Tp=new JTextField(15);
	JLabel po=new JLabel("Sistema ocioso ",10);
	JTextField Tpo= new JTextField(15);
	JLabel pn=new JLabel("P. de n personas en línea ",10);
	JTextField Tpn=new JTextField(15);
	
	JButton calcular = new JButton("Calcular"); 
	JButton borrar = new JButton("Borrar");
	
	String metodo="";
	
	public Main(){
		super("Proyecto Pt.2 de Métodos Numéricos");
		Color cl= new Color(245,245,245);
		setSize(1000,700); 
		setResizable(false);
		setBackground(cl);
		setLayout(new BorderLayout());
		controlPanel.setBackground(cl);
		controlPanel.setSize(900, 150);
		contentPanel.setBackground(cl);
		contentPanel.setSize(900, 250);
		answerPanel.setBackground(cl);
		Dimension dm = new Dimension();
		dm.setSize(900, 400);
		answerPanel.setPreferredSize(dm);
		
		add(controlPanel, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(answerPanel, BorderLayout.SOUTH);
		
		Font ft= new Font("Impact", Font.PLAIN, 18);
		Font tx1= new Font ("Trebuchet MS", Font.BOLD, 13);
		Color rj= new Color(255,99,71);
		Color gr = new Color(144,238,144);
		Color or= new Color(255,165,0);
		Color bb = new Color(112,128,144);
		
		warning.setFont(new Font("Impact", Font.PLAIN, 16));
		warning.setForeground(Color.RED);
		warning.setBackground(new Color(240,230,140));
		
		c.setFont(tx1);
		lm.setFont(tx1);
		o.setFont(tx1);
		k.setFont(tx1);
		mu.setFont(tx1);
		pnum.setFont(tx1);
		p.setFont(tx1);
		po.setFont(tx1);
		pn.setFont(tx1);
		lq.setFont(tx1);
		wq.setFont(tx1);
		ls.setFont(tx1);
		ws.setFont(tx1);
		se.setFont(tx1);
		
		MG1.setBackground(bb);;
		MG1.setForeground(Color.WHITE);
		MG1.setFont(ft);
		MG1.setBorderPainted(false);
		MMS.setBackground(bb);
		MMS.setForeground(Color.WHITE);
		MMS.setFont(ft);
		MMS.setBorderPainted(false);
		MMSK.setBackground(bb);
		MMSK.setForeground(Color.WHITE);
		MMSK.setFont(ft);
		MMSK.setBorderPainted(false);
		MM1.setBackground(bb);
		MM1.setForeground(Color.WHITE);
		MM1.setFont(ft);
		MM1.setBorderPainted(false);
		calcular.setBackground(gr);
		calcular.setFont(ft);
		calcular.setBorderPainted(false);
		borrar.setBackground(rj);
		borrar.setForeground(Color.white);
		borrar.setFont(ft);
		borrar.setBorderPainted(false);
		
		JPanel menu= new JPanel(); 
		menu.setBackground(cl);
		menu.setSize(900,150);
		GridBagLayout layout =new GridBagLayout();
		
		menu.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets=new Insets(10,10,10,10);
		gbc.ipady=30;
		gbc.ipadx=40;
		gbc.gridx=0;
		gbc.gridy=0; 
		menu.add(MM1, gbc);
		
		gbc.gridx=1; 
		gbc.gridy=0; 
		menu.add(MMS, gbc);
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.ipady=30;
		gbc.gridx=2;
		gbc.gridy=0; 
		menu.add(MMSK, gbc);
		
		gbc.gridx=3; 
		gbc.gridy=0; 
		menu.add(MG1, gbc);
		
		controlPanel.add(menu);
		
		JPanel content=new JPanel(); 
		content.setSize(900, 250);
		content.setBackground(cl);
		GridBagLayout layout2=new GridBagLayout();
		
		content.setLayout(layout2);
		GridBagConstraints gbc2= new GridBagConstraints();
		
		gbc2.fill=GridBagConstraints.HORIZONTAL;
		gbc2.insets=new Insets(10,10,10,10);
		gbc2.ipady=10;
		gbc2.ipadx=50;
		gbc2.gridx=0; 
		gbc2.gridy=0; 
		content.add(lm, gbc2);
		
		gbc2.gridx=1; 
		gbc2.gridy=0; 
		content.add(Tlm, gbc2);
		
		
		gbc2.gridx=3; 
		gbc2.gridy=0; 
		content.add(mu, gbc2);
		
		gbc2.gridx=4;
		gbc2.gridy=0; 
		content.add(Tmu, gbc2);
		
		
		gbc2.gridx=6; 
		gbc2.gridy=0; 
		content.add(k, gbc2);
		
		gbc2.gridx=7; 
		gbc2.gridy=0; 
		content.add(Tk, gbc2);
		
		gbc2.fill=GridBagConstraints.HORIZONTAL;
		gbc2.gridx=0;
		gbc2.gridy=1; 
		content.add(c, gbc2);
		
		gbc2.gridx=1;
		gbc2.gridy=1;
		content.add(Tc, gbc2);
		
		
		gbc2.gridx=3; 
		gbc2.gridy=1;
		content.add(o, gbc2);
		
		gbc2.gridx=4; 
		gbc2.gridy=1; 
		content.add(To, gbc2);
		
		
		gbc2.gridx=6;
		gbc2.gridy=1; 
		content.add(pnum, gbc2);
		
		gbc2.gridx=7;
		gbc2.gridy=1; 
		content.add(Tpnum, gbc2);
		
		contentPanel.add(content);
		
		JPanel respuestas=new JPanel(); 
		respuestas.setSize(900, 300);
		respuestas.setBackground(cl);
		GridBagLayout layout3=new GridBagLayout();
		
		respuestas.setLayout(layout3);
		GridBagConstraints gbc3= new GridBagConstraints(); 
		
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		gbc3.insets=new Insets(10,10,10,10);
		gbc3.ipady=10;
		gbc3.ipadx=50;
		gbc3.gridx=0; 
		gbc3.gridy=0; 
		respuestas.add(p, gbc3);
		gbc3.gridx=1; 
		gbc3.gridy=0; 
		Tp.setEditable(false);
		respuestas.add(Tp, gbc3);
		
		gbc3.gridx=3;
		gbc3.gridy=0;
		respuestas.add(lq, gbc3); 
		gbc3.gridx=4; 
		gbc3.gridy=0; 
		Tlq.setEditable(false);
		respuestas.add(Tlq, gbc3);
		
		
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		gbc3.gridx=0; 
		gbc3.gridy=1;
		respuestas.add(po, gbc3);
		gbc3.gridx=1; 
		gbc3.gridy=1;
		Tpo.setEditable(false);
		respuestas.add(Tpo, gbc3);
		
		gbc3.gridx=3; 
		gbc3.gridy=1; 
		respuestas.add(wq, gbc3);
		gbc3.gridx=4; 
		gbc3.gridy=1;
		Twq.setEditable(false);
		respuestas.add(Twq, gbc3);
		
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		gbc3.gridx=0; 
		gbc3.gridy=2;
		respuestas.add(pn, gbc3);
		gbc3.gridx=1; 
		gbc3.gridy=2;
		Tpn.setEditable(false);
		respuestas.add(Tpn, gbc3);
		
		gbc3.gridx=3; 
		gbc3.gridy=2; 
		respuestas.add(ls, gbc3);
		gbc3.gridx=4; 
		gbc3.gridy=2; 
		Tls.setEditable(false);
		respuestas.add(Tls, gbc3);
		
		gbc3.fill=GridBagConstraints.HORIZONTAL; 
		gbc3.gridx=0; 
		gbc3.gridy=3; 
		respuestas.add(ws, gbc3);
		gbc3.gridx=1; 
		gbc3.gridy=3;
		Tws.setEditable(false);
		respuestas.add(Tws, gbc3);
		
		gbc3.gridx=3; 
		gbc3.gridy=3; 
		respuestas.add(se, gbc3);
		gbc3.gridx=4; 
		gbc3.gridy=3;
		Tse.setEditable(false);
		respuestas.add(Tse, gbc3);
		
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		gbc3.gridx=1; 
		gbc3.gridy=4;
		respuestas.add(new JLabel(""), gbc3);
		gbc3.gridx=3; 
		gbc3.gridy=4;
		respuestas.add(new JLabel(""), gbc3);
		
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		gbc3.insets=new Insets(20,20,20,20);
		gbc3.ipady=20;
		gbc3.gridx=1; 
		gbc3.gridy=5;
		respuestas.add(calcular, gbc3);
		gbc3.gridx=3; 
		gbc3.gridy=5; 
		respuestas.add(borrar, gbc3);
		
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		gbc3.insets=new Insets(10,10,10,10);
		gbc3.gridx=1;
		gbc3.gridy=6;
		warning.setVisible(false);
		respuestas.add(warning, gbc3);
		
		answerPanel.add(respuestas);
		
		//Button Actions 
		MM1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				MM1.setBackground(or);
				MMS.setBackground(bb);
				MMSK.setBackground(bb);
				MG1.setBackground(bb);
				Tlm.setEnabled(true);
				Tmu.setEnabled(true);
				Tc.setEnabled(false);
				Tk.setEnabled(false);
				To.setEnabled(false);
				Tpnum.setEnabled(true);
				Tp.setText("");
				Tpo.setText("");
				Tpn.setText("");
				Tlq.setText("");
				Twq.setText("");
				Tls.setText("");
				Tws.setText("");
				Tse.setText("");
				metodo=MM1.getText().toString();
			}
		});
		MMS.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				MMS.setBackground(or);
				MM1.setBackground(bb);
				MMSK.setBackground(bb);
				MG1.setBackground(bb);
				Tlm.setEnabled(true);
				Tmu.setEnabled(true);
				Tc.setEnabled(true);
				Tk.setEnabled(false);
				To.setEnabled(false);
				Tpnum.setEnabled(true);
				Tp.setText("");
				Tpo.setText("");
				Tpn.setText("");
				Tlq.setText("");
				Twq.setText("");
				Tls.setText("");
				Tws.setText("");
				Tse.setText("");
				metodo=MMS.getText().toString();
			}
		});
		MMSK.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				MMSK.setBackground(or);
				MMS.setBackground(bb);
				MM1.setBackground(bb);
				MG1.setBackground(bb);
				Tlm.setEnabled(true);
				Tmu.setEnabled(true);
				Tc.setEnabled(true);
				Tk.setEnabled(true);
				To.setEnabled(false);
				Tpnum.setEnabled(true);
				Tp.setText("");
				Tpo.setText("");
				Tpn.setText("");
				Tlq.setText("");
				Twq.setText("");
				Tls.setText("");
				Tws.setText("");
				Tse.setText("");
				metodo=MMSK.getText().toString();
				
			}
		});
		MG1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				MG1.setBackground(or);
				MMS.setBackground(bb);
				MMSK.setBackground(bb);
				MM1.setBackground(bb);
				Tlm.setEnabled(true);
				Tmu.setEnabled(true);
				Tc.setEnabled(false);
				Tk.setEnabled(false);
				To.setEnabled(true);
				Tpnum.setEnabled(true);
				Tp.setText("");
				Tpo.setText("");
				Tpn.setText("");
				Tlq.setText("");
				Twq.setText("");
				Tls.setText("");
				Tws.setText("");
				Tse.setText("");
				metodo=MG1.getText().toString();
				
			}
		});
		calcular.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				calcular.setBackground(new Color(46,139,87));
				calcular.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				calcular.setBackground(gr);
				calcular.setForeground(Color.black);
			}
			
		});
		calcular.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if( (Double.parseDouble(Tlm.getText())/Double.parseDouble(Tmu.getText()))>1 ){
					warning.setText("μ debe ser mayor a λ");
					warning.setVisible(true);
				}else{
					warning.setText("");
					warning.setVisible(false);
				}
				
				switch(metodo){
				case "MM1":
					MM1 m1 = new MM1(Double.parseDouble(Tlm.getText()), Double.parseDouble(Tmu.getText()));
					m1.CalcularP();
					m1.CalcularPoc();
					m1.CalcularPn(Double.parseDouble(Tpnum.getText()));
					m1.CalcularWq();
					m1.CalcularLq();
					m1.CalcularWs();
					m1.CalcularLs();
		
					Tp.setText(String.valueOf(m1.getP()*100));
					Tpo.setText(String.valueOf(m1.getPoc()*100));
					Tpn.setText(String.valueOf(m1.getPn()*100));
					Tlq.setText(String.valueOf(m1.getLq()));
					Twq.setText(String.valueOf(m1.getWq()));
					Tls.setText(String.valueOf(m1.getLs()));
					Tws.setText(String.valueOf(m1.getWs()));
					break; 
				case "MMS":
					MMS ms = new MMS(Double.parseDouble(Tlm.getText()),Double.parseDouble(Tmu.getText()),Double.parseDouble(Tc.getText()));
					ms.CalcularP();
					ms.CalcularPo();
					ms.CalcularS();
					ms.CalcularLq();
					ms.CalcularPn(Double.parseDouble(Tpnum.getText()));
					ms.CalcularWq();
					ms.CalcularLs();
					ms.CalcularWs();
					
					Tp.setText(String.valueOf(ms.getP()*100));
					Tpo.setText(String.valueOf(ms.getPo()*100));
					Tpn.setText(String.valueOf(ms.getPn()*100));
					Tse.setText(String.valueOf(ms.getS()));
					Tlq.setText(String.valueOf(ms.getLq()));
					Twq.setText(String.valueOf(ms.getWq()));
					Tls.setText(String.valueOf(ms.getLs()));
					Tws.setText(String.valueOf(ms.getWs()));
					
					break;
				case "MMSK":
					//l, m, c,k 
					MMSK mmsk= new MMSK(Double.parseDouble(Tlm.getText()), Double.parseDouble(Tmu.getText()), Double.parseDouble(Tc.getText()), Double.parseDouble(Tk.getText()));
					mmsk.CalcularP();
					mmsk.CalcularPo();
					mmsk.CalcularPn(Double.parseDouble(Tpnum.getText()));
					mmsk.CalcularLq();
					mmsk.CalcularWq();
					mmsk.CalcularLs();
					mmsk.CalcularWs();
					
					Tp.setText(String.valueOf(mmsk.getP()*100));
					Tpo.setText(String.valueOf(mmsk.getPo()*100));
					Tpn.setText(String.valueOf(mmsk.getPn()*100));
					Tlq.setText(String.valueOf(mmsk.getLq()));
					Twq.setText(String.valueOf(mmsk.getWq()));
					Tls.setText(String.valueOf(mmsk.getLs()));
					Tws.setText(String.valueOf(mmsk.getWs()));
					
					break;
				case "MG1": 
					//l,m,o
					MG1 mg1 = new MG1(Double.parseDouble(Tlm.getText()), Double.parseDouble(Tmu.getText()),Double.parseDouble(To.getText())); 
					mg1.CalcularP();
					mg1.CalcularPo();
					mg1.CalcularPn(2);
					mg1.CalcularLq();
					mg1.CalcularWq();
					mg1.CalcularLs();
					mg1.CalcularWs();
					
					Tp.setText(String.valueOf(mg1.getP()*100));
					Tpo.setText(String.valueOf(mg1.getPo()*100));
					Tpn.setText(String.valueOf(mg1.getPn()*100));
					Tlq.setText(String.valueOf(mg1.getLq()));
					Twq.setText(String.valueOf(mg1.getWq()));
					Tls.setText(String.valueOf(mg1.getLs()));
					Tws.setText(String.valueOf(mg1.getWs()));
					
					break;
				}
				
			}
		});
		borrar.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {	
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				borrar.setBackground(new Color(220,20,60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				borrar.setBackground(rj);
			}
			
		});
		borrar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Tlm.setText("");
				Tmu.setText("");
				Tc.setText("");
				Tk.setText("");
				To.setText("");
				Tpnum.setText("");
				
				Tp.setText("");
				Tpo.setText("");
				Tpn.setText("");
				Tlq.setText("");
				Twq.setText("");
				Tls.setText("");
				Tws.setText("");
				Tse.setText("");
				warning.setVisible(false);
			}
		});
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	public static void main(String[] args) {
		new Main(); 
	}
}