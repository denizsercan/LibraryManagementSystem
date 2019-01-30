
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        ArrayList<Library> LibraryMembers = new ArrayList<Library>();         
        User User1 = new User("Esra","1234", "Esra","Cambaz","23.12.2013");
        Admin Admin1 = new Admin("admin","admin");
        LibraryMembers.add(User1);
        LibraryMembers.add(Admin1);

       
        Scanner input = new Scanner(System.in);
        
        int choice;        int ISBNNo;        String Title;        String Author;        String Subject;        boolean Rented;
        String UserID;
        
        while(true)
        {
            System.out.println("\nEnter choice, 0 to exit");
            System.out.println("1- Admin Menu");
            System.out.println("2- User Menu");        
            System.out.println("-1 Exit To Program");
            choice = input.nextInt();

    switch(choice)  {
        

    
        case 1: 
           System.out.print("Admin Id:");
            String Id=input.next();
            
            
            System.out.print("Admin Password:");
            String Pass=input.next();
           
  
           for(Library admins: LibraryMembers)
    {
        if(admins instanceof Admin)
        {
            Admin checkAdmin = (Admin) admins;
            if(checkAdmin.AdminID.equals(Id) && checkAdmin.AdminPassword.equals(Pass))
            {
            
                 while(true)
            {
            System.out.println("\nEnter choice, 0 to exit");
            System.out.println("1- Add Book");
            System.out.println("2- Search Book");        
            System.out.println("3- Load Book");
            System.out.println("4- Statistics Book");
            System.out.println("0- Top Menu");
            choice = input.nextInt();
            
               switch(choice)
                {                    
                    case 1:
                System.out.println("Enter ISBNNo Number");
                ISBNNo  = input.nextInt();
                                            try {
                                            if(!(ISBNNo >= 100000000 && ISBNNo <=999999999 )){
                                               throw new IllegalArgumentException("The ISBNNo  must be 9 characters!");
                                                 }
                                          
                                               }catch(IllegalArgumentException e) {
                                            	System.out.println("Exception thrown:" + e);
                                            	System.out.println("Enter ISBNNo");
                                                ISBNNo = input.nextInt();
                                            }
                String skip= input.nextLine();
                System.out.println("Enter Book Title");
                Title= input.nextLine();
                System.out.println("Enter Book Author");
                Author= input.nextLine();
                System.out.println("Enter Book Subject");
                Subject= input.nextLine();
            
                boolean success = Admin.Add(ISBNNo, Title, Author, Subject);
                if (!success)   {
                    System.out.println("Book with same Book Number already exists");
                }
                else    {
                    System.out.println("Book added successfully");
                }
                break;                
       
                 case 2:
                    System.out.println("Please enter ISBN No");
                    ISBNNo = input.nextInt();
                    Admin.Search(ISBNNo);
                    break;
                                         
                case 3: 
                    System.out.println("Load");   
                    Admin.Load("C:\\Users\\Doğan\\Desktop\\Term\\src\\book.txt");
                    break; 
                     
                case 4: 
                    System.out.println("Statistics");
                    Admin.Statistics();                            
                     break;

                case 0: break;
                    
                default:System.out.println("Choice must be 0-4");
    
                if(choice==0){ break;}  
                                        
                   }
                   
                break;
                 }            }          }            }
           break;
            
             case 2: 
             
            System.out.print("User Id:");
            Id=input.next();
            
            System.out.print("User Password:");
            Pass=input.next();
  
           for(Library users: LibraryMembers)
    {
        if(users instanceof User)
        {
            User checkUser = (User) users;
            if(checkUser.UserID.equals(Id) && checkUser.UserPassword.equals(Pass)){
                
            
                     System.out.println("\nEnter choice, 0 to exit");
                     System.out.println("1- Search Book");
                     System.out.println("2- Borrow Book");        
                     System.out.println("3- Return Book");
                     System.out.println("0- Top Menu");
                     choice = input.nextInt();
                     switch(choice)
                     {
                         case 1 : 
                    System.out.println("Please enter ISBN No");
                    ISBNNo = input.nextInt();
                    User.Search(ISBNNo);
                             break;
    
                         case 2:
                    System.out.println("Please enter Borrow ISBN No");  
                    ISBNNo = input.nextInt();
                    if(User.UserTakeBook==false)
                    {
                    User.Borrow(ISBNNo);
                    User.UserTakeBook=true;
                             break;
                    }
                    else{
                        System.out.println("You Can Not Borrow More Than One Book At A Time ");
                        break;
                    }
                       
    
                        case 3:
                    System.out.println("Please enter Return ISBN No");  
                    ISBNNo = input.nextInt();
                    User.Return(ISBNNo);
                    User.UserTakeBook=false;
                            break;
    
                       default:
                    System.out.println("Choice must be 0-4");
                    if(choice==0){             break;
                 }  
                       case 0:
                    
                    break;
                            
                     }
                      break;  
                      }else{
                System.out.println("Your user id or password wrong!");
                break;
                }
            }
        }
                                      
            default:
                    System.out.println("Choice must be 0-5");
                    }
    
        if(choice==-1){                 break;
                }
        }
    }

   
    }

