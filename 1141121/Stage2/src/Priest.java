public class Priest extends Role {
    private int groupHealPower;

    public Priest(String name, int health, int attackPower, int groupHealPower) {
        super(name, health, attackPower);
        this.groupHealPower = groupHealPower;
    }

    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 發出神聖之光攻擊 " +
                opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：群體治療          ║");
        System.out.println("║ 技能描述：治療所有隊友      ║");
        System.out.println("║ 治療量：" + groupHealPower + " 點生命值       ║");
        System.out.println("╚═════════════════════════════╝");
    }
}