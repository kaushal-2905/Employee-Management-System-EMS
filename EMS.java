import java.sql.*;
import java.util.*;

class DBConnection {
    // This class for JDBC connection...
    String driverName = "com.mysql.cj.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/company";
    String dbUSER = "root";
    String dbPASS = "";
    Connection con;
    DBConnection() throws Exception {
        Class.forName(driverName);
        con = DriverManager.getConnection(dbURL, dbUSER, dbPASS);
    }
}
class Stack{
    Stack s[];
    int top=-1,size;
    
    String name;
    int exp;

    public Stack(String name, int exp) {
        this.name = name;
        this.exp = exp;
    }

    public Stack(int size) {
        s=new Stack[size];
        this.size = size;
    }

    void push(Stack x){
        if(top>=size-1){
            System.out.println("Stack Overflow");
        }else {
            top++;
            s[top]=x;
        }
    }
    void pop(){
        if(top==-1){
            System.out.println("Stack Underflow");
        }else {
            top--;
        }
    }
    void display(){
        System.out.println("Experience\tName");
        System.out.println();
        for(int i=top;i>=0;i--){
            System.out.println(s[i].exp+" yr.\t"+s[i].name);
            pop();
        }
    }
}

class SinglyLL {
    String name;
    int id;
    
    public SinglyLL() {
    }

    public SinglyLL(String name, int id) {
        this.name = name;
        this.id = id;
    }

    class Node {
        SinglyLL data;
        Node next;

        Node(SinglyLL d) {
            this.data = d;
            this.next = null;
        }
    }

    Node first = null;

    void insertLast(SinglyLL y) {
        Node n = new Node(y);
        if (first == null) {
            first = n;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    void display() {
        Node temp = first;
        if (first == null) {
            System.out.println("LinkedList is Empty");
        } else {
            System.out.println(IP.Yellow+"---Previous Logins---"+IP.Reset);
            while (temp != null) {
                System.out.println("ID : "+temp.data.id+"\tName : "+temp.data.name);
                temp = temp.next;
            }
            System.out.println();
        }
    }
}

/**
 * IP
 */
public class IP {
    static Scanner sc = new Scanner(System.in);
    static DBConnection dc;
    static PreparedStatement pst;

    static String Blue = "\u001b[34m";
    static String Red = "\u001b[31m";
    static String Yellow = "\u001b[33m";
    static String Reset = "\u001b[0m";
    static String BrightBlue = "\u001b[34;1m";
    static String Green="\u001b[32m";

    public IP() throws Exception{
        dc = new DBConnection();
    }

    public static void main(String[] args) throws Exception{
        IP ip = new IP();
        Admin admin = new Admin();
        Employee employee = new Employee();
        
        System.out.println(BrightBlue+"\tWELCOME TO EMS : company name"+Reset);
        int id;
        String name;
        int ch=1,temp;

        SinglyLL sll = new SinglyLL();
        SinglyLL sllObj;
        Stack s = new Stack(1000);
        Stack obj;
        
        do {
            for(;;){
                System.out.println(Yellow+"\tLogin your Account"+Reset);
                System.out.print(Blue+"Enter your ID :- "+Reset);
                id =sc.nextInt();
                sc.nextLine();
                System.out.print(Blue+"Enter your Name :- "+Reset);
                name =sc.nextLine();
                if (admin.checkAdminIdentity(id, name)) {
                    temp=1;
                    sllObj = new SinglyLL(name, id);
                    sll.insertLast(sllObj);
                    break;
                }else if (employee.checkEmployeeIdentity(id, name)) {
                    temp=2;
                    sllObj = new SinglyLL(name, id);
                    sll.insertLast(sllObj);
                    break;
                }else{
                    System.out.println(Red+"Incorrect Details, try Again !!"+Reset);
                }
            }
            
            if (temp==1) {
                do {
                    System.out.println();
                    System.out.println(IP.Blue+"1 for add employee");   
                    System.out.println("2 for remove employee");
                    System.out.println("3 for show all employee");
                    System.out.println("4 for remove Resignation application Employees");
                    System.out.println("5 for show Resigned Employees");
                    System.out.println("6 for sort list by employee ");
                    System.out.println("7 for show Previous Logins");
                    System.out.println("8 Logout Profile"+IP.Reset);
                    System.out.println(IP.Red+"0 for close System"+IP.Reset);
                    System.out.print("Enter choice :- ");
                    ch = sc.nextInt();
                    sc.nextLine();
                    switch (ch) {
                        case 1:
                            admin.addEmployee();
                            break;
                        case 2:
                            admin.removeEmployee();
                            break;
                        case 3:
                            admin.showEmployeeList();
                            break;
                        case 4:
                            admin.ResignationEmployeeList();
                            break;
                        case 5: 
                            admin.showResingedEmployee();
                            break;
                        case 6: 
                            admin.sortByExp();
                            break;  
                        case 7:
                            sll.display();
                            break;
                        case 8:
                            System.out.println(IP.BrightBlue+"Profile Loged out !"+IP.Reset);
                            break;
                        default:
                            if (ch!=0) {
                                System.out.println("Enter valid choice !!");
                            }
                            break;
                    }
                } while ((ch!=8)&&(ch!=0));
            }
            if (temp==2) {
                do {
                    System.out.println();
                    System.out.println(IP.Yellow+"\tEmployee:"+name+IP.Reset);
                    System.out.println(IP.Blue+"1 for show profile.");
                    System.out.println("2 for show your Project Team List");
                    System.out.println("3 for Resignation Application.");
                    System.out.println("4 for show Previous Logins");
                    System.out.println("5 for Logout Profile"+IP.Reset);
                    System.out.println(IP.Red+"0 for close system"+IP.Reset);
                    System.out.print("Enter choice :- ");
                    ch = sc.nextInt();
                    sc.nextLine();
                    switch (ch) {
                        case 1:
                            employee.showProfile(id);
                            break;
                        case 2:
                            employee.OtherEmployeeInProject(id);
                            break;
                        case 3:
                            employee.updateResignation(id);
                            break;
                        case 4:
                            sll.display();
                            break;
                        case 5:
                            System.out.println(IP.BrightBlue+"Profile Loged out !"+IP.Reset);
                            break;
                        default:
                            if (ch!=0) {
                                System.out.println(IP.Red+"Enter vald choice !!"+IP.Reset);
                            }
                            break;
                    }
        
                } while ((ch!=5)&&(ch!=0));
            }
        } while (ch!=0);
    }
}
class Admin{
    static Scanner sc = new Scanner(System.in);
    static DBConnection dc;
    static PreparedStatement pst;

    public Admin() throws Exception{
        dc = new DBConnection();
    }

    boolean checkAdminIdentity(int id,String name) throws Exception{
        String sql = "select * from admin";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int temp = 0;
        while (rs.next()) {
            if ((rs.getInt(1)==id)&&(rs.getString(2).equalsIgnoreCase(name))) {
                temp = 1;
                System.out.println(IP.Green+"Welcome Back "+name+" !"+IP.Reset);
            }
        }
        if (temp==1) {
            return true;
        }else{
            return false;
        }
    }

    String checkMail(){
        String email;
		int email_temp;
        Scanner sc = new Scanner(System.in);
        do{
            email_temp=1;
            System.out.print("Email :- ");
            email=sc.nextLine();
            for(int i=0;i<email.length();i++){
                if((email.charAt(i)>='a'&&email.charAt(i)<='z')||(email.charAt(i)>='0'&&email.charAt(i)<='9')||email.charAt(i)=='@'){
                    if(email.charAt(i)=='@'){
                        email_temp=2;
                        break;
                    }
                }else{
                    System.out.println(IP.Red+"Enter email in proper format !!"+IP.Reset);
                    email_temp=0;
                    break;
                }
            }
            if(email_temp==1)
                System.out.println(IP.Red+"Enter your email in proper format !!"+IP.Reset);
            if(email_temp==2){
                String email1[]=email.split("@");
                if((email1.length!=2)){
                    System.out.println(IP.Red+"Enter your email in proper format !!"+IP.Reset);
                }else if(email1[1].equals("gmail.com")){
                    email_temp=3;
                }else{
                    System.out.println(IP.Red+"Enter proper domain of email !!"+IP.Reset);
                }
            }
        }while(email_temp!=3);
        return email;
    }

    void showResingedEmployee() throws Exception{
        System.out.println();
        System.out.println(IP.Yellow+"\tResigned Employee List"+IP.Reset);
        System.out.println();
        String sql = "select * from resigned_employee";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            System.out.println();
            System.out.print("ID:-"+rs.getInt(1));
            System.out.print("\tName:-"+rs.getString(2));
            System.out.println("\tExperience:-"+rs.getInt(4)+" yr.");
            System.out.print("E-mail ID:-"+rs.getString(3));
            System.out.println("\tRole:-"+rs.getString(5)+" devloper");
        }
    }

    void addToResingedEmployee(int id) throws Exception{
        String name=null,mail=null,role=null;
        int exp=0;

        String sql = "select * from employee where id='"+id+"' ";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            name = rs.getString(2);
            exp = rs.getInt(4);
            mail = rs.getString(6);
            role = rs.getString(7);   
        }
        String sql1 = "{call add_resign_emp(? , ?, ?, ?, ?)}";
        CallableStatement cst=dc.con.prepareCall(sql1);
        cst.setInt(1,id);
        cst.setString(2,name);
        cst.setString(3,mail);
        cst.setInt(4, exp);
        cst.setString(5,role);
        cst.execute();
    }

    void addEmployee() throws Exception{
        System.out.println(IP.Yellow+"\tEnter Employee Details"+IP.Reset);
        System.out.println();
        System.out.print("Enter employee name :- ");
        String name = sc.nextLine();
        System.out.print("Enter project name :- ");
        String p_name = sc.nextLine();
        System.out.print("Enter Experience :- ");
        int exp = sc.nextInt();
        sc.nextLine();
        String mail = checkMail();
        System.out.print("Enter devloper role :- ");
        String role  =sc.nextLine();

        String sql = "INSERT INTO `employee`(`name`, `project`, `experience`,resignation, `e-mail`, `developer_type`) VALUES ('"+name+"','"+p_name+"','"+exp+"',0,'"+mail+"','"+role+"')";
        pst = dc.con.prepareStatement(sql);
        int r = pst.executeUpdate();
        if (r>0) {
            System.out.println(IP.Green+"added successfully !!"+IP.Reset);
        }else{
            System.out.println(IP.Red+"not added !!"+IP.Reset);
        }
    }

    void removeEmployee() throws Exception{
        System.out.println();
        System.out.print("Enter employee id to remove :- ");
        int id = sc.nextInt();
        sc.nextLine();

        addToResingedEmployee(id);

        String sql = "DELETE FROM `employee` WHERE id='"+id+"' ";
        pst = dc.con.prepareStatement(sql);
        int r = pst.executeUpdate();
        if (r>0) {
            System.out.println(IP.Blue+"employee removed !!"+IP.Reset);
        }else{
            System.out.println(IP.Red+"employee id not found !!"+IP.Reset);
        }
    }

    void showEmployeeList() throws Exception{
        System.out.println();
        String sql = "select * from employee";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            System.out.println();
            System.out.print("ID:-"+rs.getInt(1));
            System.out.print("\tName:-"+rs.getString(2));
            System.out.print("\tCurrent Project:-"+rs.getString(3));
            System.out.println("\tExperience:-"+rs.getInt(4)+" yr.");
            System.out.print("E-mail ID:-"+rs.getString(6));
            System.out.println("\tRole:-"+rs.getString(7)+" devloper");
        }
    }

    void ResignationEmployeeList() throws Exception{
        System.out.println();
        String sql = "select * from employee where resignation=1";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        System.out.println(IP.Yellow+"\t\tResignation Employee List"+IP.Reset);
        
        while (rs.next()) {
            System.out.println();
            System.out.print("ID:-"+rs.getInt(1));
            System.out.print("\tName:-"+rs.getString(2));
            System.out.print("\tCurrent Project:-"+rs.getString(3));
            System.out.println("\tExperience:-"+rs.getInt(4)+" yr.");
            System.out.print("E-mail ID:-"+rs.getString(6));
            System.out.println("\tRole:-"+rs.getString(7)+" devloper");
        }
        System.out.println();
        System.out.println("To approve application ,");
        System.out.print("Enter that Employee ID :- ");
        int id = sc.nextInt();

        addToResingedEmployee(id);

        String sql1 = "DELETE FROM `employee` WHERE id='"+id+"' ";
        pst = dc.con.prepareStatement(sql1);
        int r = pst.executeUpdate();
        if (r>0) {
            System.out.println(IP.Blue+"employee removed !!"+IP.Reset);
        }else{
            System.out.println(IP.Red+"employee id not found !!"+IP.Reset);
        }
    }

    void sortByExp() throws Exception{
        String sql = "SELECT name,experience FROM `employee` ORDER BY `experience` DESC";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Stack obj;
        Stack s = new Stack(100);
        while (rs.next()) {
            obj = new Stack(rs.getString(1), rs.getInt(2));
            s.push(obj);
        }
        s.display();
    }
}
class Employee{
    static Scanner sc = new Scanner(System.in);
    static DBConnection dc;
    static PreparedStatement pst;

    public Employee() throws Exception{
        dc = new DBConnection();
    }

    boolean checkEmployeeIdentity(int id,String name) throws Exception{
        String sql = "select * from employee";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int temp = 0;
        while (rs.next()) {
            if ((rs.getInt(1)==id)&&(rs.getString(2).equalsIgnoreCase(name))) {
                temp = 1;
                System.out.println(IP.Green+"Welcome Back "+name+" !"+IP.Reset);
            }
        }
        if (temp==1) {
            return true;
        }else{
            return false;
        }
    }

    boolean checkEmployeeID(int id) throws Exception{
        String sql = "select * from employee";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int temp = 0;
        while (rs.next()) {
            if ((rs.getInt(1)==id)) {
                temp = 1;
            }
        }
        if (temp==1) {
            return true;
        }else{
            return false;
        }
    }

    void showProfile(int id) throws Exception{
            System.out.println();
            System.out.println(IP.Yellow+"\t---Your Profile---"+IP.Reset);
            String sql = "select * from employee where id='"+id+"' ";
            ResultSet rs = pst.executeQuery(sql);
            rs.next();
            System.out.println("ID\t\t:-\t"+IP.Blue+rs.getInt(1)+IP.Reset);
            System.out.println("Name\t\t:-\t"+IP.Blue+rs.getString(2)+IP.Reset);
            System.out.println("E-mail ID\t:-\t"+IP.Blue+rs.getString(6)+IP.Reset);
            System.out.println("Role\t\t:-\t"+IP.Blue+rs.getString(7)+" devloper"+IP.Reset);
            System.out.println("Current Project\t:-\t"+IP.Blue+rs.getString(3)+IP.Reset);
    }

    void OtherEmployeeInProject(int id) throws Exception{
            String sql = "select project from employee where id='"+id+"' ";
            ResultSet rs = pst.executeQuery(sql);
            rs.next();
            String project_name = rs.getString(1);

            System.out.println();
            System.out.println(IP.Yellow+"---Employees of Project : "+project_name+"---"+IP.Reset);
            
            String sql1 = "select * from employee where project='"+project_name+"' ";
            ResultSet rs1 = pst.executeQuery(sql1);
            while (rs1.next()) {
                System.out.println("ID :- "+IP.Blue+rs1.getInt(1)+IP.Reset);
                System.out.println("Name :- "+IP.Blue+rs1.getString(2)+IP.Reset);
                System.out.println("E-mail ID :- "+IP.Blue+rs1.getString(6)+IP.Reset);
                System.out.println("Role :- "+IP.Blue+rs1.getString(7)+" devloper"+IP.Reset);
            }
    }

    void updateResignation(int id) throws Exception{
        System.out.println();
        System.out.println(IP.Yellow+"---Resignation Profile Details---"+IP.Reset);
        String sql = "select * from employee where id='"+id+"' ";
        ResultSet rs = pst.executeQuery(sql);
        rs.next();
        System.out.println("ID:-\t"+IP.Blue+rs.getInt(1)+IP.Reset);
        System.out.println("Name:-\t"+IP.Blue+rs.getString(2)+IP.Reset);
        System.out.println("E-mail ID:-\t"+IP.Blue+rs.getString(6)+IP.Reset);
        System.out.println("Role :-\t"+IP.Blue+rs.getString(7)+" devloper"+IP.Reset);

        dc.con.setAutoCommit(false);
        String sql1 = "update employee set resignation=1 where id='"+id+"'";
        int r = pst.executeUpdate(sql1);
        System.out.println();

        System.out.println(IP.Red+"Confirm, Do you want apply for Resignation !!"+IP.Reset);
        System.out.println("press 1 for confirm\tPress Any number for cancel");
        System.out.print("Enter confirmation :- ");
        int ch = sc.nextInt();
        if (ch==1) {
            dc.con.commit();
            if (r>0) {
                System.out.println("Application successfull !!");
            }else{
                System.out.println("Application failed !!");
            }
        } else {
            dc.con.rollback();
            System.out.println("Application canceled !!");
        }
    }
}