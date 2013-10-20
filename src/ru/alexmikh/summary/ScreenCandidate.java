package ru.alexmikh.summary;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ScreenCandidate extends AppActivity {

    private Context context;

    private EditText fio;
    private EditText phone;
    private EditText email;
    private EditText workPosition;
    private EditText salary;
    private EditText birthday;
    private Spinner spinnerGender;
    private Spinner spinnerCurrency;
    private Button buttonSend;

    private KeyboardView kbView;
    private SpecialKeyboard phoneKeyboard;
    private SpecialKeyboard emailKeyboard;
    private SpecialKeyboard salaryKeyboard;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_candidate);

        context = getApplicationContext();

        fio = (EditText) findViewById(R.id.idFIO);
        phone = (EditText) findViewById(R.id.idPhone);
        email = (EditText) findViewById(R.id.idEmail);
        workPosition = (EditText) findViewById(R.id.idWorkPosition);
        salary = (EditText) findViewById(R.id.idSalary);
        birthday = (EditText) findViewById(R.id.idBDet);
        spinnerGender = (Spinner) findViewById(R.id.idGender);
        spinnerCurrency = (Spinner) findViewById(R.id.idCurrency);
        buttonSend = (Button) findViewById(R.id.idBtSend2activity);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneKeyboard = new SpecialKeyboard(context, R.xml.phonekeyboard);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailKeyboard = new SpecialKeyboard(context, R.xml.emailkeyboard);
            }
        });

        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salaryKeyboard = new SpecialKeyboard(context, R.xml.salarykeyboard);
                onCreateInputView(salaryKeyboard);
            }
        });

        //Отправка данных на 2 окно
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getApplicationContext(), ScreenEmployer.class);

                if(fio.getText().toString() != "" || fio.getText() != null
                    || phone.getText().toString() != "" || phone.getText() != null
                    || email.getText().toString() != "" || email.getText() != null
                    || birthday.getText().toString() != "" || birthday.getText() != null
                    || workPosition.getText().toString() != "" || workPosition.getText() != null
                    || salary.getText().toString() != "" || salary.getText() != null){

                    intent.putExtra("fio", fio.getText().toString());
                    intent.putExtra("phone", phone.getText().toString());
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("BD", birthday.getText().toString());
                    intent.putExtra("gender", spinnerGender.getSelectedItem().toString());
                    intent.putExtra("workPosition", workPosition.getText().toString());
                    intent.putExtra("salary", salary.getText().toString());
                    intent.putExtra("currency", spinnerCurrency.getSelectedItem().toString());

                    startActivity(intent);

                } else {
                        Toast.makeText(getApplicationContext(), "Заполните ВСЕ поля!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Выпадающее меню выбора пола
        ArrayAdapter<CharSequence> adapterGender = ArrayAdapter.createFromResource(this, R.array.gender,
                                                                  android.R.layout.simple_spinner_item);
        spinnerGender.setAdapter(adapterGender);
        spinnerGender.setSelection(0);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                spinnerGender.setSelection(spinnerGender.getSelectedItemPosition());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //Выпадающее меню выбора валюты
        ArrayAdapter<CharSequence> adapterCurrency = ArrayAdapter.createFromResource(this, R.array.currency,
                                                                      android.R.layout.simple_spinner_item);
        spinnerCurrency.setAdapter(adapterCurrency);
        spinnerCurrency.setSelection(0);
        spinnerCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                spinnerCurrency.setSelection(spinnerCurrency.getSelectedItemPosition());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    public void tvBDclick(View v){
        createDateDialog().show();
    }

    public Dialog createDateDialog(){
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                birthday.setText(day + "." + month + "." + year);
            }
        } ,2000, 1, 1);

        return dpd;
    }

     public View onCreateInputView(SpecialKeyboard keyboard) {
        kbView = (KeyboardView) getLayoutInflater().inflate(
                R.layout.screen_candidate, null);
        kbView.setOnKeyboardActionListener((KeyboardView.OnKeyboardActionListener) keyboard);
        kbView.setKeyboard(keyboard);
        return kbView;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.screen_candidate, menu);
		return true;
	}

}
