package ru.alexmikh.summary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScreenEmployer extends AppActivity {

    private TextView fio;
    private TextView phone;
    private TextView email;
    private TextView birthday;
    private TextView gender;
    private TextView workPosition;
    private TextView salary;
    private TextView answer;
    private Button answerButton;

    private String intPhone;
    private String intMail;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_employer);

        fio = (TextView) findViewById(R.id.idDataFIO);
        phone = (TextView) findViewById(R.id.idDataPhone);
        email = (TextView) findViewById(R.id.idDataEmail);
        birthday = (TextView) findViewById(R.id.idDataBD);
        gender = (TextView) findViewById(R.id.idDataGender);
        workPosition = (TextView) findViewById(R.id.idDataWorkPosition);
        salary = (TextView) findViewById(R.id.idDataSalary);
        answer = (TextView) findViewById(R.id.idDataAnswer);
        answerButton = (Button) findViewById(R.id.idBtAnswer);

        Intent intent = getIntent();

        fio.setText(intent.getStringExtra("fio"));
        phone.setText(intent.getStringExtra("phone"));
        email.setText(intent.getStringExtra("email"));
        birthday.setText(intent.getStringExtra("BD"));
        gender.setText(intent.getStringExtra("gender"));
        workPosition.setText(intent.getStringExtra("workPosition"));
        salary.setText(intent.getStringExtra("salary") + " " + intent.getStringExtra("currency"));

        intPhone = "tel:" + intent.getStringExtra("phone");
        intMail = "email:" + intent.getStringExtra("email");

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(intMail));
                startActivity(intent);
            }
        });
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.screen_candidate, menu);
		return true;
	}
	
}
