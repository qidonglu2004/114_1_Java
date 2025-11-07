public class SwordsMan {
    private String name;
    private int health;
    private int attackPower;

    public SwordsMan(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void attack(SwordsMan opponent) {
        opponent.health -= this.attackPower;
        System.out.println(this.name + " 攻擊 " + opponent.name +
                " 造成 " + this.attackPower + " 點傷害！");
    }

    public boolean isAlive() {
        return health > 0;
    }
}
