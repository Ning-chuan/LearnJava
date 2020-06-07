package domain;

import java.net.Socket;

public class User {
    private String id;
    private Socket socket;

    public User() {
    }

    public User(String id, Socket socket) {
        this.id = id;
        this.socket = socket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
