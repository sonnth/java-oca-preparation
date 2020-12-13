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