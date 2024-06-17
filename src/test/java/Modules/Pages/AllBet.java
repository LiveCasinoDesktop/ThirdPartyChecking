package Modules.Pages;

import Utilities.Objects.Component;

public class AllBet {

    public static class NAVIGATION{

        public static Component liveCasino = new Component(
                "Live Casino",
                "Button",
                "Landing",
                "//button[normalize-space()='LIVE GAMES']"
        );

        public static Component navigation = new Component(
                "Navigation",
                "List",
                "Live Casino",
                "//section[@id='game_types']"
        );

        public static class NAVIGATIONBUTTONS{

            public static Component baccarat = new Component(
                    "Baccarat",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Baccarat']/ancestor::button"
            );

            public static Component dragonTiger = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Dragon Tiger']/ancestor::button"
            );

            public static Component sicBo = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='SicBo']/ancestor::button"
            );

            public static Component roulette = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Roulette']/ancestor::button"
            );

            public static Component winThreeCards = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Win Three Cards']/ancestor::button"
            );

            public static Component bullBull = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Bull Bull']/ancestor::button"
            );

            public static Component threePictures = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Three Pictures']/ancestor::button"
            );

            public static Component hiLo = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='HiLo']/ancestor::button"
            );

            public static Component classicPokDeng = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Classic PokDeng']/ancestor::button"
            );

            public static Component teenPatti = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Teen Patti 20-20']/ancestor::button"
            );

            public static Component andarBahar = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Andar Bahar']/ancestor::button"
            );

            public static Component ultimateTexas = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Ultimate Texas Hold'em']/ancestor::button"
            );

            public static Component twoSidesPokDeng = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Two Sides PokDeng']/ancestor::button"
            );

            public static Component casinoWar = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Casino War']/ancestor::button"
            );

            public static Component infiniteBlackjack = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Infinite Blackjack']/ancestor::button"
            );

            public static Component fishPrawnCrab = new Component(
                    "Dragon Tiger",
                    "Button",
                    "Live Casino",
                    "//div[normalize-space()='Fish Prawn Crab']/ancestor::button"
            );

        }

    }
    public static class Tables{

        public static Component tables = new Component(
                "Table Name",
                "Table",
                "Lobby",
                "//article[@class='gamehall_table']/div[2]"
        );
    }
}
