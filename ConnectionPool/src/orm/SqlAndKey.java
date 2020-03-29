package orm;

import java.util.ArrayList;

public class SqlAndKey {
    private String sql;
    private ArrayList<String> keyList;

    public SqlAndKey() {
    }
    public SqlAndKey(String sql, ArrayList<String> keyList) {
        this.sql = sql;
        this.keyList = keyList;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public ArrayList<String> getKeyList() {
        return keyList;
    }

    public void setKeyList(ArrayList<String> keyList) {
        this.keyList = keyList;
    }
}
