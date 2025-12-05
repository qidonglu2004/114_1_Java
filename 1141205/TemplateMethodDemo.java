public abstract class Character {
    // 模板方法（final - 不可被覆寫）
    public final void performBattle(Character opponent) {
        // 步驟 1：戰鬥前檢查（具體方法）
        if (!preBattleCheck(opponent)) return;

        // 步驟 2：戰鬥準備（抽象方法）
        prepare();

        // 步驟 3：攻擊前行為（Hook Method）
        beforeAttack(opponent);

        // 步驟 4：執行攻擊（抽象方法）
        attack(opponent);

        // 步驟 5：攻擊後行為（Hook Method）
        afterAttack(opponent);
    }

    // 具體方法
    private boolean preBattleCheck(Character opponent) { ... }

    // 抽象方法
    protected abstract void prepare();
    protected abstract void attack(Character opponent);

    // Hook Method（鉤子方法）
    protected void beforeAttack(Character opponent) {}
    protected void afterAttack(Character opponent) {}
}

private boolean preBattleCheck(Character opponent) {
    if (!this.isAlive() || !opponent.isAlive()) {
        return false;
    }
    return true;
}

protected abstract void prepare();
protected abstract void attack(Character opponent);

protected void beforeAttack(Character opponent) {
    // 預設什麼都不做
    // 子類別可以選擇覆寫
}

// 子類別選擇性覆寫
@Override
protected void beforeAttack(Character opponent) {
    System.out.println("🔊 " + getName() + "：「受死吧！」");
}

