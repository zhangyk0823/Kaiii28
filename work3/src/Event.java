import java.time.LocalDate;
import java.util.*;

public class Event{

    Scanner reader = new Scanner(System.in);

    HashMap<String,Attendee> seatDetails = new HashMap<>(200,0.6f);

    private String eventID;
    private String eventName;
    private LocalDate eventDate;
    private String eventVenue;
    ArrayList<Attendee>eventAttendees = new ArrayList<>();

    public Event(){}
    public void setEventID(String id){
        eventID = id;
    }
    public String getEventID(){
        return eventID;
    }
    public void setEventName(String name){
        eventName = name;
    }
    public String getEventName(){
        return eventName;
    }
    public void setEventDate(LocalDate date){
        eventDate = date;
    }
    public LocalDate getEventDate(){
        return eventDate;
    }
    public void setEventVenue(String venue){
        eventVenue = venue;
    }
    public String getEventVenue(){
        return eventVenue;
    }
    public void setSeatDetails(String seat,Attendee attendee){
        seatDetails.put(seat,attendee);
    }
    public void getSeatDetails(String seat){
        System.out.println("The details of the seat" + "are as follows:" + "\n" + seatDetails.get(seat));
    }
    public void organizeEvent(int choice){

        switch(choice){
            case 1:
                System.out.println("Enter the Event ID: ");
                String id = reader.nextLine();
                setEventID(id);

                System.out.println("Enter the name of the event ");
                String eventName = reader.nextLine();
                setEventName(eventName);

                System.out.println("Enter the Event date (YYYY-MM-DD): ");
                LocalDate date= LocalDate.parse(reader.nextLine());
                setEventDate(date);

                System.out.println("Enter the event's venue: ");
                String venue = reader.nextLine();
                setEventVenue(venue);
            case 2:
                System.out.println("How many attendees are coming?: ");
                int num = reader.nextInt();
                reader.nextLine();

                for(int i=0;i<num;i++){
                    System.out.println("Enter the name of the attendee: ");
                    String name = reader.nextLine();

                    System.out.println("Enter the gender of the attendee: ");
                    char gender = reader.nextLine().charAt(0);

                    System.out.println("Enter the age of the attendee: ");
                    int age = reader.nextInt();
                    reader.nextLine();

                    System.out.println("Enter the email of the attendee: ");
                    String email = reader.nextLine();

                    System.out.println("Enter the seat number for the attendee: ");
                    String seat = reader.nextLine();

                    Attendee newAttendee = new Attendee(name, gender, email, age);

                    eventAttendees.add(newAttendee);
                    seatDetails.put(seat, newAttendee);
                    setSeatDetails(seat, newAttendee);

                }
                System.out.println("\n"+"All the attdendee were added successfully to the list of attendees");
                break;
            case 3:
            System.out.println("Enter the name of the attendee to remove:");
            String nameToRemove = reader.nextLine();

            for(Attendee attendee : eventAttendees){
                if(nameToRemove.equals(attendee.getName())){
                    eventAttendees.remove(attendee);
                    break;
                }
            }
            System.out.println("\n"+nameToRemove+"is removed.");
            break;
            case 4:

            System.out.println("Enter the name, or enter null if you dont't want to update:");
            String nameToUpdate = reader.nextLine();

            for(Attendee attendee : eventAttendees){
                if(nameToUpdate.equals(attendee.getName())){
                    System.out.println("Enter the new name, or enter null if you don' want to update : ");
                    String newName = reader.nextLine();
                    if(!newName.equals("null")){
                        attendee.setName(newName);                       
                    }                       
                    System.out.println("Enter the new age, or enter 0 if you don't want to update :");                       
                    int newAge = reader.nextInt();                       
                    reader.nextLine();                       
                    if(newAge != 0){                          
                        attendee.setAge(newAge);                        
                    }                       
                    System.out.println("Enter the new email, or enter null if you don't want to update :");                       
                    String newEmail = reader.nextLine();                       
                    if(!newEmail.equals("null")){                           
                        attendee.setEmail(newEmail);                        
                    }                       
                    System.out.println("Enter the new gender, or enter null if you don't want to update :");                       
                    String newGender = reader.nextLine();                       
                    if(!newGender.equals("null")){                           
                        attendee.setGender(newGender.charAt(0));                        
                    }                       
                    break;                    
                }                    
                else {                        
                    System.out.println("Invalid position. No update performed.");                        
                }                        
                break;
            }                               
            break;
            case 5:
                System.out.println("Enter the name of attendee to find:");
                String nameToFind = reader.nextLine();
                for(Attendee attendee : eventAttendees){
                    if(attendee.getName().equals(nameToFind)){
                        System.out.println(attendee);
                        System.out.println("\n"+nameToFind+"is found");
                        break;
                    }
                    else {                        
                        System.out.println("\nIt didn't find.");                        
                        break;                        
                    }                
                }                
                break;            
                case 6:                
                    System.out.println("Here is the list of attendees: "+"\n"+eventAttendees);                
                    break;            
                case 7:                
                    break;            
                default:                
                    System.out.println("Invalid choice");                        
            }    
        }
    }
