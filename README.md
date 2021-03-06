# A Hands-on Introduction to Kotlin

This repository contains code along which to present Kotlin to other programmers who are
familiar with Java. The main example are binary trees.

The goal is to make people excited about Kotlin so they want to learn it, 
not so much to teach them right now.
Therefore, this introduction bothers less with elementary syntax than e.g.
    [kotlin-workshop](https://github.com/JetBrains/kotlin-workshop)
does. Instead we demonstrate some (pseudo)-real code and discover features 
of Kotlin along the way.

We cover the following features of Kotlin:

 * Basic syntax (incidental and thus incomplete; coverage depends on presenter)
 * Null safety through optionals
 * Type inferrer
 * Optional parameters
 * Named parameters
 * Lambdas & higher-order functions
 * String comprehensions
 * Data classes
 * Sealed classes
 * Extensions
 * Java interoperability
    - Basic usage in both directions
    - Synthesized properties resp. getters/setters
    - Null-safety via annotations in Java
    - Lambda compatibility

## Roadmap

 1. Start by showing 
        [`JTree.java`](src/main/java/org/kintro/prepared/JTree.java) 
    and 
        [`JTreeTest.java`](src/test/java/org/kintro/prepared/JTreeTest.java) 
    -- this is just to get people up to speed about what the goal is.
    
 2. Live-code the Kotlin tree implementation.
    Follow the steps outlined in
        [`Ktree.kt`](src/org/kintro/goal/KTree.kt)
    and then
        [`KTree2.kt`](src/org/kintro/goal/KTree2.kt).
        
 3. Demonstrate using Java from Kotlin following the steps outlined in
        [`PersonTest.kt`](src/org/kintro/goal/PersonTest.kt).
        
 4. Demonstrate using Kotlin from Java following the steps outlined in
        [`TreeTest.java`](src/org/kintro/goal/TreeTest.java).
        
You should plan roughly one hour including questions.
        
## More Resources

For _learning_ Kotlin, I recommend:

 * [Official Workshop](https://github.com/JetBrains/kotlin-workshop)
 * [Kotlin Koans](https://github.com/Kotlin/kotlin-koans), 
   also [in the browser](https://try.kotlinlang.org)
 * [Official Reference](https://kotlinlang.org/docs/reference/)
 * [\[kotlin\] on Stack Overflow](https://stackoverflow.com/questions/tagged/kotlin)
 
### Acknowledgements
 
This introduction was developed while preparing an internal training event for 
    [Telepaxx Medical Archiving](https://telepaxx.de)
and reworked for a similar session at
    [codecentric](https://codecentric.de).
