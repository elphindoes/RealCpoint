package npa.sit.cpoint.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import npa.sit.cpoint.Fragment.BookingStep1Fragment
import npa.sit.cpoint.Fragment.BookingStep2Fragment
import npa.sit.cpoint.Fragment.BookingStep3Fragment
import npa.sit.cpoint.Fragment.BookingStep4Fragment

class MyViewPagerAdapter(fm: FragmentManager?) :
    FragmentPagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return BookingStep1Fragment()
            1 -> return BookingStep2Fragment()
            2 -> return BookingStep3Fragment()
            3 -> return BookingStep4Fragment()

        }
        return null!!

    }

    override fun getCount(): Int {

        return 4
    }
}