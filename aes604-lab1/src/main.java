
public class main {

	public static void main(String[] args) {
		Window w1 = new Window ( "F i r s t" ) ;
		Window w2 = new Window ( "S e c o n d" , 10 , 10 , 300 , 200 ) ;
		w2.show() ; // p r i n t s the s t a t e s of w2
		w1.restore();
		w1.show() ;
		w2.maximize();
		w2.setPosition(50,50) ;
		w2.setSize(100,100) ;
		w2.show();
		w2.restore();
		w2.show();
		w1.setPosition(100,10);
		w1.moveBy(5,-5);
		w1.show();
		
	}
	
}
