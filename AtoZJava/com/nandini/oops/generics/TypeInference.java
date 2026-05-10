package com.nandini.oops.generics;

// small topic:
/* 🟢
This:
ArrayList<String> list = new ArrayList<>();

Why empty <> works?
Because compiler infers: "String" automatically.

🟢
Before Java 7 people wrote:
ArrayList<String> list = new ArrayList<String>();

Now shortened using: "diamond operator" <>

🟢
Same with Generic Methods
static <T> void show(T value)

Call:
show("Hello");

Compiler infers:
T = String
automatically.*/

public class TypeInference {

}
