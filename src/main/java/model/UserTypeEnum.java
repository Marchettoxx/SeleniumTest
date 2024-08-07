package model;

public enum UserTypeEnum {
    ADMIN("CC9021"),
    BANK("CC9016");

    private final String username;

    UserTypeEnum(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
