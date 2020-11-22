import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int heroX,heroY;
	int bossX,bossY;
	int leftFlag,rightFlag,upFlag,downFlag;
	Image heroImg[][]=new Image[4][3];
	Image bossImg;
	Image currentImg;

	public MainCanvas(){
		try
	    {
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			bossImg=Image.createImage("/zuz	u000.png");
			currentImg=heroImg[3][1];

			heroX=120;
			heroY=100;
			bossX=0;
			bossY=0;
			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;

			thread=new Thread(this);
			thread.	start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void run(){
		while(true){
			try
			{
				Thread.sleep(200);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}
			if(bossY<heroY){
				bossY++;
			}
			else{
				bossY--;
			}
			repaint();
		}
	}

	public void paint(Graphics g){
		g.setColor(135,206,235);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
		if (action==LEFT){
			if(leftFlag==1){
				currentImg=heroImg[0][0];
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=heroImg[0][2];
				leftFlag=1;
			}
			heroX=heroX-1;
		}
		else if  (action==RIGHT){
			if(rightFlag==1){
				currentImg=heroImg[1][0];
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=heroImg[1][2];
				rightFlag=1;
			}
			heroX=heroX+1;
		}
		else if(action==UP){
			if(upFlag==1){
				currentImg=heroImg[2][0];
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=heroImg[2][2];
				upFlag=1;
			}
			heroY=heroY-1;
		}
		else if(action==DOWN){
			if(downFlag==1){
				currentImg=heroImg[3][0];
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=heroImg[3][2];
				downFlag=1;
			}
			heroY=heroY+1;
		}
	}
}
