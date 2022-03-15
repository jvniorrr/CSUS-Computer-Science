public class SailBoatHelper {
    public static void drawSailBoat() {
        // draw sail
        drawSail();

        // draw similar water line on top of boat or tub shape
        drawWaterLine();

        // draw boat / tub figure
        drawBoat();

        // draw 2 water lines
        drawWaterLine();
        drawWaterLine();
    }
    public static void drawSail() {
        System.out.println("      *\n      **\n      ***\n      ****\n      *****\n      ******");
    }
    public static void drawWaterLine() {
        System.out.println("------------");
    }
    public static void drawBoat() {
        /* 
        could also call the draw water line method here,
        but feel it could have some type of issue memory wise or how class object is
        executed? would prefer other approach adding drawWaterLine above 
       & out of this drawBoat method. (called inside drawSailBoat)
        */
        // drawWaterLine();
        System.out.println("\\          /");
        System.out.println(" \\        /");
        System.out.println("  --------");
    }
}
