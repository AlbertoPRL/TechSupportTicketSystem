import java.util.Scanner;

public class SupportDeskApp {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        SupportDesk supportDesk = new SupportDesk();
        String choice = "";

        while(!"6".equals(choice)){
            System.out.println("Welcome to MDC tech support system \n");
            System.out.println("1. Add new support ticket");
            System.out.println("2. Process next ticket");
            System.out.println("3. View all active tickets");
            System.out.println("4. View recently resolved tickets");
            System.out.println("5. Reopen last resolved ticket");
            System.out.println("6. Exit");

            choice = scnr.nextLine();

            switch(choice){
                case "1" -> supportDesk.addTicket(createTicketFromInput(scnr));
                case "2" -> supportDesk.processNextTicket();
                case "3" -> supportDesk.viewAllActiveTickets();
                case "4" -> supportDesk.viewRecentResolved();
                case "5" -> supportDesk.reopenLastResolved();
                case "6" -> System.out.println("Thank you for using MDC Tech Support Ticket System!");
                default -> System.out.println("Invalid selection, please try again");
            }
        }
    }


    /*
    This method, along with other input validation methods, could be extracted
    to a dedicated TicketInputHandler class for better separation of concerns
    and improved code organization.
    */
    private static Ticket createTicketFromInput(Scanner scnr) {
        int id = validateIntInput(scnr);
        String name = validateStringInput(scnr, "Enter requester name: ");
        String issue = validateStringInput(scnr, "Enter issue: ");
        String priority = validatePriority(scnr);

        return new Ticket(id, name, issue, priority);
    }

    private static int validateIntInput(Scanner scnr) {
        while (true) {
            System.out.print("Enter ticket ID: ");
            String input = scnr.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for ticket ID.");
            }
        }
    }

    private static String validateStringInput(Scanner scnr, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scnr.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            else {
                System.out.println("Input cannot be empty. Please enter a value.");
            }
        }
    }


    //Validates priority and returns a standardized priority (String)
    private static String validatePriority(Scanner scnr) {
        while (true) {
            System.out.print("Enter priority (Low/Medium/High): ");
            String priority = scnr.nextLine().trim();
            if (priority.equalsIgnoreCase("Low") ||
                    priority.equalsIgnoreCase("Medium") ||
                    priority.equalsIgnoreCase("High")) {

                return priority.substring(0, 1).toUpperCase() +
                        priority.substring(1).toLowerCase();
            }
            System.out.println("Invalid priority. Please enter Low, Medium, or High.");
        }
    }
}