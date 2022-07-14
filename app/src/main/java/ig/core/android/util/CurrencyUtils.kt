package ig.core.android.util

import java.math.BigDecimal
import java.text.DecimalFormat

/****
 *
 * Created by TUON BONDOL on 1/18/18.
 *
 */

object CurrencyUtils {

    fun amountDisplay(stringAmount: String?): String {

        var amount = stringAmount
        amount = amount!!.replace(",".toRegex(), "")
        amount = amount.replace(" ".toRegex(), "").trim { it <= ' ' }
        return run {
            val d = java.lang.Double.parseDouble(amount)
            if (d > 0) {
                val formatter = DecimalFormat("#,##0.###")
                formatter.format(d)
            } else {
                "0"
            }
        }
    }

    fun amountDisplay(amount: Float?): String {

        return if (amount != null) {
            val formatter = DecimalFormat("#,##0.##")
            formatter.format(amount)
        } else {
            "0"
        }
    }

    fun amountDisplay(amount: Double?): String {
        return if (amount != null) {
            val formatter = DecimalFormat("#,##0.##")
            formatter.format(amount)
        } else {
            "0"
        }
    }

    fun amountDisplay(amount: BigDecimal): String {

        return if (amount > BigDecimal.ZERO) {
            val formatter = DecimalFormat("#,##0.##")
            formatter.format(amount)
        } else {
            "0"
        }
    }

    fun convertCurrencyToNumber(value: Double): String {
        var newValue = value
        val power: Int
        val suffix = " KMBTQV"

        val formatter = DecimalFormat("#,###.##")
        power = StrictMath.log10(newValue).toInt()
        newValue /= Math.pow(10.0, (power / 3 * 3).toDouble())
        var formattedNumber = formatter.format(newValue)
        formattedNumber += suffix[power / 3]
        return if (formattedNumber.length > 4) formattedNumber.replace("\\.[0-9]+".toRegex(), "") else formattedNumber
    }
}