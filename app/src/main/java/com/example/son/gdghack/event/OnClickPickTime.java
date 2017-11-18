package com.example.son.gdghack.event;

import com.example.son.gdghack.models.Guest;

/**
 * Created by nttungPC on 11/18/2017.
 */

public class OnClickPickTime {
    private Guest guest;

    public OnClickPickTime(Guest guest) {
        this.guest = guest;
    }

    public Guest getGuest() {
        return guest;
    }
}
