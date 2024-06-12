package Utilities.Settings;

public class Constants {

    public static class Accounts{

        public static class IDR{

            public static String username = "testidr123456";
            public static String password = "asdf1234**";
        }

        public static class THB{

            public static String username = "testthb123456";
            public static String password = "1234qwer";
        }
    }

    public static String URL = "https://www.sekolahdua.com/";


    // * ====================== EMAIL

    public static class Email{

        public static class SMTPPort{
            public static int SSL = 587;
        }
        public static class HostName{
            public static String outlook = "smtp.office365.com";
        }

        public static class Sender{
            public static String username = "scautomation@leekie.com";
            public static String password = "SoftwareControl*";
            public static String name = "sc automation";
        }

        public static class RECEIVER{

            public static class Receiver1{
                public static String username = "kar.par@leekie.com";
                public static String name = "Karl Parole";
            }
            public static class SCReceiver{
                public static String username = "SC@leekie.com";
                public static String name = "SC";
            }

            public static class BOSS1{
                public static String username = "ngd.sts@leekie.com";
                public static String name = "Ngadiman Sentosa";
            }
        }
    }
}
