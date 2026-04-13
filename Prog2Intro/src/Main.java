import Model.AgeCalculator;
import Model.OpeningHours;
import Model.OpeningVariations;
import Model.Shop;

void main() {
      Scanner sc = new Scanner(System.in);
//    System.out.print("Enter your age: ");
//
//    int age = sc.nextInt();
//
//    AgeCalculator ac = new AgeCalculator();
//
//    System.out.printf("\nYou are %d months / %d weeks / %d days old.",
//            ac.getAgeInMonths(age), ac.getAgeInWeeks(age), ac.getAgeInDays(age));
    System.out.print("Enter day of week (1-7): ");

    // get int to assign to DayOfWeek that will then assign it to a day
    int num = sc.nextInt();
    DayOfWeek dow = DayOfWeek.of(num);

    // create instances of opening hours
    OpeningHours oh1 = new OpeningHours("10:00", "18:00", OpeningVariations.MONTOFRI);
    OpeningHours oh2 = new OpeningHours("10:00", "18:00", OpeningVariations.TUETOFRI);

    // System.out.println("\nOpening hours for today: " + oh2.getOpeningHoursToday(dow));

    Shop shop1 = new Shop("Utes Utensilien", oh1);
    OpeningHours ohshop1 = shop1.getOPENING_HOURS(); // returns the shops instance of opening hours
    System.out.printf("\n%s: %s\n", shop1.getNAME(), ohshop1.getOpeningHoursToday(dow)); // print opening hours message


    Shop shop2 = new Shop("Billa", oh2);
    OpeningHours ohshop2 = shop2.getOPENING_HOURS(); // returns the shops instance of opening hours
    System.out.printf("\n%s: %s", shop2.getNAME(), ohshop2.getOpeningHoursToday(dow)); // print opening hours message



}
