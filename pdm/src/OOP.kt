package org.example

import kotlin.math.PI
import kotlin.math.pow

class BankAccount(val bearer: String, var balance: Double) {
  var number: Int

  companion object {
    var count = 0
      private set
  }

  init {
    count++
    number = count
  }

  fun deposit(value: Double) {
    require(value > 0) {"Valor inválido! Deve ser maior que 0."}

    balance += value
  }

  fun getCount(): Int {
    return count
  }

  fun withdraw(value: Double) {
    require(value > 0) {"Valor inválido! Deve ser maior que 0."}
    require(value <= balance) {"Valor inválido! Saldo insuficiente."}

    balance -= value
  }

  override fun toString(): String {
    return """
            Bearer: $bearer,
            Balance: $balance,
            Number: $number
            
        """.trimIndent()
  }
}

fun testBankAccount() {
  val ac1 = BankAccount("Arthur", 0.0)
  val ac2 = BankAccount("José", 0.0)

  ac1.deposit(100.0)
//    ac1.deposit(-100.0)

  ac2.deposit(100.0)
  ac2.withdraw(100.0)
//    ac2.withdraw(-100.0)

  println(ac1)
  println(ac2)
  println(BankAccount.count)
}

open class Vehicle(val brand: String, val model: String) {
  open fun showInfo(): String {
    return """
      Model: $model,
      Brand: $brand
      
    """.trimIndent()
  }

}

class Car(brand: String, model: String, val numberOfDoors: Int = 2) : Vehicle(brand, model) {
  override fun showInfo(): String {
    return """
      Model: $model,
      Brand: $brand,
      Number of doors: $numberOfDoors
      
    """.trimIndent()
  }
}

fun showData(v: Vehicle) {
  println(v.showInfo())
}

fun testVehicle() {
  val v1 = Vehicle("Mercedez", "A-Class")
  val v2 = Car("Fiat", "Uno")

  showData(v1)
  showData(v2)
}

abstract class Employee {
  abstract val name: String
  abstract val baseSalary: Double

  open fun getSalary(): Double {
    return baseSalary
  }
}

class Manager(override val name: String, override val baseSalary: Double, val bonus: Double) : Employee() {
  override fun getSalary(): Double {
    return baseSalary + bonus
  }
}

fun testEmployee() {
  val m = Manager("Paulo", 1000.57, 150.90)

  println(m.getSalary())
}

interface Shape {
  fun calculateArea(): Double
}

class Circle(val radius: Double) : Shape {
  override fun calculateArea(): Double {
    return PI * (radius.pow(2))
  }

}

class Rectangle(val side: Double) : Shape {
  override fun calculateArea(): Double {
    return side.pow(2)
  }
}

fun testShape() {
  val list: List<Shape> = listOf(
    Circle(5.0),
    Circle(4.6),
    Circle(8.0),
    Rectangle(12.0),
    Rectangle(19.0),
    Rectangle(2.0),
    Rectangle(7.0),
    Rectangle(10.0),
    Circle(2.0)
  )

  list.forEach { println(it.calculateArea()) }
}
