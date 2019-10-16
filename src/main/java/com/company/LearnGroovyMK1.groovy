package com.company

import groovy.transform.TypeChecked
import groovy.transform.CompileStatic

class LearnGroovyMK1 {

    static void main(String... args) {
        println 'Groovy world!'


        def x = 1
        println x

        x = new java.util.Date()
        println x

        x = false

        println x

        // empty list
        def technologies = []

        technologies.add("Grails")

        // Left shift adds, and returns the list
        technologies << "Groovy"

        // Add multiple elements
        technologies.addAll(["Gradle"],["Griffon"])

        technologies.remove("Griffon")

        technologies = technologies - 'Grails'

        /*** Iterating Lists ***/

        technologies.each {println "Technology: $it"}

        technologies.eachWithIndex{ it, i -> println "$i: $it" }

        /*** checking list contents ***/

        def contained = technologies.contains('Groovy')

        contained = 'Groovy' in technologies

        technologies.containsAll(['Groovy','Grails'])

        /***Sorting Lists ***/

        technologies.sort()

        // To sort without mutation original, you can do:
        def sortedTechnologies = technologies.sort(false)

        // Replace all elements in the list

        Collections.replaceAll(technologies,'Gradle','gradle')

        Collections.shuffle(technologies,new Random())

        //Clear a list
        Collections.clear()

        //Creating an empty map

        def devMap = [:]

        //map
        devMap = ['name':'Roberto','framework':'Grails','language':'Groovy']

        devMap.put('lastName','Perez')

        devMap.each {println "$it.key: $it.value"}

        devMap.eachWithIndex{ it, i -> println( "$i: $it") }

        assert  devMap.containsKey('name')

        assert devMap.containsValue('Roberto')

        println devMap.keySet()

        println devMap.values()

        assert 'Hello world!' == say()

        assert 'Hi world!' == say('Hi')

        assert 'learn groovy' == say('learn','groovy')

        assert 'learn groovy' == say('learn','groovy')

        /*
            Logical Branching and Looping
         */

        //Groovy supports the usual if - else syntax

        def x2 = 3

        if(x2 ==1){
            println "One"
        } else if(x2==2){
            println "two"
        } else {
            println "X greater than Two"
        }

        def y = 10
        x2 = (y > 1) ? "Worked" : "failed"
        assert x2 == "worked"

        //Groovy supports 'The Elvis Operator' too!
        //Instead of using the ternary operator:

        def b = 0
        for(i in 0 .. 30){
            x += i
        }

        //Iterate over a list
        x = 0
        for(i in [5,3,2,1]){
            x += i
        }

        //Iterate over an array
        def array = (0..0).toArray()
        x = 0
        for(i in array){
            x += i
        }

        def map = ['name':"Roberto",'framework':'Grails','language':'Groovy']

        x = ""
        for(e in map){
            x += e.value
            x += " "
        }
        assert x.equals("Roberto Grails Groovy")

        technologies = ['Groovy','grails','Gradle']

        technologies*.toUpperCase() // Spread operator:


        //def user = User.get(1) //nullsafe
        // def usernaem = user?.username //nullsafe

        /*
            Closures
            A Groovy Closure is like a "code block " or a method pointer. It is a peice of code that is defined and executed at a later point


         */

        def clos = {println "Hello World!"}

        println "Executing the Closure:"

        clos() // calling

        def sum = {a1, b1 -> println a1 + b1}

        sum(2,4)

        // Closures may refer to variables not listed in their parameter list.

        def x3 = 5
        def multiplyBy = {num -> num * x}
        println multiplyBy(10)

        def clos2 = {print it }
        clos2("hi")

        /*
        Groovy can memoize closure results [1][2][3]
         */

        def cl = {a3, b3 -> sleep(3000) a3 + b3}

        def mem = cl.memoize() // that is sick

        // not supported yet?
//        def callClosure(a4,b4){
//            def start = System.currentTimeMillis()
//            mem(a4,b4)
//            println( "")
//        }

        // Expando

        def user = new Expando(name:"Roberto")
        assert 'Roberto' == user.name

        user.lastName = 'Perez'
        assert 'Perez' == user.lastName

        user.showInfo = {
            out ->
                out << "Name: $name"
                out << ", Last name: $lastName"
        }

        def sw = new StringWriter()
        println user.showInfo(sw)

        /*
        Metaprogramming (MOP)
         */

        //Using ExpandoMetaClass to add behaviour

        String.metaClass.testAdd = {
            println 'we added this'
        }

        String x5 = "test"
        x5?.testAdd()

        //Intercepting method calls

        def test = new Test()

        test?.sum(2,3)
        test?.multiply(2,3)

        def fooPattern = /.*foo.*/ // example of a slashy string
        assert fooPattern == '.*foo.*'

        def escapeSlash = /The character \/ is a forward slash/
        assert escapeSlash == 'The character / is a forward slash'

        def multilineSlashy = /one
        two
        three/

        assert multilineSlashy.contains('\n')

        def color = 'blue'

        def interpolatedSlashy = /a $color car/

        assert interpolatedSlashy == 'a blue car'

        // cant have empty string as a slashy

        // $ escape of a slashy

        char c1 ='A'
        assert c1 instanceof Character

        def c2 = 'B' as char
        assert  c2 instanceof Character

        def c3 = (char)'C'
        assert  c3 instanceof Character

        



























    }

    static class Test implements GroovyInterceptable{
        def sum(Integer x, Integer y){x + y}

        def invokeMethod(String name, args){
            System.out.println "Invoke method $name with args: $args"
        }
    }

}
