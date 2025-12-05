package com.rpg;

import com.rpg.core.Role;
import com.rpg.interfaces.*;
import com.rpg.roles.melee.*;
import com.rpg.roles.ranged.*;

public class RPG {

    public static void main(String[] args) {
        String[] args) {

            SwordsMan s =
                    new SwordsMan(
                            "劍士", 100, 20, 5);

            Magician m =
                    new Magician(
                            "法師", 80, 15,
                            10, 8, 100);

        System.out.println("════════════════════════════════════════");
        System.out.println("        🎮 RPG 遊戲 - 第四階段");
        System.out.println("          展示：介面的應用");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // ========== 顯示類別與介面結構 ==========
        System.out.println("【📋 類別與介面結構】");
        System.out.println("─────────────────────────────────────");
        System.out.println("Role (抽象類別)");
        System.out.println("├─ MeleeRole");
        System.out.println("│  ├─ SwordsMan");
        System.out.println("│  ├─ ShieldSwordsMan (實作 Defendable)");
        System.out.println("│  └─ Paladin (實作 Defendable + Healable) ⭐");
        System.out.println("└─ RangedRole");
        System.out.println("   ├─ Magician (實作 Healable)");
        System.out.println("   └─ Archer");
        System.out.println();
        System.out.println("介面 (Interface)：");
        System.out.println("├─ Defendable：防禦能力");
        System.out.println("└─ Healable：治療能力");
        System.out.println();

        // ========== 建立角色 ==========
        // ... (省略建立角色的程式碼)

        Paladin paladin = new Paladin("聖騎士", 110, 17, 6, 12, 12, 100);  // ← 新增

        Role[] gameRoles = {swordsMan, shieldSwordsMan, magician, archer, paladin};  // ← 新增

        // ========== 展示介面能力（新增） ==========
        System.out.println("════════════════════════════════════════");
        System.out.println("          🔍 介面能力展示");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【可防禦角色 (Defendable)】");
        for (Role role : gameRoles) {
            if (role instanceof Defendable) {
                Defendable defender = (Defendable) role;
                System.out.println("✅ " + role.getName() +
                        " - 防禦力：" + defender.getDefenseCapacity() +
                        " (可防禦：" + defender.canDefend() + ")");
            }
        }
        System.out.println();

        System.out.println("【可治療角色 (Healable)】");
        for (Role role : gameRoles) {
            if (role instanceof Healable) {
                Healable healer = (Healable) role;
                System.out.println("✅ " + role.getName() +
                        " - 治療力：" + healer.getHealPower() +
                        " (可治療：" + healer.canHeal() + ")");
            }
        }
        System.out.println();

        System.out.println("【多重能力角色】");
        for (Role role : gameRoles) {
            if (role instanceof Defendable && role instanceof Healable) {
                System.out.println("⭐ " + role.getName() +
                        " - 同時擁有防禦和治療能力！");
            }
        }
        System.out.println();

        // ========== 戰鬥流程 ==========
        System.out.println("⚔️  戰鬥開始！");
        System.out.println();

        for (Role currentRole : gameRoles) {
            if (!currentRole.isAlive()) continue;

            System.out.println("━━━━━━━━━━ 回合 ━━━━━━━━━━");

            currentRole.prepareBattle();
            System.out.println();

            // ========== Paladin 特殊處理（新增） ==========
            if (currentRole instanceof Paladin) {
                Paladin p = (Paladin) currentRole;
                double action = Math.random();

                if (action < 0.3) {
                    // 防禦
                    p.defend();
                } else if (action < 0.6) {
                    // 治療
                    Role ally = getRandomAliveRole(gameRoles);
                    if (ally != null) {
                        p.heal(ally);
                    }
                } else {
                    // 攻擊
                    Role target = getRandomAliveTarget(gameRoles, currentRole);
                    if (target != null) {
                        currentRole.attack(target);
                    }
                }
            }
            // ========== 其他角色的處理 ==========
            else if (currentRole instanceof ShieldSwordsMan) {
                // ShieldSwordsMan 可能防禦
                ShieldSwordsMan shield = (ShieldSwordsMan) currentRole;
                if (Math.random() < 0.3) {
                    shield.defend();  // ← 使用介面方法
                    System.out.println();
                }
                Role target = getRandomAliveTarget(gameRoles, currentRole);
                if (target != null) {
                    currentRole.attack(target);
                }
            }
            else if (currentRole instanceof Magician) {
                // Magician 攻擊或治療
                Magician magician = (Magician) currentRole;
                if (Math.random() < 0.6) {
                    Role target = getRandomAliveTarget(gameRoles, currentRole);
                    if (target != null) {
                        currentRole.attack(target);
                    }
                } else {
                    Role ally = getRandomAliveRole(gameRoles);
                    if (ally != null) {
                        magician.heal(ally);  // ← 使用介面方法
                    }
                }
            }
            // ... 其他角色

            System.out.println();
            if (currentRole.isAlive()) {
                currentRole.afterBattle();
            }
            System.out.println();
        }

        // ========== 最終狀態報告（增強） ==========
        System.out.println("════════════════════════════════════════");
        System.out.println("          🏆 戰鬥結束");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        for (Role role : gameRoles) {
            if (role.isAlive()) {
                String abilities = "";
                if (role instanceof Defendable && role instanceof Healable) {
                    abilities = " [防禦+治療]";  // ← Paladin
                } else if (role instanceof Defendable) {
                    abilities = " [防禦]";  // ← ShieldSwordsMan
                } else if (role instanceof Healable) {
                    abilities = " [治療]";  // ← Magician
                }

                System.out.println("✅ " + role.getName() + abilities +
                        " - 生命值：" + role.getHealth());
            } else {
                System.out.println("💀 " + role.getName() + " - 已陣亡");
            }
        }
    }

    // 輔助方法
    private static Role getRandomAliveTarget(Role[] roles, Role self) {
        // ... (省略)
    }

    private static Role getRandomAliveRole(Role[] roles) {
        // ... (省略)
    }
}
