This is the files for the Steria Scala hands-on workshop.

Discover the Power of Sharing with Steria at [Youtube](http://www.youtube.com/watch?v=XUlcKR25PAQ&feature=related)

It is based on the [Scala Koans](https://github.com/rubbish/scala-koans) by Luke Amdor
and [Extreme Startup](https://github.com/rchatley/extreme_startup) by Richard Chatley
and Matt Wynne.

How to get started:
1. Install git from http://git-scm.com/download
2. git clone http://github.com/steria/scala-workshop.git
3. git submodule init
4. Install [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk-6u31-download-1501634.html)
5. Install a text editor (we recommend [Notepad++](http://notepad-plus-plus.org/download/v5.9.8.html))
   # Copy [userDefinedLang.xml]() to %APPDATA%\Notepad++
6. Have a Scala syntax reference ready (we recommend [this one](http://www.scala-lang.org/sites/default/files/pdfs/Scala%20Quick%20Reference.pdf))

Running koans
-------------
1. `cd exercises/scala-koans`
2. `koans`

Playing Extreme Startup
-----------------------
1. `cd exercises/extreme_startup_server/scala/scalatra_for_dummies`
2. `sbt ~test`
3. `sbt run`

Doing the Yahtzee kata
----------------------
1. `cd exercises\scala-yahtzee-kata`
2. `sbt ~test`
3. Place tests under src/test/scala and production code under `src/main/scala`

What's here?
============
The installation disk already contains:
* [Java JDK 1.6](http://www.oracle.com/technetwork/java/javase/downloads/jdk-6u31-download-1501634.html)
* [Notepad++](http://notepad-plus-plus.org/download/v5.9.8.html)
* Notepad++ Scala Syntax from Scala 
* [Scala Syntax Reference](http://www.scala-lang.org/sites/default/files/pdfs/Scala%20Quick%20Reference.pdf)
