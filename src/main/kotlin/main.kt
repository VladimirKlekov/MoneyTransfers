const val PERCENT_MASTER_AND_MAESTRO = 0.6
const val PERCENT_VISA_AND_MIR = 0.75
const val PERCENT_VK_PAY = 0.00
const val RUB_LIMIT_CARD_IN_DAY = 150_000
const val RUB_MIN_LIMIT_VISA_MIR = 35
const val RUB_LIMIT_VK_PAY_ONCE = 15_000

fun main() {

    while (true) {
        println("Выберите тип карты:")
        println("1. Mastercard and Maestro")
        println("2. Visa and Мир")
        println("3. VK pay")
        println("Введите end для выхода")
        val chek = readln()
        if (chek == "end") {
            println("Программа завершена!")
            break
        }

        println("Введите сумму перевода в рублях:")
        val amount: Int = readLine()!!.toInt()

        val input = chek?.toInt()

        when (input) {
            1 -> println(result_Mastercard_And_Maestro(amount))
            2 -> println(result_Viza_And_Mir(amount))
            3 -> println(result_VK_Pay(amount))
            else -> {
                print("Ошибка ввода. Выберите правильный вариант")
            }
        }

    }

}

fun result_Mastercard_And_Maestro(amount: Int):String {
    val result =
        if (RUB_LIMIT_CARD_IN_DAY > amount) amount * 100 / 100 * PERCENT_MASTER_AND_MAESTRO + 2000
        else print("Операция не может быть совершена")
       return "Перевод соверен. Комиссия составила $result копеек"

}

fun result_Viza_And_Mir(amount: Int):String {
    val result =
        if (RUB_LIMIT_CARD_IN_DAY > amount && RUB_MIN_LIMIT_VISA_MIR < amount) amount * 100 / 100 * PERCENT_VISA_AND_MIR + 3500 else print(
            "Операция не может быть совершена"
        )
    return "Перевод соверен. Комиссия составила $result копеек"

}

fun result_VK_Pay(amount: Int): String {
    val result =
        if (RUB_LIMIT_VK_PAY_ONCE > amount) amount * 100 / 100 * PERCENT_VK_PAY else print("Операция не может быть совершена")
    return "Перевод соверен. Комиссия составила $result копеек"

}








