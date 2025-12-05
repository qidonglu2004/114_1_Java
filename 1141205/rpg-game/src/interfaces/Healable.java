package com.rpg.interfaces;

import com.rpg.core.Role;

public interface Healable {

    void heal(Role target);

    int getHealPower();

    default boolean canHeal() {
        return getHealPower() > 0;
    }
    default void showHealInfo() {
        System.out.println("💚 治療力：" + getHealPower() + " 點");
    }
}
