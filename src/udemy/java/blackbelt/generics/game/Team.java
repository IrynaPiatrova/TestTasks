package udemy.java.blackbelt.generics.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("New participant " + participant.getName() + " in " + this.name + " team");
    }

    public void playWinner(Team<T> team) {
        String nameWinner;
        Random random = new Random();
        int i = random.nextInt(2); // 0 or 1

        nameWinner = i == 0 ? this.name : team.name;

        System.out.println("winner: " + nameWinner);
    }
}
