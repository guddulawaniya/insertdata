package com.example.insertdata_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.insertdata_firebase.databinding.ActivityMainBinding;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseDatabase.getInstance();

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                module user = new module(binding.name.getText().toString(),binding.sBalance.getText().toString(),binding.mpayment.getText().toString(),
                        binding.apr.getText().toString());
                database.getReference().child("").setValue(user);
                deleteAletbox();
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.name.getText().toString().isEmpty() &&
                        !binding.sBalance.getText().toString().isEmpty()&&
                        !binding.mpayment.getText().toString().isEmpty() &&
                        !binding.apr.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "data successufully insert firebase", Toast.LENGTH_SHORT).show();


                    module user = new module(binding.name.getText().toString(),binding.sBalance.getText().toString(),binding.mpayment.getText().toString(),
                            binding.apr.getText().toString());
                    database.getReference().child("dept data").setValue(user);
                    displayAlertbox();
                }
                else if (binding.name.getText().toString().isEmpty())
                {
                    binding.name.setError("Enter the name ");
                    binding.name.requestFocus();
                } else if (binding.sBalance.getText().toString().isEmpty())
                {
                    binding.sBalance.setError("Enter the name ");
                    binding.sBalance.requestFocus();
                } else if (binding.mpayment.getText().toString().isEmpty())
                {
                    binding.mpayment.setError("Enter the name ");
                    binding.mpayment.requestFocus();
                } else if (binding.apr.getText().toString().isEmpty())
                {
                    binding.apr.setError("Enter the name ");
                    binding.apr.requestFocus();
                }
            }
        });





    }

    public void displayAlertbox()
    {
    new AlertDialog.Builder(this).setMessage("Successfully insert data in firebase ").setTitle("Thank You ")
            .setCancelable(true)
            .setNeutralButton(android.R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton){
                            finish();
                        }
                    })
            .show();

    }
    public void deleteAletbox()
    {
    new AlertDialog.Builder(this).setMessage("Data delete Successfully in Firebase ").setTitle("Thank You ")
            .setCancelable(true)
            .setNeutralButton(android.R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton){
                            finish();
                        }
                    })
            .show();

    }
}

class module{
    String name ,sbalance,mpayment,apr;

    public module(String name, String sbalance, String mpayment, String apr) {
        this.name = name;
        this.sbalance = sbalance;
        this.mpayment = mpayment;
        this.apr = apr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSbalance() {
        return sbalance;
    }

    public void setSbalance(String sbalance) {
        this.sbalance = sbalance;
    }

    public String getMpayment() {
        return mpayment;
    }

    public void setMpayment(String mpayment) {
        this.mpayment = mpayment;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }
}