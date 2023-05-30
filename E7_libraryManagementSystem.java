package TUTORIALS.EXERCISES;
import java.util.ArrayList;
import java.util.Scanner;


class Book{
    String bookName;
    String bookAuthor;
    String issuedTo;
    String issuedOn;

    public Book(){}
    public Book(String n, String a){
        this.bookName = n;
        this.bookAuthor = a;
    }
}

class Student{
    String studentName;
    int studentClass;
    String bookIssued;
    
    public Student(){}
    public Student(String n, int c){
        this.studentName = n;
        this.studentClass = c;
    }

    // Student class methods
    public void addBook(){
        System.out.println("Book has been added to the library.");
    }
    public void issueBook(String bookName){
        System.out.println(bookName + " has been issued and added to " + this.studentName + "'s database. Book to be returned next week");
    }
    public void returnBook(String bookName){
        System.out.println("Book " + bookName +  " has been returned. Hope you had a good read!");
    }
}

public class E7_libraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        Methodology:
        A(one) library consists of various(multiple) books and all(multiple) students are registered to the library. 
        
        A student visits the library to issue a book. In this transaction, a book alongwith its issuing date is added to that student's database including a returning date and a book is deducted from the library's database, both happening temporarily. 
        When it is time for the student to return the book, the book is deducted from student's database and added back to the library's database. 
        A student can also add a book to the library, which will add that book to the library's database. That book will be issuable to anyone.

        Programming:
            Classes for 
            1)Book 
            2)Student
            
            Array of objects 
            1)to store books, ask input from user(as library manager) for number of books and details for each book.
            2)to store students, ask input from user(as library manager) for number of students and details for each student.

            Student class methods implementation:
            1)addBook()- new book added in array of objects of books
            2)issueBook()- book deducted from books array of objects and added to that particular student's database(bookIssued and returnDate) temporarily
            3)returnBook()- book added back to books array of objects and student database(bookIssued and returnDate) emptied.

        Book variables:-
            1)name
            2)author
            3)issuedTo
            4)issuedOn
        
        Student variables:-
            1)name
            2)class
            3)bookIssued
            4)returnDate
        
        Student methods:-
            1)addBook
            2)issueBook
            3)returnBook
         */


        // In case of log in as admin
        // Making array list for books

        System.out.println("Login as: \n 1)Admin \n 2)Student");
        int login = sc.nextInt();
        
        // Creating basic arraylists for books and students.
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();


        // Logging in as Admin
        if (login == 1) {
            // Accepting user input for number of books
            System.out.print("(Admin)Enter number of books available in library:  ");
            int noOfBooks = sc.nextInt();
            
            // For loop for accepting book inputs
            for (int i = 0; i < noOfBooks; i++) {
                Book b = new Book();
                System.out.print("(Admin)Enter book name:  ");
                b.bookName = sc.next();
                sc.nextLine();
                System.out.print("(Admin)Enter book author:  ");
                b.bookAuthor = sc.next();
                sc.nextLine();
                books.add(b);
            }
            
            // Making array list for students
            
            // Accepting user input for number of students
            System.out.print("(Admin)Enter number of students in institution:  ");
            int noOfStudents = sc.nextInt();
            
            // For loop for accepting student inputs
            for (int i = 0; i < noOfStudents; i++) {
                Student s = new Student();
                System.out.print("(Admin)Enter student name:  ");
                s.studentName = sc.next();
                sc.nextLine();
                System.out.print("(Admin)Enter student class:  ");
                s.studentClass = sc.nextInt();
                students.add(s);
            }
            System.out.print("Thank you for your inputs. Your work is over, you will automatically be logged out!");
            System.out.print("System closed!");
        }

        // Logging in as Student
        else if(login == 2){
            System.out.println("(student)What do you want to do? \n 1) Add a book to the library \n 2)Issue a book from the library \n 3)Return an issued book");
            int methodInput = sc.nextInt();
            
            // 1)If student wants to add book
            if (methodInput == 1) {
                System.out.print("(Student) Enter your name:  ");
                String sn = sc.next();
                sc.nextLine();
                for (Student student : students) {
                    if (student.studentName == sn) {
                        System.out.print("(Student)Enter book name: ");
                        String bn = sc.next();
                        sc.nextLine();
                        System.out.print("(Student)Enter book author: ");
                        String ba = sc.next();
                        sc.nextLine();
                        Book b = new Book(bn, ba);
                        books.add(b);
                        student.addBook();
                    }else{
                        System.out.print("(Student) Sorry, you have not been registered with us!");
                    }
                    System.out.println("Do you want to log out(Y/N)?");
                    String logout = sc.next();
                    sc.nextLine();
                    if (logout == "Y"){
                        System.out.println("System closed!");
                        break;
                    }
                }
            }
    
            // 2)If student wants to issue book
            else if (methodInput == 2){
                System.out.print("(Student) Enter your name:  ");
                String sn = sc.next();
                sc.nextLine();
                for (Student student : students) {
                    if (student.studentName == sn) {
                        System.out.print("(Student)Enter book name: ");
                        String bn = sc.next();
                        for (Book book : books) {
                            if (book.bookName == bn) {
                                student.issueBook(bn);
                                student.bookIssued = bn;
                                System.out.print("(Student)Book named" + bn + "issued by " + student);
                                books.remove(book);
                            }
                        }
                    }else{
                        System.out.print("(Student) Sorry, you have not been registered with us!");
                    }
                    System.out.println("Do you want to log out(Y/N)?");
                    String logout = sc.next();
                    sc.nextLine();
                    if (logout == "Y"){
                        System.out.println("System closed!");
                        break;
                    }
                }
            }
            
            // 3)If student wants to return an issued book
            else if (methodInput == 3){
                System.out.print("(Student) Enter your name:  ");
                String sn = sc.next();
                sc.nextLine();
                for (Student student : students) {
                    if (student.studentName == sn) {
                        System.out.print("(Student)Enter book name: ");
                        String bn = sc.next();
                        System.out.print("(Student)Enter book author: ");
                        String ba = sc.next();
                        student.returnBook(bn);
                        Book b = new Book(bn, ba);
                        books.add(b);
                    }else{
                        System.out.print("(Student) Sorry, you have not been registered with us!");
                    }
                    System.out.println("Do you want to log out(Y/N)?");
                    String logout = sc.next();
                    sc.nextLine();
                    if (logout == "Y"){
                        System.out.println("System closed!");
                        break;
                    }
                }
            }
        }        
        sc.close();
    }
}
