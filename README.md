# Employee Management System (EMS)

A Java-based Employee Management System with database integration for managing employee records, resignations, and administrative tasks.

## Features

### Admin Features
- **Employee Management**
  - Add new employees with complete profile details
  - Remove employees from the system
  - View all employees with their details
  - Sort employees by experience

- **Resignation Management**
  - View resignation applications
  - Approve/process resignation requests
  - Maintain resigned employee records

- **Login History**
  - Track previous login sessions
  - View login history with user IDs and names

### Employee Features
- **Profile Management**
  - View personal profile information
  - Access project details

- **Team Collaboration**
  - View project team members
  - Access team member contact information

- **Resignation Application**
  - Submit resignation requests
  - Confirmation system with rollback capability

## Technology Stack

- **Language:** Java
- **Database:** MySQL
- **JDBC Driver:** MySQL Connector/J (com.mysql.cj.jdbc.Driver)
- **Data Structures:** Stack, Singly Linked List

## Database Configuration

The system connects to a MySQL database with the following default configuration:

```java
Database URL: jdbc:mysql://localhost:3306/company
Username: root
Password: (empty)
```

### Required Database Tables

1. **admin** - Stores administrator credentials
2. **employee** - Stores employee information including:
   - ID, Name, Project, Experience, Resignation status, Email, Developer type
3. **resigned_employee** - Archives resigned employee records

### Required Stored Procedure
- `add_resign_emp` - Handles employee resignation data transfer

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- MySQL Connector/J JDBC Driver
- Database schema with required tables and stored procedures

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/employee-management-system.git
cd employee-management-system
```

2. Set up MySQL database:
   - Create a database named `company`
   - Create required tables (`admin`, `employee`, `resigned_employee`)
   - Create the `add_resign_emp` stored procedure

3. Update database credentials in `IP.java` if needed:
```java
String dbURL = "jdbc:mysql://localhost:3306/company";
String dbUSER = "your_username";
String dbPASS = "your_password";
```

4. Add MySQL JDBC driver to your classpath

5. Compile the project:
```bash
javac IP.java
```

6. Run the application:
```bash
java IP
```

## Usage

### Login System
The system supports two types of users:
1. **Admin** - Full system access with management capabilities
2. **Employee** - Limited access to personal and team information

Enter your ID and Name when prompted to log in.

### Admin Menu Options
```
1. Add employee
2. Remove employee
3. Show all employees
4. Remove resignation application employees
5. Show resigned employees
6. Sort list by employee experience
7. Show previous logins
8. Logout profile
0. Close system
```

### Employee Menu Options
```
1. Show profile
2. Show your project team list
3. Resignation application
4. Show previous logins
5. Logout profile
0. Close system
```

## Email Validation

The system includes email validation that enforces:
- Valid email format with alphanumeric characters
- Proper @ symbol placement
- Gmail domain requirement (@gmail.com)

## Data Structures Used

- **Stack**: Used for sorting and displaying employees by experience
- **Singly Linked List**: Used for tracking login history

## Color-Coded Console Output

The application uses ANSI color codes for better user experience:
- **Blue**: General information and prompts
- **Red**: Errors and critical confirmations
- **Yellow**: Section headers
- **Green**: Success messages
- **Bright Blue**: System messages

## Transaction Management

The resignation application feature uses database transactions with:
- Manual commit/rollback control
- User confirmation before finalizing changes
- Rollback capability for canceled operations

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

[Your Name]

## Acknowledgments

- Built as part of a database management and Java programming project
- Demonstrates JDBC connectivity and SQL operations
- Implements core data structures in Java

## Support

For issues, questions, or contributions, please open an issue in the GitHub repository.

---

**Note:** Make sure to configure your database properly before running the application. The default configuration expects a MySQL server running on localhost with an empty root password.
