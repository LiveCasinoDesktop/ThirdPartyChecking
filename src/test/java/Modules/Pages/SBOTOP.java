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

        public static Component evolution = new Component(
                "Evolution Casino",
                "Button",
                "Casino",
                "//p[normalize-space()='Evolution Casino']//ancestor::div[@class='game_icon']"
        );

        public static Component redirection = new Component(
                "Redirection Message",
                "Text",
                "Casino",
                "//button[normalize-space()='OK, I See']"
        );

    }

    public static class Navigation{

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
                "//li[@id='category-navigator-baccarat_sicbo']"
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
}
