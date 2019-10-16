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

















    }
}
