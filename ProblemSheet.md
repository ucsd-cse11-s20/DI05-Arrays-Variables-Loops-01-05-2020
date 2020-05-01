# Discussion 5: Arrays, Variables, and Loops
In this discussion, we are going to practice using Arrays of various types to solve programming tasks. But, since we introduced quite a few new Java features this week, here's the review:

## Review

### Arrays
This week, we learned that we can represent a collection of values in Java using _Arrays_, which hold a *fixed-size*, *indexable* collection of values *of the same type*. Arrays are types similar to the other types we have used (`String`, `int`,`boolean`, `double`) and just like objects are stored on the Heap. However, we learned that, since they represent a collection of another type, their syntax is slightly different.

We saw that an array's type starts with the type of the elements it contains (`int`, `String`, `TextTweet`, etc.) followed by `[]`. To instantiate an array, we assigned it the list of elements separated by `,`, and wrapped with `{` and `}`. For instance, to create an array of integers containing the integers `40`, `50`, and `60`, we wrote:

```java
int[] nums = {4, 2, 7};
```

We also saw that to access a single element of the array, we use the *array index expression*, which is the name of the array, followed by the _index_ of the element we want to access wrapped with `[` and `]`. For instance, to get the _first_ element of the `someNumbers` array above, we wrote:

```java
int firstNumber = nums[0];
```

Note that array indices start at 0, so the _index_ of the first element is _zero_, not one!

Finally, we learned that to get the _length_ of the array, we could use the `length` _field_. Note that this is slightly different to `length` for `String`s, which is a _method_, not a field:

```java
String[] classNames = {"CSE11", "CSE8A", "CSE8B"};
String cse11 = classNames[0];

// Notice the missing parentheses for getting
// the array length
int classNamesLength = classNames.length;
int cse11Length = cse11.length();
```

### Java Programs without the tester library
The next new feature of Java that we learned about was how to write Java programs that accept input and write text to the terminal _without_ using the tester library!

#### Writing to the terminal
When in a method body, we saw that we can write text to the terminal using the special method `System.out.println()` with a single argument we want to be printed out. For instance:

```java
System.out.println("Hello, CSE11");
System.out.println(11);
System.out.println(2.5);
```

when run prints the following in the terminal:

```
Hello, CSE11
11
2.5
```

#### Running any Java program
To run a java program without using the tester library, we saw that we need to write a special method named `main`. Then if we built and ran it using `javac` and `java`, it would evaluate that method's body. For instance, we placed the following code in a file named `MainExample.java`:

```java
class MainExample {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
```

We then built and ran it with these commands:

```log
$ javac MainExample.java
$ java MainExample
Hello!
```

#### The `args` parameter
We saw that the paramenter of the `main` method `String[] args` is an array of the arguments we used when running the program. For instance, for the code:

```java
class MainExample {
    /* ... */

    public static void main(String[] args) {        
        System.out.println(args[0]);
    }
}
```

We saw the following output:

```log
$ javac MainExample.java
$ java MainExample hello
hello
$ java MainExample a
a
```

### Variable Updates
Last week, we learned that, similar to fields that store values in objects, we can store values in methods using _variables_, which had a very similar syntax to field definitions. This week, we learned that we can _update_ these variables' values. To do so, we wrote statements that looked very similar to variable declaration, but (a) used an existing variable's name and (b) did not include the type. For instance, the following code:

```java
class MainExample {
    public static void main(String[] args) {        
        int n = 10; // Variable declaration
        n = 5; // Variable update
        System.out.println(n);
    }
}
```

prints the number `5`:

```log
$ javac MainExample.java
$ java MainExample
5
```

because, we updated the value of `n` to be 5 before printing it. We also saw that, because lines of code in Java run sequentially, changing the value of a variable _after_ it has been used does not affect the original use. For instance, the following code:

```java
class MainExample {
    public static void main(String[] args) {
        int n = 10; // n = 10
        int m = n + 5; // m = 15
        n = n + 10; // n = 10 + 10 = 20
        
        System.out.println(n);
        System.out.println(m);
    }
}
```

prints `15` and `20`:

```log
$ javac MainExample.java
$ java MainExample
15
20
```

### Loops
Another important feature of Java that we learned about this week was how to run a block of code multiple times using "for-loop"s. The first kind of for-loop we saw was the "for-each" or "for-in" _loop_, which executes a block of code for each element of an array. For instance, we wrote a method which returns the average (mean) value of an array of `double`s:

```java
double average(double[] doubles) {
    double total = 0.0;
    for (double d: doubles) {
        total = total + d;
    }
    return total / double.length;
}
```

We then called it with the array `{2.0, 4.0, 1.0}`, which:

1. Initialized the variable `total` to `0.0`.
2. Executed the code `total = total + d` with `d` equal to `2.0`, which updated `total` to `2.0`.
3. Executed the code `total = total + d` with `d` equal to `4.0`, which updated `total` to `6.0`.
4. Executed the code `total = total + d` with `d` equal to `1.0`, which updated `total` to `7.0`.
5. Returned the result of dividing `total` (`7.0` in this case) by the length of `doubles` (`3` in this case).

The second kind of for-loop we learned about was the "counted for-loop" which had the following structure:

```java
for (/* initialization statement */; /* loop condition */; /* update expression */) {
    /* loop body */
}
```

and was executed like so:

1. Run the initialization statement.
2. Evaluate the loop condition. If it evaluates to false, exit the loop.
3. Evaluate the loop body.
4. Evaluate the update expression.
5. Go back to step 2.

This gave us more fine-grained control when accessing elements in a list. For example, the for-loop in the following code:

```java
class MainExample {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        for (int i = 0; i < nums.length; i = i + 1) {
            System.out.println(nums[i]);
        }
    }
}
```

prints `1`, `2`, and `3`:

```log
$ javac MainExample.java
$ java MainExample
1
2
3
```

while this code (notice the difference in the initalization statement):

```java
class MainExample {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        for (int i = 1; i < nums.length; i = i + 1) {
            System.out.println(nums[i]);
        }
    }
}
```

only prints `2` and `3`:

```log
$ javac MainExample.java
$ java MainExample
2
3
```


## Problems

### Problem 1: Array Warmup
In the file `Discussion05.java`, where we have already defined two classes `Book` and `Discussion05`. In the `Discussion05` class, define a new field named `books` which stores a reference to an array containing the following four books:

1. "The Fellowship of the Ring" by "J.R.R. Tolkien" costing $7.99
2. "The Two Towers" by "J.R.R. Tolkien" costing $7.99
3. "The Return of the King" by "J.R.R. Tolkien" costing $3.99
4. "War and Peace" by "Leo Tolstoy" costing $15.99

### Problem 2: Main and Writing to the terminal
In the `Discussion05` class, defined a `main` method for running the program. Using this method, write a program that prints the four books in the `books` field to the terminal in the following format:

```log
$ javac Discussion05.java
$ java Discussion05
The Fellowship of the Ring by J.R.R. Tolkien, $7.99
The Two Towers by J.R.R. Tolkien, $7.99
The Return of the King by J.R.R. Tolkien, $3.99
War and Peace by Leo Tolstoy, $15.99
```

You might find the `toText()` method defined in the `Book` class useful for this.

### Problem 3: Filtering using arguments
Extend the main method from problem 2 such that if the user provides the argument `--author` followed by a second argument containing the name of the author, the program only prints the books whose author is equal to the second argument. For example:

```log
$ javac Discussion05.java
$ java Discussion05
The Fellowship of the Ring by J.R.R. Tolkien, $7.99
The Two Towers by J.R.R. Tolkien, $7.99
The Return of the King by J.R.R. Tolkien, $3.99
War and Peace by Leo Tolstoy, $15.99
$ java Discussion05 --author "J.R.R. Tolkien"
The Fellowship of the Ring by J.R.R. Tolkien, $7.99
The Two Towers by J.R.R. Tolkien, $7.99
The Return of the King by J.R.R. Tolkien, $3.99
$ java Discussion05 --author "Leo Tolstoy"
War and Peace by Leo Tolstoy, $15.99
$ java Discussion05 --author "Neil Gaiman"
```

You can assume that the user will always provide exactly one author name.

### Problem 4: Variable update
Extend the main method from problem 3 such that if the user provides the argument `--buy` followed by the title of one or more books, the program prints the total price of all the books given by the argument. For example:

```log
$ javac Discussion05_solution.java
$ java Discussion05 --buy "The Two Towers"
7.99
$ java Discussion05 --buy "The Return of the King"
3.99
$ java Discussion05 --buy "The Two Towers" "The Return of the King"
11.98
$ java Discussion05 --buy "The Fellowship of the Ring" "The Two Towers" "The Return of the King"
19.97
```

You can assume that the user will always provide _at least_ one book name.