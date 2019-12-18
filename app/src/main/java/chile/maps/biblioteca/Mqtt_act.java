package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt_act extends AppCompatActivity {


     Button bot1, bot2, bot3, bot4;

    //Declaracion de las variables
    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:13644"; //debe ser tcp://+Host+:puerto
    static String USERNAME = "medxillb";
    static String PASSWORD = "eLqb18nwH381";
    String topicStr = "LED";
    MqttAndroidClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);


        bot1 = (Button)findViewById(R.id.btn1);
        bot2 = (Button)findViewById(R.id.btn2);
        bot3 = (Button)findViewById(R.id.btn3);
        bot4 = (Button)findViewById(R.id.btn4);


        bot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        //Conexion ClientID

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST, clientId);
        MqttConnectOptions opciones = new MqttConnectOptions();

        opciones.setUserName(USERNAME);
        opciones.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(opciones);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected un TOAST
                    Toast.makeText(getBaseContext(), "CONEXION EXITOSA", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // SI FALLA
                    Toast.makeText(getBaseContext(), "CONEXION FALLIDA", Toast.LENGTH_LONG).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }


    }


    //FALTA PONERLOS EN LOS ONCLICK!!!!!!!!!!!!

    public void testUno(View v)
    {
        String topic = topicStr;
        String message = "Test 1";

        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        Toast.makeText(getBaseContext(), "Ha Seleccionado Revival",
                Toast.LENGTH_LONG).show();

    }

    public void testDos(View v)
    {
        String topic = topicStr;
        String message = "Test 2";

        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        Toast.makeText(getBaseContext(), "Ha Seleccionado Farenheit",
                Toast.LENGTH_LONG).show();



    }

    public void testTres(View v)
    {
        String topic = topicStr;
        String message = "Test 3";

        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        Toast.makeText(getBaseContext(), "Ha Seleccionado El Alquimista",
                Toast.LENGTH_LONG).show();



    }

    public void testCuatro(View v)
    {
        String topic = topicStr;
        String message = "Test4";

        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        Toast.makeText(getBaseContext(), "Ha Seleccionado El Poder",
                Toast.LENGTH_LONG).show();



    }
    public void testCinco (View v)
    {
        String topic = topicStr;
        String message = "Test5";

        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        Toast.makeText(getBaseContext(), "Ha Seleccionado El Despertar",
                Toast.LENGTH_LONG).show();


    }




}
