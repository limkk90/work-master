package beat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mp3 extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../Image/menuBar.png")));
	private JButton playButton = new JButton(new ImageIcon(Main.class.getResource("../Image/playing.png")));
	private JButton pauseButton = new JButton(new ImageIcon(Main.class.getResource("../Image/pause.png")));
	private JButton stopButton = new JButton(new ImageIcon(Main.class.getResource("../Image/stop.png")));
	private JButton nextButton = new JButton(new ImageIcon(Main.class.getResource("../Image/next.png")));
	private JButton previousButton = new JButton(new ImageIcon(Main.class.getResource("../Image/previous.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../Image/exit.png")));
	
	
	private boolean isNextScreen = false;
	
	private int mouseX, mouseY;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Music selectedMusic;
	private Image introBackground = new ImageIcon(Main.class.getResource("../Image/back1.jpg")).getImage();
	private int nowSelected = 0;
	
	
	public Mp3() {
		
		
		setUndecorated(true);
		setTitle("Mp3");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		
		// �뷡 �߰� �� Ŀ�� ����
		
		trackList.add(new Track("back1.jpg", "music1.mp3"));
		trackList.add(new Track("back2.jpg", "music2.mp3"));
		trackList.add(new Track("back3.jpg", "music3.mp3"));
		trackList.add(new Track("back4.jpg", "music4.mp3"));
		trackList.add(new Track("back5.jpg", "music5.mp3"));
		trackList.add(new Track("back6.jpg", "music6.mp3"));
		trackList.add(new Track("back7.jpg", "music7.mp3"));
		trackList.add(new Track("back8.jpg", "music8.mp3"));
		trackList.add(new Track("back9.jpg", "music9.mp3"));

		
		// �޴���
		menuBar.setBounds(0, 0, 1250, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		
		
		// ���� ��ư
		exitButton.setBounds(1250, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setBackground(Color.black);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		
		// ��� ��ư
		playButton.setBounds(830, 500, 100, 100);
		playButton.setBackground(Color.gray);
		playButton.setBorderPainted(false);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
//				Image introBackground = new ImageIcon(Main.class.getResource("../Image/back.jpg")).getImage();
				
			}
		});
		add(playButton);
		
		
		// �Ͻ����� ��ư... ���� ���� ����
		pauseButton.setBounds(930, 500, 100, 100);
		pauseButton.setBackground(Color.gray);
		pauseButton.setBorderPainted(false);
		pauseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pauseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pauseButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		add(pauseButton);
		
		
		// ���� ��ư
		stopButton.setBounds(1030, 500, 100, 100);
		stopButton.setBackground(Color.gray);
		stopButton.setBorderPainted(false);
		stopButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				stopButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				stopButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
//				music1.close();
			}
		});
		add(stopButton);
		
		
		// ���� �뷡
		previousButton.setBounds(880, 610, 100, 100);
		previousButton.setBackground(Color.gray);
		previousButton.setBorderPainted(false);
		previousButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				previousButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		add(previousButton);
		
		
		// ���� �뷡
		nextButton.setBounds(980, 610, 100, 100);
		nextButton.setBackground(Color.gray);
		nextButton.setBorderPainted(false);
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
				
			}
		});
		add(nextButton);
			
	}
	
	
	// ȭ�� ��ü ���� �޼ҵ�
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	
	// ȭ�� �ٲ�� �ϴ� �޼ҵ�
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground,  0, 0, null);
		if(isNextScreen) {
			g.drawImage(introBackground, 1280, 0, null);
		}
		paintComponents(g);
		this.repaint();
	}
	
	
	// ���� �Ǵ� ���� �뷡�� �Ѿ �� Ŀ�� ���� �ٲ�� �޼ҵ�
	public void nextTrack(int nowTrack) {
		if(selectedMusic != null)
			selectedMusic.close();
		introBackground = new ImageIcon(Main.class.getResource("../Image/" + trackList.get(nowTrack).getTitleImage())).getImage();
		selectedMusic = new Music(trackList.get(nowTrack).getStartMusic(), true);
		selectedMusic.start();
	}
	
	
	// ���� �뷡 ���� �� �ٲ�� �޼ҵ�
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		nextTrack(nowSelected);
	}
	
	
	// ���� �뷡 ���� �� �ٲ�� �޼ҵ�
	public void selectRight() {
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		nextTrack(nowSelected);
	}
	
	public void play() {
		
	}
	
	public void stop() {
		
	}
}
