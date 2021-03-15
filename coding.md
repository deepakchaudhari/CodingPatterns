# Java Coding Standards

## Table of Contents 
- [ Introduction ](#Introduction)
- [ File Organization ](#FileOrganization)
- [ Designing Classes ](#DesigningClasses)
- [ Method Design ](#MethodDesign)
- [ Exceptions Handling & Logging ](#ExceptionsHandling)
- [ Java Docs & Comments ](#JavaDocs)
- [ Unit Testing](#UnitTesting)


<a name="Introduction"></a>
## Introduction


### What is it?
    
   This document serves as the definition of Martech Platform coding standards for source code in the Java Programming Language


###  Purpose of Having Coding Standards
   
   * To avoid issues in code reviews where people give subjective feedback. This will help to consistent ways of organizing our code. 
   * It will improve the code quality and will save the cost to maintain.
   * Having the same coding pattern improves the readability of the software, allowing engineers to understand new code more quickly and thoroughly. 
   * Ideally a team of developers should agree upon a single formatting style, and then every member of that team should use that style.

<a name="FileOrganization"></a>
## File Organization
   
   * **Classes should be small!** A class should contain an average of less than 30 methods, resulting in up to 900 lines of code.
   * **Dependent Functions should be vertically close** If one function calls another they should be vertically close, and the caller should be above the callee, if at all possible. This gives the program a natural flow.
   * **Variable declarations** Variable should be declared as close to their uses as possible. 
   * **Instance variables** Should be declared at the top of the class.
   
<a name="DesigningClasses"></a>   
## Designing Classes

* **Minimize the accessibility of classes and members** Hide and encapsulate implementation details as much as possible. Classes and their members should be as inaccessible as possible.
* **Always override hashCode() when you override equals()**
* **Avoid cloning unless you really need it.** Generally, the clone() method in Java is thought to be broken, and it's recommended that using copy constructors or copy factories instead.
* **Avoid finalizers** as they slow down performance and run non-deterministically or may never run at all.
* **The Builder pattern should be preferred when a class has several constructors taking different numbers of parameters.**
* **Utility classes should be made noninstantiable** by marking the default constructor private. Classes which group static methods or static fields fall into this category.

<a name="MethodDesign"></a>
## Method Design

* **Methods should be kept small and focused.** A method should implement a single block of functionality.
* **Methods should not have more than an average of 30 code lines** (not counting line spaces and comments).
* **For any publicly exported method, always validate the input parameters to the method.**
* **Avoid defining methods with more than four parameters.** This suggestion comes directly from Joshua Bloch's Effective Java. As the number of parameters to a method increases, it increases the mental burden on the developer to remember the right ones to pass in and can result in errors.
* **Return empty arrays or Collections but not null from methods.** Do Consider Optional<...> as a return for cases where null might be desirable.
* **Always use `````@Override````` when applicable** Always add @Override on methods overriding or implementing a method declared in a super type.

<a name="ExceptionsHandling"></a>
## Exceptions Handling & Logging

* **Include a sensible quantity of logging around changes in functionality.** All new logging should use the 
`````"message=... | foo=... | bar=...````` format.
* **Don't ignore exceptions.** An empty catch block defeats the purpose of exceptions, which is to force you to handle exceptional conditions. Ignoring an exception is analogous to turning off a fire alarm. At the very least, an empty catch block should contain appropriate comments explaining why the developer is choosing to ignore the exception.
* **Exceptions should be either logged or rethrown but not both**
* **Generic exceptions should never be thrown**, Using such generic exceptions as Error, RuntimeException, Throwable, and Exception prevents calling methods from handling true, system-generated exceptions differently than application-generated errors.
* **Try-catch blocks should not be nested.** Nesting try/catch blocks severely impacts the readability of source code because it makes it too difficult to understand which block will catch which exception.
* **Consider the option of separating out try/catch block logic into different methods** and in the try block should only have one or two lines.
* **Provide Context with Exceptions** Each exception that you throw should provide enough context to determine the source and location of an error.
````
throw new MxsServiceException("Failed to get response from MXS", e);
````

<a name="JavaDocs"></a>
## Java Docs & Comments

* **Write doc comments for all exposed API elements**
````
/**
     * Makes a call to the MXS predict endpoint with the given details.
     *
     * @param modelName Name of a model
     * @param modelVersion Version of a model
     * @param body The body payload that will be POSTed
     * @param <T> The response type
     * @return An MXS response marshaled into the given response type
     * @throws MxsServiceException Thrown when there is an issue with the MXS call
     */
````
* **We don't need  java docs/ comments for getters and setters**
* **Avoid using comments similar in context as the following**
````
/**
* Created by **** on mm/dd/yy.
*/
````
  
<a name="UnitTesting"></a>
## Unit Testing
* **Unit tests are required for new code and significant code changes. Please aim for at least 80% diff coverage.**
* **Name your unit tests clearly and consistently**, Please follow below pattern 
````
MethodName_StateUnderTest_ExpectedBehavior
getActiveExperiment_ValidParam_ShouldPass”,
getActiveExperiment_NullParam_ShouldThrowException”
````
* **Test classes should comply with a naming convention** - Ends with 'Test' and starts with the name of the class being tested example 'ClassNameTest'.
* **Aim for each unit test method to perform exactly one assertion**
* **Don’t Extend Existing Tests**, instead create a new test case for the new corner case. 
* **Add Arrange Act Assert Comments in Tests**, The Arrange, Act, Assert (AAA) pattern is used in tests to help organise and clarify test code.
It can also help to spot potential problems in test code if these three phases don’t seem to exist
````
public void getActiveExperiment_ValidParam_ShouldPass(){
//Arrange

//Act

//Assert

}
````

