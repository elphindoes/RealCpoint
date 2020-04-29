package npa.sit.cpoint

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_update_profile.*


class UpdateProfileActivity : AppCompatActivity(){
    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
        val user = mAuth!!.currentUser
        mAuth = FirebaseAuth.getInstance()


        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@UpdateProfileActivity, Dashboard::class.java))
            finish()
        }

        EmailDataView.text = user!!.email



        }




    }