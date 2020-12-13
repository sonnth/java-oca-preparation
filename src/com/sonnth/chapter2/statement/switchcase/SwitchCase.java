package com.sonnth.chapter2.statement.switchcase;

public class SwitchCase {
    public static void main(String[] args) {

    }

    private static int getSortOrder(String firstName, final String lastName) {
        String middleName = "Patricia";
        final String suffix = "JR";
        int id = 0;
        switch(firstName) {
            case "Test":
                return 52;
//            case middleName: // DOES NOT COMPILE ==> middleName is not a final variable
//                id = 5;
//                break;
            case suffix:
                id = 0;
                break;
//            case lastName: // DOES NOT COMPILE ==> lastName passed to the function, not constant
//                id = 8;
//                break;
//            case 5: // DOES NOT COMPILE ==> different type
//                id = 7;
//                break;
//            case 'J': // DOES NOT COMPILE ==> different type
//                id = 10;
//                break;
//            case java.time.DayOfWeek.SUNDAY: // DOES NOT COMPILE ==> different type
//                id=15;
//                break;
        }
        return id;
    }
}
