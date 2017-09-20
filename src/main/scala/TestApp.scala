/**
 *
 */
object CalculateApp extends App {


  val maxRange : Int = 30

  val range:Seq[Byte] = Seq.range(1, 31)
  val number : Byte = 9

  val numbersAllowedInEachColumn: Seq[Seq[Byte]] = Seq.range(0, number).map(x => range.drop(x).dropRight(number - x - 1))
  var numbers: Seq[Seq[Byte]] = numbersAllowedInEachColumn

  var result: Seq[Seq[Byte]] = Seq.empty

  // Cartesian product
  while (numbers.nonEmpty) {
    val first = numbers.head
    if (result.isEmpty) {
      result = first.map(f => Seq(f))
    } else {
      result = first.flatMap(f => result.map(r => if (r.last < f) r ++ Seq(f) else Seq.empty))
        .filter(_.nonEmpty)
    }
    numbers = numbers.tail
  }

  println(s"Range [${range.size}] - numbers on card [$number] - combinations [${result.size}]")

}
