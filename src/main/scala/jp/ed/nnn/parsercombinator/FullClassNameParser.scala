package jp.ed.nnn.parsercombinator

case class FullClassName(grade: String, className: String)

object FullClassNameParser extends MyFirstCombinator {
  def grade: Parser[String] = oneOf('1' to '3')
  def className: Parser[String] = oneOf(Seq('A', 'B', 'C', 'D'))
  def fullClassName: Parser[String] = map(combine(grade, className), {
    t: (String, String) => t._1 + '年' + t._2 + '組'
  })
  def apply(input: String): ParseResult[FullClassName] =
    map(
      combine(
        combine(
          combine(
          grade,
          s("年")
          ),
          className
        ),
        s("組")), {
    t: (((String, String), String), String) => FullClassName(t._1._1._1, t._1._2)
  })(input)
}
