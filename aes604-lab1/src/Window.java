import java.util.*;
/**
 * 
 * @author Ariel Guerrero
 * Description: Creates a Window with a state of minimized and the user is able to pass in or set the parameters of its
 * 				title,left offset, top offset, width and height.
 *
 */
public class Window {
	
	private int s_Width =0,s_Height=0,s_Left=0,s_Top=0,Width=0,Height=0,Left=0,Top=0;
	private String Name,windowState;
	private static int count= 0;
	
	Window(){
		this.Height =0;
		this.Width =0;
		this.Left=0;
		this.Top=0;
		this.Name ="UNNAMED";
		this.windowState = "Minimized";
		count++;
	}

	Window(String name){
		this.Height =0;
		this.Width =0;
		this.Left=0;
		this.Top=0;
		this.windowState = "Minimized";
		this.Name =name;
		count++;
	}
	
	Window(String name,int left, int Top, int width,int height){
		this.Name = name;
		this.Left = left;
		this.Top = Top;
		this.Height = height;
		this.Width = width;
		this.windowState = "Minimized";
		saveData(this.Left,this.Top,this.Height,this.Width);
		count++;
	}
	
	private void setState(String state) {
		this.windowState = state;
		
	}

	private void saveData(int left,int top,int height,int width) {
		this.s_Height=height;
		this.s_Width=width;
		this.s_Left=left;
		this.s_Top =top;

	}
	
	private void saveDataSize(int height, int width) {
		this.s_Height=height;
		this.s_Width=width;
	}
	
	private void saveDataPosition(int left,int top)
	{
		this.s_Left=left;
		this.s_Top =top;
	}
	/**
	 * Name: showCount()
	 * Description: Practice using static variables within a class. figured it wouldn't hurt since it was a topic covered
	 * 				during this weeks class. It just shows how many windows are created.
	 */
	public void showCount(){
		System.out.println("Window count: "+ count);
	}
	
	/**
	 * Name: minimize()
	 * Description: Sets the window variables all to 0 to simulate that the window is "minimized" and is not shown on the
	 * 				screen.
	 * 
	 */
	public void minimize(){
		this.Height =0;
		this.Width =0;
		this.Left=0;
		this.Top=0;
		setState("Minimized");
	}

	 /**
	  * Name: maximize()
	  * Parameters: N/A
	  * Description: Sets the window to the max width and height and sets the top and left variables to 0 and 0 
	  * 			 respectively to simulate the top left corner of the screen.
	  * 	 
	  */
	public void maximize() {
		this.Top = 0;
		this.Left = 0;
		this.Height= 600;
		this.Width = 800;
		setState("Maximized");
	}
	
	 /**
	  * Name: restored()
	  * Parameters: N/A
	  * Description: Sets the Windows height, length, left, and top variables back to its saved state to revert 
	  * 			 from being minimized or maximized.
	  */
	public void restore() {
		
		this.Height = this.s_Height;
		this.Width = this.s_Width;
		this.Top =this.s_Top;
		this.Left = this.s_Left;
	
		setState("Restored");
	}
	
	/**
	 * Name: show()
	 * Parameters: N/a
	 * Description: Prints the status of the window including the name,state,left variable, top 
	 * 				variable, width, and height which to me seems like a toString() kinda.
	 */
	public void show() {
		// print the state of the window
		if(this.windowState.equals("Minimized")){
			System.out.println(this.Name + " is "+ this.windowState + ".");
		}
		else {
		System.out.println(this.Name + " is "+ this.windowState + ". [ l= " + this.Left	+ " , t = "+ this.Top +" , w = " 
		+ this.Width + " , h = " + this.Height  + " ]");
		}
	 }
	
	/**
	 * Name: setPosition()
	 * @param left
	 * @param top
	 * Description: sets the position offset from the left and top of the screen
	 */
	public void setPosition(int left, int top) {
		// set left and top
		Scanner scan = new Scanner(System.in);
		while (left <0 || top <0) {
			if(left <0){
				System.out.println("ERROR: LEFT CAN NOT BE NEGATIVE PLEASE RE ENTER YOUR LEFT VARIABLE!");
				System.out.print("LEFT VARIABLE >> ");
				left = scan.nextInt();
				continue;
			}
			else if(top <0) {
				System.out.println("ERROR: TOP CAN NOT BE NEGATIVE PLEASE RE ENTER YOUR TOP VARIABLE!");
				System.out.print("TOP VARIABLE >> ");
				top = scan.nextInt();
				continue;
			}	
		}
		switch(this.windowState) {
		case "Restored": 
			this.Left = left;
			this.Top = top;
		break;
		default:
			break;
		}	
		saveDataPosition(left,top);
	}
	
	/**
	 * Name: setSize()
	 * @param height
	 * @param width
	 * Description: sets the size of the window  by setting the values of its width and height  
	 */
	public void setSize(int height, int width) {
		// set height and width		
		Scanner scan = new Scanner(System.in);
		while (height <0 || width <0) {
			if(height <0){
				System.out.println("ERROR: HEIGHT CAN NOT BE NEGATIVE PLEASE RE ENTER YOUR HEIGHT VARIABLE!");
				System.out.print("HEIGHT VARIABLE >> ");
				height = scan.nextInt();
				continue;
			}
			else if(width <0) {
				System.out.println("ERROR: WIDTH CAN NOT BE NEGATIVE PLEASE RE ENTER YOUR WIDTH VARIABLE!");
				System.out.print("WIDTH VARIABLE >> ");
				width = scan.nextInt();
				continue;
			}	
		}
			switch(this.windowState) {
			case "Restored": 
				this.Height = height;
				this.Width = width;
				break;
			default:
				break;
			}	
			saveDataSize(height,width);
	}
	
	/**
	 * Name: moveBy() 
	 * @param addLeft
	 * @param addTop
	 * Description: changes the left and top offset by adding the passed values to the current left and top values
	 */
	public void moveBy(int addLeft,int addTop) {
	// moves the position of the window by modifying top and left
		Scanner scan = new Scanner(System.in);
		while ((this.Left+addLeft) <0 || (this.Top+addTop) <0) {
			if((this.Left+addLeft) <0){
				System.out.println("ERROR: LEFT CAN NOT BE NEGATIVE PLEASE RE ENTER YOUR LEFT VARIABLE!");
				System.out.print("LEFT VARIABLE >> ");
				addLeft = scan.nextInt();
				continue;
			}
			else if(this.Top+addTop <0) {
				System.out.println("ERROR: TOP CAN NOT BE NEGATIVE PLEASE RE ENTER YOUR TOP VARIABLE!");
				System.out.print("TOP VARIABLE >> ");
				addTop = scan.nextInt();
				continue;
			}	
		}
		switch(this.windowState) {
		case "Restored": 
			this.Left+=addLeft;
			this.Top+=addTop;
			break;
		default:
			break;
		}		
		saveDataPosition(this.Left+addLeft,this.Top+addTop);
		}
	}