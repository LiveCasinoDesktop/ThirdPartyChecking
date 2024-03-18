package Utilities.Objects;

public class Component {

    private final String name;
    private final String type;
    private final String page;
    private final String path;

    public Component(String name, String type, String page, String path){

        this.name = name;
        this.type = type;
        this.page = page;
        this.path = path;
    }

    public String getName(){

        return name;
    }
    public String getType(){

        return type;
    }
    public String getPage(){

        return page;
    }
    public String getPath(){

        return path;
    }
}
