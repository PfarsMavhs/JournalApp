package journal.com.journalapp;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import journal.com.journalapp.databinding.ActivitySignUpBinding;

public class Sign_Up extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference mUserRegister;
    private int selectedGenderId;
    private ActivitySignUpBinding signUpBinding;
    private RadioButton radGender;
    private RadioGroup gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign__up);

        auth = FirebaseAuth.getInstance();

        mUserRegister = FirebaseDatabase.getInstance().getReference().child("Users");

        gender = (RadioGroup)findViewById(R.id.gender);

        signUpBinding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!signUpBinding.emailAddress.getText().toString().isEmpty() && !signUpBinding.password.getText().toString().isEmpty()) {
                    auth.createUserWithEmailAndPassword(signUpBinding.emailAddress.getText().toString(), signUpBinding.password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            selectedGenderId = gender.getCheckedRadioButtonId();

                            if (selectedGenderId != -1) {
                                radGender = (RadioButton) findViewById(selectedGenderId);

                                if (task.isSuccessful()) {

                                    String key = task.getResult().getUser().getUid();

                                    Users user = new Users(key, signUpBinding.displayName.getText().toString(), signUpBinding.emailAddress.getText().toString(),
                                            Integer.valueOf(signUpBinding.idnumber.getText().toString()));

                                    mUserRegister.child(key).setValue(user);

                                    Toast.makeText(Sign_Up.this, "Registered SuccessFully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Sign_Up.this, "Failed to Register", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(Sign_Up.this, "Please Select Gender", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }else{
                    Toast.makeText(Sign_Up.this, "Please make sure that Password and Email not Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

       Button signout = (Button)findViewById(R.id.signOut);

       signout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseAuth.getInstance().signOut();
           }
       });

    }
}
