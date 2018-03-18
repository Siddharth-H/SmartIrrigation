int sensor_pin = A0;
int mosfetPin = 13;
int relayPin = 8;
int output_value ;
int output_value_perc;
int valve_status = 0;
String message_from_pc;
int minMoisture;

void setup() {

  pinMode(mosfetPin, OUTPUT);
  pinMode(LED_BUILTIN, OUTPUT);
  Serial.begin(9600);

  //   Serial.begin(115200);
  //   Serial.println("Reading From the Sensor new code...");
  //   delay(1000);
  
  minMoisture = Serial.read();
}

void loop() {

  output_value = analogRead(sensor_pin);

  //  Serial.print("Mositure value: ");
  //   Serial.print(output_value);

  output_value_perc = map(output_value, 1024, 0, 0, 100);

  //   Serial.print(" \t Mositure percentage: ");



  //   Serial.print(output_value_perc);
  //   Serial.print("%");
  //   Serial.print("\t Mosfet Pin = ");
  //   Serial.println(mosfetPin);



  if (output_value_perc > 18)
  {

    //    Close Valve
    //    Serial.println("<< Valave Closed >>");

    digitalWrite(mosfetPin, LOW);

    digitalWrite(relayPin, LOW);
    valve_status = 0;
  }
  else
  {
    //    Open Valve
    //    Serial.println(" || Valave Opened ||");

    digitalWrite(mosfetPin, HIGH);
    valve_status = 1;

    digitalWrite(relayPin, HIGH);

  }
  message_from_pc = Serial.readString();

  //    mss = moisture sensor status

  if (message_from_pc == "mss") {

    Serial.print(output_value_perc);
    // Serial.write();
    digitalWrite(LED_BUILTIN, HIGH);
  }

  //    vs = valve status

  else if (message_from_pc == "vs") {
    Serial.print(valve_status);
    digitalWrite(LED_BUILTIN, LOW);
  }
  delay(2000);

}

