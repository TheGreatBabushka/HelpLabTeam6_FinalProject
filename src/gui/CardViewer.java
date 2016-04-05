package gui;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardViewer extends JFrame{
	BufferedImage image = null;
	
	public CardViewer(BufferedImage image){
		this.image = (BufferedImage) resizeToBig(image, 768, 1024 );
		setImage();
		
		setSize(this.image.getWidth(), this.image.getHeight());
		setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
				(int) (dim.height / 2 - this.getSize().height / 2 - dim.getHeight() / 8));
		setVisible(true);
	}

	private void setImage() {
			setContentPane(new JLabel(new ImageIcon(image)));
			setSize(this.getWidth() - 1,this.getHeight() - 1);
			setSize(this.getWidth() + 1,this.getHeight() + 1);
	}


	//taken from http://stackoverflow.com/questions/3967731/how-to-improve-the-performance-of-g-drawimage-method-for-resizing-images/11371387#11371387
	private Image resizeToBig(Image originalImage, int biggerWidth, int biggerHeight) {
	    int type = BufferedImage.TYPE_INT_ARGB;
	    
	    BufferedImage resizedImage = new BufferedImage(biggerWidth, biggerHeight, type);
	    Graphics2D g = resizedImage.createGraphics();
	    g.setComposite(AlphaComposite.Src);
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    g.drawImage(originalImage, 0, 0, biggerWidth, biggerHeight, this);
	    g.dispose();

	    return resizedImage;
	}
	
	
	

}