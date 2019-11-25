package userinterface11.com.example.minigroupassign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private TextView welcome, user, q1, q2, q3;
    private EditText name, a1, a2, a3;
    private Button b1;
    private ImageButton sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SmsReceiver SMSr = new SmsReceiver();
        welcome = (TextView)findViewById(R.id.welcome);
        user =  (TextView)findViewById(R.id.user);
        q1 = (TextView)findViewById(R.id.q1);
        q2 = (TextView)findViewById(R.id.q2);
        q3 = (TextView)findViewById(R.id.q3);
        name = (EditText)findViewById(R.id.name);
        a1 = (EditText)findViewById(R.id.a1);
        a2 = (EditText)findViewById(R.id.a2);
        a3 = (EditText)findViewById(R.id.a3);
        b1 = (Button)findViewById(R.id.b1);
        sms = (ImageButton)findViewById(R.id.sms);
    }

    public int getScore(View v){
        b1.setText("Getting Score... ");
        String userName = name.getText().toString();
        if(userName.isEmpty()) {
            userName = "Student";
        }
        String ans1 = a1.getText().toString();
        String ans2 = a2.getText().toString();
        String ans3 = a3.getText().toString();

        int score = 0;
        if (ans1.equals("implicit") || ans1.equals("explicit"))
            score += 1;

        if (ans2.equals("spinner"))
            score += 1;

        if (ans3.equals("yes"))
            score += 1;

        Toast.makeText(this,  userName + " scored " + score +" / 3", Toast.LENGTH_LONG).show();
        b1.setText("GET SCORE");
        return score;
    }

    public void sendSMS(View v){
        String userName = name.getText().toString();
        if(userName.isEmpty()) {
            userName = "Student";
        }
        int score = getScore(b1);
        String smsMessage = "Student Scored: " + String.valueOf(score);
        String phoneNo = "18682971465";

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, smsMessage, null, null);
            Toast.makeText(this, "SMS Message Successfully Sent", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "SMS Message Not Sent", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        Toast.makeText(this, "Message: '" + smsMessage + "'", Toast.LENGTH_LONG).show();
    }
}
