const val secInDay: Int = 60 * 60 * 24
const val secInHours: Int = 60 * 60
const val secInMinute: Int = 60

fun main() {
    println("был(а) в сети " + agoToText(35))
}

fun agoToText(seconds: Int): String {

    when (seconds) {
        in 0..secInMinute -> return "только что"
        in secInMinute + 1..secInHours -> {
            val minutes: Int = (seconds / (secInMinute))
            return "$minutes минут" + endMinutes(minutes) + " назад"
        }
        in secInHours + 1..secInDay -> {
            val hours: Int = (seconds / (secInHours))
            return "$hours час" + endHours(hours) + " назад"
        }
        in secInDay + 1..secInDay * 2 -> return "вчера"
        in secInDay * 2 + 1..secInDay * 3 -> return "позавчера"
        in secInDay * 3 + 1..Int.MAX_VALUE -> return "давно"
        else -> return "not rated"
    }
}

fun endHours(hour: Int) = when (hour % 10) {
    1 -> if (hour == 11) "ов" else ""
    2, 3, 4 -> "а"
    else -> "ов"
}

fun endMinutes(minute: Int) = when (minute % 10) {
    1 -> if (minute == 11) "" else "у"
    2, 3, 4 -> "ы"
    else -> ""
}
