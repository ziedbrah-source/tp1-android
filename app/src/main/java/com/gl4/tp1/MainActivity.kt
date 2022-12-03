package com.gl4.tp1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var txtNom : EditText;
    lateinit var txtPrenom : EditText;
    lateinit var txtAdresse : EditText;
    lateinit var CheckBox2: CheckBox;
    lateinit var CheckBox3 : CheckBox;
    lateinit var checkBox4 : CheckBox;

    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var button: Button
    private lateinit var button2: Button

    lateinit var checkedOption1:String
    lateinit var checkedOption2:String
    lateinit var checkedOption3:String


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNom = findViewById(R.id.nom);
        txtPrenom = findViewById(R.id.prenom);
        txtAdresse = findViewById(R.id.Adresse);
        radioGroup = findViewById(R.id.radioGroup1)
        CheckBox2=findViewById(R.id.checkBox2)
        CheckBox3=findViewById(R.id.checkBox3)
        checkBox4=findViewById(R.id.checkBox4)
        radioGroup = findViewById(R.id.radioGroup1)
        button = findViewById(R.id.btncommander)
    }



    override fun onClick(view2: View?) {
        val result = StringBuilder()
        val selectedOption: Int = radioGroup!!.checkedRadioButtonId

        // Assigning id of the checked radio button
        radioButton = findViewById(selectedOption)

        if(CheckBox2.isChecked){
            checkedOption1= CheckBox2.text as String+","
            result.append(checkedOption1)
        }

        if(CheckBox3.isChecked)
        {
            checkedOption2= CheckBox3.text as String+","
            result.append(checkedOption2)
        }

        if(checkBox4.isChecked){
            checkedOption3= checkBox4.text as String+","
            result.append(checkedOption3)
        }

        var nom = txtNom.text.toString();
        var prenom = txtPrenom.text.toString();
        var adresse = txtAdresse.text.toString();
        var pizza = radioButton.text.toString();
        var ingredient = result.toString();
        val text = "Thank you for ordering";
        val order = "Thank you for ordering \n \n Mr/Mrs $nom $prenom  ,\n your $pizza pizza " +
                "($ingredient) \n is on its way to $adresse";
        val duration = Toast.LENGTH_SHORT;

        Toast.makeText(baseContext, order.toString(), Toast.LENGTH_SHORT).show()




        if( view2?.id == R.id.btncommander){
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, "soulaimakahla@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "pizza order")
            intent.putExtra(Intent.EXTRA_TEXT, order)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Select email"))
        }
        if( view2?.id == R.id.btncommander2){
            val intent2 = Intent(view2?.context,SlashScrean::class.java);
            intent2.putExtra("order",order);
            startActivity(intent2);
        }
    }
}