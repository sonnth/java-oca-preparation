## Chapter 6: Exceptions
 
  - Definition

    - Role of Exceptions

	Exception happens when something so wrong, but "wrong" is subjective. An exception forces program to deal with them or end with exception if unhandled.

	An exception is an event that alters program flow.

    - Exception Types 

	![Exception Type](categories_of_exception.png)

	- __Error__ means something went so horribly wrong that can not recover. For example, the disk drive disappered.These are abnormal conditions that not likely to encounter

	- A __runtime exception__, tent to be unexpected but not necessarily fatal. For example, access an invalid array index is unexpectd(also known as __unchecked exceptions__)

	- A __checked exception__ includes Exception and all subclasses that do not extend RuntimeException. Checked exceptions tend to be more anticipated. For example, trying to read what does not exist.

		```
		void fall() throws Exception {
		  throw new Exception();
		}
		```
	- __throw__ tells Java that you want to throw an Exception, __throws__ declares that the method might throw an Exception or not
    - Throwing an Exception 

		**NOTE**: Pay special attention to code that calls a method on a null or that references an invalid array or ArrayList index.

		We can pass a String parameter with a message or no parameters for the defaults.

		**Important rule**
		![Exception Type](exceptions_type.png)

  - Try statement

    - Finally block

    - Catching type of exceptions

    - Throwing a second exceptions
 
  - Common exception types
 
    - Runtime exceptions
 
    - Checked exceptions
 
    - Errors
    
  - Calling methods that throw exceptions

    - Subclasses
 
    - Printing an Exception
 

## Summary 
