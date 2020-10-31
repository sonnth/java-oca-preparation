# Java OCA preparation

## Chapter 1: Java building blocks

 - Scoping variables
 - Run program
 - Type of variables
 
 ## Chapter 2: Operators and statements
 
 - Condition, loop
 - Operator
 
 ## Chapter 3: Core java APIs
 
 - Array, ArrayList, String, String Buffer, Date
 
 ## Chapter 4: Method and Encapsulation
 
 - Access modifiers
 - Lambdas
 
 ## Chapter 5: Class design
 
 - Interface, superclass
 - Casting, Polymorphism
 
 
 ### Chapter 1: Java building blocks
 
  - Java class structure: 
    - Java class has 2 primary elements: 
        - method (often called functions or procedures in other languages)
        - field (more generally known as variables)
        
        Together these are called the members of class
        
  - Package declarations and imports 
    - Wildcards
        - The * is the wildcard that **match all classes** in the package (it doesn't import child packages, fields or methods), import only classes
        - There's a special type of import called "static import" (Chapter 4)
        - The compiler figures out what's actually needed
    - Redundant imports
        - java.lang is special package, don't need to import
        - Some example:
            ```
            import java.nio.file.Files; 
            import java.nio.file.Paths;
            ```
            Consider some imports that don't work:
            ```
            import java.nio.*; // NO GOOD – a wildcard only matches //class names, not "file.*Files"
            import java.nio.*.*; // NO GOOD – you can only have one wildcard //and it must be at the end
            import java.nio.files.Paths.*; // NO GOOD – you cannot import methods //only class names
            ```
    - Naming Conflicts
        
        Pick one to use in import and the other’s fully qualified class name:
        ```
        public class Conflicts { 
            Date date;
            java.sql.Date sqlDate;
        }
        ```
      or have neither with an import and always use the fully qualified class name:
        ```
        public class Conflicts { 
            java.util.Date date;
            java.sql.Date sqlDate;
        }
        ```
      
    - Creating a New Package
      - To compile and run
          ```
          javac packagea/ClassA.java packageb/ClassB.java
          java packageb.ClassB
          ```
      - Class Paths and JARs
     
        A JAR file is like a zip file of mainly Java class files
        
  - Creating Objects
    
    The name of the constructor matches the name of the class
    
    There’s no return type
    
    Sample:
    ```
    public class Chick { 
        public Chick() {
            System.out.println("in constructor"); 
        }
        public void Chick() { } // NOT A CONSTRUCTOR                
    }
    ```
    - Instance Initializer Blocks
    
        There are three code blocks and one instance initializer.
        
        Line 6 is an instance initializer.
        ```
        3: public static void main(String[] args) {
        4: { System.out.println("Feathers"); }
        5: }
        6: { System.out.println("Snowy"); }
        ```
    - Order of Initialization
        - Fields and instance initializer blocks are run in the order in which they appear in the file.
        - The constructor runs after all fields and instance initializer blocks have run.
        Order matters for the fields and blocks of code. You can’t refer to a variable before it has been initialized:
        
        ```
        { System.out.println(name); } // DOES NOT COMPILE 
        private String name = "Fluffy";
        ```
  - Object References and Primitives
    
    Java applications contain two types of data: primitive types and reference types
    - Primitive Types
    
        Java has eight built-in data types, referred to as the Java primitive types. 
        
        For example, Java allocates 32 bits if you write this:
        ```
        int num;
        ```
        When a number is present in the code, it is called a _literal_
         
        - Converting Back to Binary:
        ```
        System.out.println(56); // 56 
        System.out.println(0b11); // 3 
        System.out.println(017); // 15 
        System.out.println(0x1F); // 31
        
        First we have our normal base 10 value. We know you already know how to read that, but 
        bear with us. The rightmost digit is 6, so it’s “worth” 6. The second-to-rightmost digit 
        is 5, so it’s “worth” 50 (5 times 10.) Adding these together, we get 56.
      
        Next we have binary, or base 2. The rightmost digit is 1 and is “worth” 1. The second-to- 
        rightmost digit is also 1. In this case, it’s “worth” 2 (1 times 2) because the base is 2. Add- 
        ing these gets us 3. 
      
        Then comes octal, or base 8. The rightmost digit is 7 and is “worth” 7. The second-to- 
        rightmost digit is 1. In this case, it’s “worth” 8 (1 times 8) because the base is 8. Adding 
        these gets us 15.
      
        Finally, we have hexadecimal, or base 16, which is also known as hex. The rightmost 
        “digit” is F and it’s “worth” 15 (9 is “worth” 9, A is “worth” 10, B is “worth” 11, and so 
        forth). The second-to-rightmost digit is 1. In this case, it’s “worth” 16 (1 times 16) because 
        the base is 16. Adding these gets us 31.
        ```
      
      - You can have underscores in numbers to make them easier to read:
        
        int million1 = 1000000; int million2 = 1_000_000;
        
        ```
        double notAtStart = _1000.00; // Does not compile
        double notAtEnd = 1000.00_; // Does not compile
        double notByDecimal = 1000_.00; // Does not compile
        double annoyingButLegal = 1_00_0.0_0; // this one compiles
        ```
    - Reference Types
        
        A reference type refers to an object (an instance of a class).
  - Declaring, Initializing and Default Variables 
  - Understanding Variable Scope
  - Ordering Elements in a Class 
  - Destroying Objects 
