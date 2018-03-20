int sensor_pin = A0;
int mosfetPin = 13;
int relayPin = 8;
int output_value ;
int output_value_perc;
int valve_status = 0;
String message_from_pc;
int waterReq;
int minMoisture;
int maxMoisture;
boolean isDataSet = false;

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

  //  Serial.print("Mositure value: ");
  //   Serial.print(output_value);

  output_value_perc = map(output_value, 1024, 0, 0, 100);

  //   Serial.print(" \t Mositure percentage: ");



  //   Serial.print(output_value_perc);
  //   Serial.print("%");
  //   Serial.print("\t Mosfet Pin = ");
  //   Serial.println(mosfetPin);

  //
  //  if (waterReq > 0)
  //  {
  //    if (output_value_perc >= maxMoisture)
  //    {
  //
  //      //    Close Valve
  //      //    Serial.println("<< Valave Closed >>");
  //
  //      digitalWrite(mosfetPin, LOW);
  //      digitalWrite(relayPin, LOW);
  //
  //      valve_status = 0;
  //      waterReq--;
  //    }
  //    else
  //    {
  //      if (output_value_perc <= minMoisture) {
  //        //    Open Valve
  //        //    Serial.println(" || Valave Opened ||");
  //
  //        digitalWrite(mosfetPin, HIGH);
  //        valve_status = 1;
  //
  //        digitalWrite(relayPin, HIGH);
  //      }
  //    }
  //  }
  //  else {
  //    digitalWrite(mosfetPin, LOW);
  //    digitalWrite(relayPin, LOW);
  //  }


  //  message_from_pc = Serial.readString();
  //
  //  //    mss = moisture sensor status
  //
  //  if (message_from_pc == "moisture") {
  //
  //    Serial.print(output_value_perc);
  //    // Serial.write();
  //    digitalWrite(LED_BUILTIN, HIGH);
  //  }
  //
  //  //    vs = valve status
  //
  //  else if (message_from_pc == "valve") {
  //    Serial.print(valve_status);
  //    digitalWrite(LED_BUILTIN, LOW);
  //  }
  //  delay(2000);


  String message1;

  message1 = Serial.readString();
  if (message1 == "readM") {
    digitalWrite(LED_BUILTIN, HIGH);
      
    Serial.print(output_value_perc);

  }
  else if (message1 == "cvs") {
    Serial.print("message");
    String vState;
    //    while (vState != "ON" || vState != "OFF")
    vState = Serial.readString();
    if (vState == "ON") {
      digitalWrite(mosfetPin, HIGH);
      digitalWrite(relayPin, HIGH);
      Serial.print("ON");

    }
    else if (vState == "OFF") {
      digitalWrite(mosfetPin, LOW);
      digitalWrite(relayPin, LOW);
      digitalWrite(LED_BUILTIN, LOW);
      Serial.print("OFF");
    }
//    else {
//      Serial.print("Wrong Entry Inside");
//    }
  }
//  else {
//    Serial.print("Wrong Entry");
//  }
  delay(2000);
}



