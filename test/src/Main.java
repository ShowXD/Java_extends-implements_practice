class Main {
    public static void main(String[] args) {

    }
}

abstract class Player {
    int exp = 0;

//    1. Jungle and support 所需的經驗值不同 但又是每個角色都需要有的功能
    abstract void checkLevelUp();
}

interface JungleEquipment {
    void SmiteMonster();
}

interface SupportEquipment {
    void bonusMoney();
}
// 2. Jungle 有可以擊殺野怪的裝備 所以實作 JungleEquipment 介面
class Jungle extends Player implements JungleEquipment {

    @Override
    public void SmiteMonster() {
        System.out.println("重擊野怪");
    }

    @Override
    void checkLevelUp() {
        System.out.println(exp > 100 ? "Level Up": "exp not enough");
    }
}
// 2. Support 有可以加快賺錢的裝備 所以實作 SupportEquipment 介面
class Support extends Player implements SupportEquipment {

    @Override
    public void bonusMoney() {
        System.out.println("額外金錢");
    }

    @Override
    void checkLevelUp() {
        System.out.println(exp > 150 ? "Level Up": "exp not enough");
    }
}

// 3. 你可能會問 為什麼不把 bonusMoney 直接寫在 Support 類別裡就好了
//    因為 bonusMoney 這個功能是 "裝備"提供的  不是 Support 本身擁有的 -> 主要的原因

// extend    強調 "繼承" 關係
// interface 則無明顯的 "繼承" 關係

// 裝備和角色沒有明顯的 "繼承" 關係 所以我用 interface