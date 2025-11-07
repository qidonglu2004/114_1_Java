public class SwordsMan extends Role {
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    @Override
    public void attack(Role opponent) {
        opponent.takeDamage(getAttackPower());
        System.out.println(getName() + " 揮劍攻擊 " + opponent.getName() +
                " 造成 " + getAttackPower() + " 點物理傷害！");
    }
}
