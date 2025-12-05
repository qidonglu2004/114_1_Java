package com.rpg.roles.melee;

import com.rpg.core.Role;
import com.rpg.interfaces.Defendable;

public class ShieldSwordsMan
        extends SwordsMan
        implements Defendable {

    private int defenseCapacity;

    public ShieldSwordsMan(
            String name,
            int health,
            int attackPower,
            int armor,
            int defenseCapacity) {
        super(name, health,
                attackPower, armor);
        this.defenseCapacity =
                defenseCapacity;
    }

    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() - 5;
        System.out.println("🛡️⚔️  " + this.getName() + " 單手揮動 " + getWeaponType() +
                " 攻擊 " + opponent.getName() + "！");
        opponent.takeDamage(reducedDamage);
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能      ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：盾牌猛擊          ║");
        System.out.println("║ 技能描述：使用盾牌撞擊敵人  ║");
        System.out.println("║ 技能效果：造成傷害並暈眩    ║");
        System.out.println("║ 防禦力：+" + defenseCapacity + " 點              ║");
        System.out.println("║ 護甲值：+" + getArmor() + " 點              ║");
        System.out.println("╚═════════════════════════════╝");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + this.getName() + " 力竭倒下...");
        System.out.println("🛡️  厚重的盾牌砸在地上，揚起一陣塵土。");
        System.out.println("⚔️  " + getWeaponType() + " 也隨之掉落。");
        System.out.println("---");
    }

    @Override
    public String getWeaponType() {
        return "單手劍+盾牌";
    }

    @Override
    protected void onMeleePrepare() {
        System.out.println("🛡️  檢查盾牌的牢固程度，準備防禦姿態...");
        System.out.println("⚔️  同時確認 " + getWeaponType() + " 的配合度。");
    }

    @Override
    public void afterBattle() {
        System.out.println("🛡️  " + this.getName() + " 檢視盾牌上的新傷痕，並進行簡單修補。");
    }

    // ========== 第四階段新增：實作 Defendable 介面 ==========

    /**
     * 實作 Defendable 介面的 defend() 方法
     * 持盾劍士使用盾牌進行防禦
     *
     * 注意：方法名稱從 defence() 改為 defend()
     */
    @Override
    public void defend() {  // ← 方法名稱改為 defend()（實作介面）
        int oldHealth = this.getHealth();
        this.setHealth(this.getHealth() + defenseCapacity);
        System.out.println("🛡️  " + this.getName() + " 舉起盾牌防禦！");
        System.out.println("💚 恢復 " + defenseCapacity + " 點生命值 (" +
                oldHealth + " → " + this.getHealth() + ")");
    }

    /**
     * 實作 Defendable 介面的 getDefenseCapacity() 方法
     */
    @Override
    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    // 注意：canDefend() 使用介面的預設實作，不需要覆寫
}
