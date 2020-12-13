 ## Chapter 4: Methods and Encapsulation

  - Designing methods

    ![method-signature](https://github.com/sonnth/java-oca-preparation/blob/develop/images/method-signature.png?raw=true)

    Explain:
    
    | Element | Value | Required? |
    | --- | --- | --- |
    | Access modifier | public | No |
    | Optional specifier | final | No |
    | Return type | void | Yes |
    | Method name | nap | Yes |
    | Parameter list | int minutes | Yes, but can be empty |
    | Optional exception list | throws InterruptedException | No |
    | Method body | {// take a nap} | Yes, but can be empty |

    - **Access Modifiers**

        Four choices:
        - ___public___ The method can be called from any class.
        - ___private___ The method can only be called from within the same class.
        - ___protected___ The method can only be called from classes in the same package or subclasses.
        - ___Default (Package Private)___ Access The method can only be called from classes in the same package. This one is tricky because there is no keyword for default access. You simply omit the access modifier.

    - **Optional Specifiers**

        You can have multiple specifiers in the same method (although not all combinations are legal), specify them in any order.
        - ___static___ Covered later in this chapter. Used for class methods.
        - ___abstract___  Used when not providing a method body.
        - ___final___ Used when a method is not allowed to be overridden by a subclass.
        - ___synchronized___ make the method synchronized
        - ___native___  Used when interacting with code written in another language such as C++.
        - ___strictfp___ Used for making floating-point calculations portable.

    - **Return Type**

        A method must have a return type. If no value is returned, the return type is void. You cannot omit the return type.
        
        ```
        String walk6(int a) { if (a == 4) return ""; } // DOES NOT COMPILE
        ```
        There is a return statement, but it doesn’t always get run. If a is 6, the return statement doesn’t get executed. Since the String always needs to be returned, the compiler complains.
    
    - **Method Name**
    
        Method names follow the same rules as variable names: only contain letters, numbers, $, or _, the first character is not allowed to be a number, and reserved words are not allowed.

    - **Parameter List**
    
        The parameter list is required, it doesn’t have to contain any parameters. This means you can just have an empty pair of parentheses after the method name, such as void nap(){}. If you do have multiple parameters, you separate them with a comma.
        
    - **Optional Exception List**

        Indicate that something went wrong by throwing an exception.
    
    - **Method Body**

        A method body is simply a code block (except for abstract methods and interfaces, but you don’t need to know about either of those until next chapter)

  - Varargs

    Varargs (variable argument) as if it is an array, just a little different. 
    A vararg parameter must be the last element in a method’s parameter list. 
    Only allowed to have one vararg parameter per method.

    ```
    public void walk1(int... nums) { }
    public void walk2(int start, int... nums) { }
    public void walk3(int... nums, int start) { } // DOES NOT COMPILE 
    public void walk4(int... start, int... nums) { } // DOES NOT COMPILE

    public static void walk(int start, int... nums) { 
    System.out.println(nums.length);
    }
    public static void main(String[] args) {
    walk(1); // 0 20: walk(1, 2); // 1
    walk(1, 2, 3); // 2 
    walk(1, new int[] {4, 5}); // 2 
    }
    ```

    When calling a method with a vararg parameter, you have a choice. You can pass in an array, or you can list the elements of the array and let Java create it for you. You can even omit the vararg values in the method call and Java will create an array of length zero for you.

  - Access Modifiers

    - Access modifiers

    <b>Can access</b> | <b>If that member is private?</b> | <b>If that member has defau (package private) access?</b> | <b>If that member is protected?</b> | <b>If that member is public?</b>
    --- | --- | --- | --- | --- |
    Member in the same class | Yes | Yes |Yes | Yes
    Member in another class in same package | No | Yes |Yes | Yes
    Member in a superclass in a different package | No | No | Yes | Yes
    Method/field in a non- superclass class in a different package | No | No | No | Yes

    - Designing Static Methods and Fields

        - Static methods don’t require an instance of the class, they are share among all users of the class

        - Pay attention to the reference type for a variable when you see a static method or variable

        - A static member cannot call an instance member

    Type | Calling | Legal? | How?
    --- | --- | --- | ---
    Static method | Another static method or variable | Yes | Using the classname
    Static method | An instance method or variable | No | 
    Instance method | A static method or variable | Yes | Using the classname or a reference variable
    Instance method | Another instance method or variable | Yes | Using a reference variable
    
    - Static Variables

        Some static variables are meant to change as the program runs. Counters are a common example of this

        Some static variables are meant to never change during the program( called constant).
        
        ~~~ static variables
        private static final int NUM_BUCKETS = 45;
        private static final ArrayList<String> values = new ArrayList<>(); 
        public static void main(String[] args) {
        values.add("changed"); 
        }
        ~~~
        Values is a reference variable. We call methods on reference variables. All the compiler can do is check that we don’t try to reassign the final values to point to a different object.
        
    - Static Initialization

        The static initializer is a `static {}` block of code inside java class, and run only one time before the constructor or main method is called.
        ```
        static
        {
        statements...
        }
        ```

        ```
        private static int one;
        private static final int two;
        private static final int three = 3;
        private static final int four;  //DOES NOT COMPILE
        static {
        one = 1;
        two = 2;
        three = 3;  //DOES NOT COMPILE
        two = 4;    //DOES NOT COMPILE
        }
        ```

    - Static Import
    
        Static import use to access the static members of a class directly without class name or any object
        ```
        import static java.util.Arrays; // DOES NOT COMPILE 
        import static java.util.Arrays.asList;
        static import java.util.Arrays.*; // DOES NOT COMPILE 
        
        public class BadStaticImports {
        public static void main(String[] args) { 
            Arrays.asList("one"); // DOES NOT COMPILE
            } 
        }
        ```
        If two static members of the same name are imported from multiple different classes, the compiler will throw an error, as it will not be able to determine which member to use in the absence of class name qualification.

  - Passing data among methods
  
    Java is a “pass-by-value” language, it means that a copy of the variable is made and the method receives that copy. Assignments made in the method do not affect the caller

    **Pass-by-Value**

    ```
    public static void main(String[] args) { 
    int original1 = 1;
    int original2 = 2;
    swap(original1, original2); 
    System.out.println(original1); 
    System.out.println(original2);
    }

    public static void swap(int a, int b) {
    int temp = a; a = b;
    b = temp;
    }
    ```

    **Pass-by-Reference**

    ```
    original1 = 1;
    original2 = 2; 
    swapByReference(original1, original2);
    print(original1); 
    print(original2);
    
    swapByReference(a, b) { 
    temp = a;
    a = b;
    b = temp;
    }
    ```

  - Overloading Methods

    Overloading allows different methods to have same name but different signatures (number of input parameters, type of input or both). It relates to polimorphism

    These are all valid overloaded methods:

    ```
    public void fly(int numMiles) { }
    public void fly(short numFeet) { }
    public boolean fly() { return false; }
    void fly(int numMiles, short numFeet) { }
    public void fly(short numFeet, int numMiles) throws Exception { }
    ```

    Some invalid overloading:

    ```
    public void fly(int numMiles) { }
    public int fly(int numMiles) { } // DOES NOT COMPILE

    public void fly(int numMiles) { }
    public static void fly(int numMiles) { } // DOES NOT COMPILE
    ```

    - Overloading and Varargs

        Java treats varargs as if they were an array, it means method signature is the same for both methods

        ```
        public void fly(int[] lengths) { }
        public void fly(int... lengths) { } // DOES NOT COMPILE
        ```

    - Autoboxing

        When the primitive version isn't present, it will autobox. However, when the primitive  version is provided, Java will not do the extra work of autoboxing.

        ```
        public void fly(int numMiles) { } 
        public void fly(Integer numMiles) { }
        ```

    - Reference Types

        If you are using wrapper class Object as an actual argument and compiler does not find the method with parameter(s) of the same reference type (i.e. class or interface type), then it starts searching a method with parameter(s) having the corresponding primitive data type.    

        ```
        public class ReferenceType {
            public void fly(String s) {
                System.out.print(s);
            }

            public void fly(Object o) {
                System.out.print(o);
            }

            public static void main(String[] args) {
                ReferenceType r = new ReferenceType();
                r.fly("3");
                r.fly(3);
            }
        }
        ```

    - Primitives

        Primitives work in a way similar to reference variables. Java tries to find the most specific matching overloaded method.

        ```
        public class Plane { 
            public void fly(int i) {
                System.out.print("int "); 
            }
            public void fly(long l) { 
                System.out.print("long ");
            }
            public static void main(String[] args) {
                Plane p = new Plane(); 
                p.fly(123); 
                p.fly(123L);
            }
        }
        ```

  - Constructor

    Constructor creates a new instance of the class. 
    
    Example: 
    `Bunny bunny = new Bunny()`
    
    When Java sees the new keyword, it allocates memory for the new object. Java also looks for a constructor and calls it.

    **this** keyword tells Java you want to reference an instance variable

    ```
    public class Person {
    private String name;
    private int age;

    public Bunny(String color, int newAge) {
        this.color = color; 
        age = newAge;
        } 
    }
    ```

    - Default Constructor

        - Every class in Java has a constructor without any parameters called _default constructor_. For clarity, sometimes call it the _default no-arguments constructor_

        - This happens during the compile step. If you look at the file with the .java extension, the constructor will still be missing. It is only in the compiled file with the.class extension that it makes an appearance

        - There no default constructor if already define one

        - Having a private constructor in a class tells the compiler not to provide a default no- argument constructor. It also prevents other classes from instantiating the class. This is useful when a class only has static methods or the class wants to control all calls to create new instances of itself.

    - Overloading Constructors

        Have multiple constructors in the same class as long as they have different method signatures

        Using _this_ to call another constructor on the same instance of the class.

        Constructor chaining
        
        ```
        public class Mouse { 
            private int numTeeth; 
            private int numWhiskers; 
            private int weight;
        public Mouse(int weight) {
            this(weight, 16); // calls constructor with 2 parameters
        }
        public Mouse(int weight, int numTeeth) {
            this(weight, numTeeth, 6); // calls constructor with 3 parameters 
        }
        public Mouse(int weight, int numTeeth, int numWhiskers) { 
            this.weight = weight;
            this.numTeeth = numTeeth;
            this.numWhiskers = numWhiskers;
        }
        public void print() {
            
            System.out.println(weight + " " + numTeeth + " " + numWhiskers); }
            
            public static void main(String[] args) { 
                Mouse mouse = new Mouse(15); 
                mouse.print();
            } 
        }
        ```

    - Final Fields

        The constructor is part of the initialization process, so it is allowed to assign final instance variables in it

        ```
        public class MouseHouse {
            private final int volume;
            private final String name = "The Mouse House";
            
            public MouseHouse(int length, int width, int height) {
            volume = length * width * height; 
            }
        }
        ```

    - Order of Initialization

        1. If there is a superclass, initialize it first.
        2. Static variable declarations and static initializers in the order they appear in the file.
        3. Instance variable declarations and instance initializers in the order they appear in the file.
        4. The constructor.

        ```
        public class InitializationOrderSimple { 
            private String name = "Torchie";
            { System.out.println(name); }
            private static int COUNT = 0;
            static { System.out.println(COUNT); }
            static { 
                COUNT += 10; 
                System.out.println(COUNT); 
                } 
            public InitializationOrderSimple() {
            System.out.println("constructor"); 
            } 
        }

        public class CallInitializationOrderSimple { 
            public static void main(String[] args) {
            InitializationOrderSimple init = new InitializationOrderSimple();
            } 
        }

        The output is:
        0
        10
        Torchie 
        constructor
        ```

        ```
        public class YetMoreInitializationOrder {

            static { 
                add(2); 
                }

            static void add(int num) { 
                System.out.print(num + " "); 
                }

            YetMoreInitializationOrder() { 
                add(5); 
                }

            static { 
                add(4); 
                }

            { add(6); }
            
            static { 
                new YetMoreInitializationOrder(); 
                }
            
            { add(8); }
            
            public static void main(String[] args) { } 
        }

        The correct answer is 2 4 6 8 5
        ```

  - Encapsulation data

    _Encapsulation_ prevents other class access instance variable, control of what gets set in our own class

    ```
    public class Swan {
        private int numberEggs; // private 
    
        public int getNumberEggs() { // getter
        return numberEggs; 
        }

        public void setNumberEggs(int numberEggs) { // setter
        if (numberEggs >= 0) // guard condition
        this.numberEggs = numberEggs; 
        } 
    }
    ```

    The JavaBeans naming conventions:

    Rule | Example
    --- | ---
    Properties are private. | private int numEggs;
    Getter methods begin with is if the property is a boolean. | public boolean isHappy() { return happy; }
    Getter methods begin with get if the property is not a boolean. | public int getNumEggs() { return numEggs; }
    Setter methods begin with set. |  public void setHappy(boolean happy) { this.happy = happy;}
    The method name must have a prefix of set/get/is, followed by the first letter of the property in uppercase, followed by the rest of the property name. | public void setNumEggs(int num) { numEggs = num;}

    </br>

    **Creating Immutable Classes**

    Omit the setter to make class immutable
    ```
    public class ImmutableSwan {
        private int numberEggs;
        
        public ImmutableSwan(int numberEggs) {
            this.numberEggs = numberEggs; 
        }

        public int getNumberEggs() { 
            return numberEggs;
        }
    }
    ```

    Problem with Return Types in Immutable Classes
    ```
    public class NotImmutable {
        private StringBuilder builder;
        
        public NotImmutable(StringBuilder b) {
            builder = b; 
        }
        public StringBuilder getBuilder() { 
            return builder;
        }

        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder("initial"); 
            NotImmutable problem = new NotImmutable(sb); 
            sb.append(" added");
            StringBuilder gotBuilder = problem.getBuilder(); 
            gotBuilder.append(" more"); 
            System.out.println(problem.getBuilder()); // Output "initial added more"
        }
    }
    ```

    A solution is to make a copy of the mutable object
    ```
    public Mutable(StringBuilder b) { 
        builder = new StringBuilder(b);
    }

    public StringBuilder getBuilder() {
        return new StringBuilder(builder); 
    }
    ```

    Another approach for the getter is to return an immutable object:
    ```
    public String getValue() { 
        return builder.toString();
    }
    ```
    There’s no rule that says we have to return the same type as we are storing
  
    > Encapsulation refers to preventing callers from changing the instance variables directly. 
    > Immutability refers to preventing callers from changing the instance variables at all.

  - Lambdas

    A lambda expression is a block of code that gets passed around, like an anonymous method. It has parameters and body but doesn't have name. 

    **Syntax**
    - Lambda syntax omitting the optional parts
        - Specify a single parameter with the name a
        - The arrow operator to separate the parameter and body
        - A body that calls a single method and returns the result of that method
        ```
        parameter name
            ↓ 
            a -> a.canHop()
              ↑    ↑  
            arrow  body
        ```

    - Lambda syntax, including optional parts
        - Specify a single parameter with the name a and stating the type is Animal
        - The arrow operator to separate the parameter and body
        - A body that has one or more lines of code, including a semicolon and a return statement
        ```
                parameter name   |        body
                        ↓        |         ↓ 
                (Animal a) -> { return a.canHop(); }
                    ↑            | ↑             ↑
        optional parameter type  | required because in block
        ```

        Some valid lambdas:
        ```
        print(() -> true);  // 0 parameters 
        print(a -> a.startsWith("test"));   // 1 parameter 
        print((String a) -> a.startsWith("test"));  // 1 parameter 
        print((a, b) -> a.startsWith("test"));  // 2 parameters 
        print((String a, String b) -> a.startsWith("test"));    // 2 parameters
        ```
        Invalid lambdas:
        ```
        print(a, b -> a.startsWith("test"));    // DOES NOT COMPILE
        print(a -> { a.startsWith("test"); });  // DOES NOT COMPILE
        print(a -> { return a.startsWith("test") });    // DOES NOT COMPILE
        ```
        
    **Predicate**
    
    Lambdas work with interfaces that have only one method. These are called functional interfaces
    
    Function interfaces: interfaces that can be used with functional programming
    
    => Have to create many interface to use lambdas. This is the reason why java provides Predicate
    
    ```
    public interface CheckFly<T> { 
        boolean test(T t);
    }
    ```
    
    ```
    public class SearchingBird  {
        public static void main(String[] args) {
            List<Bird> birds = new ArrayList<>();
            birds.add(new Bird("chicken", true, false));
            birds.add(new Bird("phoenix", true, false));
            birds.add(new Bird("penguin", false, true));
            print(birds, bird -> !bird.canSwim()); // pass class that does check
        }
    
        private static void print(List<Bird> birds, CheckFly<Bird> checker) {
            for (Bird bird : birds) {
                if (checker.test(bird))
                    System.out.println(bird + " ");
            }
            System.out.println();
        }
    }
    ```
    
### Summary
    - Java methods start with an access modifier of public, private, protected or blank (default access)
    - There are optional specifier such as static, final, or abstract
    - The return type, which is void or a Java type.
    - The method name follows, using standard Java identifier rules
    - Zero or more parameters go in parentheses as the parameter list
    - Zero or more parameters go in parentheses as the parameter list
    - Optional exception types
    - Finally, zero or more statements go in braces to make up the method body.
    
    - __private__ access means available in the same class
    - __Default (package private)__ access means available within the same package
    - __protected__ the same package or subclasses
    - __public__ means available anywhere
    - Static methods and static variables are shared by the class. When referenced outside class, 
      they called using class name StaticClass.method()
    - Instance members can call static members, but static members can not call instance
    - Static imports are used to import static members.
    
    - Java uses pass-by-value, which means that calls to methods create a copy of the parameters. 
      Assigning new values to those parameters in the method doesn’t affect the caller’s variables. 
      Calling methods on objects that are method parameters changes the state of those objects and
      is reflected in the caller.
    - Overloaded methods are methods with the same name but a different parameter list. 
      Java calls the most specific method it can find.
    
    - Constructors are used to instantiate new objects. The default no-argument constructor
      is called when no constructor is coded.
    - Multiple constructors are allowed and can call each other by writing this(). 
      If this() is present, it must be the first statement in the constructor.
    - __this__ write before variable name to indicate instance variables or method parameter
    - The order of initialization is the superclass; static variables and static initializers in the order they appear; 
      instance variables and instance initializers in the order they appear; and finally the constructor.
      
    - Encapsulation refers to preventing callers from changing the instance variables
      by making instance variables private and getters/setters public. 
    - Remove setter to make class immutable, instantiate new objects by constructors
    - JavaBeans use methods beginning with is and get for boolean and non-boolean property types, respectively. 
      Methods beginning with set are used for setters.
      
    - Lambdas are passed to a method expecting an inter- face with one method. Predicate is a common interface.