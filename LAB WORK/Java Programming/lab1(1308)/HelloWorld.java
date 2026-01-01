public class HelloWorld
 {
int id= 590020652;
String name="Aakash";
    void display()
{
	System.out.println("my name is:"+name +"my sapid is"+id);
	System.out.println(id);
	
}	
    
    public static void main(String[] args) {
        System.out.println("Welcome to lab-01");
	HelloWorld h1= new HelloWorld();
	h1.display();
    }
}