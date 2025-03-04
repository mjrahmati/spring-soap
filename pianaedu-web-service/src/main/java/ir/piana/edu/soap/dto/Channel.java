package ir.piana.edu.soap.dto;

import jakarta.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum Channel {
    WEB("WEB"),
    MOBILE("MOBILE"),
    APPCLIENT("APPCLIENT"),
    ;

    private String name;

    Channel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Channel byName(String name) {
        for (Channel channel : Channel.values()) {
            if (channel.getName().equals(name)) {
                return channel;
            }
        }
        return null;
    }
}
