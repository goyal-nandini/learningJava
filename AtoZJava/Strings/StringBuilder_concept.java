package Strings;


public class StringBuilder_concept {
    public static void main(String[] args) {
        //INITIALIZATION:
//1️⃣ Empty StringBuilder
// Creates a StringBuilder with no characters in it (ready to start building a new string):

        StringBuilder sb1 = new StringBuilder();
//2️⃣ With an Initial String
// Creates a StringBuilder initialized with the contents of the given string:

        StringBuilder sb2 = new StringBuilder("hello");
// Now, sb contains “hello”.

//3️⃣ With Initial Capacity
// Creates a StringBuilder with a given capacity (useful if you know roughly how large your string will be, for efficiency):

        StringBuilder sb3 = new StringBuilder(100); // capacity for 100 characters

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<26; i++){
            char ch = (char)('a' + i);
            builder.append(ch);
        }
        System.out.println(builder); //Automatically calls toString() under the hood.
        /*This works without calling toString() explicitly because println() automatically calls toString()
        on any object.
That's why it prints the characters you appended — but it does not give you a String object to work with.*/

        builder.toString(); // Returns a String, but you're not storing it, so it’s discarded
        // do this:
        String str = builder.toString();// 👇👇👇📍📍📍

        System.out.println(str);
        /*Now you have an actual String, which you can:
                pass to methods expecting String
                use with substring(), split(), replace(), etc.
                return from a method that needs to return a String
        StringBuilder doesn’t have those methods — it only allows mutation.
        * */

    }
}
