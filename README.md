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
 
 
   --------------------------------------------------------------------
 
 
 ## Chapter 1: Java building blocks
 
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
            <pre>
            import java.nio.file.Files; 
            import java.nio.file.Paths;
          </pre>
            Consider some imports that don't work:
            <pre>
            import java.nio.*; // NO GOOD – a wildcard only matches //class names, not "file.*Files"
            import java.nio.*.*; // NO GOOD – you can only have one wildcard //and it must be at the end
            import java.nio.files.Paths.*; // NO GOOD – you cannot import methods //only class names
          </pre>
    - Naming Conflicts
        
        Pick one to use in import and the other’s fully qualified class name:
      <pre>
        public class Conflicts { 
            Date date;
            java.sql.Date sqlDate;
        }
      </pre>
      or have neither with an import and always use the fully qualified class name:
        <pre>
        public class Conflicts { 
            java.util.Date date;
            java.sql.Date sqlDate;
        }
      </pre>
      
    - Creating a New Package
      - To compile and run
          <pre>
          javac packagea/ClassA.java packageb/ClassB.java
          java packageb.ClassB
        </pre>
      - Class Paths and JARs
     
        A JAR file is like a zip file of mainly Java class files
        
  - Creating Objects
    
    The name of the constructor matches the name of the class
    
    There’s no return type
    
    Sample:
    <pre>
    public class Chick { 
        public Chick() {
            System.out.println("in constructor"); 
        }
        public void Chick() { } // NOT A CONSTRUCTOR                
    }
  </pre>
    
   - Instance Initializer Blocks
    
        There are three code blocks and one instance initializer.
        
        Line 6 is an instance initializer.
        <pre>
        3: public static void main(String[] args) {
        4: { System.out.println("Feathers"); }
        5: }
        6: { System.out.println("Snowy"); }
     </pre>
   - Order of Initialization
        - Fields and instance initializer blocks are run in the order in which they appear in the file.
        - The constructor runs after all fields and instance initializer blocks have run.
        Order matters for the fields and blocks of code. You can’t refer to a variable before it has been initialized:
        
        <pre>
        { System.out.println(name); } // DOES NOT COMPILE 
        private String name = "Fluffy";
     </pre>
  - Object References and Primitives
    
    Java applications contain two types of data: primitive types and reference types
    - Primitive Types
    
        Java has eight built-in data types, referred to as the Java primitive types. 
        
        For example, Java allocates 32 bits if you write this:
        <pre>
        int num;
      </pre>
        When a number is present in the code, it is called a _literal_
         
        - Converting Back to Binary:
        <pre>
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
      </pre>
      
      - You can have underscores in numbers to make them easier to read:
        
        int million1 = 1000000; int million2 = 1_000_000;
        
        <pre>
        double notAtStart = _1000.00; // Does not compile
        double notAtEnd = 1000.00_; // Does not compile
        double notByDecimal = 1000_.00; // Does not compile
        double annoyingButLegal = 1_00_0.0_0; // this one compiles
      </pre>
    - Reference Types
        
        A reference type refers to an object (an instance of a class).
        
        Primitive type holds their values in memory where the variable is allocated
        
        Reference types is not, it points to an object by storing the memory address where the object is located
        
        A value is assigned to a reference in one of two ways:
        
        - A reference can be assigned to another object of the same type.
        
        - A reference can be assigned to a new object using the new keyword.  
        
    #### Key Differences
        
       - Reference types can be assigned null (not currently refer to object)
       - Primitive types give compile error when assign null
           <pre>
           int value = null; // DOES NOT COMPILE 
           String s = null;
         </pre>
       - Reference types can call methods when not point to null, Primitives do not have methods declared
         
  - Declaring, Initializing and Default Variables 
  
    - Declare variable: 
        <pre>
        String zooName; 
        int numberAnimals;
      </pre>
    - Init values: 
        <pre>
        zooName = "The Best Zoo"; 
        numberAnimals = 100;
      </pre>
    - Merge 2 actions:
        <pre>
        String zooName = "The Best Zoo"; 
        int numberAnimals = 100;
      </pre>
    
        <pre>
        int num, String value; // DOES NOT COMPILE
      </pre>
    
    - Identifiers: 3 rules
    
           - The name must begin with a letter or the symbol $ or _. 
           - Subsequent characters may also be numbers.
           - Can not use the same name as a Java reserved word
        
    - **Local Variables**: is a variable defined within a method, must be initialized before use.
        
         It cannot appear within an expression before init and the compiler will remind
        <pre>
        public void findAnswer(boolean check) { int answer;
            int onlyOneBranch;
            if (check) {
                onlyOneBranch = 1;
                answer = 1; 
            } else {
                answer = 2; 
            }
            System.out.println(answer);
            System.out.println(onlyOneBranch); // DOES NOT COMPILE 
        }
      </pre>
    
    - **Instance and Class Variables**: both do not required to initialize, just declare and it has it default value
        - Instance variables are also called fields
        - Class variables are shared across multiple objects (static).
    
  - Variable Scope
    - Local variables (method parameter and declared inside method): within the method and can not access outside the method
    - Instance variables: available as soon as they are defined and last for the entire lifetime of the object itself (until object garbage collected)
    - Class variables (static): go into scope like the other variables types and stay for the entire life of the program
    
  - Ordering Elements in a Class 
  
    - Think of the acronym PIC (picture): package, import, and class. Fields and methods are easier to remember because they merely have to be inside of a class.
    - Multiple classes can be defined in the same file, but only one of them is allowed to be public
  - Destroying Objects 

    - Garbage Collection: freeing memory on the heap by deleting objects that are no longer reachable
    
        - An object will remain on the heap until it is no longer reachable, two situations occurs:
            - The object no longer has any references pointing to it. 
            - All references to the object have gone out of scope.
 
### Summary
    - Java classes consist of members called fields and methods
    - object is an instance of a Java class
    - Three styles of comment: 
        - a single-line com- ment (//)
        - a multiline comment (/* */)
        - a Javadoc comment (/** */)
        
    - Execute main method command line: NameOfClass firstArgument... corresponding args[0]...
    
    - A wildcard ending => import all classes in that package (not include packages inside)
    - java.lang is a special package that does not need to be imported
    
    - Constructors create objects, name matching class name, omitting return type
    - When an object is instantiated, fields and blocks of code are initialized first. Then the constructor is run.
    - Primitive types are the basic building blocks of Java types. Assembled into reference types. 
    - Reference types can have methods and be assigned to null
    - Numeric literals are allowed to begin with 0 (octal), 0x (hex), 0X (hex), 0b (binary), or 0B (binary). 
    - Numeric literals are also allowed to contain underscores as long as they are directly between two other numbers
    
    - Declare => stating the data type, giving the variable a name
    - Fields in a class are automatically initialized to their corresponding “zero” or null value during object instantiation
    - Local variables must be specifically initialized.
    - Identifiers may contain letters, numbers, $, or _. Identifiers may not begin with numbers.
    
    - Three kind of varibales: 
        - Instance variables: nonstatic fields of class 
        - Class variables: static fields of class
        - Local variables: within a method
        
    - Order elements: 
        Package statement(if present)
                    v
        Import statement(if present)
                    v
        Class declaration
                    v
        Fields, methods (any order within the class)
        
    - Garbage collection is responsible for removing objects from memory when they can never be used again
    - An object becomes eligible for garbage collection when no more references or references gone out of scope
    - The finalize() method will run once for each object if/when it is first garbage collected.
    
    - Java code is object oriented, meaning all code is defined in classes
    - Access modifiers allow classes to encapsulate data
    - Java is platform independent, compiling to bytecode. It is robust and simple by not providing pointers or operator overloading
    - Java is secure because it runs inside a virtual machine.