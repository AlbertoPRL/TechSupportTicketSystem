public class Ticket {
    private int id;
    private String name;
    private String description;
    private String priority;

    public Ticket(int id, String name, String description, String priority){
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getPriority(){
        return priority;
    }

    @Override
    public String toString(){
        return String.format("[#%d] %s - %s (%s)",id, name, description, priority);
    }
}