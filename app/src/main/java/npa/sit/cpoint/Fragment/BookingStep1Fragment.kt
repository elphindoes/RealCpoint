package npa.sit.cpoint.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jaredrummler.materialspinner.MaterialSpinner
import npa.sit.cpoint.Interface.IAllLoadClinicListener
import npa.sit.cpoint.R

class BookingStep1Fragment : Fragment() {
    var allClinicRef:CollectionReference? = null
    var branchref:CollectionReference?=null
    var iAllLoadClinicListener:IAllLoadClinicListener? = null

    var spinner:MaterialSpinner? = null
    var recycler_clinic:RecyclerView? = null
    var unbinder:Unbinder? = null




    fun getInstance():BookingStep1Fragment?{
        var instance: BookingStep1Fragment? = null
        if(instance == null)
            instance = BookingStep1Fragment()
            return instance
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allClinicRef = FirebaseFirestore.getInstance().collection("AllClinic")

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var itemView:View
        itemView = inflater.inflate(R.layout.fragment_booking_step1,container,false)
        unbinder = ButterKnife.bind(this@BookingStep1Fragment,itemView)

        return itemView
    }
    fun loadAllClinic(){

    }
    fun onAllClinicLoadSuccess(areaName:MutableList<String>){

    }



    }
