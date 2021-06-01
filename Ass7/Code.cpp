#define D4 4
#define D5 5
#define D6 6
#define D7 7
#define E 8
#define RS 9

#include <LiquidCrystal.h>
//LiquidCrystal lcd(13,12,5,4,3,2);
LiquidCrystal lcd(RS, E, D4, D5, D6, D7);  
void setup() {
    // set up the LCD's number of columns and rows:
    lcd.begin(16, 2);
    // Print a message to the LCD.
    lcd.print("hello, world!");
    delay(1000);
}

void loop() {
    // scroll 13 positions (string length) to the left
    // to move it offscreen left:
    for (int i = 0; i < 13; i++) {
        // scroll one position left:
        lcd.scrollDisplayLeft();
        // wait a bit:
        delay(150);
    }

    // scroll 29 positions (string length + display length) to the right
    // to move it offscreen right:
    for (int i = 0; i < 29; i++) {
        // scroll one position right:
        lcd.scrollDisplayRight();
        // wait a bit:
        delay(150);
    }

    // scroll 16 positions (display length + string length) to the left
    // to move it back to center:
    for (int i= 0; i< 16; i++) {
        // scroll one position left:
        lcd.scrollDisplayLeft();
        // wait a bit:
        delay(150);
    }
    // delay at the end of the full loop:
    delay(2000);
}