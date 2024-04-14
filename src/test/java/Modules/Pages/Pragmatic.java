package Modules.Pages;

import Utilities.Objects.Component;

public class Pragmatic {

    public static class Navigation{

        public static Component logo = new Component(
                "Logo",
                "Navigation",
                "Pragmatic",
                "//a[@class='bT_bW']"
        );

        public static Component active = new Component(
                "Active",
                "Navigation",
                "Pragmatic",
                "//a[contains(@class, 'active')]"
        );


        public static Component baccarat = new Component(
                "Baccarat",
                "Button",
                "Casino",
                "//span[normalize-space()='Baccarat']//ancestor::a"
        );

        public static Component roulette = new Component(
                "Roulette",
                "Button",
                "Casino",
                "//span[normalize-space()='Roulette']//ancestor::a"
        );

        public static Component gameShows = new Component(
                "Game Shows",
                "Button",
                "Casino",
                "//span[normalize-space()='Game Shows']//ancestor::a"
        );

        public static Component sicBo = new Component(
                "Sic Bo",
                "Button",
                "Casino",
                "//span[normalize-space()='Sic Bo']//ancestor::a"
        );

        public static Component dragonTiger = new Component(
                "Dragon Tiger",
                "Button",
                "Casino",
                "//span[normalize-space()='Dragon Tiger']//ancestor::a"
        );

        public static Component andarBahar = new Component(
                "Andar Bahar",
                "Button",
                "Casino",
                "//span[normalize-space()='Andar Bahar']//ancestor::a"
        );
    }
    public static Component baccaratTables = new Component(
            "Baccarat Tables",
            "Button",
            "Casino",
            "//div[@class='fp_fy' and not(normalize-space()='Baccarat Multiplay')]"
    );
    public static Component rouletteTables = new Component(
            "Roulette Tables",
            "Button",
            "Casino",
            "//div[@class='fp_fy']"
    );

    public static Component showGamesTables = new Component(
            "Show Games Tables",
            "Button",
            "Casino",
            "//div[@class='fp_fy']"
    );

    public static Component sicBoTables = new Component(
            "Sic Bo Tables",
            "Button",
            "Casino",
            "//div[@class='fp_fy']"
    );

    public static Component dragonTigerTables = new Component(
            "Dragon Tiger Tables",
            "Button",
            "Casino",
            "//div[@class='fp_fy']"
    );

    public static Component andarBaharTables = new Component(
            "Andar Bahar Tables",
            "Button",
            "Casino",
            "//div[@class='fp_fy']"
    );
}
