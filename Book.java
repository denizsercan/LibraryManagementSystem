public class Book extends Library {
  protected int ISBNNo;
  protected String Title;
  protected String Author;
  protected String Subject;
  protected boolean Rented;
  protected String UserID;

    public Book(int ISBNNo, String Title, String Author, String Subject) {
        this.ISBNNo = ISBNNo;
        this.Title = Title;
        this.Author = Author;
        this.Subject = Subject;
    }

    public Book(int ISBNNo) {
        this.ISBNNo = ISBNNo;
    }

    @Override
    public String toString() {
        return "Book{" + "ISBNNo=" + ISBNNo + ", Title=" + Title + ", Author=" + Author + ", Subject=" + Subject + ", Rented=" + Rented + ", UserID=" + UserID + '}';
    }
  
  
  
    
}
