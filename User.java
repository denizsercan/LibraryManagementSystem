
import java.util.ArrayList;

public class User extends Library {
   protected String UserID;
   protected String UserPassword;
   protected String UserName;
   protected String UserSurname;
   protected String UserRegisterTime;
   protected static boolean UserTakeBook;

    public User(String UserID, String UserPassword, String UserName, String UserSurname, String UserRegisterTime) {
        this.UserID = UserID;
        this.UserPassword = UserPassword;
        this.UserName = UserName;
        this.UserSurname = UserSurname;
        this.UserRegisterTime = UserRegisterTime;
        UserTakeBook=false;
        
    }

           public static void Search(int ISBNNo) {
             
        for(Book book:Admin.Books) {
            if(book.ISBNNo==ISBNNo){
                System.out.println(book.toString());
            } 
            else { System.out.println("Book Not Found!");
            
            }
        }  
    }
       
       

  
    public static boolean Borrow(int ISBNNo) {
                     
        for(Book book:Admin.Books) {
            if(book.ISBNNo==ISBNNo){
                System.out.println(book.toString());
                if(book.Rented==false)
                {
                    System.out.println("You rented Book.");
                    book.Rented=true;
                    return true;
                }
                else { 
                    System.out.println("Book is rented in another User.");
                    return false;}
            } 
            else { System.out.println("Book Not Found!");
            return false;
            
            }
            
        }
        return false;
    }

    
    public static void Return(int ISBNNo) {
         for(int i =0; i<Admin.Books.size(); i++)
        {
            Book book1 = Admin.Books.get(i);
            if(book1.ISBNNo==ISBNNo)
            {
                book1.Rented=false;
            }
        }
        System.out.println("Thank you for return to book!");
    }

    @Override
    public String toString() {
        return "User{" + "UserID=" + UserID + ", UserPassword=" + UserPassword + ", UserName=" + UserName + ", UserSurname=" + UserSurname + ", UserRegisterTime=" + UserRegisterTime + ", UserTakeBook=" + UserTakeBook + '}';
    }
    
    
    
 
        
      
    }


   
    
    
   

