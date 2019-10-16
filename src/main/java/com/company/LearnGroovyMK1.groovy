package com.company

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



















    }
}
