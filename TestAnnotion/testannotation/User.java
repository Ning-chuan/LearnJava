package testannotation;

public class User {//Atm系统 一个账号

    private String username;
    private String password;
    private Float balances;

    @MyAnnotation({"宁川","123","999.99"})
    public User(){}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Float getBalances() {
        return balances;
    }
    public void setBalances(Float balances) {
        this.balances = balances;
    }
}
