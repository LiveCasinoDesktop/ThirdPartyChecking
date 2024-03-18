package Modules.Pages;

import Utilities.Objects.Component;

public class EvolutionComponents {

    public static Component iframe = new Component(
            "IFRAME",
            "IFrame",
            "Lobby",
            "//div[@class='games-container']//iframe"
    );

    public static Component activeNav = new Component(
            "Active Nav",
            "Navigation",
            "Lobby",
            "//div[contains(@class, 'HeaderTitle')]"
    );

    public static Component navigation = new Component(
            "Active Nav",
            "Navigation",
            "Lobby",
            "//div[contains(@class, 'CategoryIcon') and contains(@class, 'active')]"
    );

    public static class Roulette{

        public static Component rouletteTables = new Component(
                "Roulette",
                "Table",
                "Lobby",
                "//p[contains(normalize-space(), 'Roulette')]"
        );


        public static Component roulette = new Component(
                "Roulette",
                "Table",
                "Lobby",
                "//p[normalize-space()='Roulette']"
        );

        public static Component lightningRoulette = new Component(
                "Lightning Roulette",
                "Table",
                "Lobby",
                "//p[contains(normalize-space(), 'Lightning Roulette') and not(contains(normalize-space(), 'XXXtreme'))]"
        );

        public static Component xtremeRoulette = new Component(
                "XXXTreme Lightning Roulette",
                "Table",
                "Lobby",
                "//p[contains(normalize-space(), 'XXXtreme')]"
        );


        public static Component immersiveRoulette = new Component(
                "Immersive Roulette",
                "Table",
                "Lobby",
                "//p[normalize-space()='Immersive Roulette']"
        );


        public static Component autoRoulette = new Component(
                "Auto-Roulette",
                "Table",
                "Lobby",
                "//p[normalize-space()='Auto-Roulette']"
        );

        public static Component instantRoulette = new Component(
                "Instant Roulette",
                "Table",
                "Lobby",
                "//p[normalize-space()='Instant Roulette']"
        );

        public static Component speedRoulette = new Component(
                "Auto-Roulette",
                "Table",
                "Lobby",
                "//p[normalize-space()='Speed Roulette']"
        );

        public static Component vipRoulette = new Component(
                "VIP Roulette",
                "Table",
                "Lobby",
                "//p[normalize-space()='VIP Roulette']"
        );

        public static Component speedAutoRoulette = new Component(
                "Speed Auto Roulette",
                "Table",
                "Lobby",
                "//p[normalize-space()='Speed Auto Roulette']"
        );

        public static Component americanRoulette = new Component(
                "American Roulette",
                "Table",
                "Lobby",
                "//p[normalize-space()='American Roulette']"
        );

        public static Component autoRouletteVIP = new Component(
                "Auto-Roulette VIP",
                "Table",
                "Lobby",
                "//p[normalize-space()='Auto-Roulette VIP']"
        );

        public static Component autoRouletteLaPartage = new Component(
                "Auto-Roulette La Partage",
                "Table",
                "Lobby",
                "//p[normalize-space()='Auto-Roulette La Partage']"
        );
    }

    public static class Baccarat_SicBo{

        public static Component baccaratTables = new Component(
                "Baccarat Tables",
                "Navigation",
                "Lobby",
                "//p[@data-role='tile-name']"
        );
        public static Component sicBoTables = new Component(
                "Sic Bo Tables",
                "Navigation",
                "Lobby",
                "//p[contains(normalize-space(), 'Sic Bo')]"
        );
        public static Component dragonTigerTables = new Component(
                "Dragon Tiger Tables",
                "Navigation",
                "Lobby",
                "//p[contains(normalize-space(), 'Dragon Tiger')]"
        );
    }

    public static class Poker{

        public static Component pokerTables = new Component(
                "Poker Tables",
                "Navigation",
                "Lobby",
                "//li[contains(@class, 'GridListItem')]//p"
        );
    }


    public static class GameShows{

        public static Component gameShows = new Component(
                "Game Shows",
                "Navigation",
                "Lobby",
                "//li[contains(@class, 'GridListItem')]//p"
        );
    }
}
