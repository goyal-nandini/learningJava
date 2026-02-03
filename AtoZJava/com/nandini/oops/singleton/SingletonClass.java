package com.nandini.oops.singleton;

public class SingletonClass {
    // a class which u can create one object of!!
    // create only one object:

    private SingletonClass(){ } // we've make it private so that no one can create objects from this class
    // -> yes one obj can be created which is created by this private method getInstance() and further
    // managed also by this method only!! as if more than one obj is being created then it returns the same reference as
    // the first and only object get!! -> hence, ONLY ONE OBJECT CREATED
//    Nobody from outside can do new SingletonClass()
//    Only the class itself can create objects

    private static SingletonClass instance;
/*Why static?
Shared by all (class-level)
Only ONE copy exists

Why private?
Nobody can directly access/modify it
*/
    public static SingletonClass getInstance(){
        // here only the obj is created for this class
        if(instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }
/*Why static?
Can call without creating object: SingletonClass.getInstance()
*/

/*
KEY Points 📝
✅ Only ONE object can exist
✅ Private constructor prevents new
✅ Static method provides access
✅ Lazy initialization - object created only when needed
⭐⭐⭐
When to Use? 💡
Real examples:

Database connection (only one connection needed)
Logger (only one logger instance)
Configuration manager (only one config)

// Example:
DatabaseConnection db1 = DatabaseConnection.getInstance();
DatabaseConnection db2 = DatabaseConnection.getInstance();
// db1 and db2 are the SAME connection!*/

}
