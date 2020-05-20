package npa.sit.cpoint.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import npa.sit.cpoint.R

class BookingStep3Fragment : Fragment() {
    fun getInstance():BookingStep3Fragment?
    {
        var instance: BookingStep3Fragment? = null
        if(instance == null)
            instance = BookingStep3Fragment()
        return instance
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_booking_step3,container,false)
    }


}
