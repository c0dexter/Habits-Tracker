Habit Tracker - Project Specification
=====================================



#Layout
------------


Overall Layout
--------------

No UI is required for this project.




#Functionality
-------------


Compile time Errors
--------------

The code compiles without errors. 


Table Definition
--------------------

There exists a contract class that defines name of table and constants.
Inside the contract class, there is an inner class for each table created. 


Table Creation
------------------

There exists a subclass of SQLiteOpenHelper that overrides onCreate() and onUpgrade().


Data Insertion
------------------

There is a single insert method that adds at least two values of two different datatypes (e.g. INTEGER, STRING) into the database using a ContentValues object and the insert() method.


Data Reading
------------

There is a single read method that returns a Cursor object. It should get the data repository in read and use the query() method to retrieve at least one column of data.


External Libraries and Packages
-------------------------------

No external libraries (e.g. Realm) are used for the database code, and no Content Providers is used. All data insertion and reading should be done using direct method calls to the SQLite database in the SQLiteOpenHelper class. 




#Code Readability
-----------------


Readability
-----------

Code is easily readable such that a fellow programmer can understand the purpose of the app. 


Naming conventions
------------------

All variables, methods, and resource IDs are descriptively named such that another developer reading the code can easily understand their function.


Format
------

The code is properly formatted i.e. there are no unnecessary blank lines; there are no unused variables or methods; there is no commented out code.
The code also has proper indentation when defining variables and methods.
