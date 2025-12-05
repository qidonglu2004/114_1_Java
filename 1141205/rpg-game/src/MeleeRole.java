package com.rpg.roles.melee;

import com.rpg.core.Role;

public abstract class MeleeRole
        extends Role {
    private int armor;

    public MeleeRole(String name,
                     int health,
                     int attackPower,
                     int armor) {
        super(name, health, attackPower);
        this.armor = armor;
    }

    public int getArmor() { return armor; }
    public void setArmor(int armor) { this.armor = armor; }

    public int calculateDefense(int incomingDamage) {
        int actualDamage = Math.max(0, incomingDamage - armor);
        if (armor > 0 && incomingDamage > 0) {
            System.out.println("🛡️  護甲減免 " + Math.min(armor, incomingDamage) + " 點傷害！");
        }
        return actualDamage;
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = calculateDefense(damage);
        super.takeDamage(actualDamage);
    }

    public abstract String getWeaponType();

    @Override
    public void prepareBattle() {
        System.out.println("⚔️  " + getName() + " 檢查 " + getWeaponType() + " 的狀態...");
        System.out.println("🛡️  目前護甲值：" + armor);
        onMeleePrepare();
    }

    protected abstract void onMeleePrepare();

    @Override
    public String toString() {
        return super.toString() + ", 護甲值: " + armor;
    }
}
