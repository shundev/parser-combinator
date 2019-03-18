package jp.ed.nnn.parsercombinator

object Parser extends Combinator {
  def apply(input: String): ParseResult[String] = (s("true") | s("false"))(input)
}
