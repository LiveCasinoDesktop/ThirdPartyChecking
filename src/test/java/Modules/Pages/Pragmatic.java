package Modules.Pages;

import Utilities.Objects.Component;

public class Pragmatic {

    public static class Navigation{

        public static Component baccarat = new Component(
                "Baccarat",
                "Navigation",
                "Pragmatic",
                "//li[contains(@class, 'BACCARAT')]"
        );

        public static Component roulette = new Component(
                "Roulette",
                "Navigation",
                "Pragmatic",
                "//li[contains(@class, 'ROULETTE')]"
        );

        public static Component showGames = new Component(
                "Game Shows",
                "Navigation",
                "Pragmatic",
                "//li[contains(@class, 'SHOWGAMES')]"
        );

        public static Component sicbo = new Component(
                "Sic Bo",
                "Navigation",
                "Pragmatic",
                "//li[contains(@class, 'SICBO')]"
        );

        public static Component dragonTiger = new Component(
                "Dragon Tiger",
                "Navigation",
                "Pragmatic",
                "//li[contains(@class, 'DRAGONTIGER')]"
        );

        public static Component andarBahar = new Component(
                "Andar Bahar",
                "Navigation",
                "Pragmatic",
                "//li[contains(@class, 'ANDAR_BAHAR')]"
        );
    }

    public static class Baccarat{

        public static Component speedBaccarat = new Component(
                "Speed Baccarat",
                "Table",
                "Pragmatic",
                "//div[contains(@title, 'Speed')]//ancestor::li"
        );

        public static Component FortuneBaccarat = new Component(
                "Speed Baccarat",
                "Table",
                "Pragmatic",
                "//div[contains(@title, 'Fortune')]//ancestor::li"
        );

        public static Component Super8Baccarat = new Component(
                "Speed Baccarat",
                "Table",
                "Pragmatic",
                "//div[contains(@title, 'Super 8')]//ancestor::li"
        );

        public static Component baccarat = new Component(
                "Speed Baccarat",
                "Table",
                "Pragmatic",
                "//div[not(contains(@title, 'Speed') or contains(@title, 'Fortune') or contains(@title, 'Super 8')) and contains(@title, 'Baccarat')]//ancestor::li"
        );

    }

    public static class Roulette{

        public static Component megaRoulette = new Component(
                "Mega Roulette",
                "Roulette",
                "Pragmatic",
                "//div[contains(@title, 'Mega')]//ancestor::li"
        );

        public static Component azureRoulette = new Component(
                "Azure Roulette",
                "Roulette",
                "Pragmatic",
                "//div[contains(@title, 'Azure')]//ancestor::li"
        );

        public static Component powerUpRoulette = new Component(
                "Power Up Roulette",
                "Roulette",
                "Pragmatic",
                "//div[contains(@title, 'PowerUP')]//ancestor::li"
        );

        public static Component speedRoulette = new Component(
                "Speed Roulette",
                "Roulette",
                "Pragmatic",
                "//div[contains(@title, 'Speed')]//ancestor::li"
        );

        public static Component greenRoulette = new Component(
                "Green Roulette",
                "Roulette",
                "Pragmatic",
                "//div[contains(@title, 'Green')]//ancestor::li"
        );

        public static Component autoRoulette = new Component(
                "Auto Roulette",
                "Roulette",
                "Pragmatic",
                "//div[contains(@title, 'Auto')]//ancestor::li"
        );

    }

    public static class GameShows{

        public static Component megaWheel = new Component(
                "Mega Wheel",
                "Game Shows",
                "Pragmatic",
                "//div[@title='Mega Wheel']//ancestor::li"
        );

        public static Component candyLand = new Component(
                "Sweet Bonanza CandyLand",
                "Game Shows",
                "Pragmatic",
                "//div[@title='Sweet Bonanza CandyLand']//ancestor::li"
        );

        public static Component megaSicbo = new Component(
                "Mega Sic Bo",
                "Game Shows",
                "Pragmatic",
                "//div[@title='Mega Sic Bo']//ancestor::li"
        );

        public static Component megaRoulette = new Component(
                "Mega Roulette",
                "Game Shows",
                "Pragmatic",
                "//div[@title='Mega Roulette']//ancestor::li"
        );

        public static Component powerUpRoulette = new Component(
                "PowerUP Roulette",
                "Game Shows",
                "Pragmatic",
                "//div[@title='PowerUP Roulette']//ancestor::li"
        );

        public static Component boomCity = new Component(
                "Boom City",
                "Game Shows",
                "Pragmatic",
                "//div[@title='Boom City']//ancestor::li"
        );
    }

    public static class SicBo{

        public static Component megaSicBo = new Component(
                "Mega Sic Bo",
                "SicBo",
                "Pragmatic",
                "//div[@title='Mega Sic Bo']//ancestor::li"
        );
    }

    public static class DragonTiger{

        public static Component dragonTiger = new Component(
                "Dragon Tiger",
                "Dragon Tiger",
                "Pragmatic",
                "//div[@title='Dragon Tiger']//ancestor::li"
        );
    }

    public static class AndarBahar{

        public static Component andarBahar = new Component(
                "Andar Bahar",
                "Andar Bahar",
                "Pragmatic",
                "//div[@title='Andar Bahar']//ancestor::li"
        );
    }
}
