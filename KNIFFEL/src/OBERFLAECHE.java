import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class OBERFLAECHE{
 
  static JFrame fenster; 
  private JButton buttonStart;
  private ImageIcon icon = new ImageIcon("F://Eclipse//KNIFFEL//WürfelnNEU.png","");
  
  private JLabel spielzuege;
  public int zuege;
  
  private JLabel hgWuerfel1;
  private JLabel hgWuerfel2;
  private JLabel hgWuerfel3;
  private JLabel hgWuerfel4;
  private JLabel hgWuerfel5;
  
  public JButton bild1;
  public JButton bild2;
  public JButton bild3;
  public JButton bild4;
  public JButton bild5;

  String[] wuerfelBilder = {"F://Eclipse//KNIFFEL//1.gif", 
			"F://Eclipse//KNIFFEL//2.gif",
			"F://Eclipse//KNIFFEL//3.gif",
			"F://Eclipse//KNIFFEL//4.gif",
			"F://Eclipse//KNIFFEL//5.gif",
			"F://Eclipse//KNIFFEL//6.gif"};
  
  public ImageIcon icon1;
  public ImageIcon icon2;
  public ImageIcon icon3;
  public ImageIcon icon4;
  public ImageIcon icon5;

  public void fensterNeu() {
      
        fenster = new JFrame();
        fenster.setSize(1216,648);
        try {
            fenster.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("F://Eclipse//KNIFFEL//LayoutNeuer.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
         
        buttonStart = new JButton("",icon);
        buttonStart.setSize(150,50);
        buttonStart.setLocation(756,402);
        fenster.add(buttonStart);
        buttonStart.setVisible(true);
        addButtonListener(buttonStart);
        
        zuege = 0;
           
        spielzuege = new JLabel(String.valueOf(zuege));
        spielzuege.setSize(47,48);
        spielzuege.setLocation(950,402);
        fenster.add(spielzuege);
        spielzuege.setVisible(true);
        
        hgWuerfel1 = new JLabel();
        hgWuerfel1.setSize(84,85);
        hgWuerfel1.setLocation(722,150);
        hgWuerfel1.setOpaque(true);
        hgWuerfel1.setBackground(Color.red);
        fenster.add(hgWuerfel1);
        hgWuerfel1.setVisible(false);
        
        icon1 = new ImageIcon(wuerfelBilder[1-1]);
    	bild1 = new JButton("",icon1);
        bild1.setSize(74,75);
        bild1.setLocation(727,155);
        bild1.setOpaque(true);
        fenster.add(bild1);
        bild1.setVisible(true);
        bild1.setBackground(Color.red);
        addWuerfelListener(bild1, 0);
        
        hgWuerfel2 = new JLabel();
        hgWuerfel2.setSize(84,85);
        hgWuerfel2.setLocation(856,149);
        hgWuerfel2.setOpaque(true);
        hgWuerfel2.setBackground(Color.red);
        fenster.add(hgWuerfel2);
        hgWuerfel2.setVisible(false);
        
        icon2 = new ImageIcon(wuerfelBilder[2-1]);
    	bild2 = new JButton("",icon2);
        bild2.setSize(75,75);
        bild2.setLocation(860,155);
        bild2.setOpaque(true);
        fenster.add(bild2);
        bild2.setVisible(true);
        bild2.setBackground(Color.red);
        
        hgWuerfel3 = new JLabel();
        hgWuerfel3.setSize(84,85);
        hgWuerfel3.setLocation(988,150);
        hgWuerfel3.setOpaque(true);
        hgWuerfel3.setBackground(Color.red);
        fenster.add(hgWuerfel3);
        hgWuerfel3.setVisible(false);
        
        icon3 = new ImageIcon(wuerfelBilder[3-1]);
    	bild3 = new JButton("",icon3);
        bild3.setSize(75,75);
        bild3.setLocation(993,155);
        bild3.setOpaque(true);
        fenster.add(bild3);
        bild3.setVisible(true);
        bild3.setBackground(Color.red);
        
        hgWuerfel4 = new JLabel();
        hgWuerfel4.setSize(84,85);
        hgWuerfel4.setLocation(788,254);
        hgWuerfel4.setOpaque(true);
        hgWuerfel4.setBackground(Color.red);
        fenster.add(hgWuerfel4);
        hgWuerfel4.setVisible(false);
        
        icon4 = new ImageIcon(wuerfelBilder[4-1]);
    	bild4 = new JButton("",icon4);
        bild4.setSize(75,75);
        bild4.setLocation(794,259);
        bild4.setOpaque(true);
        fenster.add(bild4);
        bild4.setVisible(true);
        bild4.setBackground(Color.red);
        
        hgWuerfel5 = new JLabel();
        hgWuerfel5.setSize(84,85);
        hgWuerfel5.setLocation(922,253);
        hgWuerfel5.setOpaque(true);
        hgWuerfel5.setBackground(Color.red);
        fenster.add(hgWuerfel5);
        hgWuerfel5.setVisible(false);
        
        icon5 = new ImageIcon(wuerfelBilder[5-1]);
    	bild5 = new JButton("",icon5);
        bild5.setSize(75,75);
        bild5.setLocation(926,259);
        bild5.setOpaque(true);
        fenster.add(bild5);
        bild5.setVisible(true);
        bild5.setBackground(Color.red);
        
        

        //fenster.pack();
    }
    
    private void addButtonListener(JButton b){
        b.addActionListener(new ActionListener(){ //registriert, wenn jemand klickt
            public void actionPerformed(ActionEvent ae){ //was soll bei Klick passieren?
                addSpielzug();  //bei Klick soll eingabe() aufgerufen werden
            }
        });
    }   
    
    private void addWuerfelListener(JButton w, int x) {
    	w.addActionListener(new ActionListener(){
    		public void actionPerfomerd(ActionEvent arg0) {
    			blockWuerfel(x);
    		}
    	});
    }
  
    private void addSpielzug(){
        zuege += 1;
        spielzuege.setText(String.valueOf(zuege));
        MASTER.master.wuerfeln();
        wuerfelBildSetzen(MASTER.master.wurf1,MASTER.master.wurf2,MASTER.master.wurf3,MASTER.master.wurf4,MASTER.master.wurf5);
     
    
    }
    
    private void blockWuerfel(int x){
    	
    	if (x == 0){
    		MASTER.master.wuerfel1.sperren();
    		hgWuerfel1.setVisible(true);
    	}
    }
    
    
    public void wuerfelBildSetzen(int a, int b, int c, int d, int e){
    	
    	icon1 = new ImageIcon(wuerfelBilder[a-1]);
    	bild1.setIcon(icon1);
    	
    	icon2 = new ImageIcon(wuerfelBilder[b-1]);
    	bild2.setIcon(icon2);
    	
    	icon3 = new ImageIcon(wuerfelBilder[c-1]);
    	bild3.setIcon(icon3);
    	
    	icon4 = new ImageIcon(wuerfelBilder[d-1]);
    	bild4.setIcon(icon4);
    	
    	icon5 = new ImageIcon(wuerfelBilder[e-1]);
    	bild5.setIcon(icon5);
        
    	
    }


}
