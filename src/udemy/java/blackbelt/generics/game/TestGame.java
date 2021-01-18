package udemy.java.blackbelt.generics.game;

public class TestGame {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Kate", 13);
        Schoolar schoolar2 = new Schoolar("Rita", 14);
        Schoolar schoolar3 = new Schoolar("Oleg", 13);
        Schoolar schoolar4 = new Schoolar("Tim", 14);

        Student student1 = new Student("Pot", 17);
        Student student2 = new Student("Tom", 18);

        Employee employee1 = new Employee("Ira", 23);
        Employee employee2 = new Employee("Ann", 24);

        Team<Schoolar> schoolTeam = new Team<>("Drakon");
        schoolTeam.addNewParticipant(schoolar1);
        schoolTeam.addNewParticipant(schoolar2);
        /*schoolTeam.addNewParticipant(student1);
        schoolTeam.addNewParticipant(employee1);*/ //wrong example

        Team<Schoolar> schoolTeam2 = new Team<>("Mudretcy");
        schoolTeam2.addNewParticipant(schoolar3);
        schoolTeam2.addNewParticipant(schoolar4);

        Team<Student> studentTeam = new Team<>("Murka");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("Murka");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        schoolTeam.playWinner(schoolTeam2);
        /*schoolTeam.playWinner(employeeTeam);*/ //wrong example
    }
}
