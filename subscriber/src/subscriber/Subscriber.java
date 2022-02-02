package subscriber;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Subscriber {

	public static void main(String[] args) {
		// set environment variable		
        String MQTT_ID = "Hello world Receiver";
		String MQTT_HOST = "broker.hivemq.com";
		int MQTT_PORT = 1883;
		String MQTT_TOPIC = "/livello";
		
		try {
			//connection parameter to the message broker
			String host = String.format("tcp://%s:%d", MQTT_HOST, MQTT_PORT);
            MqttClient mqtts = new MqttClient(host, MQTT_ID);
            
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            mqtts.connect(options);
            System.out.println("Connected");
            
            // set callback function to retrieve message
            mqtts.setCallback(new SubMqttCallback());
            mqtts.subscribe(MQTT_TOPIC);

        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }

	}

}
