package org.example

class Exercise {
  fun max(matrix: List<List<Int>>): Int {
    return matrix.flatten().max()
  }

  fun existsWhere(value: Int, matrix: List<List<Int>>): MutableList<Pair<Int, Int>> {
    val positions = mutableListOf<Pair<Int, Int>>()

    for ((indexR, row) in matrix.withIndex()) {
      for ((indexC, column) in row.withIndex()) {
        val pair = Pair(indexR, indexC)
        if (column == value) {
          positions.add(pair)
        }
      }
    }

    return positions
  }

  fun maxWhere(matrix: List<List<Int>>): MutableList<Pair<Int, Int>> {
    return existsWhere(max(matrix), matrix)
  }

  fun printB() {
    val list = mutableListOf<String>()

    do {
      val input = readln()

      list.add(input)
    } while (input != "fim")

    list.forEach({s: String -> if (s[0].lowercase() == "b") println(s)})
  }

  fun helloNotNull(string: String?) {
    if (string != null) println("Olá, $string! Seja bem-vindo.")
  }
}

fun testNotionsExercises() {
  val tester = Exercise()
  val matrix = listOf(listOf(1, 2), listOf(3, 4))

  // Max
  println(tester.max(matrix))

  // ExistsWhere (valor 2)
  println(tester.existsWhere(2, matrix))

  // MaxWhere
  println(tester.maxWhere(matrix))

  // HelloNotNull
  tester.helloNotNull("Arthur")
  tester.helloNotNull(null)

  // printB (Comentado para não travar a execução)
  // tester.printB()
}
