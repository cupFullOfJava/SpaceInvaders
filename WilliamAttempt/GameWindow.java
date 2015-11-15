import javax.swing.JFrame;

public class GameWindow extends JFrame {
		
		
	public GameWindow()
	{
		System.out.println("Creating Game Window");
		setTitle("SpaceInvaders");
		Screen screen = new Screen(); 
		add(screen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();

		screen.setFocusable(true);
		screen.requestFocusInWindow();
		setVisible(true);
		
	}

	
	
	public static void main(String[] args) {
		System.out.println("Game Started");
		GameWindow window = new GameWindow();

	}

}
