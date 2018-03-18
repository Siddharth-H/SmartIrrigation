int sensor_pin = A0;
int mosfetPin = 13;
int relayPin= 8;
int output_value ;
int output_value_perc;
int valve_status = 0;
String message_from_pc;
int x =0;

void setup() {

   pinMode(mosfetPin, OUTPUT);
    pinMode(LED_BUILTIN, OUTPUT);
   Serial.begin(9600);
   
//   Serial.begin(115200);
//   Serial.println("Reading From the Sensor new code...");
//   delay(1000);

   }

void loop() {

   output_value= analogRead(sensor_pin);
   
//  Serial.print("Mositure value: ");
//   Serial.print(output_value);

   output_value_perc = map(output_value,1024,0,0,100);
   
//   Serial.print(" \t Mositure percentage: ");

    
     
//   Serial.print(output_value_perc);
//   Serial.print("%");
//   Serial.print("\t Mosfet Pin = ");
//   Serial.println(mosfetPin);

    
   x = Serial.read();
   
   if(x==0)
   {
    
//    Close Valve
//    Serial.println("<< Valave Closed >>");
  
     digitalWrite(mosfetPin, LOW);
     digitalWrite(LED_BUILTIN, LOW);
    digitalWrite(relayPin, LOW);
     valve_status = 0;
   }
   else if(x==1)
   {
//    Open Valve
//    Serial.println(" || Valave Opened ||");
  
    digitalWrite(mosfetPin, HIGH);
     valve_status = 1;
    digitalWrite(LED_BUILTIN, HIGH);
    digitalWrite(relayPin, HIGH);
    
   }
   
   delay(2000);

   }

