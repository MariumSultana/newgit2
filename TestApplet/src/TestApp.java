import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class TestApp extends Applet {
	Applet applet = this;
	
	public void init(){
		applet.setSize(600, 400);
		applet.setBackground(Color.LIGHT_GRAY);
	}

	public void start(){
		
	}
	
	public void  stop(){
		
	}
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(25, 25, 100, 100);
		Font font = new Font("new times roman", Font.BOLD, 24);
		g.setColor(Color.CYAN);
		g.setFont(font);
		g.drawString("hello applet!",250,150);
		
		
	}
}
