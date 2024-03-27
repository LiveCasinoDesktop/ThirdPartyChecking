package Modules.Pages;

import Utilities.Objects.Component;

public class SBOTOP {

    public static class Landing{

        public static Component user = new Component(
                "User Field",
                "Input",
                "Landing",
                "//input[@id='LoginName']"
        );

        public static Component pass = new Component(
                "Pass Field",
                "Input",
                "Landing",
                "//input[@id='Password']"
        );

        public static Component login = new Component(
                "Login Button",
                "Button",
                "Landing",
                "//button[@id='LoginBtn']"
        );

        public static Component liveCasino = new Component(
                "Live Casino",
                "Button",
                "Landing",
                "//a[normalize-space()='Live Casino']"
        );

        public static Component accountName = new Component(
                "Account Name",
                "Text",
                "Landing",
                "//div[@class='userFunction-userCenter userFunction-item']"
        );
    }

    public static class Casino{

        public static Component thirdParty = new Component(
                "More Casino",
                "Text",
                "Casino",
                "//h2[normalize-space()='More Live Casinos']"
        );

        public static Component pragmatic = new Component(
                "Pragmatic Play Casino",
                "Button",
                "Casino",
                "//p[normalize-space()='Pragmatic Play Casino']//ancestor::div[@class='game_icon']"
        );
        public static Component pragmaticButton = new Component(
                "Pragmatic Play Casino",
                "Button",
                "Casino",
                "//p[normalize-space()='Pragmatic Play Casino']//ancestor::div[@class='game_icon']//button"
        );

        public static Component evolution = new Component(
                "Evolution Casino",
                "Button",
                "Casino",
                "//p[normalize-space()='Evolution Casino']//ancestor::div[@class='game_icon']"
        );

        public static Component evolutionButton = new Component(
                "Evolution Casino",
                "Button",
                "Casino",
                "//p[normalize-space()='Evolution Casino']//ancestor::div[@class='game_icon']//button"
        );


        public static Component sexy = new Component(
                "Sexy Gaming Casino",
                "Button",
                "Casino",
                "//p[normalize-space()='Sexy Gaming Casino']//ancestor::div[@class='game_icon']"
        );

        public static Component sexyButton = new Component(
                "Sexy Gaming Casino",
                "Button",
                "Casino",
                "//p[normalize-space()='Sexy Gaming Casino']//ancestor::div[@class='game_icon']//button"
        );
        public static Component redirection = new Component(
                "Redirection Message",
                "Text",
                "Casino",
                "//button[normalize-space()='OK, I See']"
        );

    }

    public static class PragmaticNav{

        public static Component nav = new Component(
                "Pragmatic Navigation",
                "Text",
                "Casino",
                "//a[@class='cc_cg']"
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


        public static Component tables = new Component(
                "Baccarat Tables",
                "Button",
                "Casino",
                "//div[@class='fY_gf']//ancestor::div[2 and contains(@id, '-')]//div[@class='fY_gf']"
        );
        public static Component baccaratTables = new Component(
                "Baccarat Tables",
                "Button",
                "Casino",
                "//div[@class='fY_gf']//ancestor::div[2 and contains(@id, '-')]//div[@class='fY_gf']"
        );
        public static Component rouletteTables = new Component(
                "Roulette Tables",
                "Button",
                "Casino",
                "//ul[@id='ROULETTE']//li[contains(@class, 'lobby-roulette')]//div[@class='tableName']"
        );

        public static Component showGamesTables = new Component(
                "Show Games Tables",
                "Button",
                "Casino",
                "//ul[@id='SHOWGAMES']//li[contains(@class, 'lobbyList')]//div[@class='tableName']"
        );

        public static Component sicBoTables = new Component(
                "Sic Bo Tables",
                "Button",
                "Casino",
                "//ul[@id='SICBO']//li[contains(@class, 'lobbyList')]//div[@class='tableName']"
        );

        public static Component dragonTigerTables = new Component(
                "Dragon Tiger Tables",
                "Button",
                "Casino",
                "//ul[@id='DRAGONTIGER']//li[contains(@class, 'lobbyList')]//div[@class='tableName']"
        );

        public static Component andarBaharTables = new Component(
                "Andar Bahar Tables",
                "Button",
                "Casino",
                "//ul[@id='ANDAR_BAHAR']//li[contains(@class, 'lobbyList')]//div[@class='tableName']"
        );
    }

    public static class Navigation{

        public static Component logo = new Component(
                "Evolution Logo",
                "Button",
                "Evolution",
                "//img[@alt='casino-logo']"
        );

        public static Component roulette = new Component(
                "Roulette",
                "Button",
                "Evolution",
                "//li[@id='category-navigator-roulette']"
        );
        public static Component baccarat_SicBo = new Component(
                "Baccarat & Sic Bo",
                "Button",
                "Evolution",
                "//span[normalize-space()='Baccarat & Sic Bo']//ancestor::li"
        );

        public static Component poker = new Component(
                "Poker",
                "Button",
                "Evolution",
                "//li[@id='category-navigator-poker']"
        );
        public static Component gameShows = new Component(
                "Game Shows",
                "Button",
                "Evolution",
                "//li[@id='category-navigator-game_shows']"
        );
    }

    public static class SexyNav{

        public static Component logo = new Component(
                "Sexy Logo",
                "Text",
                "Landing",
                "//h1[@id='lobby']"
        );

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
}
