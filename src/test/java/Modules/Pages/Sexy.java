package Modules.Pages;

import Utilities.Objects.Component;

public class Sexy {

    public static class IFrame{

        public static Component gameHall = new Component(
                "Game Hall",
                "IFrame",
                "Lobby",
                "//iframe[@id='iframeGameHall']"
        );

    }

    public static class Navigation{

        public static Component baccarat = new Component(
                "Baccarat",
                "Button",
                "Lobby",
                "//div[@class='hall_content']//ul[@class='game_list' and @data-halltype='1']//li[contains(@class, 'baccarat')]"
        );

        public static Component dragonTiger = new Component(
                "Dragon Tiger",
                "Button",
                "Lobby",
                "//div[@class='hall_content']//ul[@class='game_list' and @data-halltype='1']//li[contains(@class, 'dragon_tiger')]"
        );
        public static Component dice = new Component(
                "Dice",
                "Button",
                "Lobby",
                "//div[@class='hall_content']//ul[@class='game_list' and @data-halltype='1']//li[contains(@class, 'sicbo')]"
        );
        public static Component roulette = new Component(
                "Roulette",
                "Button",
                "Lobby",
                "//div[@class='hall_content']//ul[@class='game_list' and @data-halltype='1']//li[contains(@class, 'roulette')]"
        );
    }


    public static Component baccaratTables = new Component(
            "Baccarat Tables",
            "Table",
            "Lobby",
            //"//div[@id='mexicoBacTable1']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//dt[@id='tableID']"
            "//div[@id='mexicoBacTable1']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//h5"
    );

    public static Component dragonTigerTables = new Component(
            "Dragon Tiger Tables",
            "Table",
            "Lobby",
            "//div[@id='mexicoBacTable1']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//dt[@id='tableID']"
    );

    public static Component diceTables = new Component(
            "Dice Tables",
            "Table",
            "Lobby",
            "//div[@id='mexicoBacTable1']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//dt[@id='tableID']"
    );

    public static Component rouletteTables = new Component(
            "Roulette Tables",
            "Table",
            "Lobby",
            "//div[@id='mexicoBacTable1']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//dt[@id='tableID']"
    );
}
