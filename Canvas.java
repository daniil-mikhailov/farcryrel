import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.io.InputStream;


public class Canvas extends JPanel{
	// Подклассы и переменные
    private Model model;
	private Image imageGamer;
	private Image imageWall;
	private Image imageBox;
    Canvas(Model model){
        this.model=model;
        setBackground(Color.gray);
        setOpaque(true);
		File fileNameGamer = new File("images/hero.png");
		File fileNameWall = new File("images/wall.png");
		File fileNameBox = new File("images/box.png");
		//InputStream is = getClass().getClassLoader().getResourceAsStream("sounds/game-background.mp3");
		
	try {
		imageGamer = ImageIO.read(fileNameGamer);
		imageWall = ImageIO.read(fileNameWall);
		imageBox = ImageIO.read(fileNameBox);
	} catch(IOException e) {
		System.out.println(e);
	}
	
	

    }
	
	// Фоновый звук // В разработке :)
	
	// Отображение элементов на экране.
    public void paint(Graphics pen){
        super.paint(pen);

        int start=50;
        int x = start;
        int y = start;
        int width = 50;
        int height = 50;
        int offset = 5;

        for (int i=0;i<model.desktop.length;i++){
            for(int j=0;j<model.desktop[i].length;j++){
				
                if (model.desktop[i][j]==1){
				
                /*    pen.setColor(Color.blue);
                    pen.fillRect(x,y,width,height);
                    pen.setColor(Color.black);
				*/
				
                    pen.drawImage(imageGamer, x, y, null);
				
				
                }else if(model.desktop[i][j]==2){
                /*    pen.setColor(Color.red);
                    pen.fillRect(x,y,width,height);
                    pen.setColor(Color.black);
                    pen.drawRect(x,y,width,height);
				*/
					pen.drawImage(imageWall, x, y, null);
				}else if(model.desktop[i][j]==3){
					
					pen.drawImage(imageBox, x, y, null);
					
                }else{
					
					pen.setColor(Color.white);
                    pen.drawRect(x,y,width,height);
                }
                x=x+width+offset;
            }
            x=start;
            y=y+height+offset;
        }


    }
}
