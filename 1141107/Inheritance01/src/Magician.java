public class Magician extends Role {

    private int magicPower;
    private int mana;

    public Magician(String name, int health, int attackPower, int magicPower, int mana) {
        super(name, health, attackPower);
        this.magicPower = magicPower;
        this.mana = mana;
    }

    public int getMagicPower() { return magicPower; }
    public int getMana() { return mana; }

    // 魔法攻擊（消耗 10 點魔力）
    public void castSpell(Role opponent) {
        if (mana >= 10) {
            opponent.takeDamage(this.magicPower);
            mana -= 10;
            System.out.println(getName() + " 對 " + opponent.getName() +
                    " 施放魔法，造成 " + magicPower + " 點傷害！（剩餘魔力：" + mana + "）");
        } else {
            System.out.println(getName() + " 的魔力不足，無法施法！");
        }
    }

    // 回魔
    public void recoverMana(int amount) {
        mana += amount;
        System.out.println(getName() + " 恢復了 " + amount + " 點魔力！（目前魔力：" + mana + "）");
    }

    // 治療（新增）
    public void heal(Role ally) {
        if (mana >= 15) {
            int healAmount = magicPower;
            ally.healBy(healAmount);
            mana -= 15;
            System.out.println(getName() + " 對 " + ally.getName() +
                    " 施放治療術，恢復 " + healAmount + " 點生命！（剩餘魔力：" + mana + "）");
        } else {
            System.out.println(getName() + " 的魔力不足，無法施放治療術！");
        }
    }

    // 覆寫普通攻擊
    @Override
    public void attack(Role opponent) {
        opponent.takeDamage(getAttackPower());
        System.out.println(getName() + " 揮舞法杖攻擊 " + opponent.getName() +
                " 造成 " + getAttackPower() + " 點物理傷害！");
    }
}
