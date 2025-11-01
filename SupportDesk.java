import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SupportDesk {
    private Queue<Ticket> activeTickets = new LinkedList<>();
    private Stack<Ticket> resolvedTickets = new Stack<>();

    public SupportDesk(){

    }

    public void addTicket(Ticket t){
        activeTickets.add(t);
        System.out.println("Ticket added");
    }

    public void processNextTicket(){
        if(!activeTickets.isEmpty()) {
            resolvedTickets.add(activeTickets.remove());
            System.out.println("Ticket successfully processed");
        }
        else {
            System.out.println("There are no active tickets at this moment");
        }
    }

    public void viewAllActiveTickets(){
        if(!activeTickets.isEmpty()) {
            for (Ticket ticket : activeTickets) {
                System.out.println(ticket);
            }
        }
        else{
            System.out.println("There are no active tickets at this moment");
        }
    }

    public void viewRecentResolved(){
        if(!resolvedTickets.isEmpty()){

        }
    }

    public void reopenLastResolved(){
        if(!resolvedTickets.isEmpty()){
            activeTickets.add(resolvedTickets.pop());
        }
        else{
            System.out.println("There are no resolved tickets at this point");
        }
    }
}