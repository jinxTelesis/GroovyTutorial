package com.company

class Foo {


    // read only property
    final String name = "Roberto"

    // read only property with public getting and protected setter
    String language
    protected  void setLanguage(String language){this.language = language}

    // dynamically typed property
    def lastName




    // It can be called in 3 different ways


}

def say(msg = 'Hello', name = 'world'){
    "$msg $name!"
}
