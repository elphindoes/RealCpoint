package npa.sit.cpoint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_change_profile.*
import org.jetbrains.anko.toast

class ChangeProfileActivity : AppCompatActivity() {
        var mDatabase: FirebaseDatabase? = null
        var mCurrentUser: FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_profile)

        if(intent.extras != null){
            var display_name = intent.getStringExtra("display_name")
            var name = intent.getStringExtra("name")
            var surname = intent.getStringExtra("surname")
            var status = intent.getStringExtra("status")

            display_name_edit.setText(display_name)
            name_edit.setText(name)
            surname_edit.setText(surname)
            status_edit.setText(status)
        }
        changeBtn.setOnClickListener {
            var update_display_name = display_name_edit.text.toString().trim()
            var update_name = name_edit.text.toString().trim()
            var update_surname = surname_edit.text.toString().trim()
            var update_status = status_edit.text.toString().trim()

            mCurrentUser = FirebaseAuth.getInstance().currentUser
            var uid = mCurrentUser!!.uid

            mDatabase = FirebaseDatabase.getInstance()
            var display_name_ref = mDatabase!!.reference.child("Users").child(uid).child("display_name")
            display_name_ref.setValue(update_display_name)
            var name_ref =mDatabase!!.reference.child("Users").child(uid).child("name")
            name_ref.setValue(update_name)
            var surname_ref = mDatabase!!.reference.child("Users").child(uid).child("surname")
            surname_ref.setValue(update_surname)
            var status_ref = mDatabase!!.reference.child("Users").child(uid).child("status")
            status_ref.setValue(update_status).addOnCompleteListener{
                task: Task<Void> ->
                if(task!!.isSuccessful){
                    toast("Change successful.")
                    finish()
                }
                else{
                    toast("Change failed.")
                }
            }

        }
    }
}
