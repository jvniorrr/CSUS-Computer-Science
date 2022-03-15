public class PracticeProblemsWeek3 {
    
    public static void main(String[] args) {
        practiceProblem2();
    }

    public static void practiceProblem1() {
        /*
        write the pseducode 

        declare int score1 = 97

        declare score2 = 95

        declare score3 = 88

        declare double avg = (score1 + score2 + score3)/3

        display score1

        display score2

        display score 3
        display the avg
        */
        int score1 = 97, score2 =95, score3 = 88;
        double avg = (score1 + score2 + score3) / 3;
        System.out.printf("%d\n%d\n%d\n%.1f", score1, score2, score3, avg);
    }
    public static void practiceProblem2() {
        /*
        declare double weight = 115

        declare double height = 70 

        declare double bmi = (weight /height * height) * 703

        display weight

        display heigh

        display bmi
        */
        double weight = 115, height = 70;
        double bmi = (weight / height * height) * 703;
        System.out.printf("%.1f\n%.1f\n%.1f", weight, height, bmi);
    }
    public static void problem1() {
        for (int i=100; i>0;i-=2){
            System.out.printf("%d ", i);
        }
    }
    public static void problem2() {
        for (int i=0; i<=5;i++){
            System.out.print(i*18-4 + " ");
        }
    }
    public static void problem3() {
        for(int i=1; i<=10;i++) System.out.printf("%d ", i*i);
    }
    public static void problem4() {
        /*
        output:
        KPH   MPH
        60    37.3
        70    43.5
        90    49.7
        ...   ...
        130   80.8
        */

        System.out.printf("%3s %8s\n", "KPH", "MPH");

        // use the MPH as for loop variable
        for (int i=90; i<=130; i+=10){
            // retrieve mph from kph, using formular below.
            double mph = i / 1.609;

            /* format specifiers; 
            print kph right aligned to every 3 characters
            print mph right aligned to every 8 characters (in a sense a tab). 
            Also format the double/float value to tenth decimal value, which fortunately also gets rounded
            */
            System.out.printf("%3d %8.1f\n", i, mph); 
            
        }
    }
    public static void problem5() {
        /*
        70 days until to eat turkey
        69 days until to eat turkey
        68 days until to eat turkey
        ........
        2 days until to eat turkey
        1 day until to eat turkey
        finally we eat turkey today
        */

        for (int i=70; i > 0; i--) {
            System.out.printf("%d days until to eat turkey\n", i);
        }
        System.out.println("finally we eat turkey today");
    }
    public static void problem6() {
        /*
        output:
        Hour      travel
        1         40
        2         80
        3         120
        ...      ...
        10       400 
        */
        int speed = 40;
        System.out.printf("%4s %8s\n", "Hour", "travel");
        for (int i=1; i<=10; i++) {
            System.out.printf("%-6d %-8d\n", i, i*speed);
        }
    }

}