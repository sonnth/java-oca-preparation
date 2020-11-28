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
 
 ## Chapter 6: Exceptions
 
 - Type of Exceptions
 - How to use
 
 
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
    }</pre>
    
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
        private String name = "Fluffy";</pre>

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
    
 ## Chapter 2: Operators and Statements

  - Java operators:
    - A Java operator is special symbol use for set of variables, value or literals referred to operands and returns a result
    - There are three types: **unary, binary, and ternary**
        <pre>
        int y = 4;
        double x = 3 + 2 * --y;</pre>
   
    - Order of operator precedence:
        <pre>
        <b>Operator</b>                                <b>Symbols and examples</b>
        
        Post-unary operators                    expression++, expression--
        Pre-unary operators                     ++expression, --expression
        Other unary operators                   +, -, !
        Multiplication/Division/Modulus         *, /, %
        Addition/Subtraction                    +, -
        Shift operators                         <<, >>, >>>
        Relational operators                    <, >, <=, >=, instanceof 
        Equal to/not equal to                   ==, !=
        Logical operators                       &, ^, | 
        Short-circuit logical operators         &&, ||
        Ternary operators                       boolean expression ? expression1 : expression2
        Assignment operators                    =, +=, -=, *=, /=, %=, &=, ^=, !=, <<=, >>=, >>>=</pre>
  
  - Binary Arithmetic Operators:
    - Arithmetic Operators: 
         
        - addition (+), subtraction (-), multiplication (*), division (/), and modulus (%)
        - The multiplicative operators (*, /, %) higher order than the additive operators (+, -)
        - All arithmetic operators may be applied to any Java primitives, except boolean and String
        - Only addition operators + and += may be applied to String values => results in String concatenation
        - For integer values, division results in the floor value of the nearest integer that fulfills the operation, whereas modulus is the remainder value
    - Numeric Promotion
    
        Numeric Promotion Rules:
        1. If two values have different data types, Java will automatically promote one of the val- ues to the larger of the two data types.
        2. If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value’s data type.
        3. Smaller data types, namely byte, short, and char, are first promoted to int any time they’re used with a Java binary arithmetic operator, even if neither of the operands is int.
        4. After all promotion has occurred and the operands have the same data type, the result- ing value will have the same data type as its promoted operands.
        
        <pre>
        -  int x = 1;
           long y = 33;
           first rule x * y => int value is promoted to a long, type long
        -  double x = 39.21;
           float y = 2.1;
           floating-point literals are assumed to be double, unless post-fixed with an f, as in 2.1f
           x + y => not compile
        -  short x = 10;
           short y = 3;
           third rule x / y => x and y will both be promoted to int before the operation, output type int
        -  short x = 14;
           float y = 13; 
           double z = 30;
           all rules => result in a double value</pre>
        
  - Unary Operators:
    
    Unary operator is one that requires exactly one operand, or variable, to function, often perform simple tasks, such as increasing a numeric variable by one, or negating a boolean value.
    
    - Logical Complement and Negation Operators: 
    
        The logical complement operator: !, flips the value of a boolean expression
    
    Pay attention: 
    <pre>
    int x = !5; // DOES NOT COMPILE 
    boolean y = -true; // DOES NOT COMPILE 
    boolean z = !0; // DOES NOT COMPILE</pre>
    
    - Increment and Decrement Operators:
    
        Increment and decrement operators: ++, --, applied to numeric operands and have higher order, often get applied first to an expression
        
        The order applied to operand can make different in how they processed:
         
         -  Placed before operand (pre-increment, pre-decrement operator) 
         
            => The operator is applied first, the value return is the new value of the expression 
        
         -  Placed after operand (post-increment, post-decrement operator) 
             
            => The original value of the expression is returned, with operator applied after the value is returned.
        
        Sample:
        <pre>
        int counter = 0; 
        System.out.println(counter); // Outputs 0 
        System.out.println(++counter); // Outputs 1 
        System.out.println(counter); // Outputs 1 
        System.out.println(counter--); // Outputs 1 
        System.out.println(counter); // Outputs 0</pre>
    
  - Additional Binary Operators:
    - Assignment Operators:
    
        - An assignment operator is a binary operator that modifies, or assigns, the variable on the left-hand side of the operator
        
        - Java will automatically promote from smaller to larger types and throw compiler exception if convert larger to smaller data types
        
        - Casting larger to smaller data types, or convert:
            
            Overflow: number too large => wraps around to the next lowest value and counts up from there 
            
            Underflow: the number too low to fit in the data type.
    - Compound Assignment Operators: += and -=
    
        - Shorthand
        
        - Do not have to explicitly cast a value
            <pre>long x = 10;
          int y = 5;
          y = y * x; // DOES NOT COMPILE
          y *= x; // the compiler automatically cast result to the left-hand side value</pre>
        
    - Relational Operators: 
    
        - Compare two expressions and return a boolean value:
            <pre><             Strictly less than
          <=            Less than or equal to
          >             Strictly greater than
          =>            Greater than or equal to</pre>
        - The relation operator _a instanceof b_ : is applied to object references and classes or interfaces
          
          Determining whether an arbitrary object is a member of a particular class or interface
          
    - The ogical Operators: (&), (|), and (^)
        
        - For boolean data: referred to as logical operators
            
            AND (&): is only true if both operands are true.
            
            Inclusive OR (|): is only false if both operands are false. 
            
            Exclusive OR (^): is only true if the operands are different.
        - For numeric data: referred to as bitwise operators, bitwise comparisons of the bits
    
    - The conditional operators: The short-circuit operators (&&), (||)
        
        Nearly identical to the logical operators, & and |, respectively, except that the right-hand side of the expression may never be evaluated if the final result can be determined by the left-hand side of the expression
        
        Pay attention:
        <pre>int x = 6;
      boolean y = (x >= 6) || (++x <= 7); 
      System.out.println(x);</pre>
        Because x >= 6 is true, the increment operator on the right-hand side of the expression is never evaluated, so the output is 6.
    
    - Equality Operators:
    
        Used in one of three scenarios:
        - Comparing two numeric primitive types, the values are automatically promoted 
            ```
            5 == 5.00 returns true
            ```
        - Comparing two boolean values.
        - Comparing two objects, including null and String values.
        
        For object comparison, the equality operator is applied to the references. Two references are equal if and only if they point to the same object, or both point to null
        
        <pre>File x = new File("myFile.txt");
      File y = new File("myFile.txt");
      File z = x;
      System.out.println(x == y); // Outputs false 
      System.out.println(x == z); // Outputs true</pre>
      
  - Java statements:
  
    - If-then statements 
    
       The structure:
         ```
         if(booleanExpression) <- Parentheses (required) {
              // Branch if true
         } <- Curly braces required for block of multiple statements, optional for single statement
         ```
        
      - The **morningGreetingCount** always execute the increment operation, tabs are just whitespace, not evaluated as part of the execution
          ```
          if(hourOfDay < 11) 
          System.out.println("Good Morning"); 
          morningGreetingCount++;
          ```
      - Curly braces required for block of multiple statements, optional for single statement
      
    - The if-then-else Statement
    
       The structure:
         ```
         if(booleanExpression) <- Parentheses (required) {
              // Branch if true
         } else <- Optional else statement {
              // Branch if true
         }
         All curly braces required for block of multiple statements, optional for single statement
         ```
      
      - _if-then-else_ statements order is important
          ```
          System.out.println("Good Afternoon");
          } else if(hourOfDay < 11) {
          System.out.println("Good Morning"); // UNREACHABLE CODE
          } else {
          System.out.println("Good Evening");
          }      
          ```
    - Ternary Operator: 
    
        The structure:
        ```
        booleanExpression ? expression1 : expression2
        ```
    
        No requirement that second and third expressions in ternary operations have the same data types
        ```
        System.out.println((y > 5) ? 21 : "Zebra");
        int animal = (y < 91) ? 9 : "Horse"; // DOES NOT COMPILE
        ```
        The expressions in a ternary operator may not be applied if the particular expression is not used
        
    - The _switch_ Statement:
    
        The structure:
        ```  
        switch(variableToTest) <- required { <- Beginning curly brace (required)
            case constantExpression1: 
                 // Branch for case1;
                 break; <- Optional break
            case constantExpression2: 
                 // Branch for case2;
                 break; <- Optional break
            ...
            default: <- Optional default that may appear anywhere within switch statement
                 // Branch for default
        } <- Ending curly brace (required)
        ```
    
       - Data support: int and Integer, byte and Byte, short and Short, char and Character, String, enum values
        
       - boolean and long, and their associated wrapper classes, are not supported by switch statements
       
       - The value each case statement must be constant and same data type  as the switch value
       
       - **break** statement terminate the switch statement and return flow control to the enclosing statement
       
       - No requirement that the case or default statements be in a particular order, unless you are going to have pathways that reach multiple sections of the switch block in a single execution.
       
    - The _while_ Statement: 
    
        The structure:
        ```
        while(booleanExpression) {
        //body 
        Curly braces required for block of multiple statements, optional for single statement
        }
        ```
    
        Like all repetition control structures, it has a termination condition, imple- mented as a boolean expression, that will continue as long as the expression evaluates to true.
    
       - Using non-constant variables
       
       - Be aware of infinite loop
       
    - The _do-while_ Statement
    
        The structure:
        ```
        do {
        //body 
        Curly braces required for block of multiple statements, optional for single statement
        } while (booleanExpression) <- Parentheses (required); <- Semicolon (required)
        ```
    
       - Like a while loop, but a do-while loop guarantees that the statement or block will be executed at least once.
       
    - The _for_ Statement
        The structure:
        ```
        for(initialization; booleanExpression; updateStatement) -> Parentheses (required) {
                          ↑                  ↑   2 semicolons (required)
             // Body
        } Curly braces required for block of multiple statements, optional for single statement
      
        1. Initialization statement executes
        2. If booleanExpression is true continue, else exit loop
        3. Body executes
        4. Execute updateStatements
        5. Return to Step 2
        ```
      
        - Variables declared in the initialization block of a for loop have limited scope and
          are only accessible within the for loop
        - Be wary of variable already declared within the initialization block
        
        1. Creating an Infinite Loop
            
            ```
            for( ; ; ) {
            System.out.println("Hello World"); }
            ```
       
        2. Adding Multiple Terms to the for Statement
        
            ```
            int x = 0;
            for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) { 
            System.out.print(y + " ");
            } System.out.print(x);
           ```
           
        3. Redeclaring a Variable in the Initialization Block
        
           ```
           int x = 0;
           for(long y = 0, x = 4; x < 5 && y < 10; x++, y++) {
           System.out.print(x + " "); 
           }
           ```
           
        4. Using Incompatible Data Types in the Initialization Block
        
           ```
           for(long y = 0, int x = 4; x < 5 && y<10; x++, y++) { // DOES NOT COMPILE 
           System.out.print(x + " ");
           }
           ```
           
        5. Using Loop Variables Outside the Loop
        
           ```
           for(long y = 0, x = 4; x < 5 && y < 10; x++, y++) { 
           System.out.print(y + " ");
           }
           System.out.print(x); // DOES NOT COMPILE
           ```
    - The for-each Statement
        The structure:
        ```
         Semicolon (required) ↴
        for(datatype instance : collection) <- Parentheses (required) {
                ↑                      ↑
        datatype of collection member|Iterable collection of objects
        } -> Curly braces required for block of multiple statements, optional for single statement
        ```
        
  - Flow control:
  
    The path taken during runtime may not be as straightforward => Control flow
  
    - Nested Loops:
    
      Loops can contain other loops
      
      ```
      int x = 20; 
      while(x>0) {
      do {
      x -= 2
      } while (x>5);
      x--; System.out.print(x+"\t");
      }
      ```
    
    - Adding Optional Labels
    
      _if-then_ statements, _switch_ statements, and loops can all have optional labels, it's useful in nested environments
    
      A label is an optional pointer to the head of a statement that allows the application flow to jump to it or break from it
      
      Formatting: labels follow the same rules for identifiers, uppercase with underscores between words
        
        ```
        int[][] myComplexArray = {{5,2,1,3}, {3,9,8,9}, {5,7,12,7}}; 
        OUTER_LOOP: for(int[] mySimpleArray : myComplexArray) {
        INNER_LOOP: for(int i = 0; i < mySimpleArray.length; i++) { 
        System.out.print(mySimpleArray[i] + "\t");
        }
        System.out.println(); 
        }
        ```
        
    - The break Statement
    
      Using for end the loop early
      
        The structure:
        ```
        optionalLabel: while(booleanExpression) {
      
           // Body
      
           // Somewhere in loop
           break optionalLabel; <- Semicolon (required)
        }
        ```
      
      - Without label parameter, the break statement terminate nearest inner loop
      
      - The optional label parameter allows us to break out of a higher level outer loop
      
      ```
      public class SearchSample {
          public static void main(String[] args) {
              int[][] list = {{1, 13, 5}, {1, 2, 5}, {2, 7, 2}};
              int searchValue = 2;
              int positionX = -1;
              int positionY = -1;
              PARENT_LOOP:
              for (int i = 0; i < list.length; i++) {
                  for (int j = 0; j < list[i].length; j++) {
                      if (list[i][j] == searchValue) {
                          positionX = i;
                          positionY = j;
                          break PARENT_LOOP;
                      }
                  }
              }
              if (positionX == -1 || positionY == -1) {
                  System.out.println("Value " + searchValue + " not found");
              } else {
                  System.out.println("Value " + searchValue + " found at: " + "(" + positionX + "," + positionY + ")");
              }
          }
      }
      Output: Value 2 found at: (1,1)
      ```
      
    - The continue Statement
    
        The structure:
        ```
        optionalLabel: while(booleanExpression) {
      
           // Body
      
           // Somewhere in loop
           continue optionalLabel; <- Semicolon (required)
        }
        ```

        - Syntax are similar to **break** statement but different results
            - The break statement transfers control to the enclosing statement 
            - The continue statement transfers control to the boolean expression that determines if the loop should continue, it ends the current iteration of the loop
            
      ```
      public class Continue {
          public static void main(String[] args) {
              FIRST_CHAR_LOOP:
              for (int a = 1; a <= 4; a++) {
                  for (char x = 'a'; x <= 'c'; x++) {
                      if (a == 2 || x == 'b') continue FIRST_CHAR_LOOP;
                      System.out.print(" " + a + x);
                  }
              }
          }
      }
      Output: 1a 3a 4a
      ```
      
    Conclusion:
    
    Labels, break, and continue statements can be used inside single loops as well.
    
    ```
                     Allows optional labels      Allows break statement      Allows continue statement
        if                  Yes *                       No                              No                
        while               Yes                         Yes                             Yes
        do while            Yes                         Yes                             Yes
        for                 Yes                         Yes                             Yes
        switch              Yes                         Yes                             No
    ```
    
    Labels are allowed for any block statement, including those that are preceded with an if-then statement.
       
### Summary
    - When you see an operator on the exam, always check that the appropriate data types are used and that they match each other where applicable.
    - Two types of control structures: decision-making controls structures, including if-then, if-then-else, and switch statements, as well as repetition control structures including for, for-each, while, and do-while
    - The switch statement is the only one that supports a variety of data types, including String variables as of Java 7.
    - With a for-each statement you don’t need to explicitly write a boolean expression
    - Control flow when nested loops, break statements, and continue statements
    
    
    
 ## Chapter 3: Core Java APIs

  - Creating and Manipulating Strings:
    - Concatenation
    
       - If both operands are numeric, + means numeric addition.
       - If either operand is a String, + means concatenation. 
       - The expression is evaluated left to right.
    
    - Immutability
    
        - Once a String object is created, it is not allowed to change

    - The String Pool
        
        - Strings can use up a lot of memory(25-40% memory of program) 
            
            => The String Pool (intern pool) reusing common ones, location in JVM and collects all these strings.
            
        - The String Pool contains literal values appear
        
            "string" is a literal and therefore goes into the string pool. 
            
            myObject.toString() is a string but not a literal => does not go into the string pool. 
            
            Strings not in the string pool are garbage collected just like any other object.
        
    - String methods
    
        - String is a sequence of characters count from 0 when indexed
        
        - There are 13 methods from the String class
            - **length()**: number of characters in the String
                
                Sample:
                ```
                String string = "animals";
                System.out.println(string.length()); // 7
                ```
            - **charAt()**: query the string to find out what character is at a specific index

                Sample:
                ```
                String string = "animals"; 
                System.out.println(string.charAt(0)); // a 
                System.out.println(string.charAt(6)); // s 
                System.out.println(string.charAt(7)); // throws java.lang.StringIndexOutOfBoundsException
                ```
            - **indexOf()**: looks at the characters in the string and finds the first index that matches the desired value
                
                The method signatures:
                ```
                int indexOf(char ch)
                int indexOf(char ch, index fromIndex) 
                int indexOf(String str)
                int indexOf(String str, index fromIndex)
                ```

                Sample:
                ```
                String string = "animals"; 
                System.out.println(string.indexOf('a'));  // 0
                System.out.println(string.indexOf("al")); // 4 
                System.out.println(string.indexOf('a', 4)); // 4 
                System.out.println(string.indexOf("al", 5)); // -1
              
            - **substring()**: looks at the characters in the string and finds the first index that matches the desired value
                
                The method signatures:
                ```
                int substring(int beginIndex)
                int substring(int beginIndex, int endIndex)
                ```

                Sample:
                ```
                String string = "animals"; 
                System.out.println(string.substring(3)); // mals 
                System.out.println(string.substring(string.indexOf('m'))); // mals 
                System.out.println(string.substring(3, 4)); // m 
                System.out.println(string.substring(3, 7)); // mals
                System.out.println(string.substring(3, 3)); // empty string 
                System.out.println(string.substring(3, 2)); // throws exception 
                System.out.println(string.substring(3, 8)); // throws exception
                ```  
              
            - **toLowerCase() and toUpperCase()**: converts any lowercase, uppercase characters to uppercase or lowercase in the returned string
            
            - **equals() and equalsIgnoreCase()**: 
            
                The equals() method checks whether two String objects contain exactly the same characters in the same order
                
                The equalsIgnoreCase() method checks whether two String objects contain the same characters with the exception that it will convert the characters’ case if needed
                
                The method signatures:
                ```
                boolean equals(String str)
                boolean equalsIgnoreCase(String str)
                ```

                Sample:
                ```
                System.out.println("abc".equals("ABC")); // false 
                System.out.println("ABC".equals("ABC")); // true 
                System.out.println("abc".equalsIgnoreCase("ABC")); // true
                ```
            
            - **startsWith() and endsWith()**: look at whether the provided value matches part of the String
                
                The method signatures:
                ```
                boolean startsWith(String prefix)
                boolean endsWith(String suffix)
                ```

                Sample:
                ```
                System.out.println("abc".startsWith("a")); // true 
                System.out.println("abc".startsWith("A")); // false 
                System.out.println("abc".endsWith("c")); // true 
                System.out.println("abc".endsWith("a")); // false
                ```
            
            - **contains()**: looks for matches in the String
                
                The method signatures:
                ```
                boolean contains(String str)
                ```
              
                Sample:
                ```
                System.out.println("abc".contains("b")); // true
                System.out.println("abc".contains("B")); // false
                ```
                The contains() method is a convenience method, do not have to write str.indexOf(otherString) != -1
            
            - **replace()**: does a simple search and replace on the string
                
                The method signatures:
                ```
                String replace(char oldChar, char newChar)
                String replace(CharSequence oldChar, CharSequence newChar)
                ```
              
                Sample:
                ```
                System.out.println("abcabc".replace('a', 'A')); // AbcAbc 
                System.out.println("abcabc".replace("a", "A")); // AbcAbc
                ```
            
            - **trim()**: method removes whitespace from the beginning and end of a String, whitespace consists of spaces along with the \t (tab) and \n (newline) characters. Other characters, such as \r (carriage return), are also included in what gets trimmed
                
                The method signatures:
                ```
                public String trim()
                ```
              
                Sample:
                ```
                System.out.println("abc".trim()); // abc 
                System.out.println("\t a b c\n".trim()); // a b c
                ```
            
    - Method chaining
    
        This is just a series of String methods
        
        `String result = "AniMaL ".trim().toLowerCase().replace('a', 'A');`
    
  - Using the StringBuilder Class:
  
    Why need StringBuilder: because String is immutable, most of string  eligible for garbage collection => inefficient
    
    The StringBuilder class creates a String without storing all those interim String values. Unlike the String class, StringBuilder is not immutable.
    
    - Creating a StringBuilder
    
        StringBuilder sb1 = new StringBuilder();
         
        StringBuilder sb2 = new StringBuilder("animal"); 
        
        StringBuilder sb3 = new StringBuilder(10);
    - StringBuilder Methods
        - **charAt(), indexOf(), length(), and substring()**: 
        
            Four methods work exactly the same as in the String class
                    
            Notice that substring() returns a String rather than a StringBuilder
          
        - **append()**: adds the parameter to the StringBuilder and returns a reference to the current StringBuilder
                    
            Method signature:
            ```
            StringBuilder append(String str);
            ```
                    
            Sample:
            ```
            StringBuilder sb = new StringBuilder().append(1).append('c'); 
            sb.append("-").append(true);
            System.out.println(sb); // 1c-true
            ```
            Just call append() without having to convert your parameter to a String first.
          
        - **insert()**: adds characters to the StringBuilder at the requested index and returns a reference to the current StringBuilder
                    
            Method signature:
            ```
            StringBuilder insert(int offset, String str);
            ```
            _offset_ is the index where we want to insert the requested parameter.
                    
            Sample:
            ```
            StringBuilder sb = new StringBuilder("animals");
            sb.insert(7, "-");      // sb = animals-
            sb.insert(0, "-");      // sb = -animals- 
            sb.insert(4, "-");      // sb = -ani-mals
            System.out.println(sb);
            ```
            Just call append() without having to convert your parameter to a String first.
          
        - **delete() and deleteCharAt()**: removes characters from the sequence and returns a reference to the current StringBuilder.
                    
            Method signature:
            ```
            StringBuilder delete(int start, int end) 
            StringBuilder deleteCharAt(int index)
            ```
                    
            Sample:
            ```
            StringBuilder sb = new StringBuilder("abcdef");
            sb.delete(1, 3); // sb = adef 
            sb.deleteCharAt(5); // throws an exception
            ```
          
        - **reverse()**: reverses the characters in the sequences and returns a reference to the current StringBuilder
                    
            Method signature:
            ```
            StringBuilder reverse()
            ```
                    
            Sample:
            ```
            StringBuilder sb = new StringBuilder("ABC"); 
            sb.reverse();
            System.out.println(sb); //CBA
            ```
          
        - **toString()**: converts a StringBuilder into a String
                    
            Method signature:
            ```
            String toString()
            ```
                    
            Sample:
            ```
            String s = sb.toString();
            ```
    
    - StringBuilder vs. StringBuffer:
    
        StringBuilder: writing new code that concatenates a lot of String objects together
        
        StringBuffer does the same thing but more slowly because it is thread safe
  
  - Equality:
  
    - Use == to compare numbers and that object references refer to the same object.
    ```
    StringBuilder one = new StringBuilder(); 
    StringBuilder two = new StringBuilder(); 
    StringBuilder three = one.append("a"); 
    System.out.println(one == two); // false 
    System.out.println(one == three); // true
    ```
    
    - The way the JVM reuses String literals:
    Strings are immutable and literals are pooled. The JVM created only one literal in memory. x and y both point to the same location in memory.
    ```
    String x = "Hello World";
    String y = "Hello World"; 
    System.out.println(x == y); // true
    ```
    
    - Since you have specifically requested a different String object, the pooled value isn’t shared
    ```
    String x = "Hello World";
    String z = " Hello World".trim(); 
    System.out.println(x == z); // false
    
    ------------------------------------
    
    String x = new String("Hello World"); 
    String y = "Hello World"; 
    System.out.println(x == y); // false
    ```
    
    **Never use == to compare String objects**
    
  - Java Arrays:
    
    - Creating an Array of Primitives
        - The basic structure of an array:    
            int: Type of array       
            []: array symbol(required)      
            [3]: size of array
    
            `int[] numbers = new int[3];`
        - Another way:
        
            `int[] numbers2 = new int[] {42, 55, 99};`
            
        - As a shortcut:
    
            This approach is called an anonymous array. It is anonymous because you don’t specify the type and size.
        
           `int[] numbers2 = {42, 55, 99};`
           
        - Finally, you can type the [] before or after the name, and adding a space is optional. 
            This means that all four of these statements do the exact same thing:
            ```
            int[] numAnimals; 
            int [] numAnimals2; 
            int numAnimals3[]; 
            int numAnimals4 []; 
            ```
    
            int[] ids, types;       is two variables of type int[]
            
            int ids[], types;       The first one is a int[] called ids. The second one is regular integer called types
    - Creating an Array with Reference Variables
    
        An array is an object, this would work even on an int[] too. int is a primitive; int[] is an object.
        
        ```
        public class ArrayType {
            public static void main(String args[]) {
            String [] bugs = { "cricket", "beetle", "ladybug" };
            String [] alias = bugs;
            System.out.println(bugs.equals(alias)); // true 
            System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0
            //java .util.Arrays.toString(bugs) would print [cricket, beetle, lady- bug]
            //[L means it is an array, java.lang.String is the reference type, and 160bc7c0 is the hash code
            }
        }
        ```

        Line 7 is where this gets interesting. From the point of view of the compiler, this is just fine. A StringBuilder object can clearly go in an Object[]. The problem is that we don’t actually have an Object[]. We have a String[] referred to from an Object[] variable. At runtime, the code throws an ArrayStoreException
        ```
        String[] strings = { "stringValue" };
        Object[] objects = strings;
        String[] againStrings = (String[]) objects;
        againStrings[0] = new StringBuilder(); // DOES NOT COMPILE 7: 
        objects[0] = new StringBuilder(); // careful!
        ```
    - Using an Array:
        <pre>
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        for (String i : cars) {
        System.out.println(i);
        }</pre>
    
    - Sorting:
    
        Arrays is the first class provided by Java we have used that requires an import
        
        import java.util.* // import whole package including Arrays 
        
        import java.util.Arrays; // import just Arrays
        
        This simple example sorts three numbers:
        <pre>
        int[] numbers = { 6, 9, 1 }; 
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++)
        System.out.print (numbers[i] + " ");    //outputs 1 6 9</pre>
        
        With String types: String sorts in alphabetic order, and 1 sorts before 9
        <pre>
        String[] strings = { "10", "9", "100" }; 
        Arrays.sort(strings);
        for (String string : strings)
        System.out.print(string + " ");     //outputs 10 100 9</pre>
        
    - Searching:
    
        **Arrays.binarySearch()** is the simplest and most efficient method to find an element in a sorted array in Java
        <pre>
        <b>Scenario</b>                                        <b>Result</b>
        Target element found in sorted array            Index of match
        
        Target element not found in sorted array        Negative value showing one smaller than the negative of index, where a match needs to be inserted to preserve sorted order
        
        Unsorted array                                  A surprise—this result isn’t predictable
        </pre>
        ```
        int[] numbers = {2,4,6,8};
        System.out.println(Arrays.binarySearch(numbers, 2)); // 0 
        System.out.println(Arrays.binarySearch(numbers, 4)); // 1 
        System.out.println(Arrays.binarySearch(numbers, 1)); // -1 
        System.out.println(Arrays.binarySearch(numbers, 3)); // -2
        System.out.println(Arrays.binarySearch(numbers, 9)); // -5
                            --------
        int numbers = new int[] {3,2,1};
        System.out.println(Arrays.binarySearch(numbers, 2)); 
        System.out.println(Arrays.binarySearch(numbers, 3));
        ```
    - Varargs:
    
        Three examples with a main() method:
        
        - public static void main(String[] args)
        
        - public static void main(String args[])
        
        - public static void main(String... args) // varargs
    - Multidimensional Arrays:
    
        Creating a Multidimensional Array
        ```
        int[][] vars1;              // a 2D AND
        int vars2 [][];             // a 2D AND
        int[] vars3[];              // a 2D AND
        int[] vars4 [], space [][]; // a 2D AND a 3D array
        ```
      
        Specify the size of your multidimensional array
        ```
        String [][] rectangle = new String[3][2];
        ```
    
        Using a Multidimensional Array
        ```
        for (int[] inner : twoD) { 
            for (int num : inner)
            System.out.print(num + " "); 
            System.out.println();
        }
        ```

  - ArrayList: creating an ArrayList, common methods, autoboxing, conversion, and sorting.
    - Create ArrayList: three ways to create an ArrayList.
        ```
        ArrayList list1 = new ArrayList(); 
        ArrayList list2 = new ArrayList(10); 
        ArrayList list3 = new ArrayList(list2);
        ```
        Java 5 introduced generics, which allow you to specify the type of class that the ArrayList will contain.
        ```
        ArrayList<String> list4 = new ArrayList<String>(); 
        ArrayList<String> list5 = new ArrayList<>();
        ```
        <> called the diamond operator

        ArrayList implements an interface called List => ArrayList is a List
        ```
        List<String> list6 = new ArrayList<>();
        ArrayList<String> list7 = new List<>(); // DOES NOT COMPILE
        ```

    - Common methods
        - **add()**:  insert a new value in the ArrayList
                    
            Method signature:
            ```
            boolean add(E element)
            void add(int index, E element)
            ```
                    
            Sample:
            
            Didn’t specify a type for ArrayList; therefore, the type is Object, which includes everything except primitives
            ```
            ArrayList list = new ArrayList(); 
            list.add("hawk"); // [hawk]
            list.add(Boolean.TRUE); // [hawk, true] 
            System.out.println(list); // [hawk, true]
            ```
            
            Using generics to tell the compiler we only want to allow String objects
            ```
            ArrayList<String> safer = new ArrayList<>(); 
            safer.add("sparrow");
            safer.add(Boolean.TRUE); // DOES NOT COMPILE
            
            List<String> birds = new ArrayList<>();
            birds.add("hawk");          // [hawk]
            birds.add(1, "robin");      // [hawk, robin]
            birds.add(0, "blue jay");   // [blue jay, hawk, robin]
            birds.add(1, "cardinal");   // [blue jay, cardinal, hawk, robin]
            System.out.println(birds);  // [blue jay, cardinal, hawk, robin]
            ```

        - **remove()**:  remove the first matching value in the ArrayList or remove the element at a specified index
                    
            Method signature:
            ```
            boolean remove(Object object) E 
            remove(int index)
            ```
                    
            Sample:
            
            ```
            List<String> birds = new ArrayList<>();
            birds.add("hawk"); // [hawk]
            birds.add("hawk"); // [hawk, hawk]
            System.out.println(birds.remove("cardinal")); // prints false 
            System.out.println(birds.remove("hawk")); // prints true
            System.out.println(birds.remove(0)); // prints hawk 
            System.out.println(birds); // []
            
            birds.remove(100)   throws an IndexOutOfBoundsException.
            ```
        
        - **set()**:  changes one of the elements of the ArrayList without changing the size
                    
            Method signature:
            ```
            E set(int index, E newElement)
            ```
                    
            Sample:
            
            ```
            List<String> birds = new ArrayList<>();
            birds.add("hawk");  // [hawk]
            System.out.println(birds.size());   // 1
            birds.set(0, "robin");  // [robin]
            System.out.println(birds.size());   // 1
            birds.set(1, "robin");  // IndexOutOfBoundsException
            ```            
        
        - **isEmpty() and size()**: look at how many of the slots are in use
                    
            Method signature:
            ```
            boolean isEmpty() 
            int size()
            ```
                    
            Sample:
            
            ```
            System.out.println(birds.isEmpty());    // true 
            System.out.println(birds.size());   // 0
            birds.add("hawk");  // [hawk]
            birds.add("hawk");  // [hawk, hawk]
            System.out.println(birds.isEmpty()); // false 
            System.out.println(birds.size()); // 2
            ```            
                    
            Method signature:
            ```
            E set(int index, E newElement)
            ```
                    
            Sample:
            
            ```
            List<String> birds = new ArrayList<>();
            birds.add("hawk");  // [hawk]
            System.out.println(birds.size());   // 1
            birds.set(0, "robin");  // [robin]
            System.out.println(birds.size());   // 1
            birds.set(1, "robin");  // IndexOutOfBoundsException
            ```
        
        - **clear()**: discard all elements of the ArrayList
                    
            Method signature:
            ```
            void clear()
            ```
                    
            Sample:
            
            ```
            List<String> birds = new ArrayList<>();
            birds.add("hawk"); // [hawk]
            birds.add("hawk"); // [hawk, hawk]
            System.out.println(birds.isEmpty()); // false
            System.out.println(birds.size()); // 2
            birds.clear(); // []
            System.out.println(birds.isEmpty()); // true
            System.out.println(birds.size());// 0
            ```
        
        - **contains()**: checks whether a certain value is in the ArrayList
                    
            Method signature:
            ```
            boolean contains(Object object)
            ```
                    
            This method calls equals() on each element of the ArrayList to see whether there are any matches
            ```
            List<String> birds = new ArrayList<>(); 
            birds.add("hawk"); // [hawk] 
            System.out.println(birds.contains("hawk")); // true 
            System.out.println(birds.contains("robin")); // false
            ```
        
        - **equals()**: ArrayList has a custom implementation of equals() so you can compare two lists to see if they contain the same elements in the same order
                    
            Method signature:
            ```
            boolean equals(Object object)
            ```
                    
            Sample:
            
            ```
            List<String> one = new ArrayList<>(); 
            List<String> two = new ArrayList<>(); 
            System.out.println(one.equals(two)); // true
            one.add("a"); // [a]
            System.out.println(one.equals(two)); // false
            two.add("a"); // [a]

            System.out.println(one.equals(two)); // true
            one.add("b"); // [a,b]
            two.add(0, "b"); // [b,a]
            System.out.println(one.equals(two)); // false
            ```

    - Wrapper Classes
    
        <pre>
        <b>Primitive type</b>          <b>Wrapper class</b>           <b>Example of constructing</b>
        boolean                 Boolean                 new Boolean(true) 
        byte                    Byte                    new Byte((byte) 1) 
        short                   Short                   new Short((short) 1) 
        int                     Integer                 new Integer(1)
        long                    Long                    new Long(1)
        float                   Float                   new Float(1.0)
        double                  Double                  new Double(1.0)
        char                    Character               new Character('c')</pre>
        
        Converting from a String
        <pre>
        <b>Wrapper class</b>           <b>Converting String to primitive</b>              <b>Converting String to wrapper class</b>
        Boolean                 Boolean.parseBoolean("true");               Boolean.valueOf("TRUE");
        Byte                    Byte.parseByte("1");                        Byte.valueOf("2");
        Short                   Short.parseShort("1");                      Short.valueOf("2");
        Integer                 Integer.parseInt("1");                      Integer.valueOf("2");
        Long                    Long.parseLong("1");                        Long.valueOf("2");
        Float                   Float.parseFloat("1");                      Float.valueOf("2.2");
        Double                  Double.parseDouble("1");                    Double.valueOf("2.2");
        Character               None                                        None</pre>
    
    - Autoboxing
        
        In Java 5, you can just type the primitive value and Java will convert it to the relevant wrapper class for you. This is called autoboxing.
        ```
        List<Double> weights = new ArrayList<>();
        weights.add(50.5);  // [50.5]
        weights.add(new Double(60));    // [50.5, 60.0]
        weights.remove(50.5);   // [60.0] 
        double first = weights.get(0); // 60.0
        ```
        
        Unbox a null value
        ```
        List<Integer> heights = new ArrayList<>();
        heights.add(null);
        int h = heights.get(0); // NullPointerException
        ```
        
    - Converting Between array and List

        Converting ArrayList to array
        ```
        List<String> list = new ArrayList<>(); 
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();
        System.out.println(objectArray.length); // 2
        String[] stringArray = list.toArray(new String[0]); 
        System.out.println(stringArray.length); // 2
        ```
        Converting from an array to a List. The original array and created array backed List are linked. When a change is made to one, it is available in the other. It is a fixed-size list and is also known a backed List because the array changes with it
        ```
        String[] array = { "hawk", "robin" }; // [hawk, robin]
        List<String> list = Arrays.asList(array); // returns fixed size list 
        System.out.println(list.size()); // 2
        list.set(1, "test"); // [hawk, test]
        array[0] = "new"; // [new, test]
        for (String b : array) System.out.print(b + " "); // new test
        list.remove(1); // throws UnsupportedOperation Exception
        ```
        It updates both array and list because they point to the same data store.
        Last line throws an exception because we are not allowed to change the size of the list.

    - Sorting

        Similar to sorting an array but use a different helper class.
        
        ```
        List<Integer> numbers = new ArrayList<>(); 
        numbers.add(99);
        numbers.add(5);
        numbers.add(81); 
        Collections.sort(numbers); 
        System.out.println(numbers); [5, 81, 99]
        ```
    
  - Dates and Times:

    import java.time.*; // import time classes

    - Creating Dates and Times

        <pre>  - <b>LocalDate</b> contains just a date—no time and no time zone. A good example of LocalDate is your birthday this year. It is your birthday for a full day regardless of what time it is.
        - <b>LocalTime</b> Contains just a time—no date and no time zone. A good example of LocalTime is midnight. It is midnight at the same time every day.
        - <b>LocalDateTime</b> Contains both a date and time but no time zone. A good example of LocalDateTime is “the stroke of midnight on New Year’s.” Midnight on January 2 isn’t nearly as special, and clearly an hour after midnight isn’t as special either.</pre>
    
        Method signature:
        ```
        public static LocalDate of(int year, int month, int dayOfMonth) 
        public static LocalDate of(int year, Month month, int dayOfMonth)
        public static LocalTime of(int hour, int minute)
        public static LocalTime of(int hour, int minute, int second)
        public static LocalTime of(int hour, int minute, int second, int nanos)

        public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute)
        public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second) 
        public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos) 
        public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute)
        public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second) 
        public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanos) 
        public static LocalDateTime of(LocalDate date, LocalTime)
        ```

        ```
        System.out.println(LocalDate.now());        //2015-01-20
        System.out.println(LocalTime.now());        //12:45:18.401
        System.out.println(LocalDateTime.now());    //2015-01-20T12:45:18.401

        //Date
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20); 
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        //Time
        LocalTime time1 = LocalTime.of(6, 15);  // hour and minute
        LocalTime time2 = LocalTime.of(6, 15, 30);  // + seconds
        LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

        //Combine date and time
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30); 
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

        ```

        The date and time classes have private constructors to force you to use the static methods:
        Not allowed to construct a date or time object directly.
        ```
        LocalDate d = new LocalDate(); // DOES NOT COMPILE
        LocalDate.of(2015, Month.JANUARY, 32) // throws DateTimeException
        ```
    
    - Manipulating Dates and Times

        Plus day
        ```
        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20); 
        System.out.println(date); // 2014-01-20
        date = date.plusDays(2);
        System.out.println(date); // 2014-01-22
        date = date.plusWeeks(1);
        System.out.println(date); // 2014-01-29
        date = date.plusMonths(1); 
        System.out.println(date); // 2014-02-28
        date = date.plusYears(5); 
        System.out.println(date); // 2019-02-28
        ```
        Minus day
        ```
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);   // 2020-01-20T05:15
        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime);   // 2020-01-19T05:15
        dateTime = dateTime.minusHours(10); 
        System.out.println(dateTime);   // 2020-01-18T19:15
        dateTime = dateTime.minusSeconds(30); 
        System.out.println(dateTime);   // 2020-01-18T19:14:30
        ```
        Chained
        ```
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(date2, time).minusDays(1).minusHours(10).minusSeconds(30);
        ```
        Note that Date is immutalbe type, make sure the return value of a method call isn’t ignored.
        ```
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
        date.plusDays(10);
        System.out.println(date); // 2020-01-20
        ```
    
        LocalDate does not contain time, so you can not add minutes to it 
        ```
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
        date = date.plusMinutes(1); // DOES NOT COMPILE
        ```
        
        Methods in LocalDate, LocalTime, and LocalDateTime
        
        Methods LocalDate => plusYears/minusYears, plusMonths/minusMonths, plusWeeks/minusWeeks, plusDays/minusDays.
        Methods LocalTime => plusHours/minusHours, plusMinutes/minusMinutes, plusSeconds/minusSeconds, plusNanos/minusNanos.
        Methods LocalDateTime includes both LocalDate and LocalTime.
        
    - Working with Periods
    
        ```
        Period annually = Period.ofYears(1); // every 1 year 
        Period quarterly = Period.ofMonths(3); // every 3 months
        Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks 
        Period everyOtherDay = Period.ofDays(2); // every 2 days
        Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days
        ```

        Period.ofXXX methods are static methods so you cannot chain methods when creating a Period. That’s why the of() method allows us to pass in the number of years, months, and days.
        2 methods below are the same
        ```
        Period wrong = Period.ofYears(1).ofWeeks(1); // every week
        
        Period wrong = Period.ofYears(1); 
        wrong = Period.ofWeeks(7);
        ```

        Objects can use with Period
        ```
        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Period period = Period.ofMonths(1);
        System.out.println(date.plus(period)); // 2015-02-20
        System.out.println(dateTime.plus(period)); // 2015-02-20T06:15
        System.out.println(time.plus(period)); // UnsupportedTemporalTypeException
        ```
        pay attention to the type of date and time objects
        
    - Formatting Dates and Times

        **DateTimeFormatter** is in the package java.time.format. It can be used to format any type of date and/or time object

        ```
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(date .format(DateTimeFormatter.ISO_LOCAL_DATE)); //2020-01-20
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));  //11:12:34
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); //2020-01-20T11:12:34
        ```
        ISO is a standard for dates. 

        Some useful predefined formats:
        ```
        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(dateTime)); // 1/20/20 
        System.out.println(shortDateTime.format(date)); // 1/20/20 
        System.out.println(shortDateTime.format(time)); // UnsupportedTemporalTypeException
        ```

        DateTimeFormatter f = DateTimeFormatter._____ (FormatStyle.SHORT);
        DateTimeFormatter f = DateTimeFormatter._____ (FormatStyle.MEDIUM);
        
        `ofLocalizedDate` => Throws runtime exception when call `f.format(localTime)`
        
        `ofLocalizedDateTime` => Legal all

        `ofLocalizedTime` => Throws runtime exception when call `f.format(localDate)`

        ```
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
        LocalTime time = LocalTime.of(11, 12, 34); 
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(shortF.format(dateTime));    // 1/20/20 11:12 AM
        System.out.println(mediumF.format(dateTime));   // Jan 20, 2020 11:12:34 AM
        ```

        Create format
        ```
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm"); 
        System.out.println(dateTime.format(f)); // January 20, 2020, 11:12
        ```
        - MMMM M represents the month. M outputs 1, MM outputs 01, MMM outputs Jan, and MMMM outputs January.
        - dd d represents the date in the month. dd means to include the leading zero for a single-digit month.
        - Use , if you want to output a comma (this also appears after the year).
        - yyyy y represents the year. yy outputs a two-digit year and yyyy outputs a four-digit year.
        - hh h represents the hour. Use hh to include the leading zero if you’re outputting a single- digit hour.
        - : Use : if you want to output a colon. 
        - mm m represents the minute.

        ```
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm"); 
        f.format(dateTime);
        f.format(date); => Throw exception
        f.format(time);
        ```

    - Parsing Dates and Times
        ```
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy"); 
        LocalDate date = LocalDate.parse("01 02 2015", formatter);
        LocalTime time = LocalTime.parse("11:22"); 
        System.out.println(date); // 2015-01-02 
        System.out.println(time); // 11:22
        ```

### Summary
    - Strings are immutable sequences of characters, concatenation operator (+) creates a new String
    - If either operand involved in the + expression is a String, concatenation is used; otherwise, addition is used. 
    - String literals are stored in the string pool
    - All String methods: charAt(), concat(), endsWith(), equals(), equalsIgnoreCase(), indexOf(), length(), replace(), startsWith(), substring(), toLowerCase(), toUpperCase(), and trim()

    - StringBuilders are mutable sequences of characters. Most of the methods return a reference to the current object to allow method chaining
    - All StringBuilders methods:  append(), charAt(), delete(), deleteCharAt(), indexOf(), insert(), length(), reverse(), substring(), and toString()
    - StringBuffer is the same as StringBuilder except that it is thread safe

    - Calling == on String objects will check whether they point to the same object in the pool
    - Calling == on StringBuilder references will check whether they are pointing to the same StringBuilder object
    - Calling equals() on String objects will check whether the sequence of characters is the same
    - Calling equals() on StringBuilder objects will check whether they are pointing to the same object rather than looking at the values inside

    - An array is a fixed-size area of memory on the heap that has space for primitives or pointers to objects, specify the size when creating it
    - The Arrays.sort() method sorts an array
    - Arrays.binarySearch() searches a sorted array and returns the index of a match
    - If no match is found, it negates the position where the element would need to be inserted and subtracts 1
    - Methods that are passed varargs (...) can be used as if a normal array was passed in
    - In a multidimensional array, the second-level arrays and beyond can be different sizes.

    - An ArrayList can change size over its life. It can be stored in an ArrayList or List reference
    - Generics can specify the type that goes in the ArrayList
    - All ArrayList methods: add(), clear(), contains(), equals(), isEmpty(), remove(), set(), and size()
    - Java will autobox parameters passed in to the proper wrapper type, ArrayList is not allowed to contain primitives
    - Collections.sort() sorts an ArrayList.
    
    - A LocalDate contains just a date, a LocalTime contains just a time, and a LocalDateTime contains both a date and time
    - All three have private constructors and are created using LocalDate.now() or LocalDate.of() (or the equivalents for that class)
    - Dates and times can be manipulated using plusXXX or minusXXX methods
    - The Period class represents a number of days, months, or years to add or subtract from a LocalDate or LocalDateTime
    - DateTimeFormatter is used to output dates and times in the desired format. The date and time classes are all immutable, which means the return value must be used.

 ## Chapter 4: Methods and Encapsulation

  - Designing methods

    ![method-signature](https://github.com/sonnth/java-oca-preparation/blob/develop/images/method-signature.png?raw=true)


    

  - Varargs


  - Access Modifiers


  - Passing data


  - Overloading


  - Constructor


  - Encapsulation data


  - Lambdas


### Summary
    - Sonnth

    