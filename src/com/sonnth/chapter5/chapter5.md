 ## Chapter 5: Class Design

  - Class inheritance
  - Abstract classes
  - Interfaces
  - Polymorphism

    - Object vs Reference

    - Casting Objects	

    - Virtual Methods

	Virtual methods is methods that not determined until runtime

	```
	public class Bird {
		public String getName() {
		return "Unknown"; 
		}

		public void displayInformation() { 
		System.out.println("The bird name is: "+getName());
		}
	}

	public class Peacock extends Bird { 
		public String getName() {
		return "Peacock"; 
		}

		public static void main(String[] args) { 
			Bird bird = new Peacock(); 
			bird.displayInformation();
		} 
	}
	```

	The nature of the polymorphism is that an object can take on many different forms, may be interpreted in vastly different ways at runtime.

    - Polymorphic Parameters 
	Can pass instances of a subclass or interface to a method. Example, define a method takes an instance of an interface as a parameter, any class that implements the interface can be passed to the method

	=> Using superclass or interface type of input parameters whenever possible. It helps code reusability

    - Polymorphism and Method Overriding 
	

## Summary 
