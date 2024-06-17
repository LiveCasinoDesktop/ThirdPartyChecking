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

        public static Component banner = new Component(
                "Banner",
                "Button",
                "Landing",
                "//div[@class='popupBanner_content']//*[name()='svg']"
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

        public static Component promotionClose = new Component(
                "More Casino",
                "Text",
                "Casino",
                "//div[@class='modal_close']"
        );

        public static Component thirdParty = new Component(
                "More Casino",
                "Text",
                "Casino",
                "//h2[normalize-space()='More Live Casinos']"
        );

        public static Component allBet = new Component(
                "All Bet",
                "Button",
                "Casino",
                "//div[@id='MoreLiveCasino']//p[@class='game_name'][normalize-space()='Allbet']//ancestor::div[contains(@class, 'game_icon')]"
        );

        public static Component allBetButton = new Component(
                "Pragmatic Play Casino",
                "Button",
                "Casino",
                "//div[@id='MoreLiveCasino']//p[@class='game_name'][normalize-space()='Allbet']//ancestor::div[contains(@class, 'game_icon')]//button"
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
                "//a[@class='cN_cQ']"
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
                "//div[@class='fp_fy']"
        );
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

        public static Component loading = new Component(
                "Hall Content",
                "Text",
                "Landing",
                "//div[@class='loading_text']//p[@id='loadingProg']"
        );

        public static Component halLContent = new Component(
                "Hall Content",
                "Text",
                "Landing",
                "//div[@class='hall_content']"
        );

        public static Component closeBanner = new Component(
                "Pragmatic Banner",
                "Text",
                "Casino",
                "//div[@class='close']"
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

        public static Component baccaratNonMaintenance = new Component(
                "Baccarat Tables",
                "Table",
                "Lobby",
                //"//div[@id='mexicoBacTable1']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//dt[@id='tableID']"
                "//div[@id='mexicoBacTable1']//dt[@id='tableID']"
        );

        public static Component dragonTigerTables = new Component(
                "Dragon Tiger Tables",
                "Table",
                "Lobby",
                "//div[@id='mexicoDraTable']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//h5"
        );
        public static Component dragonTigerNonMaintenance = new Component(
                "Dragon Tiger Tables",
                "Table",
                "Lobby",
                "//div[@id='mexicoDraTable']//dt[@id='tableID']"
        );

        public static Component diceTables = new Component(
                "Dice Tables",
                "Table",
                "Lobby",
                "//div[@id='mexicoSicTable']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//h5"
        );

        public static Component diceNonMaintenance = new Component(
                "Dice Tables",
                "Table",
                "Lobby",
                "//div[@id='mexicoSicTable']//dt[@id='tableID']"
        );

        public static Component rouletteTables = new Component(
                "Roulette Tables",
                "Table",
                "Lobby",
                "//div[@id='mexicoRouTable']//div[contains(@class, 'table_box') and not(contains(@style, 'display'))]//h5"
        );

        public static Component rouletteNonMaintenance = new Component(
                "Dice Tables",
                "Table",
                "Lobby",
                "//div[@id='mexicoRouTable']//dt[@id='tableID']"
        );
    }
}
