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
                case "1" -> {
                    supportDesk.addTicket(new Ticket(5,"asd", "asd", "asd"));
                }
                case "2" -> {
                    supportDesk.processNextTicket();
                }
                case "3" -> {
                    supportDesk.viewAllActiveTickets();
                }
                case "4" -> {
                    supportDesk.viewRecentResolved();
                }
                case "5" -> {
                    supportDesk.reopenLastResolved();
                }
                case "6" -> {
                    System.out.println("Thank you for using MDC Tech Support Ticket System!");
                }
                default -> {
                    System.out.println("Invalid selection, please try again");
                }
            }
        }
    }
}