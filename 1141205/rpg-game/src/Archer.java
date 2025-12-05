// 第三階段和第四階段完全相同
public class Archer extends RangedRole {
    private int arrowCount;
    private int maxArrows;

    public Archer(String name, int health, int attackPower,
                  int range, int maxEnergy, int maxArrows) {
        super(name, health, attackPower, range, maxEnergy);
        this.maxArrows = maxArrows;
        this.arrowCount = maxArrows;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    public void reloadArrows(int amount) {
        int oldCount = arrowCount;
        arrowCount = Math.min(arrowCount + amount, maxArrows);
        System.out.println("🏹 補充箭矢 " + (arrowCount - oldCount) +
                " 支 (" + oldCount + " → " + arrowCount + ")");
    }

    @Override
    public void attack(Role opponent) {
        if (arrowCount <= 0) {
            System.out.println("❌ " + getName() + " 箭矢用盡，無法攻擊！");
            return;
        }

        if (!consumeEnergy(10)) {
            System.out.println("❌ " + getName() + " 體力不足，無法拉弓！");
            return;
        }

        arrowCount--;
        System.out.println("🏹 " + getName() + " 射出 " + getRangedAttackType() +
                " 攻擊 " + opponent.getName() + "！");
        System.out.println("📊 剩餘箭矢：" + arrowCount + "/" + maxArrows);
        opponent.takeDamage(this.getAttackPower());
    }

    // ... 其他方法
}
