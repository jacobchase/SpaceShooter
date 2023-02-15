package spaceshooter;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import basicgraphics.SpriteSpriteCollisionListener;
import basicgraphics.BasicContainer;
import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.sounds.ReusableClip;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    public static int score = 000;
    public static double executeOrderSixtySix=1.12;
    public static int spaceshipsDestroyed=0;
	public static int lives=3;
	public static int enemiesRemaining=100;
	public static boolean done=false;
	public static int coinsCollected=0;
	public static void main(String[] args) {
        final ReusableClip clip = new ReusableClip("lasershoot.wav");
        final ReusableClip gameover = new ReusableClip("gameover.wav");
        final ReusableClip enemydeath = new ReusableClip("explosion.wav");
        final ReusableClip coinChime = new ReusableClip("smw_coin.wav");
        final BasicFrame bf = new BasicFrame("SpaceShooter");
        final Container content = bf.getContentPane();
        final CardLayout cards = new CardLayout();
        Timer timer = new Timer();
        content.setLayout(cards);
        BasicContainer bc1 = new BasicContainer();
        content.add(bc1,"Splash");
        final BasicContainer bc2 = new BasicContainer();
        content.add(bc2,"Game");
		final SpriteComponent sc = new SpriteComponent() {
            @Override
            public void paintBackground(Graphics g) {
                Dimension d = getSize();
                g.setColor(Color.black);
                g.fillRect(0, 0, d.width, d.height);
                final int NUM_STARS = 30;
                Random rand = new Random();
                rand.setSeed(0);
                g.setColor(Color.white);
                for(int i=0;i<NUM_STARS;i++) {
                    int diameter = rand.nextInt(5)+1;
                    int xpos = rand.nextInt(d.width);
                    int ypos = rand.nextInt(d.height);
                    g.fillOval(xpos, ypos, diameter, diameter);
                }
            }
        };
        sc.setPreferredSize(new Dimension(800,800));
        String[][] splashLayout = {
            {"Title"},
            {"Button"}
        };
        bc1.setStringLayout(splashLayout);
        bc1.add("Title",new JLabel("SpaceShooter"));
        JButton jstart = new JButton("Start");
        jstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content,"Game");
                bc2.requestFocus();
                Clock.start(10);
            }
        });
        bc1.add("Button",jstart);
        String[][] layout = {{
            "Flyer"
        }};
        bc2.setStringLayout(layout);
        bc2.add("Flyer",sc);
        bf.show();
        JOptionPane.showMessageDialog(sc, "Welcome to SpaceShooter! "
        		+ "\nTo move your spaceship, press the left and right arrow keys."
        		+ "\nTo shoot a laser, press the Spacebar."
        		+ "\nIf you want to pause the game, press p."
        		+ "\nGet your blaster ready, and have fun!");
        JOptionPane.showMessageDialog(sc,"SYSTEM_MESSAGE: Welcome to your X-233 model starship.  This is your automated computer system. "
        		+ "\n If any significant conditions occur, I am programmed to inform you of the status of this ship and these areas of space. "
        		+ "\n Please press OK to dismiss this message.");
        JOptionPane.showMessageDialog(sc,"SYSTEM_MESSAGE: There is a legion of enemy aliens approaching! "
        		+ "\nPrepare to defend yourself by shooting lasers to destroy the enemy."
        		+ "\nYou can also collect coins in order to strengthen the Republic's resources."
        		+ "\nGood luck surviving the horde, captain!");
        final Lives LifeOne=new Lives(sc);
        final Lives LifeTwo=new Lives(sc);
        final Lives LifeThree=new Lives(sc);
		Lives newLifeOneIcon=new Lives(sc);
		Lives newLifeTwoIcon=new Lives(sc);
		Lives newLifeThreeIcon=new Lives(sc);
        LifeOne.setX(0);
        LifeOne.setY(0);
        LifeTwo.setX(50);
        LifeTwo.setY(0);
        LifeThree.setX(100);
        LifeThree.setY(0);
        final Spaceship s = new Spaceship(sc);
        s.setX(350);
		s.setY(600);
		timer.schedule(new TimerTask(){
			public void run() {
        Enemy enemyOne = new Enemy(sc);
        enemyOne.setX(150); 
        enemyOne.setVelY(0.8);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwo = new Enemy(sc);
        enemyTwo.setX(258);
        enemyTwo.setVelY(0.6);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThree = new Enemy(sc);
        enemyThree.setX(340);
        enemyThree.setVelY(1.03);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFour = new Enemy(sc);
        enemyFour.setX(672);
        enemyFour.setVelY(1.1);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFive = new Enemy(sc);
        enemyFive.setX(454);
        enemyFive.setVelY(0.92);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySix = new Enemy(sc);
        enemySix.setX(569);
        enemySix.setVelY(1.05);
        enemiesRemaining=enemiesRemaining-1;
        }},1*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemySeven = new Enemy(sc);
        enemySeven.setX(500);
        enemySeven.setVelY(1.3);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyEight = new Enemy(sc);
        enemyEight.setX(325);
        enemyEight.setVelY(1.2);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyNine = new Enemy(sc);
        enemyNine.setX(160);
        enemyNine.setVelY(.87);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTen = new Enemy(sc);
        enemyTen.setX(439);
        enemyTen.setVelY(.96);
        enemiesRemaining=enemiesRemaining-1;
        }},3*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyEleven = new Enemy(sc);
        enemyEleven.setX(520);
        enemyEleven.setVelY(1.13);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwelve = new Enemy(sc);
        enemyTwelve.setX(325);
        enemyTwelve.setVelY(1.4);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirteen = new Enemy(sc);
        enemyThirteen.setX(90);
        enemyThirteen.setVelY(1.3);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourteen = new Enemy(sc);
        enemyFourteen.setX(150);
        enemyFourteen.setVelY(0.78);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFifteen = new Enemy(sc);
        enemyFifteen.setX(220);
        enemyFifteen.setVelY(0.98);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixteen = new Enemy(sc);
        enemySixteen.setX(650);
        enemySixteen.setVelY(1.055);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventeen = new Enemy(sc);
        enemySeventeen.setX(402);
        enemySeventeen.setVelY(1.1);
        enemiesRemaining=enemiesRemaining-1;
        }},6*1000);
		timer.schedule(new TimerTask() {
			public void run() {
		Coins coinOne = new Coins(sc);
		coinOne.setX(520);
		coinOne.setY(250);
		Coins coinTwo = new Coins(sc);
		coinTwo.setX(560);
		coinTwo.setY(250);
		Coins coinThree = new Coins(sc);
		coinThree.setX(500);
		coinThree.setY(300);
		Coins coinFour = new Coins(sc);
		coinFour.setX(540);
		coinFour.setY(300);
		Coins coinFive = new Coins(sc);
		coinFive.setX(580);
		coinFive.setY(300);
		Coins coinSix = new Coins(sc);
		coinSix.setX(500);
		coinSix.setY(350);
		Coins coinSeven = new Coins(sc);
		coinSeven.setX(540);
		coinSeven.setY(350);
		Coins coinEight = new Coins(sc);
		coinEight.setX(580);
		coinEight.setY(350);
		Coins coinNine = new Coins(sc);
		coinNine.setX(520);
		coinNine.setY(400);
		Coins coinTen = new Coins(sc);
		coinTen.setX(560);
		coinTen.setY(400);
		timer.schedule(new TimerTask() {
			public void run() {
				coinOne.setVelY(0.8);
				coinTwo.setVelY(0.8);
				coinThree.setVelY(0.8);
				coinFour.setVelY(0.8);
				coinFive.setVelY(0.8);
				coinSix.setVelY(0.8);
				coinSeven.setVelY(0.8);
				coinEight.setVelY(0.8);
				coinNine.setVelY(0.8);
				coinTen.setVelY(0.8);
			}},3*1000);}},7*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyEighteen = new Enemy(sc);
        enemyEighteen.setX(443);
        enemyEighteen.setVelY(0.67);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyNineteen = new Enemy(sc);
        enemyNineteen.setX(524);
        enemyEighteen.setVelY(1.42);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwenty = new Enemy(sc);
        enemyTwenty.setX(675);
        enemyTwenty.setVelY(0.92);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwentyOne = new Enemy(sc);
        enemyTwentyOne.setX(252);
        enemyTwentyOne.setVelY(1.03);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwentyTwo = new Enemy(sc);
        enemyTwentyTwo.setX(343);
        enemyTwentyTwo.setVelY(0.81);
        enemiesRemaining=enemiesRemaining-1;
        }},9*1000);
		timer.schedule(new TimerTask() {
			public void run() {
				LifeIcon LifeIconOne=new LifeIcon(sc);
				LifeIconOne.setX(340);
				LifeIconOne.setY(300);
				timer.schedule(new TimerTask() {
					public void run() {
						LifeIconOne.setVelY(1);
					}
				},4*1000);
			}},12*1000);
		timer.schedule(new TimerTask() {
		public void run() {
        Enemy enemyTwentyThree = new Enemy(sc);
        enemyTwentyThree.setX(64);
        enemyTwentyThree.setVelY(.8);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwentyFour = new Enemy(sc);
        enemyTwentyFour.setX(200);
        enemyTwentyFour.setVelY(1.24);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTentyFive = new Enemy(sc);
        enemyTentyFive.setX(390);
        enemyTentyFive.setVelY(0.89);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwentySix = new Enemy(sc);
        enemyTwentySix.setX(500);
        enemyTwentySix.setVelY(1.4);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwentySeven = new Enemy(sc);
        enemyTwentySeven.setX(425);
        enemyTwentySeven.setVelY(1.7);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwentyEight = new Enemy(sc);
        enemyTwentyEight.setX(600);
        enemyTwentyEight.setVelY(0.73);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyTwentyNine = new Enemy(sc);
        enemyTwentyNine.setX(680); 
        enemyTwentyNine.setVelY(1.11);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirty = new Enemy(sc);
        enemyThirty.setX(200);
        enemyThirty.setVelY(1.21);
        enemiesRemaining=enemiesRemaining-1;
        }},14*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyThirtyOne = new Enemy(sc);
        enemyThirtyOne.setX(500);
        enemyThirtyOne.setVelY(0.87);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirtyTwo = new Enemy(sc);
        enemyThirtyTwo.setX(300);
        enemyThirtyTwo.setVelY(1.12);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirtyThree = new Enemy(sc);
        enemyThirtyThree.setX(650);
        enemyThirtyThree.setVelY(1.3);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirtyFour = new Enemy(sc);
        enemyThirtyFour.setX(222);
        enemyThirtyFour.setVelY(0.67);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirtyFive = new Enemy(sc);
        enemyThirtyFive.setX(560);
        enemyThirtyFive.setVelY(1.04);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirtySix = new Enemy(sc);
        enemyThirtySix.setX(170);
        enemyThirtySix.setVelY(1.43);
        enemiesRemaining=enemiesRemaining-1;
        }},17*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyThirtySeven = new Enemy(sc);
        enemyThirtySeven.setX(435);
        enemyThirtySeven.setVelY(0.78);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirtyEight = new Enemy(sc);
        enemyThirtyEight.setX(150);
        enemyThirtyEight.setVelY(1.13);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyThirtyNine = new Enemy(sc);
        enemyThirtyNine.setX(380);  
        enemyThirtyNine.setVelY(1.07);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourty = new Enemy(sc);
        enemyFourty.setX(600);
        enemyFourty.setVelY(0.86);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourtyOne = new Enemy(sc);
        enemyFourtyOne.setX(550);
        enemyFourtyOne.setVelY(1.6);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourtyTwo = new Enemy(sc);
        enemyFourtyTwo.setX(700);
        enemyFourtyTwo.setVelY(0.53);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourtyThree = new Enemy(sc);
        enemyFourtyThree.setX(290);
        enemyFourtyThree.setVelY(1.2);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourtyFour = new Enemy(sc);
        enemyFourtyFour.setX(240);
        enemyFourtyFour.setVelY(0.95);
        enemiesRemaining=enemiesRemaining-1;
        }},21*1000);
		timer.schedule(new TimerTask() {
			public void run() {
		Coins coinOne = new Coins(sc);
		coinOne.setX(320);
		coinOne.setY(250);
		Coins coinTwo = new Coins(sc);
		coinTwo.setX(360);
		coinTwo.setY(250);
		Coins coinThree = new Coins(sc);
		coinThree.setX(300);
		coinThree.setY(300);
		Coins coinFour = new Coins(sc);
		coinFour.setX(340);
		coinFour.setY(300);
		Coins coinFive = new Coins(sc);
		coinFive.setX(380);
		coinFive.setY(300);
		Coins coinSix = new Coins(sc);
		coinSix.setX(300);
		coinSix.setY(350);
		Coins coinSeven = new Coins(sc);
		coinSeven.setX(340);
		coinSeven.setY(350);
		Coins coinEight = new Coins(sc);
		coinEight.setX(380);
		coinEight.setY(350);
		Coins coinNine = new Coins(sc);
		coinNine.setX(320);
		coinNine.setY(400);
		Coins coinTen = new Coins(sc);
		coinTen.setX(360);
		coinTen.setY(400);
		timer.schedule(new TimerTask() {
			public void run() {
				coinOne.setVelY(1);
				coinTwo.setVelY(1);
				coinThree.setVelY(1);
				coinFour.setVelY(1);
				coinFive.setVelY(1);
				coinSix.setVelY(1);
				coinSeven.setVelY(1);
				coinEight.setVelY(1);
				coinNine.setVelY(1);
				coinTen.setVelY(1);
			}},3*1000);}},23*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyFourtyFive = new Enemy(sc);
        enemyFourtyFive.setX(170);
        enemyFourtyFive.setVelY(1.13);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourtySix = new Enemy(sc);
        enemyFourtySix.setX(250);
        enemyFourtySix.setVelY(0.87);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourtySeven = new Enemy(sc);
        enemyFourtySeven.setX(325);
        enemyFourtySeven.setVelY(0.68);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourtyEight = new Enemy(sc);
        enemyFourtyEight.setX(571);
        enemyFourtyEight.setVelY(1.34);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFourtyNine = new Enemy(sc);
        enemyFourtyNine.setX(640);
        enemyFourtyNine.setVelY(1.02);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFifty = new Enemy(sc);
        enemyFifty.setX(174);
        enemyFifty.setVelY(1.28);
        enemiesRemaining=enemiesRemaining-1;
		}},25*1000);
		timer.schedule(new TimerTask() {
			public void run() {
				LifeIcon LifeIconOne=new LifeIcon(sc);
				LifeIconOne.setX(340);
				LifeIconOne.setY(300);
				timer.schedule(new TimerTask() {
					public void run() {
						LifeIconOne.setVelY(1);
					}
				},4*1000);
			}},27*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyFiftyOne = new Enemy(sc);
        enemyFiftyOne.setX(373);
        enemyFiftyOne.setVelY(0.71);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFiftyTwo = new Enemy(sc);
        enemyFiftyTwo.setX(430);
        enemyFiftyTwo.setVelY(1.2);        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFiftyThree = new Enemy(sc);
        enemyFiftyThree.setX(300);
        enemyFiftyThree.setVelY(0.98);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFiftyFour = new Enemy(sc);
        enemyFiftyFour.setX(230);
        enemyFiftyFour.setVelY(1.34);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFiftyFive = new Enemy(sc);
        enemyFiftyFive.setX(600);
        enemyFiftyFive.setVelY(1.04);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFiftySix = new Enemy(sc);
        enemyFiftySix.setX(505);
        enemyFiftySix.setVelY(0.84);
        enemiesRemaining=enemiesRemaining-1;
        }},29*1000);
		timer.schedule(new TimerTask() {
			public void run() {
		Coins coinOne = new Coins(sc);
		coinOne.setX(520);
		coinOne.setY(300);
		Coins coinTwo = new Coins(sc);
		coinTwo.setX(560);
		coinTwo.setY(300);
		Coins coinThree = new Coins(sc);
		coinThree.setX(500);
		coinThree.setY(350);
		Coins coinFour = new Coins(sc);
		coinFour.setX(540);
		coinFour.setY(350);
		Coins coinFive = new Coins(sc);
		coinFive.setX(580);
		coinFive.setY(350);
		Coins coinSix = new Coins(sc);
		coinSix.setX(500);
		coinSix.setY(400);
		Coins coinSeven = new Coins(sc);
		coinSeven.setX(540);
		coinSeven.setY(400);
		Coins coinEight = new Coins(sc);
		coinEight.setX(580);
		coinEight.setY(400);
		Coins coinNine = new Coins(sc);
		coinNine.setX(520);
		coinNine.setY(450);
		Coins coinTen = new Coins(sc);
		coinTen.setX(560);
		coinTen.setY(450);
		timer.schedule(new TimerTask() {
			public void run() {
				coinOne.setVelY(1.2);
				coinTwo.setVelY(1.2);
				coinThree.setVelY(1.2);
				coinFour.setVelY(1.2);
				coinFive.setVelY(1.2);
				coinSix.setVelY(1.2);
				coinSeven.setVelY(1.2);
				coinEight.setVelY(1.2);
				coinNine.setVelY(1.2);
				coinTen.setVelY(1.2);
			}},3*1000);}},31*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyFiftySeven = new Enemy(sc);
        enemyFiftySeven.setX(233);
        enemyFiftySeven.setVelY(.72);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFiftyEight = new Enemy(sc);
        enemyFiftyEight.setX(560);
        enemyFiftyEight.setVelY(1.18);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyFiftyNine = new Enemy(sc);
        enemyFiftyNine.setX(300);
        enemyFiftyNine.setVelY(1.08);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixty = new Enemy(sc);
        enemySixty.setX(425);
        enemySixty.setVelY(1.24);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixtyOne = new Enemy(sc);
        enemySixtyOne.setX(150);
        enemySixtyOne.setVelY(0.64);
        enemiesRemaining=enemiesRemaining-1;
        }},33*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemySixtyTwo = new Enemy(sc);
        enemySixtyTwo.setX(250);
        enemySixtyTwo.setVelY(1.05);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixtyThree = new Enemy(sc);
        enemySixtyThree.setX(370);
        enemySixtyThree.setVelY(1.32);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixtyFour = new Enemy(sc);
        enemySixtyFour.setX(300);
        enemySixtyFour.setVelY(1.3);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixtyFive = new Enemy(sc);
        enemySixtyFive.setX(522);
        enemySixtyFive.setVelY(0.91);
        enemiesRemaining=enemiesRemaining-1;
        }},37*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemySixtySix = new Enemy(sc);
        enemySixtySix.setX(370);
        enemySixtySix.setVelY(executeOrderSixtySix);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixtySeven = new Enemy(sc);
        enemySixtySeven.setX(500);
        enemySixtySeven.setVelY(1.38);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixtyEight = new Enemy(sc);
        enemySixtyEight.setX(590);
        enemySixtyEight.setVelY(0.78);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySixtyNine = new Enemy(sc);
        enemySixtyNine.setX(399);
        enemySixtyNine.setVelY(1.02);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventy = new Enemy(sc);
        enemySeventy.setX(107);
        enemySeventy.setVelY(1.23);
        enemiesRemaining=enemiesRemaining-1;
        }},41*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemySeventyOne = new Enemy(sc);
        enemySeventyOne.setX(597);
        enemySeventyOne.setVelY(0.89);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventyTwo = new Enemy(sc);
        enemySeventyTwo.setX(325);
        enemySeventyTwo.setVelY(1.34);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventyThree = new Enemy(sc);
        enemySeventyThree.setX(369);
        enemySeventyThree.setVelY(1.13);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventyFour = new Enemy(sc);
        enemySeventyFour.setX(700);
        enemySeventyFour.setVelY(1.01);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventyFive = new Enemy(sc);
        enemySeventyFive.setX(540);
        enemySeventyFive.setVelY(1.45);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventySix = new Enemy(sc);
        enemySeventySix.setX(226);
        enemySeventySix.setVelY(0.98);
        enemiesRemaining=enemiesRemaining-1;
        }},45*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemySeventySeven = new Enemy(sc);
        enemySeventySeven.setX(478);
        enemySeventySeven.setVelY(1.65);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventyEight = new Enemy(sc);
        enemySeventyEight.setX(390);
        enemySeventyEight.setVelY(0.87);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemySeventyNine = new Enemy(sc);
        enemySeventyNine.setX(175);
        enemySeventyNine.setVelY(0.67);
        enemiesRemaining=enemiesRemaining-1;
        Enemy eighty = new Enemy(sc);
        eighty.setX(620);
        eighty.setVelY(1.2);
        enemiesRemaining=enemiesRemaining-1;
        }},49*1000);
		timer.schedule(new TimerTask() {
			public void run() {
		Coins coinOne = new Coins(sc);
		coinOne.setX(120);
		coinOne.setY(350);
		Coins coinTwo = new Coins(sc);
		coinTwo.setX(160);
		coinTwo.setY(350);
		Coins coinThree = new Coins(sc);
		coinThree.setX(100);
		coinThree.setY(400);
		Coins coinFour = new Coins(sc);
		coinFour.setX(140);
		coinFour.setY(400);
		Coins coinFive = new Coins(sc);
		coinFive.setX(180);
		coinFive.setY(400);
		Coins coinSix = new Coins(sc);
		coinSix.setX(100);
		coinSix.setY(450);
		Coins coinSeven = new Coins(sc);
		coinSeven.setX(140);
		coinSeven.setY(450);
		Coins coinEight = new Coins(sc);
		coinEight.setX(180);
		coinEight.setY(450);
		Coins coinNine = new Coins(sc);
		coinNine.setX(120);
		coinNine.setY(500);
		Coins coinTen = new Coins(sc);
		coinTen.setX(160);
		coinTen.setY(500);
		timer.schedule(new TimerTask() {
			public void run() {
				coinOne.setVelY(1.4);
				coinTwo.setVelY(1.4);
				coinThree.setVelY(1.4);
				coinFour.setVelY(1.4);
				coinFive.setVelY(1.4);
				coinSix.setVelY(1.4);
				coinSeven.setVelY(1.4);
				coinEight.setVelY(1.4);
				coinNine.setVelY(1.4);
				coinTen.setVelY(1.4);
			}},3*1000);}},52*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyeightyOne = new Enemy(sc);
        enemyeightyOne.setX(150);
        enemyeightyOne.setVelY(0.78);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyeightyTwo = new Enemy(sc);
        enemyeightyTwo.setX(250);
        enemyeightyTwo.setVelY(1.13);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyeightyThree = new Enemy(sc);
        enemyeightyThree.setX(345);
        enemyeightyThree.setVelY(0.78);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyeightyFour = new Enemy(sc);
        enemyeightyFour.setX(680);
        enemyeightyFour.setVelY(0.98);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyeightyFive = new Enemy(sc);
        enemyeightyFive.setX(560);
        enemyeightyFive.setVelY(1.34);
        enemiesRemaining=enemiesRemaining-1;
		}},55*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyeightySix = new Enemy(sc);
        enemyeightySix.setX(555);
        enemyeightySix.setVelY(1.3);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyeightySeven = new Enemy(sc);
        enemyeightySeven.setX(490);
        enemyeightySeven.setVelY(0.84);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyeightyEight = new Enemy(sc);
        enemyeightyEight.setX(334);
        enemyeightyEight.setVelY(1.03);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyeightyNine = new Enemy(sc);
        enemyeightyNine.setX(246);
        enemyeightyNine.setVelY(0.85);
        enemiesRemaining=enemiesRemaining-1;
        Enemy ninety = new Enemy(sc);
        ninety.setX(500);
        ninety.setVelY(1.49);
        enemiesRemaining=enemiesRemaining-1;
        }},58*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyninetyOne = new Enemy(sc);
        enemyninetyOne.setX(150); 
        enemyninetyOne.setVelY(1.23);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyninetyTwo = new Enemy(sc);
        enemyninetyTwo.setX(250);
        enemyninetyTwo.setVelY(0.67);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyninetyThree = new Enemy(sc);
        enemyninetyThree.setX(370);
        enemyninetyThree.setVelY(1.49);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyninetyFour = new Enemy(sc);
        enemyninetyFour.setX(550);
        enemyninetyFour.setVelY(0.73);
        enemiesRemaining=enemiesRemaining-1;
        }},62*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyninetyFive = new Enemy(sc);
        enemyninetyFive.setX(380);
        enemyninetyFive.setVelY(0.98);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyninetySix = new Enemy(sc);
        enemyninetySix.setX(340);
        enemyninetySix.setVelY(1.31);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyninetySeven = new Enemy(sc);
        enemyninetySeven.setX(500);
        enemyninetySeven.setVelY(0.54);
        enemiesRemaining=enemiesRemaining-1;
        }},65*1000);
		timer.schedule(new TimerTask() {
			public void run() {
				LifeIcon LifeIconOne=new LifeIcon(sc);
				LifeIconOne.setX(340);
				LifeIconOne.setY(300);
				timer.schedule(new TimerTask() {
					public void run() {
						LifeIconOne.setVelY(1);
					}
				},4*1000);
			}},68*1000);
		timer.schedule(new TimerTask() {
			public void run() {
		Coins coinOne = new Coins(sc);
		coinOne.setX(220);
		coinOne.setY(250);
		Coins coinTwo = new Coins(sc);
		coinTwo.setX(260);
		coinTwo.setY(250);
		Coins coinThree = new Coins(sc);
		coinThree.setX(200);
		coinThree.setY(300);
		Coins coinFour = new Coins(sc);
		coinFour.setX(240);
		coinFour.setY(300);
		Coins coinFive = new Coins(sc);
		coinFive.setX(280);
		coinFive.setY(300);
		Coins coinSix = new Coins(sc);
		coinSix.setX(200);
		coinSix.setY(350);
		Coins coinSeven = new Coins(sc);
		coinSeven.setX(240);
		coinSeven.setY(350);
		Coins coinEight = new Coins(sc);
		coinEight.setX(280);
		coinEight.setY(350);
		Coins coinNine = new Coins(sc);
		coinNine.setX(220);
		coinNine.setY(400);
		Coins coinTen = new Coins(sc);
		coinTen.setX(260);
		coinTen.setY(400);
		timer.schedule(new TimerTask() {
			public void run() {
				coinOne.setVelY(1);
				coinTwo.setVelY(1);
				coinThree.setVelY(1);
				coinFour.setVelY(1);
				coinFive.setVelY(1);
				coinSix.setVelY(1);
				coinSeven.setVelY(1);
				coinEight.setVelY(1);
				coinNine.setVelY(1);
				coinTen.setVelY(1);
			}},3*1000);}},67*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy enemyninetyEight = new Enemy(sc);
        enemyninetyEight.setX(643);
        enemyninetyEight.setVelY(1.21);
        enemiesRemaining=enemiesRemaining-1;
        Enemy enemyninetyNine = new Enemy(sc);
        enemyninetyNine.setX(300);
        enemyninetyNine.setVelY(0.71);
        enemiesRemaining=enemiesRemaining-1;
        }},69*1000);
		timer.schedule(new TimerTask() {
			public void run() {
        Enemy hundred = new Enemy(sc);
        hundred.setX(600);
        hundred.setVelY(1.33);
        enemiesRemaining=0;
        		done = true;
        		timer.schedule(new TimerTask() {
        			public void run() {
        			JOptionPane.showMessageDialog(sc, "Congratulations! You survived the horde!"
        					+ "\n You destroyed " + spaceshipsDestroyed + "/100 spaceships and you collected " + coinsCollected + " coins.");
        			System.exit(0);}},7*1000);
        	}},72*1000);
		if (enemiesRemaining==0) {
			JOptionPane.showMessageDialog(sc, "Congratulations! You survived the horde!"
					+ "\n You destroyed " + spaceshipsDestroyed + "/100 spaceships and you collected " + coinsCollected + " coins.");
			System.exit(0);
		}
        bc2.addKeyListener(new KeyAdapter() {   
            @Override
            public void keyPressed(KeyEvent ke) {
            	int key = ke.getKeyCode();
                if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    s.setVelX(1);
                } else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    s.setVelX(-1);
                } else if(ke.getKeyCode()==KeyEvent.VK_DOWN) {
                	s.setVelY(1);
                }
                else if(ke.getKeyCode()==KeyEvent.VK_UP) {
                	s.setVelY(-1);
                }
                else if(ke.getKeyChar()=='a') {
                	s.setVelX(-1);
                }
                else if(ke.getKeyChar()=='d') {
                	s.setVelX(1);
                }
                else  if(ke.getKeyChar()=='w') {
                	s.setVelY(-1);
                }
                else if(ke.getKeyChar()=='s') {
                	s.setVelY(1);
                }
                else if(ke.getKeyChar() == ' ') {
                    Laser las = new Laser(sc);
                    las.setVelX(0);
                    las.setVelY(-2);
                    las.setCenterX(s.centerX());
                    las.setCenterY(s.centerY());
                    clip.play();
                }
                else if(ke.getKeyChar()=='p') {
                	Clock.stop();
                	JOptionPane.showMessageDialog(sc, "The game is currently paused. "
                			+ "Click the OK button below to resume the game.");
                	Clock.start(10);
                }
                else if(ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                	Clock.stop();
                	int SelectedOption = JOptionPane.showConfirmDialog(null, "Would you like to quit the game?", "Choose an Option.",JOptionPane.YES_NO_OPTION);
                	if(SelectedOption==JOptionPane.YES_OPTION) {
                		System.exit(0);
                	}
                	if(SelectedOption==JOptionPane.NO_OPTION) {
                		Clock.start(10);
                	}
                }
            }});
        bc2.addKeyListener(new KeyAdapter () {
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    s.setVelX(0);
                } else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    s.setVelX(0);
                } else if(ke.getKeyCode()==KeyEvent.VK_DOWN) {
                	s.setVelY(0);
                }
                else if(ke.getKeyCode()==KeyEvent.VK_UP) {
                	s.setVelY(0);
                }
                else if(ke.getKeyChar()=='a') {
                	s.setVelX(0);
                }
                else if(ke.getKeyChar()=='d') {
                	s.setVelX(0);
                }
                else  if(ke.getKeyChar()=='w') {
                	s.setVelY(0);
                }
                else if(ke.getKeyChar()=='s') {
                	s.setVelY(0);
                }
            	}
            });
        sc.addSpriteSpriteCollisionListener(Enemy.class, Laser.class, new SpriteSpriteCollisionListener<Enemy, Laser>() {
            @Override
            public void collision(Enemy sp1, Laser sp2) {
                sp1.setActive(false);
                sp2.setActive(false);
                enemydeath.play();
                spaceshipsDestroyed=spaceshipsDestroyed+1;
            }
        });
        sc.addSpriteSpriteCollisionListener(Enemy.class, Spaceship.class, new SpriteSpriteCollisionListener<Enemy, Spaceship>(){
        	@Override
        	public void collision(Enemy sp1, Spaceship sp2) {
        		sp1.setActive(false);
        		lives=lives-1;
        		if (lives==2) {
        			newLifeThreeIcon.removeLifeIcon();
        			LifeThree.removeLifeIcon();
        			Clock.stop();
        			JOptionPane.showMessageDialog(sc, "SYSTEM.MESSAGE: Attention Captain, the main hull has taken significant damage."
        					+ "\n  Further sustained damage may result in critical conditions.");
        			Clock.start(10);
        		}
        		if(lives==1) {
        			newLifeTwoIcon.removeLifeIcon();
           			LifeTwo.removeLifeIcon();
        			Clock.stop();
        			JOptionPane.showMessageDialog(sc, "SYSTEM.MESSAGE: Captain, we have taken critical damage."
        					+ "\n Our shields have been destroyed! Any further damage may result in destruction of this X-233 model.");
        			Clock.start(10);
        		}
        		if (lives==0) {
        			sp2.setActive(false);
        			done=true;
        			gameover.play();
        			Clock.stop();
        			LifeOne.removeLifeIcon();
                	JOptionPane.showMessageDialog(sc, "Your spaceship was destroyed by the enemy!  "
                			+ "\nYou destroyed "+ spaceshipsDestroyed + "/100 spaceships and collected " +coinsCollected +" coins!");
                    System.exit(0);
                }
        	}
        });
        sc.addSpriteSpriteCollisionListener(Laser.class, Coins.class, new SpriteSpriteCollisionListener<Laser,Coins>(){
        	@Override
        	public void collision(Laser sp1, Coins sp2) {
        		sp1.setActive(true);
        		sp2.setActive(false);
        		coinChime.play();
        		coinsCollected=coinsCollected+1;
        	}
        });
        sc.addSpriteSpriteCollisionListener(Spaceship.class,Coins.class, new SpriteSpriteCollisionListener<Spaceship,Coins>(){
        	public void collision(Spaceship sp1, Coins sp2) {
        		sp1.setActive(true);
        		sp2.setActive(false);
        		coinChime.play();
        		coinsCollected=coinsCollected+1;
        	}
        });
        sc.addSpriteSpriteCollisionListener(LifeIcon.class, Spaceship.class, new SpriteSpriteCollisionListener<LifeIcon,Spaceship>(){
        	public void collision(LifeIcon sp1, Spaceship sp2) {
        		sp1.setActive(false);
        		sp2.setActive(true);
        		lives=lives+1;
        	    if(lives==1) {
        			newLifeOneIcon.setX(0);
        			newLifeOneIcon.setY(0);
        		}
        		else if(lives==2) {
        			newLifeTwoIcon.setX(50);
        			newLifeTwoIcon.setY(0);
        		}
        		else if(lives==3) {
        	        newLifeThreeIcon.setX(100);
        	        newLifeThreeIcon.setY(0);
        		}
        		else if (lives>=4) {
        			lives=3;
        		}
        	}
        });
        sc.addSpriteSpriteCollisionListener(LifeIcon.class, Laser.class, new SpriteSpriteCollisionListener<LifeIcon,Laser>(){
        	public void collision(LifeIcon sp1, Laser sp2) {
        		sp1.setActive(false);
        		sp2.setActive(true);
        		lives=lives+1;
        	    if(lives==1) {
        			newLifeOneIcon.setX(0);
        			newLifeOneIcon.setY(0);
        		}
        		else if(lives==2) {
        			newLifeTwoIcon.setX(50);
        			newLifeTwoIcon.setY(0);
        		}
        		else if(lives==3) {
        	        newLifeThreeIcon.setX(100);
        	        newLifeThreeIcon.setY(0);
        		}
        		else if (lives>=4) {
        			lives=3;
        		}
        	}
        });
        Clock.addTask(sc.moveSprites());
    }
	public boolean isGameOver(SpriteCollisionEvent Collision) {
		boolean gameover=false;
		if(Collision.xlo==true)
			gameover=true;
		return gameover;
	}
	}
