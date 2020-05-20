package npa.sit.cpoint

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.shuhart.stepview.StepView
import npa.sit.cpoint.Adapter.MyViewPagerAdapter
import org.jetbrains.anko.support.v4.onPageChangeListener

class BookingActivity : AppCompatActivity() {
    var stepView: StepView? = null
    var viewPager: ViewPager? = null

    var btn_next_step: Button? = null
    var btn_previous_step: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        viewPager = findViewById(R.id.view_pager)
        stepView = findViewById(R.id.step_view)
        btn_previous_step = findViewById(R.id.btn_previous_step)
        btn_next_step = findViewById(R.id.btn_next_step)

        setupStepView()

        viewPager?.adapter = MyViewPagerAdapter(supportFragmentManager)
        viewPager?.addOnPageChangeListener(object:ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                    if(position == 0) {
                        btn_previous_step!!.isEnabled = false
                    }


            }
        }
        )
    }
    private fun setupStepView(){
        val stepList: MutableList<String> = ArrayList()
        stepList.add("Clinic")
        stepList.add("Doctor")
        stepList.add("Time")
        stepList.add("Confirmation")
        stepView?.setSteps(stepList)
    }



    }





