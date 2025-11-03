import java.util.*;

public class SupportDesk {
    private Queue<Ticket> activeTickets = new LinkedList<>();
    private Stack<Ticket> resolvedTickets = new Stack<>();
    private HashSet<Integer> usedIds = new HashSet<>();

    public SupportDesk(){

    }

    public void addTicket(Ticket t){
        if(!isDuplicateId(t.getId())){
            activeTickets.add(t);
            usedIds.add(t.getId());
            System.out.println("Ticket successfully added.");
            System.out.println(t);
            System.out.println("_____________________");
        }
        else
        {
            System.out.printf("Ticket not added: ID %d already in use.\n", t.getId());
            System.out.println("_____________________");
        }

    }

    public void processNextTicket(){
        if(!activeTickets.isEmpty()) {
            System.out.println("Processing following ticket: ");
            System.out.println();
            resolvedTickets.add(activeTickets.remove());
            System.out.println("Ticket successfully processed.");
        }
        else {
            System.out.println("There are no active tickets at this moment");
        }
    }

    public void viewAllActiveTickets(){
        if(!activeTickets.isEmpty()) {
            System.out.println("Active tickets");
            System.out.println("_____________________");
            for (Ticket ticket : activeTickets) {
                System.out.println(ticket);
            }
            System.out.println("_____________________");
        }
        else{
            System.out.println("There are no active tickets at this moment");
        }
    }

    public void viewRecentResolved(){
        if(!resolvedTickets.isEmpty()) {
            System.out.println("Recently resolved tickets (most recent first):");
            System.out.println("_____________________");

            int startIndex = Math.max(0, resolvedTickets.size() - 3);

            for (int i = resolvedTickets.size() - 1; i >= startIndex; i--) {
                System.out.println(resolvedTickets.get(i));
            }
            System.out.println("_____________________");
        } else {
            System.out.println("There are no resolved tickets at this moment");
        }
    }

    public void reopenLastResolved(){
        if(!resolvedTickets.isEmpty()){
            System.out.println("The following ticket has been reopened: ");
            System.out.println(resolvedTickets.peek());
            activeTickets.add(resolvedTickets.pop());
            System.out.println("_____________________");
        }
        else{
            System.out.println("There are no resolved tickets at this point");
        }
    }

    private boolean isDuplicateId(Integer id) {
        return usedIds.contains(id);
    }
}