// C++ code
//
void setup()
{
  pinMode(A0, INPUT);
  pinMode(10, OUTPUT);
  Serial.begin(9600);
}

void loop()
{
  int value = analogRead(A0);
  Serial.println("Analog Value :");
  Serial.println(value);  
  if(value>=400)
    digitalWrite(10, LOW);
  else
    digitalWrite(10, HIGH);
  delay(1000); // Wait for 1000 millisecond(s)
}
