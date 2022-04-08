import java.awt.*;
import java.awt.event.*;
class WindowSensor extends WindowAdapter{
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
}
class MyFrame extends Frame{
    private String msg;
    public MyFrame(){
        super("Java First Window");
        Button b=new Button("OK");
        
        msg="Frame is created";
        add(b);
        b.addActionListener(new ButtonSensor(this));
        setSize(600,400);
	setLayout(new FlowLayout());
    }
    public void setMessage(String s){
        msg=s;
    }
	public void paint(Graphics g){
		g.setColor(new Color(102,51,0));
		g.drawLine(100,100,100,300);
		g.drawLine(90,100,90,300);
		g.drawLine(90,100,100,100);
		g.drawLine(90,300,100,300);
		g.setColor(new Color(0,102,0));
		g.fillRect(100,120,200,100);
		g.drawString(msg,20,40);
		g.setColor(Color.RED);
		g.fillOval(175, 145, 50, 50);
     
	}
}
class ButtonSensor implements ActionListener{
	MyFrame fm;
	static int c;
	public ButtonSensor(MyFrame f){
		fm=f;
	}
	public void actionPerformed(ActionEvent ae){
		c++;
		fm.setMessage("Button Pressed : "+c);
		fm.repaint();
		System.out.println("Button Pressed : "+c);
	}
}
public class DrawTest{
    public static void main(String str[]){
        MyFrame mf=new MyFrame();
        mf.addWindowListener(new WindowSensor());
        mf.setVisible(true);
    }
}