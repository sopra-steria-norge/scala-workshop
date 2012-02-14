package org.scalakoans

import support.KoanSuite

class AboutRegularExpressions extends KoanSuite {

  koan ("regular expressions match substrings") {
    val expression = """wor""".r
    expression.findFirstIn("hello world").orNull should be ("wor")
  }

  koan ("regular expressions will match nothing if no match") {
    val expression = """wor""".r
    expression.findFirstIn("hello there").orNull should be (null)
  }

  koan ("regular expressions can be used in matchers") {
    val expression1 = "hello there".r
    val expression2 = "hello world".r
    var result:String = null
    
    "hello world" match {
      case expression1() => result = "there"
      case expression2() => result = "world"
      case _ =>             result = "no match"
    }

    result should be("world")
    //mediate
    // change the matched string to make each of the following pass
    // result should be("there")
    // result should be("no match")
  }

  koan ("expressions can extract values") {
    val SumExpression = """the sum of (.) and (.)""".r
    val SumExpression(a, b) = "the sum of 1 and 2"
    a should be("1")
    b should be("2")
  }

  koan ("match zero or more characters") {
    val expression = """h(a*)llo there""".r
    "haaaaaaallo there" match {
      case expression(s) => s should be("aaaaaaa")
      case _ => fail()
    }
  }
  
  koan ("match zero characters") {
    val expression = """h(a*)llo""".r
    "hllo" match {
      case expression(s) => s should be("")
      case _ => fail()
    }
    // meditate
    // what happens if you change val expression = """h(a+)llo""".r
  }
  
  koan ("doesn't match partial string") {
    val nonPartialExpression = """hello""".r
    val frontPartialExpression = """.*hello""".r
    val endPartialExpression = """hello.*""".r
    val fullPartialExpression = """.*hello.*""".r
    var result:String = "no match"
    "oh, hello there" match {
      case nonPartialExpression() => result = "non partial match"
      case frontPartialExpression() => result = "front partial match"
      case endPartialExpression() => result = "end partial match"
      case fullPartialExpression() => result = "full partial match"
    }
    result should be("full partial match")
  }
  
  koan ("numeric match") {
    val numericMatch = """the answer is (\d+)""".r
    "the answer is 123" match {
       case numericMatch(number) => number should be("123")
       case _ => fail("should match")
    }
  }
  
}
