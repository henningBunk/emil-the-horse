#include <SoftwareSerial.h>// import the serial library
 
SoftwareSerial BT(2, 3); // RX, TX
int ledpin=9; // led on D13 will show blink on / off
int BluetoothData; // the data given from Computer
 
void setup() 
{
  BT.begin(9600);
  while (!BT) {
    ; // wait for serial port to connect
  }
  BT.println("Bluetooth On please press 1 or 0 blink LED ..");
  
  pinMode(ledpin, OUTPUT);
  digitalWrite(ledpin, HIGH);
  delay(200);
  digitalWrite(ledpin, LOW);
}
 
void loop() 
{
  if (BT.available())
  {
    BluetoothData=BT.read();
    if(BluetoothData=='a')
    {   
      // if number a pressed ....
      digitalWrite(ledpin, HIGH);
      BT.println("LED  On D13 ON ! ");
    }
    if (BluetoothData=='b')
    {
      // if number b pressed ....
      digitalWrite(ledpin, LOW);
      BT.println("LED  On D13 Off ! ");
    }
  }
  delay(100);// prepare for next data ...
}
