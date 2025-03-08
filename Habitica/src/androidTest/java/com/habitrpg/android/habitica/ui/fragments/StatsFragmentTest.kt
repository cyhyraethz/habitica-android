package xyz.prfn.android.habitica.ui.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import xyz.prfn.android.habitica.R
import xyz.prfn.android.habitica.databinding.FragmentStatsBinding
import com.habitrpg.shared.habitica.models.tasks.Attribute
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.mockk.coVerify
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class StatsScreen : Screen<StatsScreen>() {
    val strengthStatsView = KView { withId(R.id.strengthStatsView) }
    val strengthAllocateButton =
        KButton {
            withId(R.id.allocateButton)
            isDescendantOfA { withId(R.id.strengthStatsView) }
        }
    val intelligenceStatsView = KView { withId(R.id.intelligenceStatsView) }
    val intelligenceAllocateButton =
        KButton {
            withId(R.id.allocateButton)
            isDescendantOfA { withId(R.id.intelligenceStatsView) }
        }
    val constitutionStatsView = KView { withId(R.id.constitutionStatsView) }
    val constitutionAllocateButton =
        KButton {
            withId(R.id.allocateButton)
            isDescendantOfA { withId(R.id.constitutionStatsView) }
        }
    val perceptionStatsView = KView { withId(R.id.perceptionStatsView) }
    val perceptionAllocateButton =
        KButton {
            withId(R.id.allocateButton)
            isDescendantOfA { withId(R.id.perceptionStatsView) }
        }
    val bulkAllocateButton = KView { withId(R.id.statsAllocationButton) }
}

@LargeTest
@RunWith(AndroidJUnit4::class)
class StatsFragmentTest : FragmentTestCase<StatsFragment, FragmentStatsBinding, StatsScreen>() {
    override val screen = StatsScreen()

    override fun makeFragment() {
        fragment = spyk()
        fragment.shouldInitializeComponent = false
    }

    override fun launchFragment(args: Bundle?) {
        scenario =
            launchFragmentInContainer(args, R.style.MainAppTheme) {
                return@launchFragmentInContainer fragment
            }
    }

    @Before
    fun setUpUser() {
        user.stats?.lvl = 20
        user.stats?.points = 30
        userState.value = user

        every { inventoryRepository.getEquipment(listOf()) } returns flowOf(listOf())
    }

    @Test
    fun showStatsTest() {
        verify { userRepository.getUser() }
        screen {
            strengthStatsView.isVisible()
            intelligenceStatsView.isVisible()
            constitutionStatsView.isVisible()
            perceptionStatsView.isVisible()
        }
    }

    @Test
    fun showsAllocationButtons() {
        verify { userRepository.getUser() }
        screen {
            strengthAllocateButton.isVisible()
            intelligenceAllocateButton.isVisible()
            constitutionAllocateButton.isVisible()
            perceptionAllocateButton.isVisible()
            bulkAllocateButton.isVisible()
            bulkAllocateButton.isClickable()
        }
    }

    @Test
    fun allocatesOnClick() {
        screen {
            strengthAllocateButton.click()
            coVerify { userRepository.allocatePoint(Attribute.STRENGTH) }
            intelligenceAllocateButton.click()
            coVerify { userRepository.allocatePoint(Attribute.INTELLIGENCE) }
            constitutionAllocateButton.click()
            coVerify { userRepository.allocatePoint(Attribute.CONSTITUTION) }
            perceptionAllocateButton.click()
            coVerify { userRepository.allocatePoint(Attribute.PERCEPTION) }
        }
    }
}
