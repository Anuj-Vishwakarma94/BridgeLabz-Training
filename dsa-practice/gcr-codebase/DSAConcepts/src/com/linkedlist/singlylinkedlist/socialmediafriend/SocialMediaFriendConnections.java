package com.linkedlist.singlylinkedlist.socialmediafriend;

public class SocialMediaFriendConnections {
    public static void main(String[] args) {

        SocialMediaLinkedList sm = new SocialMediaLinkedList();

        sm.addUser(1, "Andrew", 39);
        sm.addUser(2, "Anuj", 21);
        sm.addUser(3, "Tristan", 36);
        sm.addUser(4, "Ellie", 21);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(3, 4);

        System.out.println("\n--- Display Friends ---");
        sm.displayFriends(1);

        System.out.println("\n--- Mutual Friends (1 & 2) ---");
        sm.findMutualFriends(1, 2);

        System.out.println("\n--- Search by Name ---");
        sm.searchByName("Neha");

        System.out.println("\n--- Count Friends ---");
        sm.countFriends();

        System.out.println("\n--- Remove Friend Connection ---");
        sm.removeFriendConnection(1, 3);
        sm.displayFriends(1);
    }
}