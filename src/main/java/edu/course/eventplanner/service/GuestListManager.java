package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import java.util.*;

public class GuestListManager {
    private final LinkedList<Guest> guests = new LinkedList<>();
    private final Map<String, Guest> guestByName = new HashMap<>();
    public void addGuest(Guest guest) { /* TODO */
   if(guestByName.containsKey(guest.getName())){
       System.out.println("Guest already exists");
   } else{
    guests.add(guest);
    guestByName.put(guest.getName(), guest);}
    }
    public boolean removeGuest(String guestName) {
        if(!guestByName.containsKey(guestName)){
            return false;
        }
        guestByName.remove(guestName);
        guests.remove(guestByName.get(guestName));
        return true; }
    public Guest findGuest(String guestName) {
        if (guestByName.containsKey(guestName)){
            System.out.println("Guest found");
            return guestByName.get(guestName);
        }else{
            System.out.println("Guest not found");
            return null;
        }
    }
    public int getGuestCount() {
        return guests.size(); }
    public List<Guest> getAllGuests() { return guests; }
}
