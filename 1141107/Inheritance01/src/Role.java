public abstract class Role {

    private String name;
    private int health;
    private int attackPower;

    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }

    public void takeDamage(int damage) {
        if (damage <= 0) return;
        health = Math.max(0, health - damage);
    }

    // 新增：被治療（供 Magician.heal() 呼叫）
    public void healBy(int amount) {
        if (amount <= 0) return;
        health += amount;
        System.out.println(name + " 恢復了 " + amount + " 點生命！（目前生命：" + health + "）");
    }

    public void attack(Role opponent) {
        opponent.takeDamage(this.attackPower);
        System.out.println(this.name + " 攻擊 " + opponent.name +
                " 造成 " + this.attackPower + " 點傷害！");
    }

    public boolean isAlive() { return health > 0; }
}
