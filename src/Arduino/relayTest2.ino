int sensor_pin = A0;
int mosfetPin = 13;
int relayPin = 8;
int output_value ;
int output_value_perc;
int valve_status = 0;
int iteration = 0;
String message_from_pc;

void setup() {

  pinMode(mosfetPin, OUTPUT);
  pinMode(LED_BUILTIN, OUTPUT);
  Serial.begin(9600);

  //   Serial.begin(115200);
  //   Serial.println("Reading From the Sensor new code...");
  //   delay(1000);

}

void loop() {

  output_value = analogRead(sensor_pin);

  output_value_perc = map(output_value, 1024, 0, 0, 100);
  iteration++;
  Serial.print("Iteration: ");
  Serial.println(iteration);



  if (output_value_perc > 15)
  {

    //    Close Valve
    Serial.println("<< Valave Closed >>");

    digitalWrite(mosfetPin, LOW);

    digitalWrite(relayPin, LOW);

    valve_status = 0;
  }
  else
  {
    //    Open Valve
    Serial.println(" || Valave Opened ||");

    digitalWrite(mosfetPin, HIGH);
    valve_status = 1;

    digitalWrite(relayPin, HIGH);
  }
  Serial.print("Moisture:: ");
  Serial.println(output_value_perc);


  Serial.print("valve:: ");
  Serial.println(valve_status);

  delay(5000);

  //   }

}
