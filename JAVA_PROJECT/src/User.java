public class User {

    private String name;
    private String surename;
    private int id;
    private int idcnt=0;
    private String login;
    private String password;

    public User(String name,String surename,String login,String password){
        this();
        this.name=name;
        this.surename=surename;
        this.login=login;
        this.password=password;
    }

    public User(){
        this.id=++idcnt;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
