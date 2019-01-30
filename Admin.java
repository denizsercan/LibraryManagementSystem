
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends Library {
   protected String AdminID;
   protected String AdminPassword;

    public Admin(String AdminID, String AdminPassword) {
        this.AdminID = AdminID;
        this.AdminPassword = AdminPassword;
    }

 protected static ArrayList<Book> Books = new ArrayList<Book>();
   
    
    public static boolean Add(int ISBNNo, String Title, String Author, String Subject){
    for(Book book:Books)
    {
        if(book.ISBNNo==ISBNNo)
        {
            return false;
        }
      
    }
    Book book1 = new Book(ISBNNo);
    book1.Title=Title;
    book1.Author=Author;
    book1.Subject=Subject;
    Books.add(book1);
    return true ;
}  
    

    
    public static void Search(int ISBNNo) {
        
       
        for(Book book:Books) {
            if(book.ISBNNo==ISBNNo){
                System.out.println(book.toString());
            } 
            else { System.out.println("Book Not Found!");
            
            }
        }        
    }


      public static void Load(String path ) 
{
       Scanner input = null;
       try {
           input = new Scanner(new File(path));
           while (input.hasNext()) {
               System.out.println(input.next());
           }
       } // end method quotient
       catch (FileNotFoundException ex) {
           System.out.printf("File not found : %s" , path);
       }
       finally {
           if (input != null) {               
               input.close();
            }
       }
   }
    
    

    
    public static void Statistics() {
        for(Book book:Books)
    {
        if(book.Rented==true)
        {
            System.out.println(book.Title + " is rented by " +book.UserID);
        }
        
    }
    }

    @Override
    public String toString() {
        return "Admin{" + "AdminID=" + AdminID + ", AdminPassword=" + AdminPassword + '}';
    }


 
    
    
    
}



