package com.example.assigment1_irfanarrahman

fun main() {
    val user = User()
    while (true) {
        println("Personal Finance Manager Apllication")
        println("=======---========")
        println("1. Input pemasukan dan pengeluaran")
        println("2. Perhitungan Saldo")
        println("3. Riwayat Transaksi")
        println("4. Analisis Total")
        println("5. Keluar")
        print("masukan menu: ")
        val menu = readln().toIntOrNull()
        when (menu) {
            1 -> user.pemasukanPengeluaran()
            2 -> println("saldo anda sebesar Rp.${user.getSaldo()}")
            3 -> user.riwayatTransaksi()
            4 -> user.analisisTotal()
            5 -> {
                println("keluar")
                break
            }

            else -> println("menu tidak ada")
        }
    }

}

class User {
    private var saldo = 0
    private var pemasukan = 0
    private var pengeluaran = 0
    private val listPemasukan = mutableListOf(pemasukan)
    private val listPengeluaran = mutableListOf(pengeluaran)
    private var totalPemasukan = 0
    private var totalPengeluaran = 0

    fun pemasukanPengeluaran() {
        println("1.  pemasukan")
        println("2.  pengeluaran")
        print("pilih : ")
        val menu = readln().toIntOrNull()
        when (menu) {
            1 -> {
                print("inputkan pemasukan: Rp.")
                pemasukan = readln().toInt()
                if (pemasukan < 0) {
                    println("tidak dapat memasukan mines")
                } else {
                    saldo += pemasukan
                    listPemasukan.add(pemasukan)
                    if (listPemasukan.first() == 0) {
                        listPemasukan.removeFirst()
                    }
                    totalPemasukan = listPemasukan.sum()
                    println(" pemasukan Rp.$pemasukan")
                }
            }

            2 -> {
                print("inputkan pengeluaran: Rp. ")
                pengeluaran = readln().toInt()
                if (pengeluaran < 0) {
                    println("tidak dapat memasukan mines")
                } else {
                    saldo -= pengeluaran
                    listPengeluaran.add(pengeluaran)
                    if (listPengeluaran.first() == 0) {
                        listPengeluaran.removeFirst()
                    }
                    totalPengeluaran = listPengeluaran.sum()
                    println(" pengeluaran Rp.$pengeluaran")
                }

            }

            else -> println("menu tidak ada")

        }
        println("total saldo Rp.$saldo")
    }

    fun getSaldo(): Int {
        return saldo
    }

    fun riwayatTransaksi() {
        if (listPemasukan.isEmpty() && listPengeluaran.isEmpty()) {
            println("riwayat transaksi tidak ada silahkan masukan pemasukan atau pengeluaran")
        } else {
            println("riwayat pemasukan")
            listPemasukan.forEach { println("Rp.$it") }
            println("riwayat pengeluaran")
            listPengeluaran.forEach { println("Rp.$it") }
        }
    }

    fun analisisTotal() {
        println(
            " jumlah pemasukan sebesar : " +
                    "Rp.$totalPemasukan \n jumlah pengeluaran sebesar: Rp.$totalPengeluaran \n total saldo: Rp.$saldo"
        )

    }

}