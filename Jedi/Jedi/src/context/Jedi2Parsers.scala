package context
import scala.util.parsing.combinator._
import expression._
import value._

class Jedi2Parsers extends Jedi1Parsers {
  // params parser
  // a parameter list is zero or more comma-separated identifiers bracketed by parentheses:
  // params ::= "(" ~ (identifier ~ ("," ~ identifier)*)? ~ ")"
  def params: Parser[List[Identifier]] = "(" ~> opt(identifier ~ rep("," ~> identifier)) <~ ")" ^^ {
    case None => Nil
    case Some(e ~ Nil) => List(e)
    case Some(e ~ more) => e :: more
  }
  
  // lambda parser
  // lambda ::= "lambda" ~ params ~ expression
  def lambda: Parser[Lambda] = "lambda" ~ params ~ expression ^^ {
    case "lambda" ~ params ~ expression => Lambda(params, expression)
  }
  
  // block parser
  // a block is one or more semi-colon separated expressions bracketed by curly braces:
  // block ::= "{" ~ expression ~ (";" ~ expression)* ~ "}"
  def block: Parser[Block] = "{" ~> expression ~ rep(";" ~> expression) <~ "}" ^^ {
    case expression ~ Nil => Block(List(expression))
    case expression ~ moreExpressions => Block(expression :: moreExpressions)
  }
  
  // override of term parser
  override def term: Parser[Expression]  = lambda | funCall | block | literal | "("~>expression<~")"
  
}



/** Test outputs:

-> def pi = 3.14
ok
-> def pi2 = {def x = 2; 2 * pi}
ok
-> write(pi2)
6.28
done
-> def fun1 = lambda(x, y) 3 * x + 2 * y
ok
-> fun1(5, 7)
29
-> def tri = lambda(n) if (n == 0) 0 else n + tri(n - 1)
ok
-> tri(5)
15
-> tri(6)
21
-> def square = lambda(x) x * x
ok
-> def addx = lambda(x) lambda(y) x + y
ok
-> def add5 = addx(5)
ok
-> add5(9)
14
-> def compose = lambda(f, g) lambda(z) f(g(z))
ok
-> def add5square = compose(square, add5)
ok
-> add5square(3)
64
-> def fun2 = {def x = 10; lambda(y) x * y}
ok
-> fun2(5.5)
55.0
-> def fun3 = lambda (y) { def x = 10; x * y}
ok
-> fun3(5.5)
55.0
bye


*/