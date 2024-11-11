package praktikum.client;

import org.apache.commons.lang3.RandomStringUtils;

public class Client {
    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client() {

    }

    public Client(String name, String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Client(String password) {
        this.password = password;
    }

    //создание уникального пользователя;
    public static Client randomClient() {
        return new Client("Beni Johnson", "Brat" + RandomStringUtils.randomAlphanumeric(2, 11) + "@ya.com", "dva" + RandomStringUtils.randomAlphanumeric(3, 11));
    }

    public static Client randomClientIncorrectPassword() {
        return new Client(RandomStringUtils.randomAlphabetic(1, 5));
    }

}
