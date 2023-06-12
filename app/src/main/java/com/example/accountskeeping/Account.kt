package com.example.accountskeeping

class Account(val name: String, var money: Int, val imgId: Int, var category: Int, var time: String) {

    // Getter 和 Setter 函式
    fun getName(): String {
        return name
    }

    fun getMoney(): Int {
        return money
    }

    fun setMoney(newMoney: Int) {
        money = newMoney
    }

    fun getImgId(): Int {
        return imgId
    }

    fun getCategory(): Int {
        return category
    }

    fun setCategory(newCategory: Int) {
        category = newCategory
    }

    fun getTime(): String {
        return time
    }

    fun setTime(newTime: String) {
        time = newTime
    }
}