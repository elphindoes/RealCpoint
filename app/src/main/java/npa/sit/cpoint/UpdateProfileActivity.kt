package npa.sit.cpoint

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_update_profile.*
import java.io.IOException


class UpdateProfileActivity : AppCompatActivity(){
    var mAuth: FirebaseAuth? = null
    private var btnSaveButton: Button? = null
    private val TAG: String = "Update Profile"
    private var textViewEmailName: TextView? = null
    private var databaseReference: DatabaseReference? = null
    private var editTextName: EditText? = null
    private var editTextSurname: EditText? = null
    private var editTextPhoneNo: EditText? = null
    private var profileImageView: ImageView? = null
    private var firebaseStorage: FirebaseStorage? = null
    private var PICKIMAGE = 123
    var imagePath: Uri? = null
    private var storageReference: StorageReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
        val user = mAuth!!.currentUser
        mAuth = FirebaseAuth.getInstance()


        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@UpdateProfileActivity, ResultActivity::class.java))
            finish()
        }

        EmailDataView.text = user!!.email



        }




    }