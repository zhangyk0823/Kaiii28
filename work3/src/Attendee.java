public class Attendee {
    private String name;
    private char gender;
    private String email;
    private int age;

    public Attendee (String name, char gender, String email,int age)  {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
       return name;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    public char getGender(){
        return gender;
    }
    
    public void setEmail(String email){
        this.email = email;
        
    }
    public String getEmail(){
        return email;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
