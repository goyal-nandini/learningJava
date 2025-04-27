// static means "belonging to the class, not to objects".

// 4 ways to use static
// 1. static variable
class StudInfo{
    static String school = "ABC";
//    This means no matter how many objects you create, there is only one copy of "school",
//    belonging to the class itself.
//    school is shared. It's not duplicated for every "stud_info".

    void display(){
        System.out.println("My school name is " + school);
    }
}

// 2. static method
class MathUtil{
    static void add(int a, int b){
        System.out.println(a+b);
    }
}

// 3. static block
// A "static block" is a block of code that runs only once — when the class is loaded into
// memory (before any object is created).
// It automatically runs once when the class is loaded into memory.
class Demo{
    static int num;
    static {
        System.out.println("Static block is running...");
        num = 10;
    }
}


// 4. static in nested class
class Outer{
    static class Inner{
        void mess(){
            System.out.println("Hello from static inner class");
        }
    }
}

public class StaticKeyword {
    public static void main(String[] args) {
        StudInfo obj = new StudInfo();
        obj.display();
        System.out.println(StudInfo.school); // static variable accessed by class name

        System.out.println(obj.school); // not recommended
//        obj.school is interpreted by Java as stud_info.school internally.
//        It's just allowed for convenience, but it's not recommended because it
//        looks like you're accessing an object's property (which it isn't)

        MathUtil.add(2, 5); // No object needed

        System.out.println(Demo.num);

        Outer.Inner nestedObj = new Outer.Inner();
        nestedObj.mess();

    }
}

