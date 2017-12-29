package steganography;

//Handle an event in a Swing program.
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

import javax.imageio.ImageIO;
import javax.swing.*;


public class EventDemo extends JPanel {
public JLabel jlab;
public JLabel jlab2;
public JLabel jlab4;
public JLabel jlab5;
public JLabel label1;
public static BufferedImage buff;
public static BufferedImage buff2;
public static String tt2;
public static String userInput1;
public static String password;
public static String dpassword;
public static File im1;
public static File im2;
public static int pwdv1;
public static String fpth;
public static String fpth0;
public String path;
public String original;
public String ext1;




EventDemo() {

	//Create a new JFrame container.
JFrame jfrm = new JFrame("Steganography");



//create a Jpanel
JPanel enpanel1 = new JPanel();
JPanel enpanel2 = new JPanel();

enpanel1.setLayout(null);
enpanel2.setLayout(null);





//Specify FlowLayout for the layout manager.
jfrm.setLayout(new BorderLayout());


//Give the frame an initial size.
jfrm.setSize(1000, 900);



//Terminate the program when the user closes the application.
jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//Make two buttons.
JButton browse = new JButton("BROWSE PICTURE");
JButton Enter = new JButton("ENTER TEXT");
JButton Exit = new JButton("Exit");
JButton gen = new JButton("Generate Stego");
JButton pwd = new JButton("Enter Password");




JButton decrypt = new JButton("Decrypt Image");
JButton browse2 = new JButton("BROWSE PICTURE");
JButton Exit2 = new JButton("Exit");
JButton dpwd = new JButton("Enter Password");





//Make Filechooser.
JFileChooser J1 = new javax.swing.JFileChooser();
JFileChooser J2 = new javax.swing.JFileChooser();


//make a icon.
JLabel labe = new javax.swing.JLabel();
JLabel labe2 = new javax.swing.JLabel();







labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steganography/en3.jpg")));
//labe.setText("Encryption");
labe2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steganography/en2.jpg")));






//make a textfield.
JTextField txtbox = new javax.swing.JTextField();
txtbox.setText("");


//make a textfiled for password
JTextField ptxtbox = new javax.swing.JTextField();
ptxtbox.setText("");


//make a textfiled for password
JTextField dptxtbox = new javax.swing.JTextField();
dptxtbox.setText("");




//Add action listener for browse.
browse.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {

if (ae.getSource() == browse) {
    int returnVal = J1.showOpenDialog(EventDemo.this);
    
     im1 = J1.getSelectedFile();
    fpth0= im1.getAbsolutePath();
    fpth = fpth0.
    	    substring(0,fpth0.lastIndexOf(File.separator));
    System.out.println(""+fpth);
    try {
    	buff = ImageIO.read(im1);
    	System.out.println(""+buff.getHeight());
    } catch (IOException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    }


}

jlab.setText("Picture browsed succesfully.");
}
});






//Add action listener for browse2.
browse2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {

if (ae.getSource() == browse2) {
  int returnVal = J1.showOpenDialog(EventDemo.this);
  
   im2 = J1.getSelectedFile();    
  try {
  	buff2 = ImageIO.read(im2);
  	System.out.println(""+buff2.getHeight());
  } catch (IOException e) {
  	// TODO Auto-generated catch block
  	e.printStackTrace();
  }


}
jlab2.setText("Picture browsed succesfully.");
}
});















//Add action listener for entertext.
Enter.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {

tt2=txtbox.getText();
System.out.println(""+tt2);

jlab.setText("Text Entered.");
}
});





//Add action listener for Exit.
Exit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
	System.exit(0);   
}
});


//Add action listener for Exit2.
Exit2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
	System.exit(0);   
}
});






///Add action listener for pwd.
pwd.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {

	password=ptxtbox.getText();
	
	int pwdl1=((password.length())/2)+1;
	char a = password.charAt(pwdl1);
	pwdv1= (int) a;
	
	System.out.println("pwdv1"+pwdv1);
			
	jlab.setText("password entered");
}
});




///Add action listener for dpwd.
dpwd.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
	
	
	
	dpassword=dptxtbox.getText();
	
	jlab2.setText("password entered");
}
});


















//Add action listener for Generate.
gen.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
	
	Encryption ob2=new Encryption();
	
		
	
	
	
	userInput1 = JOptionPane.showInputDialog("Please enter the name of the file you want to generate.");
	System.out.println(""+fpth);
	
	
	
	ob2.encrypt(buff,tt2,fpth,userInput1,password,pwdv1);
	System.out.println("hdgbbmm");
	//ob2.setImage(buff,new File(ob2.image_path(fpth,userInput1,"png")),"png");
	
	jlab.setText("Stego generated successfully");//need to correct the timming of the display
}
});




//Add action listener for Decrypt.
decrypt.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
	
Encryption ob3=new Encryption();
	
	
	
    //ob3.decode(buff2);

System.out.println(""+buff2.getWidth());
	
	String us2= ob3.decode(buff2,dpassword,pwdv1);
	
	
	jlab2.setText("text decoded successfully");
	
	
	
	JOptionPane.showMessageDialog (null, ""+us2, "Secret Message", JOptionPane.INFORMATION_MESSAGE);

}
});










///Add action listener for textbox.
txtbox.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
	//String tt1=txtbox.getText();
	//System.out.println(""+tt1);
}
});






//Set locations and sizes.
browse.setBounds(650,700,200,50);

Enter.setBounds(100,700,200,50);

gen.setBounds(100, 760, 200, 50);

Exit.setBounds(650,760,200,50);

decrypt.setBounds(100,760,200,50);

Exit2.setBounds(650,760,200,50);
browse2.setBounds(650,700,200,50);

pwd.setBounds(650,630,200,50);
dpwd.setBounds(650,630,200,50);


J1.setBounds(300,300,300,200);
J2.setBounds(300,300,300,200);
//no need to add j1 as it is linked with a button


//Create a text-based label.
jlab = new JLabel("Press a button.");
jlab.setBounds(405,700,300,200);
jlab2 = new JLabel("Press a button.");
jlab2.setBounds(405,700,300,200);


jlab4 = new JLabel("Enter a password of Maximum 8 Charactes");
jlab4.setBounds(630,430,300,200);


jlab5 = new JLabel("Enter a password of Maximum 8 Charactes");
jlab5.setBounds(630,430,300,200);

//Add the label to the content pane.
//jfrm.add(jlab);


labe.setBounds(0,0,990,400);
labe2.setBounds(0,0,990,400);
//jfrm.add(labe);


//add text box to the content pane.
txtbox.setBounds(100,550,330,120);

ptxtbox.setBounds(600,550,330,80);
dptxtbox.setBounds(600,550,330,80);

//jfrm.add(txtbox);


enpanel1.add(browse);
enpanel1.add(Enter);
enpanel1.add(Exit);
enpanel1.add(gen);
enpanel1.add(txtbox);
enpanel1.add(jlab);
enpanel1.add(labe);
enpanel1.add(ptxtbox);
enpanel1.add(pwd);
enpanel1.add(jlab4);


enpanel2.add(decrypt);
enpanel2.add(Exit2);
enpanel2.add(browse2);
enpanel2.add(jlab2);
enpanel2.add(labe2);
enpanel2.add(dptxtbox);
enpanel2.add(dpwd);
enpanel2.add(jlab5);








JTabbedPane tabbedpane = new JTabbedPane();
tabbedpane.addTab("Encryption", enpanel1);

tabbedpane.addTab("Decryption", enpanel2);

jfrm.add(tabbedpane);
//Display the frame.
jfrm.setVisible(true);
}


	


public static void main(String args[]) {

	
	
	// Create the frame on the event dispatching thread.
SwingUtilities.invokeLater(new Runnable() {
public void run() {
new EventDemo();



}
});


}

}








class Encryption{
	
public WritableRaster raster;
public WritableRaster raster2;
public DataBufferByte data1;	
public DataBufferByte data2;
public byte[] b;
public byte[] bu;
public byte[] p;
public byte[] dp;
public byte img[];
public byte img2[];
public byte len[];
public byte plen[];
public byte dplen[];

	
public boolean encrypt(BufferedImage buff, String tt2, String fpth, String userInput1, String password, int pwdv1)

{

	
	 //buff  = new BufferedImage(buff.getWidth(), buff.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
	
	
	
	
	
raster = buff.getRaster();	
data1   = (DataBufferByte) raster.getDataBuffer();
b = ((String)tt2).getBytes();


img  = data1.getData();;
 len   = bit_conversion(b.length);
 
 

 System.out.println("password"+password);
 p= ((String)password).getBytes();
 plen =bit_conversion(p.length);
 
 System.out.println("hiplen="+plen);
 System.out.println("hil="+len);


 
 
 for(int i=0; i<b.length; i++)
 {
 System.out.println("hib="+b[i]);
 }
 
 
 for(int i=0; i<len.length; i++)
 {
 System.out.println("hi len="+len[i]);
 }
 
 
 	 
	 pwdv1 = pwdv1 % p.length;
	    while (pwdv1-- > 0)
	    {
	        int tmp = p[0];
	        for (int i = 1; i < p.length; i++)
	        { p[i - 1] = p[i];
	        System.out.println("hip="+p[i]);}
	        p[p.length - 1] = (byte) tmp;
	        
	    }
	 
	  
	 
 
 
 
 
 for(int i=0; i<plen.length; i++)
 {
 System.out.println("hi plen="+plen[i]);
 }
 
 
  
 
 
 
 
 
 
	System.out.println("hi"+buff.getHeight());
	
	

 try
	{
	 encode_text(img, plen,  0);
	 encode_text(img, p,  32);
	 
		encode_text(img, len,  100); //0 first positiong
		encode_text(img, b, 132); //4 bytes of space for length: 4bytes*8bit = 32 bits
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, 
"Target File cannot hold message!", "Error",JOptionPane.ERROR_MESSAGE);
	}
 System.out.println("encrypt");
 
 return(setImage(buff,new File(image_path(fpth,userInput1,"png")),"png"));
     
}
 
 
 
 

















/*
 *Gernerates proper byte format of an integer
 *@param i The integer to convert
 *@return Returns a byte[4] array converting the supplied integer into bytes
 */
private byte[] bit_conversion(int i)
{
	//originally integers (ints) cast into bytes
	//byte byte7 = (byte)((i & 0xFF00000000000000L) >>> 56);
	//byte byte6 = (byte)((i & 0x00FF000000000000L) >>> 48);
	//byte byte5 = (byte)((i & 0x0000FF0000000000L) >>> 40);
	//byte byte4 = (byte)((i & 0x000000FF00000000L) >>> 32);
	System.out.println("i ="+i);
	//only using 4 bytes
	byte byte3 = (byte)((i & 0xFF000000) >>> 24); //0
	byte byte2 = (byte)((i & 0x00FF0000) >>> 16); //0
	byte byte1 = (byte)((i & 0x0000FF00) >>> 8 ); //0
	byte byte0 = (byte)((i & 0x000000FF)	   );
	//{0,0,0,byte0} is equivalent, since all shifts >=8 will be 0
	System.out.println("bit_conversion");
	return(new byte[]{byte3,byte2,byte1,byte0});
}



/*
 *Encode an array of bytes into another array of bytes at a supplied offset
 *@param image	 Array of data representing an image
 *@param addition Array of data to add to the supplied image data array
 *@param offset	  The offset into the image array to add the addition data
 *@return Returns data Array of merged image and addition data
 */
private byte[] encode_text(byte[] ig, byte[] addition, int offset)
{
	//check that the data + offset will fit in the image
	if(addition.length + offset > ig.length)
	{
		throw new IllegalArgumentException("File not long enough!");
	}
	//loop through each addition byte
	for(int i=0; i<addition.length; ++i)
	{
		//loop through the 8 bits of each byte
		int add = addition[i];
		for(int bit=7; bit>=0; --bit, ++offset) //ensure the new offset value carries on through both loops
		{
			//assign an integer to b, shifted by bit spaces AND 1
			//a single bit of the current byte
			int b = (add >>> bit) & 1;
			//assign the bit by taking: [(previous byte value) AND 0xfe] OR bit to add
			//changes the last bit of the byte in the image to be the bit of addition
			ig[offset] = (byte)((ig[offset] & 0xFE) | b );
		}
	}
	System.out.println("encode text");
	return ig;
}









/*
 *Decrypt assumes the image being used is of type .png, extracts the hidden text from an image
 *@param path   The path (folder) containing the image to extract the message from
 *@param name The name of the image to extract the message from
 *@param type integer representing either basic or advanced encoding
 */
public String decode(BufferedImage buff2, String dpassword, int pwdv1)
{
	byte[] decod;
	
	try
	{
		
		
		
		
		
		//user space is necessary for decrypting
		
		BufferedImage buf  = user_space(buff2);

		System.out.println("dpassword"+dpassword);
		
	System.out.println(""+buf.getHeight());
	
		
		raster2 = buf.getRaster();	
		data2   = (DataBufferByte) raster2.getDataBuffer();
		img2  = data2.getData();;
		
		
		
		decod = decode_text(img2,dpassword,pwdv1);
		
		
				
		String trnsfr= new String(decod);;
		
		
		System.out.println(""+decod);
		System.out.println(""+trnsfr);
	
		return( trnsfr);
		
		
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, 
			"There is no hidden message in this image!","Error",
			JOptionPane.ERROR_MESSAGE);
		return "";
	}
}




/*
 *Creates a user space version of a Buffered Image, for editing and saving bytes
 *@param image The image to put into user space, removes compression interferences
 *@return The user space version of the supplied image
 */
private BufferedImage user_space(BufferedImage image)
{
	//create new_img with the attributes of image
	BufferedImage new_img  = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
	Graphics2D	graphics = new_img.createGraphics();
	graphics.drawRenderedImage(image, null);
	//graphics.dispose(); //release all allocated memory for this image
	return new_img;
}









































/*
 *Retrieves hidden text from an image
 *@param image Array of data, representing an image
 *@return Array of data which contains the hidden text
 */
private byte[] decode_text(byte[] img2, String dpassword, int pwdv1)
{
	
	String nu= "wrong password";
	byte[] nresult= ((String)nu).getBytes();
	
	dp= ((String)dpassword).getBytes();
	 //dplen =bit_conversion(dp.length);
	//byte[] img3 = img2;
	
	
	
	
	
	
	
	int plength = 0;
	int poffset  = 32;
	//loop through 32 bytes of data to determine text length
	for(int i=0; i<32; ++i) //i=24 will also work, as only the 4th byte contains real data
	{
		plength = (plength << 1) | (img2[i] & 1);
	}
	
	byte[] presult = new byte[plength];
	
	//loop through each byte of text
	for(int c=0; c<presult.length; ++c )
	{
		//loop through each bit within a byte of text
		for(int i=0; i<8; ++i, ++poffset)
		{
			//assign bit: [(new byte value) << 1] OR [(text byte) AND 1]
			presult[c] = (byte)((presult[c] << 1) | (img2[poffset] & 1));
		}
	}
	
	
	
	 

	 
	    while (pwdv1-- > 0)
	    {
	        int tmp1 = presult[presult.length - 1];
	        for (int i = presult.length - 1; i >0; i--)
	        { presult[i] = presult[i-1];
	        System.out.println("hip="+presult[i]);}
	        presult[0] = (byte) tmp1;
	        
	    }
	
	
		
	
	String passw= new String(presult);;
	
	String passw1 = passw.trim();
	 
	System.out.println("presult"+passw1);
	System.out.println("presultlength"+passw1.length());
	System.out.println(""+dpassword);
	
	if(passw1.equals(dpassword))
	 	{
	 
	int length = 100;
	int offset  = 132;
	//loop through 32 bytes of data to determine text length
	for(int i=100; i<132; ++i) //i=24 will also work, as only the 4th byte contains real data
	{
		length = (length << 1) | (img2[i] & 1);
	}
	
	byte[] result = new byte[length];
	
	//loop through each byte of text
	for(int b=0; b<result.length; ++b )
	{
		//loop through each bit within a byte of text
		for(int i=0; i<8; ++i, ++offset)
		{
			//assign bit: [(new byte value) << 1] OR [(text byte) AND 1]
			result[b] = (byte)((result[b] << 1) | (img2[offset] & 1));
		}
	}
	return result;
}

	
	else{
		
		return nresult;
			}
	
	
	
	
	
}

/*
 *Returns the complete path of a file, in the form: path\name.ext
 *@param path   The path (folder) of the file
 *@param name The name of the file
 *@param ext	  The extension of the file
 *@return A String representing the complete path of a file
 */
String image_path(String path, String name, String ext)
{
	return path + "/" + name + "." + ext;
}












/*
 *Set method to save an image file
 *@param image The image file to save
 *@param file	  File  to save the image to
 *@param ext	  The extension and thus format of the file to be saved
 *@return Returns true if the save is succesful
 */
boolean setImage(BufferedImage buff, File file, String ext)
{
	System.out.println(""+buff.getHeight());
	System.out.println(""+file);
	try
	{
		file.delete(); //delete resources used by the File
		ImageIO.write(buff,ext,file);
		System.out.println("setImage");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, 
			"File could not be saved!","Error",JOptionPane.ERROR_MESSAGE);
		return false;
		
	}
}









	
	
}
	

