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
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update_profile.*


class UpdateProfileActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    var mDatabase: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance()

        var userId = mAuth!!.currentUser!!.uid
        var userRef = mDatabase!!.reference.child("Users").child(userId)

        userRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                finish()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var display_name = dataSnapshot.child("display_name").value.toString()
                var email = dataSnapshot.child("email").value.toString()
                var status = dataSnapshot.child("status").value.toString()
                var name = dataSnapshot.child("name").value.toString()
                var surname = dataSnapshot.child("surname").value.toString()
                var image = dataSnapshot.child("image").value.toString()

                textViewProfile.text = display_name
                emailView2.text = email
                statusView2.text = status
                nameView2.text = name
                surnameView2.text = surname

                if (image != "Default") {
                    Picasso.get().load(image).placeholder(R.drawable.defavatar)
                        .into(update_imageView)

                }

            }


        })


    }
}