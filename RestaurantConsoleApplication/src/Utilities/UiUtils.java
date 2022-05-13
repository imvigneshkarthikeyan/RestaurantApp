package Utilities;

public class UiUtils {
    public static void drawDoubleLine() {
        System.out.println("\033[0;1m=========================================================================================================================================================\033[0;0m");
    }

    public static void drawLine() {
        System.out.println("\033[0;1m---------------------------------------------------------------------------------------------------------------------------------------------------------\033[0;0m");
    }
    
    public static void displayLineTitleAndUser(String messageTitle, String typeOfUser) {
        drawDoubleLine();
        System.out.println("\033[0;1m=================================================================== " + messageTitle + " " + typeOfUser + " ===================================================================\033[0;0m");
        drawDoubleLine();
    }

    public static void displayLineWithTitle(String messageTitle) {
        drawDoubleLine();
        System.out.println("\033[0;1m==================================================================== " + messageTitle + " =====================================================================\033[0;0m");
        drawDoubleLine();
    }
}
