package com.example.assigment1_irfanarrahman

fun main() {
    val transaction = Transaction()
    while (true) {
        println("Personal Finance Manager Apllication")
        println("=======---========")
        println("1. Input pemasukan dan pengeluaran")
        println("2. Perhitungan Saldo")
        println("3. Riwayat Transaksi")
        println("4. Analisis Total")
        println("5. Keluar")
        print("masukan menu: ")
        val menu = readln().trim().toIntOrNull()
        when (menu) {
            1 -> transaction.IncomeExpense()
            2 -> println("saldo anda sebesar Rp${transaction.getSaldo()}")
            3 -> transaction.historyTransaction()
            4 -> transaction.totalAnalysis()
            5 -> {
                println("keluar")
                break
            }

            else -> println("menu tidak ada")
        }
    }

}

class Transaction {
    private var saldo = 0
    private var income = 0
    private var expense = 0
    private val listIncome = mutableListOf(income)
    private val listExpense = mutableListOf(expense)
    private var totalIncome = 0
    private var totalExpense = 0

    fun IncomeExpense() {
        println("1.  pemasukan")
        println("2.  pengeluaran")
        print("pilih : ")
        val menu = readln().trim().toIntOrNull()
        when (menu) {
            1 -> {
                print("inputkan pemasukan: Rp.")
                income = readln().trim().toInt()
                if (income < 0) {
                    println("tidak dapat memasukan mines")
                } else {
                    saldo += income
                    listIncome.add(income)
                    if (listIncome.first() == 0) {
                        listIncome.removeFirst()
                    }
                    totalIncome = listIncome.sum()
                    println(" pemasukan Rp $income")
                }
            }

            2 -> {
                print("inputkan pengeluaran: Rp  ")
                expense = readln().trim().toInt()
                if (expense < 0) {
                    println("tidak dapat memasukan mines")
                } else {
                    saldo -= expense
                    listExpense.add(expense)
                    if (listExpense.first() == 0) {
                        listExpense.removeFirst()
                    }
                    totalExpense = listExpense.sum()
                    println(" pengeluaran Rp $expense")
                }

            }

            else -> println("menu tidak ada")

        }
        println("total saldo Rp $saldo")
    }

    fun getSaldo() = saldo

    fun historyTransaction() {
        if (listIncome.isEmpty() && listExpense.isEmpty()) {
            println("riwayat transaksi tidak ada silahkan masukan pemasukan atau pengeluaran")
        } else {
            println("riwayat pemasukan")
            listIncome.forEach { println("Rp $it") }
            println("riwayat pengeluaran")
            listExpense.forEach { println("Rp $it") }
        }
    }

    fun totalAnalysis() {
        println(
            " jumlah pemasukan sebesar : " +
                    "Rp.$totalIncome \n jumlah pengeluaran sebesar: Rp.$totalExpense \n total saldo: Rp.$saldo"
        )

    }

}