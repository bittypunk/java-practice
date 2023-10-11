package week4;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.stringInput;
import static java.util.Collections.sort;

public class guestList {
    public static void main(String[] args) {

        List<String> guests = new ArrayList<>();

        while(true) {
            String guest = stringInput("Please type a guest's name, or press Enter to exit.");

            // end if an empty string is entered
            if (guest.isEmpty()) {
                break;
            }

            // ask for another guest if the guest already exists
            if (guests.contains(guest)) {
                System.out.println("This guest has already been added.");
                continue;
            }

            // add the guest to the list
            guests.add(guest);
        }

        // sort guests in alphabetical order
        sort(guests);

        // print the guests
        for (String guest: guests) {
            System.out.println(guest);
        }

        // ask if the user wants to delete any names
        while (true) {
            String exile = stringInput("If you would like to remove a name, please type it here, else press Enter");

            // stop asking once an empty string is entered
            if (exile.isEmpty()) {
                break;
            }

            // if the name exists, remove it
            if (guests.contains(exile)) {
                guests.remove(exile);
            }
            else {
                System.out.println("This guest doesn't exist");
            }
        }

        // print the list again
        System.out.println("Here is the edited list, containing " + guests.size() + " guests.");
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
