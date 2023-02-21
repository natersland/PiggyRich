package com.natersfantasy.piggyrichrpg.commons.usecases

fun levelHandling(savingMoney: Int):Int {
    return when(savingMoney) {
        in 0..500 -> 1
        in 501..1000 -> 2
        in 1001..5000 -> 3
        in 5001..10000 -> 4
        in 10001..50000 -> 5
        in 50001..100000 -> 6
        else -> 1
    }
}