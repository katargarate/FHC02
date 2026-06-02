public class Ansi {

    // Reset

    public static final String RESET = "\u001B[0m";

    // Regular Colors

    public static final String BLACK = "\u001B[30m";

    public static final String RED = "\u001B[31m";

    public static final String GREEN = "\u001B[32m";

    public static final String YELLOW = "\u001B[33m";

    public static final String BLUE = "\u001B[34m";

    public static final String PURPLE = "\u001B[35m";

    public static final String CYAN = "\u001B[36m";

    public static final String WHITE = "\u001B[37m";

    // Bright Colors

    public static final String BRIGHT_BLACK = "\u001B[90m";

    public static final String BRIGHT_RED = "\u001B[91m";

    public static final String BRIGHT_GREEN = "\u001B[92m";

    public static final String BRIGHT_YELLOW = "\u001B[93m";

    public static final String BRIGHT_BLUE = "\u001B[94m";

    public static final String BRIGHT_PURPLE = "\u001B[95m";

    public static final String BRIGHT_CYAN = "\u001B[96m";

    public static final String BRIGHT_WHITE = "\u001B[97m";

    // Background Colors

    public static final String BG_BLACK = "\u001B[40m";

    public static final String BG_RED = "\u001B[41m";

    public static final String BG_GREEN = "\u001B[42m";

    public static final String BG_YELLOW = "\u001B[43m";

    public static final String BG_BLUE = "\u001B[44m";

    public static final String BG_PURPLE = "\u001B[45m";

    public static final String BG_CYAN = "\u001B[46m";

    public static final String BG_WHITE = "\u001B[47m";

    // Bright Background Colors

    public static final String BG_BRIGHT_BLACK = "\u001B[100m";

    public static final String BG_BRIGHT_RED = "\u001B[101m";

    public static final String BG_BRIGHT_GREEN = "\u001B[102m";

    public static final String BG_BRIGHT_YELLOW = "\u001B[103m";

    public static final String BG_BRIGHT_BLUE = "\u001B[104m";

    public static final String BG_BRIGHT_PURPLE = "\u001B[105m";

    public static final String BG_BRIGHT_CYAN = "\u001B[106m";

    public static final String BG_BRIGHT_WHITE = "\u001B[107m";

    // Styles

    public static final String BOLD = "\u001B[1m";

    public static final String DIM = "\u001B[2m";

    public static final String ITALIC = "\u001B[3m";

    public static final String UNDERLINE = "\u001B[4m";

    public static final String BLINK = "\u001B[5m";

    public static final String REVERSE = "\u001B[7m";

    public static final String HIDDEN = "\u001B[8m";

    public static final String STRIKETHROUGH = "\u001B[9m";

    public static void main(String[] args) {

        System.out.println("=== REGULAR COLORS ===");

        System.out.println(BLACK + "BLACK" + RESET);

        System.out.println(RED + "RED" + RESET);

        System.out.println(GREEN + "GREEN" + RESET);

        System.out.println(YELLOW + "YELLOW" + RESET);

        System.out.println(BLUE + "BLUE" + RESET);

        System.out.println(PURPLE + "PURPLE" + RESET);

        System.out.println(CYAN + "CYAN" + RESET);

        System.out.println(WHITE + "WHITE" + RESET);

        System.out.println("\n=== BRIGHT COLORS ===");

        System.out.println(BRIGHT_BLACK + "BRIGHT BLACK" + RESET);

        System.out.println(BRIGHT_RED + "BRIGHT RED" + RESET);

        System.out.println(BRIGHT_GREEN + "BRIGHT GREEN" + RESET);

        System.out.println(BRIGHT_YELLOW + "BRIGHT YELLOW" + RESET);

        System.out.println(BRIGHT_BLUE + "BRIGHT BLUE" + RESET);

        System.out.println(BRIGHT_PURPLE + "BRIGHT PURPLE" + RESET);

        System.out.println(BRIGHT_CYAN + "BRIGHT CYAN" + RESET);

        System.out.println(BRIGHT_WHITE + "BRIGHT WHITE" + RESET);

        System.out.println("\n=== BACKGROUND COLORS ===");

        System.out.println(BG_BLACK + WHITE + " BG BLACK " + RESET);

        System.out.println(BG_RED + WHITE + " BG RED " + RESET);

        System.out.println(BG_GREEN + BLACK + " BG GREEN " + RESET);

        System.out.println(BG_YELLOW + BLACK + " BG YELLOW " + RESET);

        System.out.println(BG_BLUE + WHITE + " BG BLUE " + RESET);

        System.out.println(BG_PURPLE + WHITE + " BG PURPLE " + RESET);

        System.out.println(BG_CYAN + BLACK + " BG CYAN " + RESET);

        System.out.println(BG_WHITE + BLACK + " BG WHITE " + RESET);

        System.out.println("\n=== BRIGHT BACKGROUND COLORS ===");

        System.out.println(BG_BRIGHT_BLACK + WHITE + " BG BRIGHT BLACK " + RESET);

        System.out.println(BG_BRIGHT_RED + WHITE + " BG BRIGHT RED " + RESET);

        System.out.println(BG_BRIGHT_GREEN + BLACK + " BG BRIGHT GREEN " + RESET);

        System.out.println(BG_BRIGHT_YELLOW + BLACK + " BG BRIGHT YELLOW " + RESET);

        System.out.println(BG_BRIGHT_BLUE + WHITE + " BG BRIGHT BLUE " + RESET);

        System.out.println(BG_BRIGHT_PURPLE + WHITE + " BG BRIGHT PURPLE " + RESET);

        System.out.println(BG_BRIGHT_CYAN + BLACK + " BG BRIGHT CYAN " + RESET);

        System.out.println(BG_BRIGHT_WHITE + BLACK + " BG BRIGHT WHITE " + RESET);

        System.out.println("\n=== TEXT STYLES ===");

        System.out.println(BOLD + "BOLD" + RESET);

        System.out.println(DIM + "DIM" + RESET);

        System.out.println(ITALIC + "ITALIC" + RESET);

        System.out.println(UNDERLINE + "UNDERLINE" + RESET);

        System.out.println(BLINK + "BLINK (might not work in all terminals)" + RESET);

        System.out.println(REVERSE + "REVERSE" + RESET);

        System.out.println(HIDDEN + "HIDDEN (you probably can't see this)" + RESET);

        System.out.println(STRIKETHROUGH + "STRIKETHROUGH" + RESET);

        System.out.println("\n=== COMBINATIONS ===");

        System.out.println(BOLD + RED + "BOLD RED" + RESET);

        System.out.println(UNDERLINE + BLUE + "UNDERLINED BLUE" + RESET);

        System.out.println(BOLD + BG_YELLOW + BLACK + " BOLD BLACK ON YELLOW " + RESET);

        System.out.println(ITALIC + PURPLE + "ITALIC PURPLE" + RESET);

        System.out.println(BRIGHT_CYAN + BG_BLACK + " BRIGHT CYAN ON BLACK " + RESET);

    }

}