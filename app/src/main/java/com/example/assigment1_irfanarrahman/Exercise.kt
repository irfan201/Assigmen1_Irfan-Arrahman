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
    var pemasukan = 0
    var pengeluaran = 0
    val listPemasukan = mutableListOf(pemasukan)
    val listPengeluaran = mutableListOf(pengeluaran)
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
                saldo += pemasukan
                listPemasukan.add(pemasukan)
                totalPemasukan = listPemasukan.sum()
                println("total pemasukan Rp.$totalPemasukan")
            }

            2 -> {
                print("inputkan pengeluaran: Rp. ")
                pengeluaran = readln().toInt()
                saldo -= pengeluaran
                listPengeluaran.add(pengeluaran)
                totalPengeluaran = listPengeluaran.sum()
                println("total pengeluaran Rp.$totalPengeluaran")
            }
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