package npa.sit.cpoint

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import butterknife.BindView
import butterknife.ButterKnife
import com.shuhart.stepview.StepView
import npa.sit.cpoint.Adapter.MyViewPagerAdapter

class BookingActivity : AppCompatActivity() {
    @BindView(R.id.step_view)
    var stepView: StepView? = null

    @BindView(R.id.view_pager)
    var viewPager: ViewPager? = null

    @BindView(R.id.btn_next_step)
    var btn_next_step: Button? = null

    @BindView(R.id.btn_previous_step)
    var btn_previous_step: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        ButterKnife.bind(this@BookingActivity)
        setupStepView()
        setColorButton()

        //View
        viewPager!!.adapter = MyViewPagerAdapter(supportFragmentManager)
        viewPager!!.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int)
            {
            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    btn_previous_step!!.isEnabled = false }
                    else {
                    btn_previous_step!!.isEnabled = true
                    setColorButton()
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        }
        )
    }

    private fun setupStepView() {
        val stepList: MutableList<String> = ArrayList()
        stepList.add("Clinic")
        stepList.add("Doctor")
        stepList.add("Time")
        stepList.add("Confirmation")
        stepView!!.setSteps(stepList)
    }

    private fun setColorButton() {
        if (btn_next_step!!.isEnabled) {
            btn_next_step!!.setBackgroundResource(R.color.colorPrimary)
        } else {
            btn_next_step!!.setBackgroundResource(R.color.colorPrimaryDark)
        }
        if (btn_previous_step!!.isEnabled) {
            btn_previous_step!!.setBackgroundResource(R.color.colorPrimary)
        } else {
            btn_previous_step!!.setBackgroundResource(R.color.colorPrimary)
        }
    }
}