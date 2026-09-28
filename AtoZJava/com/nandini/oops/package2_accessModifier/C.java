package com.nandini.oops.package2_accessModifier;

import com.nandini.oops.package1_accessModifier.A;

public class C extends A{
    public static void main(String[] args) {
        A obj = new A();

//        System.out.println(obj.privateVar);  // can't access
//        System.out.println(obj.defaultVar); // access in same package only
//        System.out.println(obj.protectedVar); // can't access when no extend used in class 'C'
        System.out.println(obj.publicVar);

        // after extending class 'A'
        C obj2 = new C();
        System.out.println(obj2.protectedVar); // diff package in subclass, accessed


    }
    void test() {
        A obj = new C(); // upcast, A reference to object of C, Upcasting = treating a subclass object as a parent type
//        System.out.println(obj.protectedVar); // won't work, as reference type matters

//        C obj3 = new A(); ohh downcast unsafe, runtime error,
//        C reference to object of A, A is the parent of C
//        Every C is an A ✔ But every A is NOT a C ❌


    }
}
/*take scenario of not extending class 'A'
we have diff package but imported package 'package1_accessModifier' with class 'A'

🟢🟢Situation 1 (FAILED case ❌)
    A obj = new A();
    System.out.println(obj.protectedVar);

You are in a different package and NOT a subclass
👉 So Java says:
“You are an outsider. No access.”


🟢🟢Situation 2 (WORKS ✅)
    class C extends A {
        public static void main(String[] args) {
            C obj = new C();
            System.out.println(obj.protectedVar);
        }
    }

Now you are:

in a different package ✔
BUT a subclass ✔

👉 Java allows this because:
protected = accessible to subclasses (even in different packages)
*


🟢🟢💥 The KEY RULE (don’t ignore this)

In a different package:

✔ You can access protected
❗ ONLY through inheritance
❗ AND ONLY via 'subclass reference' 🟢🟢🟢

for protected access modifier:
| Case                                            | Works? | Why                    |
| ----------------------------------------------- | ------ | ---------------------- |
| Same package                                    | ✅      | default access allowed |
| Different package + no inheritance              | ❌      | outsider               |
| Different package + subclass + `this`           | ✅      | child access           |
| Different package + subclass + parent reference | ❌      | treated as outsider    |

*/
