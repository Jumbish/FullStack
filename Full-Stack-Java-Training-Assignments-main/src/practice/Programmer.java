package practice;

class Writer 
{ 
    public  static void write() 
    { 
        System.out.println("Writing..."); 
    } 
} 
class Author extends Writer 
{ 
//    public  static void write() 
//    { 
//        System.out.println("Writing book"); 
//    } 
} 
  
public class Programmer extends Author 
{ 
    public  static void write() 
    { 
        System.out.println("Writing code"); 
    } 
  
    public static void main(String[] args) 
    { 
    	
    	float f1[ ], f2[ ]; 
        f1 = new float[10]; 
        f2 = f1; 
        System.out.println("f2[0] = " + f2[0]); 
//    	 int x = 11 & 9;
//         int y = x ^ 3;
//         System.out.println( y | 12 );
    } 
} 
