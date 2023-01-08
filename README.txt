#Threads and ThreadPool

In our project after we compare between the times it took to do the same task like counting lines in files but in differents technique,

At first we created 10,000 files with random amount of lines. In our main we measure the time it took to the different techniques 
to count the lines in all of the files.

The first technique - using a regular function with no threads = 10.3 sec.
The second technique - using multiple threads = 4.819 sec.
The third technique - using threadpool = 7.503 sec

Secondly we created 1,000 files

The first technique - using a regular function with no threads = 2.125 sec.
The second technique - using multiple threads = 0.672 sec.
The third technique - using threadpool = 0.675 sec


We have got to conclusion that using threads helps the project to run faster rather than using a regular function.
Threads can be executed concurrently, while regular functions are executed sequentially.

When you create a new thread, it is scheduled by the operating system to be executed concurrently with other threads.
This means that the CPU can switch between different threads and execute them in parallel,
improving the overall performance of the program.

On the other hand, regular functions are executed sequentially in the order they are called.
This means that the CPU executes one function at a time, and it cannot switch to another function until
the current function has finished executing.

Therefore, we assumes that if you have a program that performs a lot of independent tasks that can be parallelized,
using threads can improve the performance of the program by allowing the tasks to be executed concurrently.
However , notice that when using a lot of file we use a lot of resources so we need to take it into account.



