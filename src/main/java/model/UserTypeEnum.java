package model;

public enum UserTypeEnum {
    ADMIN("CC9024"),
    STANDARD("CC9024"),
    BANK("CC9015");

    private final String username;

    UserTypeEnum(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
