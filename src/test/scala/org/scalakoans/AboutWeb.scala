package org.scalakoans

import support.KoanSuite
import org.scalatra._
import org.scalatra.test.scalatest._
import java.net.{URL, HttpURLConnection, InetAddress, InetSocketAddress, Proxy}
import java.io.{ InputStream, OutputStream }

class AboutWeb extends ScalatraSuite with KoanSuite {
	addServlet(classOf[AboutWebServlet], "/*")
	
	koan("basic request") {
		get("/") {
			body should __
		}
	}
	
	koan("basic request params") {
		get("/question") {
			body should __
		}
		
		get("/question?q=Hello+World!") {
			body should __
		}
	}
	
	koan("request with regex matcher") {
		get("/question_with_matcher?q=My+name+is+Fred.+What+is+my+name?") {
			body should be ("Fred")
		}
	}
	
	koan("named request params") {
		get("/users/test") {
			body should equal ("username=___")
			status should __
		}
	}
	
	koan("session variables") {
		val name = "scala koans"
			
		post("/session_variables", "name" -> name) {
			body should __
		}
		
		get("/session_variables") {
			body should __
		}
		
		session {
		  post("/session_variables", "name" -> name) {
			body should include (name)
		  }
		  
		  get("/session_variables") {
			body should include (name)
		  }
		}
	}
	
	koan("get response headers") {
		get("/set_response_headers") {
			header("__") should equal ("World")
		}
	}

	koan("unexisting matchers") {
		get("/foobar") {
			status should __
			body should equal ("page not found")
		}
		
		get("/secret/foobar") {
			body should equal ("foo-bar")
		}
	}

	koan("handle HTTP methods") {
		put("/http_method") {
		  body should __
		}
		
		delete("/http_method") {
			body should __
		}
		
		// send a raw HTTP request using Jettys ServletTester (the 'tester' object)
		val response = tester.getResponses("PUT /http_method HTTP/1.0\r\n\r\n");
		response should __
	}
}

class AboutWebServlet extends ScalatraServlet {
	get("/") {
		"Hello, world!"
	}
	
	get("/users/:username") {
		"username=" + params("username")
	}
	
	get("/question") {
		params.getOrElse("q", "ask a question!")
	}
	
	get("/question_with_matcher") {
		val NameMatcher = """.*m|My name is (.*)\. What is my name.*""".r
		
		params("q") match {
			case NameMatcher(name) => name
			case _ => "Unknown question."
		}
	}
	
	post("/session_variables") {
		session("name") = params("name")
		session.getOrElse("name", "error!")
    }
	
	get("/session_variables") {
		session.getOrElse("name", "error!")
    }
	
	get("/set_response_headers") {
		response.setHeader("Hello", "World")
	}
	
	get("/http_method") {
		response.getWriter.print(request.getMethod)
	}
	
	put("/http_method") {
		response.setContentType("text/html; charset=UTF-8")
		response.getWriter.print(request.getMethod)
	}

	delete("/http_method") {
		response.getWriter.print(request.getMethod)
	}
	
	// hits here if no matcher is found
	notFound {
		requestPath match {
		  case s if s.equals("/secret/foobar") => "foo-bar"
		  case _ => {
			status(404)
			"page not found"
		  }
		}
	}
}
