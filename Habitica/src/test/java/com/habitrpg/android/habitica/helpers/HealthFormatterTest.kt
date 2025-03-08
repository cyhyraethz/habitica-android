package xyz.prfn.android.habitica.helpers

import com.habitrpg.common.habitica.helpers.HealthFormatter
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.util.Locale

class HealthFormatterTest : StringSpec({
    "should round values greater than 1" {
        49.0 shouldBe HealthFormatter.format(49.9)
        9.0 shouldBe HealthFormatter.format(9.9999)
        1.0 shouldBe HealthFormatter.format(1.9)
        1.0 shouldBe HealthFormatter.format(1.0001)

        "49" shouldBe HealthFormatter.formatToString(49.9, Locale.US)
        "9" shouldBe HealthFormatter.formatToString(9.9999, Locale.US)
        "1" shouldBe HealthFormatter.formatToString(1.9, Locale.US)
        "1" shouldBe HealthFormatter.formatToString(1.0001, Locale.US)
    }

    "should round values between 0 and 1 up" {
        1.0 shouldBe HealthFormatter.format(0.99)
        0.2 shouldBe HealthFormatter.format(0.11)
        0.1 shouldBe HealthFormatter.format(0.0001)

        "1" shouldBe HealthFormatter.formatToString(0.99, Locale.US)
        "0.2" shouldBe HealthFormatter.formatToString(0.11, Locale.US)
        "0.1" shouldBe HealthFormatter.formatToString(0.0001, Locale.US)
    }

    "should round negative values down" {
        -1.0 shouldBe HealthFormatter.format(-0.1)
        -2.0 shouldBe HealthFormatter.format(-2.0)

        "-1" shouldBe HealthFormatter.formatToString(-0.1, Locale.US)
        "-2" shouldBe HealthFormatter.formatToString(-2.0, Locale.US)
    }

    "should leave acceptable values as is" {
        20.0 shouldBe HealthFormatter.format(20)
        0.0 shouldBe HealthFormatter.format(0)
        0.9 shouldBe HealthFormatter.format(0.9)

        "20" shouldBe HealthFormatter.formatToString(20, Locale.US)
        "0" shouldBe HealthFormatter.formatToString(0, Locale.US)
        "0.9" shouldBe HealthFormatter.formatToString(0.9, Locale.US)
    }
})
